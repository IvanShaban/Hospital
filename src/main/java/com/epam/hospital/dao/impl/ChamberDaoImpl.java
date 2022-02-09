package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.ChamberDao;
import com.epam.hospital.dao.connectionpool.ConnectionPool;
import com.epam.hospital.dao.mapper.ChamberMapper;
import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;

import java.sql.*;
import java.util.List;

public class ChamberDaoImpl implements ChamberDao {
    public static final String INSERT_CHAMBER = "INSERT INTO hospital.chambers (departments_id, number_of_beds) VALUES (?, ?)";
    public static final String SELECT_LAST_INSERT_ID = "SELECT id FROM hospital.chambers WHERE id = LAST_INSERT_ID()";
    public static final String SELECT_ALL_BY_CHAMBER_ID = "SELECT id, departments_id, number_of_beds FROM hospital.chambers WHERE id = ?";
    public static final String SELECT_ALL_BY_DEPARTMENT_ID = "SELECT id, departments_id, number_of_beds FROM hospital.chambers WHERE departments_id = ?";
    public static final String SELECT_ALL_CHAMBERS = "SELECT id, departments_id, number_of_beds FROM hospital.chambers";

    private ConnectionPool connectionPool;

    public ChamberDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public Chamber insert(ChamberDto chamberDto) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHAMBER);
            preparedStatement.setInt(1, chamberDto.getDepartmentId());
            preparedStatement.setInt(2, chamberDto.getBedsNumber());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_LAST_INSERT_ID);
            resultSet.next();
            return ChamberMapper.toChamber(resultSet.getInt(1), chamberDto);
        }
    }

    @Override
    public Chamber findById(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_CHAMBER_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ChamberMapper.toChamber(resultSet);
        }
    }

    @Override
    public List<Chamber> findByDepartmentId(int departmentId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_DEPARTMENT_ID);
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ChamberMapper.toChamberList(resultSet);
        }
    }

    @Override
    public List<Chamber> selectAllChambers() throws SQLException{
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CHAMBERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ChamberMapper.toChamberList(resultSet);
        }
    }
}
