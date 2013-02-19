/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client;

import java.util.List;
import java.util.Map;

import org.mule.modules.handshake.client.impl.HandshakeAPIException;

public interface GenericHandshakeClient<T> {

    /**
     * Create the given element on Handshake for the connected account
     * @param element to be created
     * @return the created element
     */
    T create(final T t);

    /**
     * Get all the the elements that match the given filters
     * @return all the Orders matching the given filters
     */
    List<T> getAll(final Map<String, String> filters);

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
