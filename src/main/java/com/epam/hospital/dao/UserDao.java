package com.epam.hospital.dao;

import com.epam.hospital.dto.UserDto;
import com.epam.hospital.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User, UserDto> {
    List<User> findByDepartmentsId(int departmentsId) throws SQLException;
    List<User> findBySurname(String surname) throws SQLException;
    List<User> findBySpecialisation(String specialisation) throws SQLException;
    User findByPhoneNumber(int phoneNumber) throws SQLException;
    List<User> findByRoleId(int roleId) throws SQLException;
    void deleteUser(int id) throws SQLException;
    User login(String login) throws SQLException;
    User updateById(int userId, UserDto userDto) throws SQLException;
    List<User> selectAllUsers() throws SQLException;
}
