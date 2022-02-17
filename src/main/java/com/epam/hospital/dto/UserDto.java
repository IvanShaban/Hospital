package com.epam.hospital.dto;

public class UserDto {
    private String login;
    private String password;
    private int departmentsId;
    private String surname;
    private String name;
    private String patronymic;
    private String specialisation;
    private String phoneNumber;
    private int roleId;

    public UserDto(String login,
                   String password,
                   int departmentsId,
                   String surname,
                   String name,
                   String patronymic,
                   String specialisation,
                   String phoneNumber,
                   int roleId) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
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
