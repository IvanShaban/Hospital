package com.epam.hospital.entity;

public class Patient {
    private int id;
    private int chambersId;
    private int doctorsId;
    private String surname;
    private String name;
    private String patronymic;
    private String provisionalDiagnosis;
    private String address;
    private int birthday;
    private String status;
    private String bloodType;
    private String allergy;
    private int receiptDate;
    private int dischargeDate;

    public Patient(int id,
                   int chambersId,
                   int doctorsId,
                   String surname,
                   String name,
                   String patronymic,
                   String provisionalDiagnosis,
                   String address,
                   int birthday,
                   String status,
                   String bloodType,
                   String allergy,
                   int receiptDate,
                   int dischargeDate) {
        this.id = id;
        this.chambersId = chambersId;
        this.doctorsId = doctorsId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.provisionalDiagnosis = provisionalDiagnosis;
        this.address = address;
        this.birthday = birthday;
        this.status = status;
        this.bloodType = bloodType;
        this.allergy = allergy;
        this.receiptDate = receiptDate;
        this.dischargeDate = dischargeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChambersId() {
        return chambersId;
    }

    public void setChambersId(int chambersId) {
        this.chambersId = chambersId;
    }

    public int getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(int doctorsId) {
        this.doctorsId = doctorsId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getProvisionalDiagnosis() {
        return provisionalDiagnosis;
    }

    public void setProvisionalDiagnosis(String provisionalDiagnosis) {
        this.provisionalDiagnosis = provisionalDiagnosis;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public int getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(int receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(int dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public static class Builder {
        private int id;
        private int chambersId;
        private int doctorsId;
        private String surname;
        private String name;
        private String patronymic;
        private String provisionalDiagnosis;
        private String address;
        private int birthday;
        private String status;
        private String bloodType;
        private String allergy;
        private int receiptDate;
        private int dischargeDate;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder chambersId(int chambersId) {
            this.chambersId = chambersId;
            return this;
        }

        public Builder doctorsId(int doctorsId) {
            this.doctorsId = doctorsId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder provisionalDiagnosis(String provisionalDiagnosis) {
            this.provisionalDiagnosis = provisionalDiagnosis;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder birthday(int birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder bloodType(String bloodType) {
            this.bloodType = bloodType;
            return this;
        }

        public Builder allergy(String allergy) {
            this.allergy = allergy;
            return this;
        }

        public Builder receiptDate(int receiptDate) {
            this.receiptDate = receiptDate;
            return this;
        }

        public Builder dischargeDate(int dischargeDate) {
            this.dischargeDate = dischargeDate;
            return this;
        }

        public Patient build() {
            return new Patient(id, chambersId, doctorsId, surname, name, patronymic, provisionalDiagnosis, address,
                    birthday, status, bloodType, allergy, receiptDate, dischargeDate);
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", chambersId=" + chambersId +
                ", doctorsId=" + doctorsId +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", provisionalDiagnosis='" + provisionalDiagnosis + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", status='" + status + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", allergy='" + allergy + '\'' +
                ", receiptDate=" + receiptDate +
                ", dischargeDate=" + dischargeDate +
                '}';
    }
}
