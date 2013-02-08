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
     * Get one element, matching the given id
     * @param id of the element to get
     * @return the element with the given id, or null if it doesn't exist
     */
    T getById(final String id);
}
