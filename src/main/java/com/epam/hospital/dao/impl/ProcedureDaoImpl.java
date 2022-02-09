package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.ProcedureDao;
import com.epam.hospital.dao.connectionpool.ConnectionPool;
import com.epam.hospital.dao.mapper.ProcedureMapper;
import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.entity.Procedure;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class ProcedureDaoImpl implements ProcedureDao {
    public static final String INSERT_PROCEDURE =
            "INSERT INTO hospital.procedures (patients_id, date_of_completion, name_of_procedure, appointed_doctors_id," +
                    "access, specification) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_LAST_INSERT_ID = "SELECT id FROM hospital.procedures WHERE id = LAST_INSERT_ID()";
    public static final String SELECT_ALL_BY_PROCEDURE_ID = "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors_id, access, " +
            "performed_by_id, specification " +
            "FROM hospital.procedures WHERE id = ?";
    public static final String SELECT_ALL_BY_PATIENT_ID = "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors_id, access, " +
            "performed_by_id, specification " +
            "FROM hospital.procedures WHERE patients_id = ?";
    public static final String SELECT_ALL_BY_COMPLETION_DATE = "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors_id, access, " +
            "performed_by_id, specification " +
            "FROM hospital.procedures WHERE date_of_completion = ?";
    public static final String SELECT_ALL_BY_PROCEDURE_NAME = "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors_id, access, " +
            "performed_by_id, specification " +
            "FROM hospital.procedures WHERE name_of_procedure = ?";
    public static final String SELECT_ALL_BY_APPOINTED_DOCTOR_ID = "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors_id, access, " +
            "performed_by_id, specification " +
            "FROM hospital.procedures WHERE appointed_doctors_id = ?";
    public static final String SELECT_ALL_BY_PERFORMED_USER_ID = "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors_id, access, " +
            "performed_by_id, specification " +
            "FROM hospital.procedures WHERE performed_by_id = ?";
    public static final String DELETE_BY_ID = "DELETE FROM hospital.procedures WHERE id = ?";

    private ConnectionPool connectionPool;

    public ProcedureDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public Procedure insert(ProcedureDto procedureDto) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROCEDURE);
            preparedStatement.setInt(1, procedureDto.getPatientsId());
            preparedStatement.setInt(2, procedureDto.getCompletionDate());
            preparedStatement.setString(3, procedureDto.getProceduresName());
            preparedStatement.setInt(4, procedureDto.getAppointedDoctorsId());
            preparedStatement.setInt(5, procedureDto.getAccess());
            preparedStatement.setString(6, procedureDto.getSpecification());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_LAST_INSERT_ID);
            resultSet.next();
            return ProcedureMapper.toProcedure(resultSet.getInt(1), procedureDto);
        }
    }

    @Override
    public Procedure findById(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PROCEDURE_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ProcedureMapper.toProcedure(resultSet);
        }
    }

    @Override
    public List<Procedure> findByPatientsId(int patientsId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PATIENT_ID);
            preparedStatement.setInt(1, patientsId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ProcedureMapper.toProcedureList(resultSet);
        }
    }

    @Override
    public List<Procedure> findByCompletionDate(Date completionDate) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_COMPLETION_DATE);
            preparedStatement.setDate(1, (java.sql.Date) completionDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ProcedureMapper.toProcedureList(resultSet);
        }
    }

    @Override
    public List<Procedure> findByProceduresName(String proceduresName) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PROCEDURE_NAME);
            preparedStatement.setString(1, proceduresName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ProcedureMapper.toProcedureList(resultSet);
        }
    }

    @Override
    public List<Procedure> findByAppointedDoctorsId(int appointedDoctorsId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_APPOINTED_DOCTOR_ID);
            preparedStatement.setInt(1, appointedDoctorsId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ProcedureMapper.toProcedureList(resultSet);
        }
    }

    @Override
    public List<Procedure> findByPerformedUserId(int performedUserId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PERFORMED_USER_ID);
            preparedStatement.setInt(1, performedUserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ProcedureMapper.toProcedureList(resultSet);
        }
    }

    @Override
    public void deleteProcedure(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
        }
    }
}
