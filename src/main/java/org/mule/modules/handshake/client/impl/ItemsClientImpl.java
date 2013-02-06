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

import org.mule.modules.handshake.client.ItemsClient;
import org.mule.modules.handshake.core.Item;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.WebResource.Builder;

public class ItemsClientImpl extends AbstractHandshakeClient implements ItemsClient {
    private static final Type ITEM_TYPE = new TypeToken<Item>() {}.getType();

    private String apiKey;

    public ItemsClientImpl(final String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    protected String extendGetBaseUrl(final String baseUrl) {
        return baseUrl + "items/";
    }

    @Override
    public Item createItem(final Item item) {
        final Builder builder = getBuilder(apiKey, getBaseURL(), null);
        return this.post(builder, ITEM_TYPE, ITEM_TYPE, item);
    }

}
