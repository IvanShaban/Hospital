package com.epam.hospital.service;

import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.entity.Chamber;
import com.epam.hospital.entity.Patient;

import java.util.Date;
import java.util.List;

public interface PatientService extends Service<Patient, PatientDto> {
    List<Patient> findByChambersId(int chambersId);
    List<Patient> findByDoctorsId(int doctorsId);
    List<Patient> findBySurname(String surname);
    List<Patient> findByProvisionalDiagnosis(String provisionalDiagnosis);
    List<Patient> findByBirthday(Date birthday);
    List<Patient> findByStatus(String status);
    List<Patient> findByBloodType(String bloodType);
    List<Patient> findByReceiptDate(Date receiptDate);
    List<Patient> findByDischargeDate(Date dischargeDate);
    void deletePatient(int id);
    List<Chamber> findFreeBeds(List<Chamber> chambers);
    void writeOutPatient(int id);
}
