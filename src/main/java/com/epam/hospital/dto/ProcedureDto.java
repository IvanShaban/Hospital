package com.epam.hospital.dto;

import java.util.Date;

public class ProcedureDto {
    private int patientsId;
    private int completionDate;
    private String proceduresName;
    private int appointedDoctorsId;
    private int access;
    private int performedUserId;
    private String specification;

    public ProcedureDto(int patientsId,
                        int completionDate,
                        String proceduresName,
                        int appointedDoctorsId,
                        int access,
                        int performedUserId,
                        String specification) {
        this.patientsId = patientsId;
        this.completionDate = completionDate;
        this.proceduresName = proceduresName;
        this.appointedDoctorsId = appointedDoctorsId;
        this.access = access;
        this.performedUserId = performedUserId;
        this.specification = specification;
    }

    public int getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(int patientsId) {
        this.patientsId = patientsId;
    }

    public int getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(int completionDate) {
        this.completionDate = completionDate;
    }

    public String getProceduresName() {
        return proceduresName;
    }

    public void setProceduresName(String proceduresName) {
        this.proceduresName = proceduresName;
    }

    public int getAppointedDoctorsId() {
        return appointedDoctorsId;
    }

    public void setAppointedDoctorsId(int appointedDoctorsId) {
        this.appointedDoctorsId = appointedDoctorsId;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public int getPerformedUserId() {
        return performedUserId;
    }

    public void setPerformedUserId(int performedUserId) {
        this.performedUserId = performedUserId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "ProcedureDto{" +
                "patientsId=" + patientsId +
                ", completionDate=" + completionDate +
                ", proceduresName='" + proceduresName + '\'' +
                ", appointedDoctorsId=" + appointedDoctorsId +
                ", access='" + access + '\'' +
                ", performedUserId=" + performedUserId +
                ", specification='" + specification + '\'' +
                '}';
    }
}
