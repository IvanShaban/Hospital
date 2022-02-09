package com.epam.hospital.entity;

public class User {
    private int id;
    private String login;
    private String password;
    private int departmentsId;
    private String surname;
    private String name;
    private String patronymic;
    private String specialisation;
    private int phoneNumber;
    private int roleId;

    public User(int id,
                String login,
                String password,
                int departmentsId,
                String surname,
                String name,
                String patronymic,
                String specialisation,
                int phoneNumber,
                int roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.departmentsId = departmentsId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.specialisation = specialisation;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public static class Builder {
        private int id;
        private String login;
        private String password;
        private int departmentsId;
        private String surname;
        private String name;
        private String patronymic;
        private String specialisation;
        private int phoneNumber;
        private int roleId;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder departmentsId(int departmentsId) {
            this.departmentsId = departmentsId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder specialisation(String specialisation) {
            this.specialisation = specialisation;
            return this;
        }

        public Builder phoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder roleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public User build() {
            return new User(id, login, password, departmentsId, surname, name, patronymic, specialisation,
                    phoneNumber, roleId);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", departmentsId=" + departmentsId +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", roleId=" + roleId +
                '}';
    }
}
