package com.epam.hospital.entity;

public enum UserRole {
    ADMIN(1),
    MANAGER(2),
    DOCTOR(3),
    NURSE(4);
    private int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}