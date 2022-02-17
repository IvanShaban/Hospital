package com.epam.hospital.service.impl;

import com.epam.hospital.controller.ContextListener;
import com.epam.hospital.dao.PatientDao;
import com.epam.hospital.dao.impl.PatientDaoImpl;
import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.entity.Chamber;
import com.epam.hospital.entity.Patient;
import com.epam.hospital.entity.PatientStatus;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);
    private static final PatientService instance = new PatientServiceImpl();

    private PatientDao patientDao;

    public static PatientService getInstance() {
        return instance;
    }

    private PatientServiceImpl() {
        this.patientDao = new PatientDaoImpl();
    }

    @Override
    public Patient insert(PatientDto patientDto) {
        if (patientDto.getSurname() == null || patientDto.getSurname().isEmpty() || patientDto.getName() == null ||
                patientDto.getName().isEmpty() || patientDto.getStatus() == null || patientDto.getStatus().isEmpty()) {
            logger.error("Patient not valid " + patientDto);
            throw new NotValidException("Patient not valid " + patientDto);
        }
        try {
            return patientDao.insert(patientDto);
        } catch (SQLException e) {
            logger.error("Cannot insert patient " + patientDto, e);
            throw new DaoException("Cannot insert patient " + patientDto, e);
        }
    }

    @Override
    public Patient findById(int id) {
        if (id < 1) {
            logger.error("Patient id not valid " + id);
            throw new NotValidException("Patient id not valid " + id);
        }
        try {
            return patientDao.findById(id);
        } catch (SQLException e) {
            logger.error("Cannot find patient by id " + id, e);
//            throw new DaoException("Cannot find patient by id " + id, e);
            return null;
        }
    }

    @Override
    public List<Patient> findByChambersId(int chambersId) {
        if (chambersId < 1) {
            logger.error("Chamber id not valid " + chambersId);
            throw new NotValidException("Chamber id not valid " + chambersId);
        }
        try {
            return patientDao.findByChambersId(chambersId);
        } catch (SQLException e) {
            logger.error("Cannot find patient by chamber id " + chambersId, e);
            throw new DaoException("Cannot find patient by chamber id " + chambersId, e);
        }
    }

    @Override
    public List<Patient> findByDoctorsId(int doctorsId) {
        if (doctorsId < 1) {
            logger.error("Doctor id not valid " + doctorsId);
            throw new NotValidException("Doctor id not valid " + doctorsId);
        }
        try {
            return patientDao.findByDoctorsId(doctorsId);
        } catch (SQLException e) {
            logger.error("Cannot find patient by doctor id " + doctorsId, e);
            throw new DaoException("Cannot find patient by doctor id " + doctorsId, e);
        }
    }

    @Override
    public List<Patient> findBySurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            logger.error("Patient surname not valid " + surname);
            throw new NotValidException("Patient surname not valid " + surname);
        }
        try {
            return patientDao.findBySurname(surname);
        } catch (SQLException e) {
            logger.error("Cannot find patient by surname " + surname, e);
            throw new DaoException("Cannot find patient by surname " + surname, e);
        }
    }

    @Override
    public List<Patient> findByProvisionalDiagnosis(String provisionalDiagnosis) {
        if (provisionalDiagnosis == null || provisionalDiagnosis.isEmpty()) {
            logger.error("Patient provisional diagnosis not valid " + provisionalDiagnosis);
            throw new NotValidException("Patient provisional diagnosis not valid " + provisionalDiagnosis);
        }
        try {
            return patientDao.findByProvisionalDiagnosis(provisionalDiagnosis);
        } catch (SQLException e) {
            logger.error("Cannot find patient by provisional diagnosis " + provisionalDiagnosis, e);
            throw new DaoException("Cannot find patient by provisional diagnosis " + provisionalDiagnosis, e);
        }
    }

    @Override
    public List<Patient> findByBirthday(Date birthday) {
        return null;
    }

    @Override
    public List<Patient> findByStatus(String status) {
        if (status == null || status.isEmpty()) {
            logger.error("Patient status not valid " + status);
            throw new NotValidException("Patient status not valid " + status);
        }
        try {
            return patientDao.findByStatus(status);
        } catch (SQLException e) {
            logger.error("Cannot find patient by status " + status, e);
            throw new DaoException("Cannot find patient by status " + status, e);
        }
    }

    @Override
    public List<Patient> findByBloodType(String bloodType) {
        if (bloodType == null || bloodType.isEmpty()) {
            logger.error("Patient blood type not valid " + bloodType);
            throw new NotValidException("Patient blood type not valid " + bloodType);
        }
        try {
            return patientDao.findByBloodType(bloodType);
        } catch (SQLException e) {
            logger.error("Cannot find patient by blood type " + bloodType, e);
            throw new DaoException("Cannot find patient by blood type " + bloodType, e);
        }
    }

    @Override
    public List<Patient> findByReceiptDate(Date receiptDate) {
        return null;
    }

    @Override
    public List<Patient> findByDischargeDate(Date dischargeDate) {
        return null;
    }

    @Override
    public void deletePatient(int id) {
        if (id < 1) {
            logger.error("Patient id not valid " + id);
            throw new NotValidException("Patient id not valid " + id);
        }
        try {
            patientDao.deletePatient(id);
        } catch (SQLException e) {
            logger.error("Cannot find patient by id " + id, e);
            throw new DaoException("Cannot find patient by id " + id, e);
        }
    }

    @Override
    public List<Chamber> findFreeBeds(List<Chamber> chambers) {
        try {
            List<Patient> patients = patientDao.findByStatus(String.valueOf(PatientStatus.ENABLE));
            for (Chamber chamber : chambers) {
                int freeBeds = chamber.getBedsNumber();
                for (Patient patient : patients) {
                    if (chamber.getId() == patient.getChambersId()) {
                        freeBeds--;
                    }
                }
                chamber.setBedsNumber(freeBeds);
            }
            return chambers;
        } catch (SQLException e) {
            logger.error("Cannot find patient by status ", e);
            throw new DaoException("Cannot find patient by status ", e);
        }
    }

    @Override
    public void writeOutPatient(int id) {
        if (id < 1) {
            logger.error("Patient id not valid " + id);
            throw new NotValidException("Patient id not valid " + id);
        }
        try {
            patientDao.writeOutPatient(id);
        } catch (SQLException e) {
            logger.error("Cannot find patient by id " + id, e);
            throw new DaoException("Cannot find patient by id " + id, e);
        }
    }
}
