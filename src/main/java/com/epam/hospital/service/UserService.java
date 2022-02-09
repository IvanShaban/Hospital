package com.epam.hospital.service;

import com.epam.hospital.dto.UserDto;
import com.epam.hospital.entity.User;

import java.util.List;

public interface UserService extends Service<User, UserDto> {
    List<User> findByDepartmentsId(int departmentsId);
    List<User> findBySurname(String surname);
    List<User> findBySpecialisation(String specialisation);
    User findByPhoneNumber(int phoneNumber);
    List<User> findByRoleId(int roleId);
    void deleteUser(int id);
    User login(String login, String password);
    User findByLogin(String login);
    User updateById(int userId, UserDto userDto);
    List<User> selectAllUsers();
}
