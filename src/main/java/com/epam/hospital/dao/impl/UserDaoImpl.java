package com.epam.hospital.dao.impl;

import com.epam.hospital.dto.UserDto;
import com.epam.hospital.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    String USERNAME = "root";
    String PASSWORD = "root";
    String URL = "jdbc:mysql://localhost:3306/hospital";

    public User insert(UserDto userDto) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO users (login, password, departments_id, surname, name, patronymic, specialisation," +
                            "phone_number, roles) " +
                            "VALUES ('" + userDto.getLogin() + "', '" + userDto.getPassword() + "', '" +
                            userDto.getDepartmentsId() + "', '" + userDto.getSurname() + "', '" + userDto.getName() + "', '" +
                            userDto.getPatronymic() + "', '" + userDto.getSpecialisation() + "', '" +
                            userDto.getPhoneNumber() + "', '" + userDto.getRoleId() + "')");
            ResultSet resultSet = statement.executeQuery("SELECT id from chambers where id = LAST_INSERT_ID()");
            resultSet.next();
            return new User.Builder()
                    .id(resultSet.getInt(1))
                    .login(resultSet.getString(2))
                    .password(resultSet.getString(3))
                    .departmentsId(resultSet.getInt(4))
                    .surname(resultSet.getString(5))
                    .name(resultSet.getString(6))
                    .patronymic(resultSet.getString(7))
                    .specialisation(resultSet.getString(8))
                    .phoneNumber(resultSet.getInt(9))
                    .roleId(resultSet.getInt(10))
                    .build();
        }
    }

    public User findById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, " +
                            "phone_number, roles from departments where id = " + id);
            resultSet.next();
            return new User.Builder()
                    .id(resultSet.getInt(1))
                    .login(resultSet.getString(2))
                    .password(resultSet.getString(3))
                    .departmentsId(resultSet.getInt(4))
                    .surname(resultSet.getString(5))
                    .name(resultSet.getString(6))
                    .patronymic(resultSet.getString(7))
                    .specialisation(resultSet.getString(8))
                    .phoneNumber(resultSet.getInt(9))
                    .roleId(resultSet.getInt(10))
                    .build();
        }
    }

    public List<User> findByDepartmentsId(int departmentsId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, " +
                            "phone_number, roles from departments where departments_id = " + departmentsId);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User.Builder()
                        .id(resultSet.getInt(1))
                        .login(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .departmentsId(resultSet.getInt(4))
                        .surname(resultSet.getString(5))
                        .name(resultSet.getString(6))
                        .patronymic(resultSet.getString(7))
                        .specialisation(resultSet.getString(8))
                        .phoneNumber(resultSet.getInt(9))
                        .roleId(resultSet.getInt(10))
                        .build());
            }
            return users;
        }
    }

    public List<User> findBySurname(String surname) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, " +
                            "phone_number, roles from departments where surname = " + surname);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User.Builder()
                        .id(resultSet.getInt(1))
                        .login(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .departmentsId(resultSet.getInt(4))
                        .surname(resultSet.getString(5))
                        .name(resultSet.getString(6))
                        .patronymic(resultSet.getString(7))
                        .specialisation(resultSet.getString(8))
                        .phoneNumber(resultSet.getInt(9))
                        .roleId(resultSet.getInt(10))
                        .build());
            }
            return users;
        }
    }

    public List<User> findBySpecialisation(String specialisation) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, " +
                            "phone_number, roles from departments where specialisation = " + specialisation);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User.Builder()
                        .id(resultSet.getInt(1))
                        .login(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .departmentsId(resultSet.getInt(4))
                        .surname(resultSet.getString(5))
                        .name(resultSet.getString(6))
                        .patronymic(resultSet.getString(7))
                        .specialisation(resultSet.getString(8))
                        .phoneNumber(resultSet.getInt(9))
                        .roleId(resultSet.getInt(10))
                        .build());
            }
            return users;
        }
    }

    public User findByPhoneNumber(int phoneNumber) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, " +
                            "phone_number, roles from departments where phone_number = " + phoneNumber);
            resultSet.next();
            return new User.Builder()
                    .id(resultSet.getInt(1))
                    .login(resultSet.getString(2))
                    .password(resultSet.getString(3))
                    .departmentsId(resultSet.getInt(4))
                    .surname(resultSet.getString(5))
                    .name(resultSet.getString(6))
                    .patronymic(resultSet.getString(7))
                    .specialisation(resultSet.getString(8))
                    .phoneNumber(resultSet.getInt(9))
                    .roleId(resultSet.getInt(10))
                    .build();
        }
    }

    public List<User> findByRoleId(int roleId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, " +
                            "phone_number, roles from departments where roles = " + roleId);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User.Builder()
                        .id(resultSet.getInt(1))
                        .login(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .departmentsId(resultSet.getInt(4))
                        .surname(resultSet.getString(5))
                        .name(resultSet.getString(6))
                        .patronymic(resultSet.getString(7))
                        .specialisation(resultSet.getString(8))
                        .phoneNumber(resultSet.getInt(9))
                        .roleId(resultSet.getInt(10))
                        .build());
            }
            return users;
        }
    }
}
