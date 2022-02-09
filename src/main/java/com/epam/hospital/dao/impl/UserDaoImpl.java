package com.epam.hospital.dao.impl;

import com.epam.hospital.dao.UserDao;
import com.epam.hospital.dao.connectionpool.ConnectionPool;
import com.epam.hospital.dao.mapper.UserMapper;
import com.epam.hospital.dto.UserDto;
import com.epam.hospital.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public static final String INSERT_USER =
            "INSERT INTO hospital.users (login, password, departments_id, surname, name, patronymic, specialisation," +
                    "phone_number, roles_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER_BY_ID =
            "UPDATE hospital.users SET login = ?, password = ?, departments_id = ?, surname = ?, name = ?, patronymic = ?, specialisation = ?, phone_number = ?, roles_id = ? WHERE id = ?";
    public static final String SELECT_LAST_INSERT_ID = "SELECT id FROM hospital.users WHERE id = LAST_INSERT_ID()";
    public static final String SELECT_USER_BY_ID = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE id = ?";
    public static final String SELECT_USER_BY_DEPARTMENT_ID = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE departments_id = ?";
    public static final String SELECT_USER_BY_SURNAME = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE surname = ?";
    public static final String SELECT_USER_BY_SPECIALISATION = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE specialisation = ?";
    public static final String SELECT_USER_BY_PHONE_NUMBER = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE phone_number = ?";
    public static final String SELECT_USER_BY_ROLE_ID = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE roles_id = ?";
    public static final String DELETE_BY_ID = "DELETE FROM hospital.users WHERE id = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users WHERE login = ?";
    public static final String SELECT_ALL_FROM_TABLE = "SELECT id, login, password, departments_id, surname, name, patronymic, specialisation, phone_number, roles_id FROM hospital.users";

    private ConnectionPool connectionPool;

    public UserDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public User insert(UserDto userDto) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, userDto.getLogin());
            preparedStatement.setString(2, DigestUtils.sha256Hex(userDto.getPassword()));
            preparedStatement.setInt(3, userDto.getDepartmentsId());
            preparedStatement.setString(4, userDto.getSurname());
            preparedStatement.setString(5, userDto.getName());
            preparedStatement.setString(6, userDto.getPatronymic());
            preparedStatement.setString(7, userDto.getSpecialisation());
            preparedStatement.setInt(8, userDto.getPhoneNumber());
            preparedStatement.setInt(9, userDto.getRoleId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_LAST_INSERT_ID);
            resultSet.next();
            return UserMapper.toUser(resultSet.getInt(1), userDto);
        }
    }

    @Override
    public User updateById(int userId, UserDto userDto) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
            preparedStatement.setString(1, userDto.getLogin());
            preparedStatement.setString(2, DigestUtils.sha256Hex(userDto.getPassword()));
            preparedStatement.setInt(3, userDto.getDepartmentsId());
            preparedStatement.setString(4, userDto.getSurname());
            preparedStatement.setString(5, userDto.getName());
            preparedStatement.setString(6, userDto.getPatronymic());
            preparedStatement.setString(7, userDto.getSpecialisation());
            preparedStatement.setInt(8, userDto.getPhoneNumber());
            preparedStatement.setInt(9, userDto.getRoleId());
            preparedStatement.setInt(10, userId);
            preparedStatement.executeUpdate();
            return UserMapper.toUser(userId, userDto);
        }
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_TABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUserList(resultSet);
        }
    }

    @Override
    public User findById(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUser(resultSet);
        }
    }

    @Override
    public List<User> findByDepartmentsId(int departmentsId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_DEPARTMENT_ID);
            preparedStatement.setInt(1, departmentsId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUserList(resultSet);
        }
    }

    @Override
    public List<User> findBySurname(String surname) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_SURNAME);
            preparedStatement.setString(1, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUserList(resultSet);
        }
    }

    @Override
    public List<User> findBySpecialisation(String specialisation) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_SPECIALISATION);
            preparedStatement.setString(1, specialisation);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUserList(resultSet);
        }
    }

    @Override
    public User findByPhoneNumber(int phoneNumber) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_PHONE_NUMBER);
            preparedStatement.setInt(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUser(resultSet);
        }
    }

    @Override
    public List<User> findByRoleId(int roleId) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ROLE_ID);
            preparedStatement.setInt(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUserList(resultSet);
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
        }
    }

    @Override
    public User login(String login) throws SQLException {
        try (Connection connection = connectionPool.takeConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            return UserMapper.toUser(resultSet);
        }
    }
}
