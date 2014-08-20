/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.handshake.client.serialization;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Handshake API doesn't support Decimal values as parameters for POST methods, as they don't want to suffer from precision errors, they ask for Strings
 * 
 * @author marianosimone
 *
 */
public class BigDecimalAsStringSerializer implements JsonSerializer<BigDecimal> {

    @Override
    public JsonElement serialize(final BigDecimal src, final Type typeOfSrc, final JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }

}
