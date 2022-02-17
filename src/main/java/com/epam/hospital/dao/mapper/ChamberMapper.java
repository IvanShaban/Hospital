package com.epam.hospital.dao.mapper;

import com.epam.hospital.dto.ChamberDto;
import com.epam.hospital.entity.Chamber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ChamberMapper {
    private ChamberMapper() {}

    public static Chamber toChamber(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new Chamber.Builder()
                .id(resultSet.getInt(1))
                .departmentId(resultSet.getInt(2))
                .bedsNumber(resultSet.getInt(3))
                .build();
    }

    public static Chamber toChamber(int id, ChamberDto chamberDto) {
        return new Chamber.Builder()
                .id(id)
                .departmentId(chamberDto.getDepartmentId())
                .bedsNumber(chamberDto.getBedsNumber())
                .build();
    }

    public static List<Chamber> toChamberList(ResultSet resultSet) throws SQLException {
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
}
