package com.epam.hospital.dto;

public class ChamberDto {
    private int departmentId;
    private int bedsNumber;

    public ChamberDto(int departmentId, int bedsNumber) {
        this.departmentId = departmentId;
        this.bedsNumber = bedsNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(int bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    @Override
    public String toString() {
        return "ChamberDto{" +
                "departmentId=" + departmentId +
                ", bedsNumber=" + bedsNumber +
                '}';
    }
}
