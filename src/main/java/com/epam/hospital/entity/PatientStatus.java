package com.epam.hospital.entity;

public enum PatientStatus {
    ENABLE(1),
    DISCHARGE(2);
    private int value;

    PatientStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
