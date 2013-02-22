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

import org.mule.modules.handshake.core.Item;

public class HandshakeItemSerializer extends AbstractHandshakeSerializer<Item> {

    @Override
    protected void updateMapWithNestedObjects(final Map<String, Object> mappedCustomer, final Item src) {
        if (src.getCategory() != null) {
            mappedCustomer.put("category", src.getCategory().getResourceUri() != null ? src.getCategory().getResourceUri() : src.getCategory());
        }
        //TODO: Variants?
    }

}
