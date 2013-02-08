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
