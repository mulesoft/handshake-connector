/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.handshake.client.impl;

import java.util.Collection;
import java.util.Iterator;

import org.mule.modules.utils.pagination.PaginatedIterable;

/**
 * 
 * @author marianosimone
 *
 * @param <T>
 * @param <Page>
 */
public abstract class PaginatedCollection<T, Page> implements Collection<T> {

    protected abstract Page firstPage();
    protected abstract boolean hasNextPage(final Page currentPage);
    protected abstract Page nextPage(final Page currentPage);
    protected abstract Iterator<T> pageIterator(final Page currentPage);

    final PaginatedIterable<T, Page> baseIterable;

    public PaginatedCollection() {
        final PaginatedCollection<T, Page> self = this;
        this.baseIterable = new PaginatedIterable<T, Page>() {
            @Override
            protected Page firstPage() {
                return self.firstPage();
            }

            @Override
            protected boolean hasNextPage(Page currentPage) {
                return self.hasNextPage(currentPage);
            }

            @Override
            protected Page nextPage(Page currentPage) {
                return self.nextPage(currentPage);
            }

            @Override
            protected Iterator<T> pageIterator(Page currentPage) {
                return self.pageIterator(currentPage);
            }
        };
    }

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract int size();

    @Override
    public Iterator<T> iterator() {
        return this.baseIterable.iterator();
    }

    @Override
    public boolean add(T e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <Type> Type[] toArray(Type[] a) {
        throw new UnsupportedOperationException();
    }
}
