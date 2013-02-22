/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mule.modules.handshake.core.Item;
import org.mule.modules.handshake.core.Variant;

public class HandshakeItemSerializer extends AbstractHandshakeSerializer<Item> {

    @Override
    protected void updateMapWithNestedObjects(final Map<String, Object> mappedCustomer, final Item src) {
        if (src.getCategory() != null) {
            mappedCustomer.put("category", src.getCategory().getResourceUri() != null ? src.getCategory().getResourceUri() : src.getCategory());
        }
        if (src.getVariants() != null) {
            final List<Object> variants = new ArrayList<Object>(src.getVariants().size());
            for (final Variant variant : src.getVariants()) {
                variants.add(variant.getResourceUri() != null ? variant.getResourceUri() : variant);
            }
            mappedCustomer.put("variants", variants);
        }
    }

}
