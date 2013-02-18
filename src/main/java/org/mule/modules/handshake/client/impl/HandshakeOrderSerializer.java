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
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.mule.modules.handshake.core.Order;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Convert an Order to a JsonElement, taking into account that sometimes we get a resource_uri for an existing nested object instead of the full object to be created
 * @author marianosimone
 */
public class HandshakeOrderSerializer implements JsonSerializer<Order> {

    @Override
    public JsonElement serialize(final Order src, final Type typeOfSrc, final JsonSerializationContext context) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> mappedOrder = BeanUtils.describe(src);
            if (src.getCustomer() != null) {
                mappedOrder.put("customer", src.getCustomer().getResourceUri() != null ? src.getCustomer().getResourceUri() : src.getCustomer());
            }
            if (src.getBillTo() != null) {
                mappedOrder.put("billTo", src.getBillTo().getResourceUri() != null ? src.getBillTo().getResourceUri() : src.getBillTo());
            }
            if (src.getShipTo() != null) {
                mappedOrder.put("shipTo", src.getShipTo().getResourceUri() != null ? src.getShipTo().getResourceUri() : src.getShipTo());
            }
            if (src.getCreditCard() != null) {
                mappedOrder.put("creditCard", src.getCreditCard().getResourceUri() != null ? src.getCreditCard().getResourceUri() : src.getCreditCard());
            }
            if (src.getLines() != null) {
                mappedOrder.put("lines", src.getLines());
            }
            mappedOrder.remove("class");
            return context.serialize(mappedOrder);
        } catch (final Exception e) {
            throw new RuntimeException("This won't happen, rigth?");
        }
    }

}
