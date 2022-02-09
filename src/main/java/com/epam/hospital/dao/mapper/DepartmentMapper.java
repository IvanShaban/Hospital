package com.epam.hospital.dao.mapper;

import com.epam.hospital.dto.DepartmentDto;
import com.epam.hospital.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper {
    private DepartmentMapper() {}

    public static Department toDepartment(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new Department.Builder()
                .id(resultSet.getInt(1))
                .title(resultSet.getString(2))
                .chambersNumber(resultSet.getInt(3))
                .bedsNumber(resultSet.getInt(4))
                .setHeadDoctorId(resultSet.getInt(5))
                .build();
    }

    public static Department toDepartment(int id, DepartmentDto departmentDto) throws SQLException {
        return new Department.Builder()
                .id(id)
                .title(departmentDto.getTitle())
                .chambersNumber(departmentDto.getChambersNumber())
                .bedsNumber(departmentDto.getBedsNumber())
                .setHeadDoctorId(departmentDto.getHeadDoctorId())
                .build();
    }
}
