package com.epam.hospital.dao.mapper;

import com.epam.hospital.entity.Chamber;
import com.epam.hospital.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentMapper {
    private DepartmentMapper() {
    }

    public static List<Department> toDepartmentList(ResultSet resultSet) throws SQLException {
        List<Chamber> chambers = new ArrayList<>();
        while (resultSet.next()) {
            chambers.add(new Chamber.Builder()
                    .id(resultSet.getInt(1))
                    .departmentId(resultSet.getInt(2))
                    .bedsNumber(resultSet.getInt(3))
                    .build());
        }
        return chambers;
    }

    public static Chamber toDepartment(ResultSet resultSet) throws SQLException {
        return new Chamber.Builder()
                .id(resultSet.getInt(1))
                .departmentId(resultSet.getInt(2))
                .bedsNumber(resultSet.getInt(3))
                .build();
    }
}
