package com.epam.hospital.dao.mapper;

import com.epam.hospital.dto.UserDto;
import com.epam.hospital.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private UserMapper() {}

    public static User toUser(ResultSet resultSet) throws SQLException {
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
                .phoneNumber(resultSet.getString(9))
                .roleId(resultSet.getInt(10))
                .build();
    }

    public static User toUser(int id, UserDto userDto) {
        return new User.Builder()
                .id(id)
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .departmentsId(userDto.getDepartmentsId())
                .surname(userDto.getSurname())
                .name(userDto.getName())
                .patronymic(userDto.getPatronymic())
                .specialisation(userDto.getSpecialisation())
                .phoneNumber(userDto.getPhoneNumber())
                .roleId(userDto.getRoleId())
                .build();
    }

    public static List<User> toUserList(ResultSet resultSet) throws SQLException {
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
                    .phoneNumber(resultSet.getString(9))
                    .roleId(resultSet.getInt(10))
                    .build());
        }
        return users;
    }
}
