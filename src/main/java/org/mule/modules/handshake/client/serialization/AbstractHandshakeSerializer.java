/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.serialization;

import java.lang.reflect.Type;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.mule.modules.handshake.client.impl.HandshakeAPIException;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Convert a Handshake POJO to a JsonElement, taking into account that sometimes we get a resource_uri for an existing nested
 * object instead of the full object to be created.
 * 
 * Child classes must implement class-specific replacements for the Map that will be jsonified
 * @author marianosimone
 */
public abstract class AbstractHandshakeSerializer<T> implements JsonSerializer<T> {

    @Override
    public JsonElement serialize(final T src, final Type typeOfSrc, final JsonSerializationContext context) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> mappedObject = BeanUtils.describe(src);
            mappedObject.remove("class");
            updateMapWithNestedObjects(mappedObject, src);
            return context.serialize(mappedObject);
        } catch (final Exception e) {
            if (e instanceof HandshakeAPIException) {
                throw (HandshakeAPIException)e;
            } else {
                throw new RuntimeException("This won't happen, rigth?", e);
            }
        }
    }

    protected abstract void updateMapWithNestedObjects(final Map<String, Object> mappedObject, final T src);
}
