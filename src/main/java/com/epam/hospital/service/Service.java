package com.epam.hospital.service;

public interface Service<T, A> {
    T insert(A dto);
}
