package com.epam.hospital.service;

import com.epam.hospital.dto.DepartmentDto;
import com.epam.hospital.entity.Department;

import java.util.List;

public interface DepartmentService extends Service<Department, DepartmentDto> {
    Department findByTitle(String title);
    Department findByHeadDoctorsId(int headDoctorId);
    List<Department> selectAllDepartments();
}
