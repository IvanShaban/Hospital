package com.epam.hospital.dto;

public class DepartmentDto {
    private String title;
    private int chambersNumber;
    private int bedsNumber;
    private int headDoctorId;

    public DepartmentDto(String title, int chambersNumber, int bedsNumber, int headDoctorId) {
        this.title = title;
        this.chambersNumber = chambersNumber;
        this.bedsNumber = bedsNumber;
        this.headDoctorId = headDoctorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChambersNumber() {
        return chambersNumber;
    }

    public void setChambersNumber(int chambersNumber) {
        this.chambersNumber = chambersNumber;
    }

    public int getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(int bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    public int getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(int headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "title='" + title + '\'' +
                ", chambersNumber=" + chambersNumber +
                ", bedsNumber=" + bedsNumber +
                ", headDoctorId=" + headDoctorId +
                '}';
    }
}
