package com.epam.hospital.service.impl;

import com.epam.hospital.controller.ContextListener;
import com.epam.hospital.dao.DepartmentDao;
import com.epam.hospital.dao.impl.DepartmentDaoImpl;
import com.epam.hospital.dto.DepartmentDto;
import com.epam.hospital.entity.Department;
import com.epam.hospital.service.DepartmentService;
import com.epam.hospital.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);
    private static final DepartmentService instance = new DepartmentServiceImpl();

    private DepartmentDao departmentDao;

    public static DepartmentService getInstance() {
        return instance;
    }

    private DepartmentServiceImpl() {
        this.departmentDao = new DepartmentDaoImpl();
    }

    @Override
    public Department insert(DepartmentDto departmentDto) {
        if (departmentDto.getTitle() == null || departmentDto.getTitle().isEmpty() ||
                departmentDto.getChambersNumber() < 1 || departmentDto.getBedsNumber() < 1 ||
                departmentDto.getBedsNumber() > 8 || departmentDto.getHeadDoctorId() < 1) {
            logger.error("Department not valid " + departmentDto);
            throw new NotValidException("Department not valid " + departmentDto);
        }
        try {
            return departmentDao.insert(departmentDto);
        } catch (SQLException e) {
            logger.error("Cannot insert department " + departmentDto, e);
            throw new DaoException("Cannot insert department " + departmentDto, e);
        }
    }

    @Override
    public Department findById(int id) {
        if (id < 1) {
            logger.error("Department id not valid " + id);
            throw new NotValidException("Department id not valid " + id);
        }
        try {
            return departmentDao.findById(id);
        } catch (SQLException e) {
            logger.error("Cannot find department by id " + id, e);
            throw new DaoException("Cannot find department by id " + id, e);
        }
    }

    @Override
    public Department findByTitle(String title) {
        if (title == null || title.isEmpty()) {
            logger.error("Department title not valid " + title);
            throw new NotValidException("Department title not valid " + title);
        }
        try {
            return departmentDao.findByTitle(title);
        } catch (SQLException e) {
            logger.error("Cannot find department by id " + title, e);
            throw new DaoException("Cannot find department by id " + title, e);
        }
    }

    @Override
    public Department findByHeadDoctorsId(int headDoctorId) {
        if (headDoctorId < 1) {
            logger.error("Head doctor id not valid " + headDoctorId);
            throw new NotValidException("Head doctor id not valid " + headDoctorId);
        }
        try {
            return departmentDao.findById(headDoctorId);
        } catch (SQLException e) {
            logger.error("Cannot find department by head doctor id " + headDoctorId, e);
            throw new DaoException("Cannot find department by head doctor id " + headDoctorId, e);
        }
    }

    @Override
    public List<Department> selectAllDepartments() {
        try {
            return departmentDao.selectAllDepartments();
        } catch (SQLException e) {
            logger.error("Cannot find departments ", e);
            throw new DaoException("Cannot find departments ", e);
        }
    }
}
