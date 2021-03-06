package com.epam.hospital.entity;

public class Procedure {
    private int id;
    private int patientsId;
    private int completionDate;
    private String proceduresName;
    private int appointedDoctorsId;
    private int access;
    private int performedUserId;
    private String specification;

    public Procedure(int id,
                     int patientsId,
                     int completionDate,
                     String proceduresName,
                     int appointedDoctorsId,
                     int access,
                     int performedUserId,
                     String specification) {
        this.id = id;
        this.patientsId = patientsId;
        this.completionDate = completionDate;
        this.proceduresName = proceduresName;
        this.appointedDoctorsId = appointedDoctorsId;
        this.access = access;
        this.performedUserId = performedUserId;
        this.specification = specification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static class Builder {
        private int id;
        private int patientsId;
        private int completionDate;
        private String proceduresName;
        private int appointedDoctorsId;
        private int access;
        private int performedUserId;
        private String specification;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder patientsId(int patientsId) {
            this.patientsId = patientsId;
            return this;
        }

        public Builder completionDate(int completionDate) {
            this.completionDate = completionDate;
            return this;
        }

        public Builder proceduresName(String proceduresName) {
            this.proceduresName = proceduresName;
            return this;
        }

        public Builder appointedDoctorsId(int appointedDoctorsId) {
            this.appointedDoctorsId = appointedDoctorsId;
            return this;
        }

        public Builder access(int access) {
            this.access = access;
            return this;
        }

        public Builder performedUserId(int performedUserId) {
            this.performedUserId = performedUserId;
            return this;
        }

        public Builder specification(String specification) {
            this.specification = specification;
            return this;
        }

        public Procedure build() {
            return new Procedure(id, patientsId, completionDate, proceduresName, appointedDoctorsId, access,
                    performedUserId, specification);
        }
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "id=" + id +
                ", patientsId=" + patientsId +
                ", completionDate=" + completionDate +
                ", proceduresName='" + proceduresName + '\'' +
                ", appointedDoctorsId=" + appointedDoctorsId +
                ", access='" + access + '\'' +
                ", performedPersonalId=" + performedUserId +
                ", specification='" + specification + '\'' +
                '}';
    }
}
