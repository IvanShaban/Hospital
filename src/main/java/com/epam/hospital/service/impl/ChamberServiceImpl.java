package com.epam.hospital.service.impl;

import com.epam.hospital.controller.ContextListener;
import com.epam.hospital.dao.ChamberDao;
import com.epam.hospital.dao.impl.ChamberDaoImpl;
import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;
import com.epam.hospital.exception.*;
import com.epam.hospital.service.ChamberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ChamberServiceImpl implements ChamberService {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);
    private static final ChamberService instance = new ChamberServiceImpl();

    private ChamberDao chamberDao;

    public static ChamberService getInstance() {
        return instance;
    }

    private ChamberServiceImpl() {
        this.chamberDao = new ChamberDaoImpl();
    }

    @Override
    public Chamber insert (ChamberDto chamberDto) {
        if (chamberDto.getBedsNumber() < 1 || chamberDto.getDepartmentId() < 1) {
            logger.error("Chamber not valid " + chamberDto);
            throw new NotValidException("Chamber not valid " + chamberDto);
        }
        try {
            return chamberDao.insert(chamberDto);
        } catch (SQLException e) {
            logger.error("Cannot insert chamber " + chamberDto, e);
            throw new DaoException("Cannot insert chamber " + chamberDto, e);
        }
    }

    @Override
    public void insert (Chamber chamber) {
        if (chamber.getId() < 1 || chamber.getBedsNumber() < 1 || chamber.getDepartmentId() < 1) {
            logger.error("Chamber not valid " + chamber);
            throw new NotValidException("Chamber not valid " + chamber);
        }
        try {
            chamberDao.insert(chamber);
        } catch (SQLException e) {
            logger.error("Cannot insert chamber " + chamber, e);
            throw new DaoException("Cannot insert chamber " + chamber, e);
        }
    }

    @Override
    public Chamber findById(int id) {
        if (id < 1) {
            logger.error("Chamber id not valid " + id);
            throw new NotValidException("Chamber id not valid " + id);
        }
        try {
            return chamberDao.findById(id);
        } catch (SQLException e) {
            logger.error("Cannot find chamber by id " + id, e);
            throw new DaoException("Cannot find chamber by id " + id, e);
        }
    }

    @Override
    public List<Chamber> findByDepartmentId(int id) {
        if (id < 1) {
            logger.error("Department id not valid " + id);
            throw new NotValidException("Department id not valid " + id);
        }
        try {
            return chamberDao.findByDepartmentId(id);
        } catch (SQLException e) {
            logger.error("Cannot find chamber by department id " + id, e);
            throw new DaoException("Cannot find chamber by department id " + id, e);
        }
    }

    @Override
    public List<Chamber> selectAllChambers() {
        try {
            return chamberDao.selectAllChambers();
        } catch (SQLException e) {
            logger.error("Cannot find chambers ", e);
            throw new DaoException("Cannot find chamber by department id ", e);
        }
    }
}
