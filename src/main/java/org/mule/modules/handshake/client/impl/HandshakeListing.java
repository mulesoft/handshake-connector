/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.mule.modules.handshake.core.HandshakeAPIResponse;

public class HandshakeListing<T> {
    private List<T> results;
    private Integer totalCount;
    private Integer next;
    private Integer offset;
    private Integer limit;

    public static <T> HandshakeListing<T> fromAPIResponse(final HandshakeAPIResponse<T> response) {
        final HandshakeListing<T> listing = new HandshakeListing<T>();
        listing.results = response.getObjects();
        listing.totalCount = response.getMeta().getTotal_count();
        listing.offset = response.getMeta().getOffset();
        listing.limit = response.getMeta().getLimit();
        if (!StringUtils.isBlank(response.getMeta().getNext())) {
            listing.next = listing.offset + listing.limit;
        }
        return listing ;
    }

    public List<T> getResults() {
        return results;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    public Integer getNext() {
        return next;
    }
    public Integer getOffset() {
        return offset;
    }
    public Integer getLimit() {
        return limit;
    }
}
