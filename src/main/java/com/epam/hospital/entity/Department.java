package com.epam.hospital.entity;

public class Department {
    private int id;
    private String title;
    private int chambersNumber;
    private int bedsNumber;
    private int headDoctorId;

    public Department(int id, String title, int chambersNumber, int bedsNumber, int headDoctorId) {
        this.id = id;
        this.title = title;
        this.chambersNumber = chambersNumber;
        this.bedsNumber = bedsNumber;
        this.headDoctorId = headDoctorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static class Builder {
        private int id;
        private String title;
        private int chambersNumber;
        private int bedsNumber;
        private int headDoctorId;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder chambersNumber(int chambersNumber) {
            this.chambersNumber = chambersNumber;
            return this;
        }

        public Builder bedsNumber(int bedsNumber) {
            this.bedsNumber = bedsNumber;
            return this;
        }

        public Builder setHeadDoctorId(int headDoctorId) {
            this.headDoctorId = headDoctorId;
            return this;
        }

        public Department build() {
            return new Department(id, title, chambersNumber, bedsNumber, headDoctorId);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", chambersNumber=" + chambersNumber +
                ", bedsNumber=" + bedsNumber +
                ", headDoctor=" + headDoctorId +
                '}';
    }
}
