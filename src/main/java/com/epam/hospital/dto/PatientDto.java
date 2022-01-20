package com.epam.hospital.dto;

import java.util.Date;

public class PatientDto {
    private int chambersId;
    private int doctorsId;
    private String surname;
    private String name;
    private String patronymic;
    private String provisionalDiagnosis;
    private String address;
    private Date birthday;
    private String status;
    private String bloodType;
    private String allergy;
    private Date receiptDate;
    private Date dischargeDate;

    public PatientDto(int chambersId, int doctorsId, String surname, String name, String patronymic, String provisionalDiagnosis, String address, Date birthday, String status, String bloodType, String allergy, Date receiptDate, Date dischargeDate) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "chambersId=" + chambersId +
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
