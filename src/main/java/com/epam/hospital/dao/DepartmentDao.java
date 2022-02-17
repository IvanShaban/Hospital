package com.epam.hospital.dao;

import com.epam.hospital.dto.DepartmentDto;
import com.epam.hospital.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao extends Dao<Department, DepartmentDto> {
    Department findByTitle(String title) throws SQLException;
    Department findByHeadDoctorsId(int headDoctorId) throws SQLException;
    List<Department> selectAllDepartments() throws SQLException;
}
