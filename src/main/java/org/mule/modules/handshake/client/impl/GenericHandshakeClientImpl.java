/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.client.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mule.modules.handshake.client.GenericHandshakeClient;
import org.mule.modules.handshake.core.HandshakeAPIResponse;
import org.mule.modules.handshake.core.HandshakeObject;

import com.sun.jersey.api.client.WebResource.Builder;

public class GenericHandshakeClientImpl<T extends HandshakeObject> extends AbstractHandshakeClient implements GenericHandshakeClient<T> {

    private final String apiKey;
    private final String securityToken;
    private final String antiThrottleKey;
    private final String resourcePath;
    private final Type elementType;
    private final Type responseElementType;
    private static final Pattern RESOURCE_PATTERN = Pattern.compile("^/api/v.*/.*/(\\d+)$");

    public GenericHandshakeClientImpl(final String baseUrl, final String apiKey, final String securityToken, final String antiThrottleKey, final String resourcePath, final Type elementType, final Type responseElementType) {
        super(baseUrl);
        this.apiKey = apiKey;
        this.securityToken = securityToken;
        this.antiThrottleKey = antiThrottleKey;
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
        final Builder builder = getBuilder(apiKey, securityToken, antiThrottleKey, getBaseURL(), null);
        return this.post(builder, elementType, elementType, t);
    }

    @Override
    public T update(final String resourceUri, final T edited) {
        if (StringUtils.isBlank(resourceUri) && StringUtils.isBlank(edited.getResourceUri())) {
            throw new InvalidHandshakeObjectReferenceException("You have to either pass the resourceUri or set it to the element to edit");
        }
        final Builder builder = getBuilder(apiKey, securityToken, antiThrottleKey, this.detailUrl(StringUtils.isBlank(resourceUri) ? edited.getResourceUri() : resourceUri), null);
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
        final Builder builder = getBuilder(apiKey, securityToken, antiThrottleKey, getBaseURL(), params);
        return this.get(builder, responseElementType);
    }

    @Override
    public Collection<T> getAll(final Map<String, String> filters, final boolean fetchAllResults) {
        final GenericHandshakeClientImpl<T> client = this;
        final Collection<T> pagedResult = new PaginatedCollection<T, HandshakeAPIResponse<T>>() {
            private HandshakeAPIResponse<T> first;

            @Override
            protected synchronized HandshakeAPIResponse<T> firstPage() {
                if (first == null) {
                    first = client.paginate(filters, null, null);
                }
                return first;
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

            @Override
            public boolean isEmpty() {
                return (this.size() == 0);
            }

            @Override
            public int size() {
                return this.firstPage().getMeta().getTotalCount();
            }
        };
        if (fetchAllResults) {
            final Collection<T> result = new ArrayList<T>(pagedResult.size());
            CollectionUtils.addAll(result, pagedResult.iterator());
            return result;
        } else {
            return pagedResult;
        }
    }

    @Override
    public T getById(final String id) {
        @SuppressWarnings("serial")
        final Builder builder = getBuilder(apiKey, securityToken, antiThrottleKey, getBaseURL(), new HashMap<String, String>() {{put("id", id);}});
        final HandshakeAPIResponse<T> response = this.get(builder, responseElementType);
        if (!response.getObjects().isEmpty()) {
            return response.getObjects().get(0);
        } else {
            return null;
        }
    }

    @Override
    public T getByResourceUri(final String resourceUri) {
        final Builder builder = getBuilder(apiKey, securityToken, antiThrottleKey, this.detailUrl(resourceUri), null);
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
