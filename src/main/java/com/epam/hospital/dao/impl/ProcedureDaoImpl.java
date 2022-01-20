package com.epam.hospital.dao.impl;

import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.entity.Procedure;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcedureDaoImpl {
    String USERNAME = "root";
    String PASSWORD = "root";
    String URL = "jdbc:mysql://localhost:3306/hospital";

    public Procedure insert(ProcedureDto procedureDto) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO procedures (patients_id, date_of_completion, name_of_procedure, appointed_doctors," +
                            "access, performed_by_id, specification) " +
                            "VALUES ('" + procedureDto.getPatientsId() + "', '" + procedureDto.getCompletionDate() + "', '" +
                            procedureDto.getProceduresName() + "', '" + procedureDto.getAppointedDoctorsId() + "', '" +
                            procedureDto.getAccess() + "', '" + procedureDto.getPerformedUserId() + "', '" +
                            procedureDto.getSpecification() + "')");
            ResultSet resultSet = statement.executeQuery("SELECT id from chambers where id = LAST_INSERT_ID()");
            resultSet.next();
            return new Procedure.Builder()
                    .id(resultSet.getInt(1))
                    .patientsId(resultSet.getInt(2))
                    .completionDate(resultSet.getDate(3))
                    .proceduresName(resultSet.getString(4))
                    .appointedDoctorsId(resultSet.getInt(5))
                    .access(resultSet.getString(6))
                    .performedUserId(resultSet.getInt(7))
                    .specification(resultSet.getString(8))
                    .build();
        }
    }

    public Procedure findById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where id = " + id);
            resultSet.next();
            return new Procedure.Builder()
                    .id(resultSet.getInt(1))
                    .patientsId(resultSet.getInt(2))
                    .completionDate(resultSet.getDate(3))
                    .proceduresName(resultSet.getString(4))
                    .appointedDoctorsId(resultSet.getInt(5))
                    .access(resultSet.getString(6))
                    .performedUserId(resultSet.getInt(7))
                    .specification(resultSet.getString(8))
                    .build();
        }
    }

    public List<Procedure> findByPatientsId(int patientsId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where patients_id = " + patientsId);
            List<Procedure> procedures = new ArrayList<>();
            while (resultSet.next()) {
                procedures.add(new Procedure.Builder()
                        .id(resultSet.getInt(1))
                        .patientsId(resultSet.getInt(2))
                        .completionDate(resultSet.getDate(3))
                        .proceduresName(resultSet.getString(4))
                        .appointedDoctorsId(resultSet.getInt(5))
                        .access(resultSet.getString(6))
                        .performedUserId(resultSet.getInt(7))
                        .specification(resultSet.getString(8))
                        .build());
            }
            return procedures;
        }
    }

    public List<Procedure> findByCompletionDate(Date completionDate) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where date_of_completion = " + completionDate);
            List<Procedure> procedures = new ArrayList<>();
            while (resultSet.next()) {
                procedures.add(new Procedure.Builder()
                        .id(resultSet.getInt(1))
                        .patientsId(resultSet.getInt(2))
                        .completionDate(resultSet.getDate(3))
                        .proceduresName(resultSet.getString(4))
                        .appointedDoctorsId(resultSet.getInt(5))
                        .access(resultSet.getString(6))
                        .performedUserId(resultSet.getInt(7))
                        .specification(resultSet.getString(8))
                        .build());
            }
            return procedures;
        }
    }

    public List<Procedure> findByProceduresName(String proceduresName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where name_of_procedure = " + proceduresName);
            List<Procedure> procedures = new ArrayList<>();
            while (resultSet.next()) {
                procedures.add(new Procedure.Builder()
                        .id(resultSet.getInt(1))
                        .patientsId(resultSet.getInt(2))
                        .completionDate(resultSet.getDate(3))
                        .proceduresName(resultSet.getString(4))
                        .appointedDoctorsId(resultSet.getInt(5))
                        .access(resultSet.getString(6))
                        .performedUserId(resultSet.getInt(7))
                        .specification(resultSet.getString(8))
                        .build());
            }
            return procedures;
        }
    }

    public List<Procedure> findByAppointedDoctorsId(int appointedDoctorsId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where appointed_doctors = " + appointedDoctorsId);
            List<Procedure> procedures = new ArrayList<>();
            while (resultSet.next()) {
                procedures.add(new Procedure.Builder()
                        .id(resultSet.getInt(1))
                        .patientsId(resultSet.getInt(2))
                        .completionDate(resultSet.getDate(3))
                        .proceduresName(resultSet.getString(4))
                        .appointedDoctorsId(resultSet.getInt(5))
                        .access(resultSet.getString(6))
                        .performedUserId(resultSet.getInt(7))
                        .specification(resultSet.getString(8))
                        .build());
            }
            return procedures;
        }
    }

    public List<Procedure> findByPerformedUserId(int performedUserId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where performed_by_id = " + performedUserId);
            List<Procedure> procedures = new ArrayList<>();
            while (resultSet.next()) {
                procedures.add(new Procedure.Builder()
                        .id(resultSet.getInt(1))
                        .patientsId(resultSet.getInt(2))
                        .completionDate(resultSet.getDate(3))
                        .proceduresName(resultSet.getString(4))
                        .appointedDoctorsId(resultSet.getInt(5))
                        .access(resultSet.getString(6))
                        .performedUserId(resultSet.getInt(7))
                        .specification(resultSet.getString(8))
                        .build());
            }
            return procedures;
        }
    }

    public List<Procedure> findByPerformedUserIdMy(int performedUserId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, patients_id, date_of_completion, name_of_procedure, appointed_doctors, access, " +
                            "performed_by_id, specification " +
                            "from procedures where performed_by_id = " + performedUserId);
            return creator(resultSet);
        }
    }

    private List<Procedure> creator(ResultSet resultSet) throws SQLException {
        ArrayList<Procedure> procedures = new ArrayList<>();
        while (resultSet.next()) {
            procedures.add(new Procedure.Builder()
                    .id(resultSet.getInt(1))
                    .patientsId(resultSet.getInt(2))
                    .completionDate(resultSet.getDate(3))
                    .proceduresName(resultSet.getString(4))
                    .appointedDoctorsId(resultSet.getInt(5))
                    .access(resultSet.getString(6))
                    .performedUserId(resultSet.getInt(7))
                    .specification(resultSet.getString(8))
                    .build());
        }
        return procedures;
    }
}
