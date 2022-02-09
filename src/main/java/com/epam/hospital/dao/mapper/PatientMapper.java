package com.epam.hospital.dao.mapper;

import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.entity.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientMapper {
    private PatientMapper() {}

    public static Patient toPatient(ResultSet resultSet) throws SQLException {
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
                .birthday(resultSet.getInt(9))
                .status(resultSet.getString(10))
                .bloodType(resultSet.getString(11))
                .allergy(resultSet.getString(12))
                .receiptDate(resultSet.getInt(13))
                .dischargeDate(resultSet.getInt(14))
                .build();
    }

    public static Patient toPatient(int id, PatientDto patientDto) throws SQLException {
        return new Patient.Builder()
                .id(id)
                .chambersId(patientDto.getChambersId())
                .doctorsId(patientDto.getDoctorsId())
                .surname(patientDto.getSurname())
                .name(patientDto.getName())
                .patronymic(patientDto.getPatronymic())
                .provisionalDiagnosis(patientDto.getProvisionalDiagnosis())
                .address(patientDto.getAddress())
                .birthday(patientDto.getBirthday())
                .status(patientDto.getStatus())
                .bloodType(patientDto.getBloodType())
                .allergy(patientDto.getAllergy())
                .receiptDate(patientDto.getReceiptDate())
                .dischargeDate(patientDto.getDischargeDate())
                .build();
    }

    public static List<Patient> toPatientList(ResultSet resultSet) throws SQLException {
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
                    .birthday(resultSet.getInt(9))
                    .status(resultSet.getString(10))
                    .bloodType(resultSet.getString(11))
                    .allergy(resultSet.getString(12))
                    .receiptDate(resultSet.getInt(13))
                    .dischargeDate(resultSet.getInt(14))
                    .build());
        }
        return patients;
    }
}
