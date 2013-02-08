package org.mule.modules.handshake.client;

public interface GenericHandshakeClient<T> {

    /**
     * Create the given element on Handshake for the connected account
     * @param element to be created
     * @return the created element
     */
    T create(final T t);
}
