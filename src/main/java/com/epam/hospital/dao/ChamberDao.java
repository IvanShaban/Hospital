package com.epam.hospital.dao;

import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;

import java.sql.SQLException;
import java.util.List;

public interface ChamberDao extends Dao<Chamber, ChamberDto> {
    Chamber insert (ChamberDto chamberDto) throws SQLException;
    Chamber findById(int id) throws SQLException;
    List<Chamber> findByDepartmentId(int id) throws SQLException;
    List<Chamber> selectAllChambers() throws SQLException;
}
