/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
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
 */
public abstract class AbstractHandshakeSerializer<T> implements JsonSerializer<T> {

    public JsonElement serialize(final T src, final Type typeOfSrc, final JsonSerializationContext context) {
        try {
            @SuppressWarnings("unchecked")
            final Map<String, Object> mappedObject = BeanUtils.describe(src);
            mappedObject.remove("class");
            updateMapWithNestedObjects(mappedObject, src);
            return context.serialize(mappedObject);
        } catch (final HandshakeAPIException e) {
            throw e;
        } catch (final Exception e) {
            throw new RuntimeException("This won't happen, rigth?", e);
        }
    }

    protected abstract void updateMapWithNestedObjects(final Map<String, Object> mappedObject, final T src);
}
