package org.mule.modules.handshake.core;

import java.util.List;

public class HandshakeAPIResponse<T> {
    private HandshakeAPIResponseMetadata meta;
    private List<T> objects;

    public HandshakeAPIResponseMetadata getMeta() {
        return meta;
    }

    public void setMeta(HandshakeAPIResponseMetadata meta) {
        this.meta = meta;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public class HandshakeAPIResponseMetadata {
        private int limit;
        private int offset;
        private int total_count;
        private String next;
        private String previous;

        public int getLimit() {
            return limit;
        }
        public void setLimit(int limit) {
            this.limit = limit;
        }
        public int getOffset() {
            return offset;
        }
        public void setOffset(int offset) {
            this.offset = offset;
        }
        public int getTotal_count() {
            return total_count;
        }
        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }
        public String getNext() {
            return next;
        }
        public void setNext(String next) {
            this.next = next;
        }
        public String getPrevious() {
            return previous;
        }
        public void setPrevious(String previous) {
            this.previous = previous;
        }
    }
}
