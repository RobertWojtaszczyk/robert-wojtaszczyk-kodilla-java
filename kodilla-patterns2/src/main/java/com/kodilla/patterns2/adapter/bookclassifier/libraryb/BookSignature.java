package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.Objects;

public class BookSignature {
    private final String signature;

    public BookSignature(final String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookSignature)) return false;
        BookSignature that = (BookSignature) o;
        return Objects.equals(getSignature(), that.getSignature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSignature());
    }
}