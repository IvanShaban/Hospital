package com.epam.hospital.entity;

public class Chamber {
    private int id;
    private int departmentId;
    private int bedsNumber;

    public Chamber(int id, int departmentId, int bedsNumber) {
        this.id = id;
        this.departmentId = departmentId;
        this.bedsNumber = bedsNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static class Builder {
        private int id;
        private int departmentId;
        private int bedsNumber;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder departmentId(int departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder bedsNumber(int bedsNumber) {
            this.bedsNumber = bedsNumber;
            return this;
        }

        public Chamber build() {
            return new Chamber(id, departmentId, bedsNumber);
        }
    }

    @Override
    public String toString() {
        return "Chamber{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", bedsNumber=" + bedsNumber +
                '}';
    }
}
