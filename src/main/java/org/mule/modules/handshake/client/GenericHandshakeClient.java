/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake.client;

import java.util.Collection;
import java.util.Map;

import org.mule.modules.handshake.client.impl.HandshakeAPIException;
import org.mule.modules.handshake.core.HandshakeAPIResponse;

public interface GenericHandshakeClient<T> {

    /**
     * Create the given element on Handshake for the connected account
     * @param element to be created
     * @return the created element
     */
    T create(final T t);

    /**
     * Updates an existing element on Handshake, by providing its resourceUri and an object with the fields to update.
     * Because of the way Handshake references work, you should not include fields that you don't want updated, specially if they are nested objects, and should either leave them blank or include the corresponding resourceUri
     * @param resourceUri of the element to edit
     * @param toUpdate object with the fields to be edited
     * @return the updated element
     */
    T update(final String resourceUri, final T toUpdate);

    /**
     * Pagiante elements that match the given filters
     * @param filters to apply to the search
     * @param limit the maximum amount of items to be returned
     * @param offset pagination offset
     * @return an object with elements matching the filters, and metadata to retrieve more in another call (using "next" as "offset")
     */
    HandshakeAPIResponse<T> paginate(final Map<String, String> filters, final Integer limit, final Integer offset);

    /**
     * Get all the elements that match the given filters
     * @param filters to apply to the search
     * @param fetchAllResults if set to true, will try to fetch all the results, even if they are too much. WARNING: Could be slow and raise OutOfMemoryError
     * @return a Collection of all the elements matching the filters
     */
    Collection<T> getAll(final Map<String, String> filters, final boolean fetchAllResults);

    /**
     * Get one element, matching the given id. The id is the user-specified one for the given entity.
     * Note that not all entities support this field, so you might be looking for {@link GenericHandshakeClient#getByResourceUri(String)}
     * @param id of the element to get
     * @return the element with the given id, or null if it doesn't exist
     */
    T getById(final String id);
    
    /**
     * Get one element, matching the given Handshake Id (resourceUri)
     * @param id of the element to get
     * @return the element with the given id
     * @throws IllegalArgumentException if the resourceUri is not well-formed
     * @throws HandshakeAPIException if the element doesn't exist in Handshake
     */
    T getByResourceUri(final String resourceUri);

}
