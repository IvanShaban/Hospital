package com.epam.hospital.dao;

import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.entity.Procedure;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ProcedureDao extends Dao<Procedure, ProcedureDto> {
    List<Procedure> findByPatientsId(int patientsId) throws SQLException;
    List<Procedure> findByCompletionDate(Date completionDate) throws SQLException;
    List<Procedure> findByProceduresName(String proceduresName) throws SQLException;
    List<Procedure> findByAppointedDoctorsId(int appointedDoctorsId) throws SQLException;
    List<Procedure> findByPerformedUserId(int performedUserId) throws SQLException;
    void deleteProcedure(int id) throws SQLException;
}
