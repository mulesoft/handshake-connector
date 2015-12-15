/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.client.serialization;

import java.util.Map;

import org.mule.modules.handshake.core.Order;

public class HandshakeOrderSerializer extends AbstractHandshakeSerializer<Order> {

    @Override
    protected void updateMapWithNestedObjects(final Map<String, Object> mappedOrder, final Order src) {
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
    }

}
