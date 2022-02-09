package com.epam.hospital.service;

import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;

import java.util.List;

public interface ChamberService extends Service<Chamber, ChamberDto> {
    Chamber insert (ChamberDto chamberDto);
    Chamber findById(int id);
    List<Chamber> findByDepartmentId(int id);
    List<Chamber> selectAllChambers();
}
