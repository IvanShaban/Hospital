package com.epam.hospital.dao.impl;

import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.entity.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDaoImpl {
    String USERNAME = "root";
    String PASSWORD = "root";
    String URL = "jdbc:mysql://localhost:3306/hospital";

    public Patient insert(PatientDto patientDto) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO patients (chambers_id, doctors_id, surname, name, patronymic, " +
                            "provisional_diagnosis, address, birthday, status, blood_type, allergy, receipt_date," +
                            "discharge_date) " +
                            "VALUES ('" + patientDto.getChambersId() + "', '" + patientDto.getDoctorsId() + "', '"
                            + patientDto.getSurname() + "', '" + patientDto.getName() + "', '" +
                            patientDto.getPatronymic() + "', '" + patientDto.getProvisionalDiagnosis() + "', '" +
                            patientDto.getAddress() + "', '" + patientDto.getBirthday() + "', '" + patientDto.getStatus() + "', '" +
                            patientDto.getBloodType() + "', '" + patientDto.getAllergy() + "', '" +
                            patientDto.getReceiptDate() + "', '" + patientDto.getDischargeDate() + "')");
            ResultSet resultSet = statement.executeQuery("SELECT id from chambers where id = LAST_INSERT_ID()");
            resultSet.next();
            return new Patient.Builder()
                    .id(resultSet.getInt(1))
                    .chambersId(resultSet.getInt(2))
                    .doctorsId(resultSet.getInt(3))
                    .surname(resultSet.getString(4))
                    .name(resultSet.getString(5))
                    .patronymic(resultSet.getString(6))
                    .provisionalDiagnosis(resultSet.getString(7))
                    .address(resultSet.getString(8))
                    .birthday(resultSet.getDate(9))
                    .status(resultSet.getString(10))
                    .bloodType(resultSet.getString(11))
                    .allergy(resultSet.getString(12))
                    .receiptDate(resultSet.getDate(13))
                    .dischargeDate(resultSet.getDate(14))
                    .build();
        }
    }

    public Patient findById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ArrayList<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where id = " + id);
            return new Patient.Builder()
                    .id(resultSet.getInt(1))
                    .chambersId(resultSet.getInt(2))
                    .doctorsId(resultSet.getInt(3))
                    .surname(resultSet.getString(4))
                    .name(resultSet.getString(5))
                    .patronymic(resultSet.getString(6))
                    .provisionalDiagnosis(resultSet.getString(7))
                    .address(resultSet.getString(8))
                    .birthday(resultSet.getDate(9))
                    .status(resultSet.getString(10))
                    .bloodType(resultSet.getString(11))
                    .allergy(resultSet.getString(12))
                    .receiptDate(resultSet.getDate(13))
                    .dischargeDate(resultSet.getDate(14))
                    .build();
        }
    }

    public List<Patient> findByChambersId(int chambersId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, " +
                            "address, birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where chambers_id = " + chambersId);
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByDoctorsId(int doctorsId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where doctors_id = " + doctorsId);
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findBySurname(String surname) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where surname = " + surname);
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByProvisionalDiagnosis(String provisionalDiagnosis) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where provisional_diagnosis = " + provisionalDiagnosis);
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByBirthday(Date birthday) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where birthday = " + birthday);
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByStatus(String status) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where status = " + status);
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByBloodType(String bloodType) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where blood_type = " + bloodType);
            List<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByReceiptDate(Date receiptDate) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where receipt_date = " + receiptDate);
            List<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByDischargeDate(Date dischargeDate) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where discharge_date = " + dischargeDate);
            List<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new Patient.Builder()
                        .id(resultSet.getInt(1))
                        .chambersId(resultSet.getInt(2))
                        .doctorsId(resultSet.getInt(3))
                        .surname(resultSet.getString(4))
                        .name(resultSet.getString(5))
                        .patronymic(resultSet.getString(6))
                        .provisionalDiagnosis(resultSet.getString(7))
                        .address(resultSet.getString(8))
                        .birthday(resultSet.getDate(9))
                        .status(resultSet.getString(10))
                        .bloodType(resultSet.getString(11))
                        .allergy(resultSet.getString(12))
                        .receiptDate(resultSet.getDate(13))
                        .dischargeDate(resultSet.getDate(14))
                        .build());
            }
            return patients;
        }
    }

    public List<Patient> findByDischargeDateMy(Date dischargeDate) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
                            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
                            "from patients where discharge_date = " + dischargeDate);
            return creator(resultSet);
        }
    }

    private List<Patient> creator(ResultSet resultSet) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {
            patients.add(new Patient.Builder()
                    .id(resultSet.getInt(1))
                    .chambersId(resultSet.getInt(2))
                    .doctorsId(resultSet.getInt(3))
                    .surname(resultSet.getString(4))
                    .name(resultSet.getString(5))
                    .patronymic(resultSet.getString(6))
                    .provisionalDiagnosis(resultSet.getString(7))
                    .address(resultSet.getString(8))
                    .birthday(resultSet.getDate(9))
                    .status(resultSet.getString(10))
                    .bloodType(resultSet.getString(11))
                    .allergy(resultSet.getString(12))
                    .receiptDate(resultSet.getDate(13))
                    .dischargeDate(resultSet.getDate(14))
                    .build());
        }
        return patients;
    }
}
