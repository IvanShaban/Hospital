package com.epam.hospital.service;

import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.entity.Procedure;

import java.util.Date;
import java.util.List;

public interface ProcedureService extends Service<Procedure, ProcedureDto> {
    List<Procedure> findByPatientsId(int patientsId);
    List<Procedure> findByCompletionDate(Date completionDate);
    List<Procedure> findByProceduresName(String proceduresName);
    List<Procedure> findByAppointedDoctorsId(int appointedDoctorsId);
    List<Procedure> findByPerformedUserId(int performedUserId);
    void deleteProcedure(int id);
}
