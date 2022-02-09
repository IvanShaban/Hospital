package com.epam.hospital.dao.mapper;

import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.entity.Procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcedureMapper {
    private ProcedureMapper() {}

    public static Procedure toProcedure(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new Procedure.Builder()
                .id(resultSet.getInt(1))
                .patientsId(resultSet.getInt(2))
                .completionDate(resultSet.getInt(3))
                .proceduresName(resultSet.getString(4))
                .appointedDoctorsId(resultSet.getInt(5))
                .access(resultSet.getInt(6))
                .performedUserId(resultSet.getInt(7))
                .specification(resultSet.getString(8))
                .build();
    }

    public static Procedure toProcedure(int id, ProcedureDto procedureDto) throws SQLException {
        return new Procedure.Builder()
                .id(id)
                .patientsId(procedureDto.getPatientsId())
                .completionDate(procedureDto.getCompletionDate())
                .proceduresName(procedureDto.getProceduresName())
                .appointedDoctorsId(procedureDto.getAppointedDoctorsId())
                .access(procedureDto.getAccess())
                .performedUserId(procedureDto.getPerformedUserId())
                .specification(procedureDto.getSpecification())
                .build();
    }

    public static List<Procedure> toProcedureList(ResultSet resultSet) throws SQLException {
        List<Procedure> procedures = new ArrayList<>();
        while (resultSet.next()) {
            procedures.add(new Procedure.Builder()
                    .id(resultSet.getInt(1))
                    .patientsId(resultSet.getInt(2))
                    .completionDate(resultSet.getInt(3))
                    .proceduresName(resultSet.getString(4))
                    .appointedDoctorsId(resultSet.getInt(5))
                    .access(resultSet.getInt(6))
                    .performedUserId(resultSet.getInt(7))
                    .specification(resultSet.getString(8))
                    .build());
        }
        return procedures;
    }
}
