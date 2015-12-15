/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.handshake.core;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class HandshakeAPIResponse<T> {
    private HandshakeAPIResponseMetadata meta;
    private List<T> objects;

    public HandshakeAPIResponseMetadata getMeta() {
        return meta;
    }

    public void setMeta(final HandshakeAPIResponseMetadata meta) {
        this.meta = meta;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(final List<T> objects) {
        this.objects = objects;
    }

    public class HandshakeAPIResponseMetadata {
        private int limit;
        private int offset;
        @SerializedName("total_count")
        private int totalCount;
        private String next;
        private String previous;

        public int getLimit() {
            return limit;
        }
        public void setLimit(final int limit) {
            this.limit = limit;
        }
        public int getOffset() {
            return offset;
        }
        public void setOffset(final int offset) {
            this.offset = offset;
        }
        public int getTotalCount() {
            return totalCount;
        }
        public void setTotalCount(final int total_count) {
            this.totalCount = total_count;
        }
        public void setNext(final String next) {
            this.next = next;
        }
        public String getPrevious() {
            return previous;
        }
        public void setPrevious(final String previous) {
            this.previous = previous;
        }
        public Integer getNextOffset() {
            if (this.next == null) {
                return null;
            }
            return this.offset + this.limit;
        }
    }
}
