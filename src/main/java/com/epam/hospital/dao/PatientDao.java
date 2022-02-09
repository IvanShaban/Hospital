package com.epam.hospital.dao;

import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.entity.Patient;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface PatientDao extends Dao<Patient, PatientDto> {
    List<Patient> findByChambersId(int chambersId) throws SQLException;
    List<Patient> findByDoctorsId(int doctorsId) throws SQLException;
    List<Patient> findBySurname(String surname) throws SQLException;
    List<Patient> findByProvisionalDiagnosis(String provisionalDiagnosis) throws SQLException;
    List<Patient> findByBirthday(Date birthday) throws SQLException;
    List<Patient> findByStatus(String status) throws SQLException;
    List<Patient> findByBloodType(String bloodType) throws SQLException;
    List<Patient> findByReceiptDate(Date receiptDate) throws SQLException;
    List<Patient> findByDischargeDate(Date dischargeDate) throws SQLException;
    void deletePatient(int id) throws SQLException;
}
