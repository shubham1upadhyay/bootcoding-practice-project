package com.bootcoding.ipl.store;

public interface DataStore<V,R> {
    V load(R request);
}
