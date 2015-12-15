/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
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
