/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.client.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mule.modules.handshake.client.impl.HandshakeAPIException;
import org.mule.modules.handshake.core.Address;
import org.mule.modules.handshake.core.CreditCard;
import org.mule.modules.handshake.core.Customer;

public class HandshakeCustomerSerializer extends AbstractHandshakeSerializer<Customer> {

    @Override
    protected void updateMapWithNestedObjects(final Map<String, Object> mappedCustomer, final Customer src) {
        if (src.getBillTo() != null) {
            mappedCustomer.put("billTo", src.getBillTo().getResourceUri() != null ? src.getBillTo().getResourceUri() : src.getBillTo());
        }
        if (src.getCustomerGroup() != null) {
            if (src.getCustomerGroup().getResourceUri() != null) {
                mappedCustomer.put("customerGroup", src.getCustomerGroup().getResourceUri());
            } else {
                throw new HandshakeAPIException("You can not create a new CustomerGroup via a Customer, you must do it first and then use a reference to it");
            }
        }
        if (src.getUserGroup() != null) {
            if (src.getUserGroup().getResourceUri() != null) {
                mappedCustomer.put("userGroup", src.getUserGroup().getResourceUri());
            } else {
                throw new HandshakeAPIException("You can not create a new UserGroup via a Customer, you must do it first and then use a reference to it");
            }
        }
        if (src.getShipTos() != null) {
            final List<Object> addresses = new ArrayList<Object>(src.getShipTos().size());
            for (final Address address : src.getShipTos()) {
                addresses.add(address.getResourceUri() != null ? address.getResourceUri() : address);
            }
            mappedCustomer.put("shipTos", addresses);
        }
        if (src.getCreditCards() != null) {
            final List<Object> cards = new ArrayList<Object>(src.getCreditCards().size());
            for (final CreditCard cc : src.getCreditCards()) {
                cards.add(cc.getResourceUri() != null ? cc.getResourceUri() : cc);
            }
            mappedCustomer.put("creditCards", cards);
        }
    }

}
