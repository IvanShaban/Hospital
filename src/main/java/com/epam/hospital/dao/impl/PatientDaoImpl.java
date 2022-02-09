package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.PatientDao;
import com.epam.hospital.dao.connectionpool.ConnectionPool;
import com.epam.hospital.dao.mapper.PatientMapper;
import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.entity.Patient;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
    public static final String INSERT_PATIENT =
            "INSERT INTO hospital.patients (chambers_id, doctors_id, surname, name, patronymic, " +
                    "provisional_diagnosis, address, birthday, status, blood_type, allergy, receipt_date, discharge_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_LAST_INSERT_ID = "SELECT id FROM hospital.patients WHERE id = LAST_INSERT_ID()";
    public static final String SELECT_ALL_BY_PATIENT_ID = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE id = ?";
    public static final String SELECT_ALL_BY_CHAMBER_ID = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, " +
            "address, birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE chambers_id = ?";
    public static final String SELECT_ALL_BY_DOCTOR_ID = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE doctors_id = ?";
    public static final String SELECT_ALL_BY_SURNAME = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE surname = ?";
    public static final String SELECT_ALL_BY_PROVISIONAL_DIAGNOSIS = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE provisional_diagnosis = ?";
    public static final String SELECT_ALL_BY_BIRTHDAY = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE birthday = ?";
    public static final String SELECT_ALL_BY_STATUS = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE status = ?";
    public static final String SELECT_ALL_BY_BLOOD_TYPE = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE blood_type = ?";
    public static final String SELECT_ALL_BY_RECEIPT_DATE = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE receipt_date = ?";
    public static final String SELECT_ALL_BY_DISCHARGE_DATE = "SELECT id, chambers_id, doctors_id, surname, name, patronymic, provisional_diagnosis, address, " +
            "birthday, status, blood_type, allergy, receipt_date, discharge_date " +
            "FROM hospital.patients WHERE discharge_date = ?";
    public static final String DELETE_BY_ID = "DELETE FROM hospital.patients WHERE id = ?";

    private ConnectionPool connectionPool;

    public PatientDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public Patient insert(PatientDto patientDto) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT);
            preparedStatement.setInt(1, patientDto.getChambersId());
            preparedStatement.setInt(2, patientDto.getDoctorsId());
            preparedStatement.setString(3, patientDto.getSurname());
            preparedStatement.setString(4, patientDto.getName());
            preparedStatement.setString(5, patientDto.getPatronymic());
            preparedStatement.setString(6, patientDto.getProvisionalDiagnosis());
            preparedStatement.setString(7, patientDto.getAddress());
            preparedStatement.setInt(8, patientDto.getBirthday());
            preparedStatement.setString(9, patientDto.getStatus());
            preparedStatement.setString(10, patientDto.getBloodType());
            preparedStatement.setString(11, patientDto.getAllergy());
            preparedStatement.setInt(12, patientDto.getReceiptDate());
            preparedStatement.setInt(13, patientDto.getDischargeDate());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_LAST_INSERT_ID);
            resultSet.next();
            return PatientMapper.toPatient(resultSet.getInt(1), patientDto);
        }
    }

    @Override
    public Patient findById(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PATIENT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatient(resultSet);
        }
    }

    @Override
    public List<Patient> findByChambersId(int chambersId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_CHAMBER_ID);
            preparedStatement.setInt(1, chambersId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByDoctorsId(int doctorsId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_DOCTOR_ID);
            preparedStatement.setInt(1, doctorsId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findBySurname(String surname) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_SURNAME);
            preparedStatement.setString(1, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByProvisionalDiagnosis(String provisionalDiagnosis) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PROVISIONAL_DIAGNOSIS);
            preparedStatement.setString(1, provisionalDiagnosis);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByBirthday(Date birthday) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_BIRTHDAY);
            preparedStatement.setDate(1, (java.sql.Date) birthday);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByStatus(String status) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_STATUS);
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByBloodType(String bloodType) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_BLOOD_TYPE);
            preparedStatement.setString(1, bloodType);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByReceiptDate(Date receiptDate) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_RECEIPT_DATE);
            preparedStatement.setDate(1, (java.sql.Date) receiptDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public List<Patient> findByDischargeDate(Date dischargeDate) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_DISCHARGE_DATE);
            preparedStatement.setDate(1, (java.sql.Date) dischargeDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            return PatientMapper.toPatientList(resultSet);
        }
    }

    @Override
    public void deletePatient(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
        }
    }


}
