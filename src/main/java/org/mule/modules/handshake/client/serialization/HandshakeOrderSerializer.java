/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
