/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.mule.modules.handshake.client.GenericHandshakeClient;
import org.mule.modules.handshake.core.HandshakeAPIResponse;
import org.mule.modules.handshake.core.HandshakeObject;
import org.mule.modules.utils.pagination.PaginatedIterable;

import com.sun.jersey.api.client.WebResource.Builder;

public class GenericHandshakeClientImpl<T extends HandshakeObject> extends AbstractHandshakeClient implements GenericHandshakeClient<T> {

    private final String apiKey;
    private final String securityToken;
    private final String resourcePath;
    private final Type elementType;
    private final Type responseElementType;
    private static final Pattern RESOURCE_PATTERN = Pattern.compile("^/api/v2/.*/(\\d+)$");

    public GenericHandshakeClientImpl(final String apiKey, final String securityToken, final String resourcePath, final Type elementType, final Type responseElementType) {
        this.apiKey = apiKey;
        this.securityToken = securityToken;
        this.resourcePath = resourcePath;
        this.elementType = elementType;
        this.responseElementType = responseElementType;
    }

    @Override
    protected StringBuilder extendGetBaseUrl(final StringBuilder baseUrl) {
        return baseUrl.append(this.resourcePath);
    }

    @Override
    public T create(final T t) {
        final Builder builder = getBuilder(apiKey, securityToken, getBaseURL(), null);
        return this.post(builder, elementType, elementType, t);
    }

    @Override
    public T update(final String resourceUri, final T edited) {
        if (StringUtils.isBlank(resourceUri) && StringUtils.isBlank(edited.getResourceUri())) {
            throw new InvalidHandshakeObjectReferenceException("You have to either pass the resourceUri or set it to the element to edit");
        }
        final Builder builder = getBuilder(apiKey, securityToken, this.detailUrl(StringUtils.isBlank(resourceUri) ? edited.getResourceUri() : resourceUri), null);
        return this.update(builder, elementType, edited);
    }

    @Override
    public HandshakeAPIResponse<T> paginate(final Map<String, String> filters, final Integer limit, final Integer offset) {
        final Map<String, String> params = new HashMap<String, String>();
        if (filters != null) {
            params.putAll(filters);
        }
        if (limit != null) {
            params.put("limit", limit.toString());
        }
        if (offset != null) {
            params.put("offset", offset.toString());
        }
        final Builder builder = getBuilder(apiKey, securityToken, getBaseURL(), params);
        return this.get(builder, responseElementType);
    }

    @Override
    public Iterable<T> getAll(final Map<String, String> filters) {
        final GenericHandshakeClientImpl<T> client = this;
        return new PaginatedIterable<T, HandshakeAPIResponse<T>>() {
            @Override
            protected HandshakeAPIResponse<T> firstPage() {
                return client.paginate(filters, null, null);
            }

            @Override
            protected boolean hasNextPage(final HandshakeAPIResponse<T> currentPage) {
                return currentPage.getMeta().getNextOffset() != null;
            }

            @Override
            protected HandshakeAPIResponse<T> nextPage(final HandshakeAPIResponse<T> currentPage) {
                return client.paginate(filters, currentPage.getMeta().getLimit(), currentPage.getMeta().getNextOffset());
            }

            @Override
            protected Iterator<T> pageIterator(final HandshakeAPIResponse<T> currentPage) {
                return currentPage.getObjects().iterator();
            }
        };
    }

    @Override
    public T getById(final String id) {
        @SuppressWarnings("serial")
        final Builder builder = getBuilder(apiKey, securityToken, getBaseURL(), new HashMap<String, String>() {{put("id", id);}});
        final HandshakeAPIResponse<T> response = this.get(builder, responseElementType);
        if (!response.getObjects().isEmpty()) {
            return response.getObjects().get(0);
        } else {
            return null;
        }
    }

    @Override
    public T getByResourceUri(final String resourceUri) {
        final Builder builder = getBuilder(apiKey, securityToken, this.detailUrl(resourceUri), null);
        return this.singleGet(builder, elementType);
    }

    /**
     * Extracts the resource id from a resourceUri
     * @param resourceUri from which to extract the resource ID
     * @throws InvalidHandshakeObjectReferenceException if the resourceUri is not well formed
     * @return the id
     */
    protected static String extractIdFromResourceUri(final String resourceUri) {
        final Matcher matcher = RESOURCE_PATTERN.matcher(resourceUri);
        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            throw new InvalidHandshakeObjectReferenceException("The given resourceUri is not valid: " + resourceUri);
        }
    }

    private String detailUrl(final String resourceUri) {
        return new StringBuilder(getBaseURL()).append("/").append(extractIdFromResourceUri(resourceUri)).toString();
    }

}
