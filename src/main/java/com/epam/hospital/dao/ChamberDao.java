package com.epam.hospital.dao;

import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ChamberDao extends Dao<Chamber, ChamberDto> {
    List<Chamber> findByDepartmentId(int id) throws SQLException;
}
