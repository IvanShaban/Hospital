package com.epam.hospital.service.impl;

import com.epam.hospital.controller.ContextListener;
import com.epam.hospital.dao.ProcedureDao;
import com.epam.hospital.dao.impl.ProcedureDaoImpl;
import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.entity.Procedure;
import com.epam.hospital.service.ChamberService;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.ProcedureService;
import com.epam.hospital.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProcedureServiceImpl implements ProcedureService {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);
    private static final ProcedureService instance = new ProcedureServiceImpl();

    private ProcedureDao procedureDao;

    public static ProcedureService getInstance() {
        return instance;
    }

    private ProcedureServiceImpl() {
        this.procedureDao = new ProcedureDaoImpl();
    }

    @Override
    public Procedure insert(ProcedureDto procedureDto) {
        if (procedureDto.getPatientsId() < 1 || procedureDto.getProceduresName() == null ||
                procedureDto.getProceduresName().isEmpty() || procedureDto.getAppointedDoctorsId() < 1 ||
                procedureDto.getAccess() < 3 || procedureDto.getAccess() > 4) {
            logger.error("Procedure not valid " + procedureDto);
            throw new NotValidException("Procedure not valid " + procedureDto);
        }
        try {
            return procedureDao.insert(procedureDto);
        } catch (SQLException e) {
            logger.error("Cannot insert procedure " + procedureDto, e);
            throw new DaoException("Cannot insert procedure " + procedureDto, e);
        }
    }

    @Override
    public Procedure findById(int id) {
        if (id < 1) {
            logger.error("Procedure id not valid " + id);
            throw new NotValidException("Procedure id not valid " + id);
        }
        try {
            return procedureDao.findById(id);
        } catch (SQLException e) {
            logger.error("Cannot find procedure by id " + id, e);
            throw new DaoException("Cannot find procedure by id " + id, e);
        }
    }

    @Override
    public List<Procedure> findByPatientsId(int patientsId) {
        if (patientsId < 1) {
            logger.error("Patient id not valid " + patientsId);
            throw new NotValidException("Patient id not valid " + patientsId);
        }
        try {
            return procedureDao.findByPatientsId(patientsId);
        } catch (SQLException e) {
            logger.error("Cannot find patient by id " + patientsId, e);
            throw new DaoException("Cannot find patient by id " + patientsId, e);
        }
    }

    @Override
    public List<Procedure> findByCompletionDate(Date completionDate) {
        return null;
    }

    @Override
    public List<Procedure> findByProceduresName(String proceduresName) {
        if (proceduresName == null || proceduresName.isEmpty()) {
            logger.error("Procedure name not valid " + proceduresName);
            throw new NotValidException("Procedure name not valid " + proceduresName);
        }
        try {
            return procedureDao.findByProceduresName(proceduresName);
        } catch (SQLException e) {
            logger.error("Cannot find procedure by procedure name " + proceduresName, e);
            throw new DaoException("Cannot find procedure by procedure name " + proceduresName, e);
        }
    }

    @Override
    public List<Procedure> findByAppointedDoctorsId(int appointedDoctorsId) {
        if (appointedDoctorsId < 1) {
            logger.error("Appointed doctor id not valid " + appointedDoctorsId);
            throw new NotValidException("Appointed doctor id not valid " + appointedDoctorsId);
        }
        try {
            return procedureDao.findByAppointedDoctorsId(appointedDoctorsId);
        } catch (SQLException e) {
            logger.error("Cannot find procedure by appointed doctor id " + appointedDoctorsId, e);
            throw new DaoException("Cannot find procedure by appointed doctor id " + appointedDoctorsId, e);
        }
    }

    @Override
    public List<Procedure> findByPerformedUserId(int performedUserId) {
        if (performedUserId < 1) {
            logger.error("Performed user id not valid " + performedUserId);
            throw new NotValidException("Performed user id not valid " + performedUserId);
        }
        try {
            return procedureDao.findByPerformedUserId(performedUserId);
        } catch (SQLException e) {
            logger.error("Cannot find procedure by performed user id " + performedUserId, e);
            throw new DaoException("Cannot find procedure by performed user id " + performedUserId, e);
        }
    }

    @Override
    public void deleteProcedure(int id) {
        if (id < 1) {
            logger.error("Procedure id not valid " + id);
            throw new NotValidException("Procedure id not valid " + id);
        }
        try {
            procedureDao.deleteProcedure(id);
        } catch (SQLException e) {
            logger.error("Cannot find procedure by id " + id, e);
            throw new DaoException("Cannot find procedure by id " + id, e);
        }
    }
}
