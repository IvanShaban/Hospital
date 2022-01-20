package com.epam.hospital.service.impl;

import com.epam.hospital.dao.ChamberDao;
import com.epam.hospital.dao.impl.ChamberDaoImpl;
import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;
import com.epam.hospital.service.ChamberService;
import com.epam.hospital.exception.DaoException;
import com.epam.hospital.exception.NotValidException;

import java.sql.SQLException;

public class ChamberServiceImpl implements ChamberService {
    private ChamberDao chamberDao;

    public ChamberServiceImpl() {
        this.chamberDao = new ChamberDaoImpl();
    }

    public Chamber insert (ChamberDto chamberDto) {
        if (chamberDto.getBedsNumber() < 1 || chamberDto.getDepartmentId() < 1) {
            throw new NotValidException("Chamber not valid " + chamberDto);
        }
        try {
            return chamberDao.insert(chamberDto);
        } catch (SQLException e) {
            throw new DaoException("Cannot insert chamber " + chamberDto, e);
        }
    }
}
