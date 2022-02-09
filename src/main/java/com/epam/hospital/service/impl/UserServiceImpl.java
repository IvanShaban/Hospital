package com.epam.hospital.service.impl;

import com.epam.hospital.controller.ContextListener;
import com.epam.hospital.dao.UserDao;
import com.epam.hospital.dao.impl.UserDaoImpl;
import com.epam.hospital.dto.UserDto;
import com.epam.hospital.entity.User;
import com.epam.hospital.service.UserService;
import com.epam.hospital.exception.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);
    private static final UserService instance = new UserServiceImpl();

    private UserDao userDao;

    public static UserService getInstance() {
        return instance;
    }

    private UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User insert(UserDto userDto) {
        if (userDto.getLogin() == null || userDto.getLogin().isEmpty() || userDto.getPassword() == null ||
                userDto.getPassword().isEmpty() || userDto.getPassword().length() < 4) {
            logger.error("User not valid " + userDto);
            throw new NotValidException("User not valid " + userDto);
        }
        try {
            return userDao.insert(userDto);
        } catch (SQLException e) {
            logger.error("Cannot insert user " + userDto, e);
            throw new DaoException("Cannot insert user " + userDto, e);
        }
    }

    @Override
    public User findById(int id) {
        if (id < 1) {
            logger.error("User id not valid " + id);
            throw new NotValidException("User id not valid " + id);
        }
        try {
            return userDao.findById(id);
        } catch (SQLException e) {
            logger.error("Cannot find user by id " + id, e);
            throw new DaoException("Cannot find user by id " + id, e);
        }
    }

    @Override
    public List<User> findByDepartmentsId(int departmentsId) {
        if (departmentsId < 1) {
            logger.error("Department id not valid " + departmentsId);
            throw new NotValidException("Department id not valid " + departmentsId);
        }
        try {
            return userDao.findByDepartmentsId(departmentsId);
        } catch (SQLException e) {
            logger.error("Cannot find user by department id " + departmentsId, e);
            throw new DaoException("Cannot find user by department id " + departmentsId, e);
        }
    }

    @Override
    public List<User> findBySurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            logger.error("User surname not valid " + surname);
            throw new NotValidException("User surname not valid " + surname);
        }
        try {
            return userDao.findBySurname(surname);
        } catch (SQLException e) {
            logger.error("Cannot find user by surname " + surname, e);
            throw new DaoException("Cannot find user by surname " + surname, e);
        }
    }

    @Override
    public List<User> findBySpecialisation(String specialisation) {
        if (specialisation == null || specialisation.isEmpty()) {
            logger.error("User specialisation not valid " + specialisation);
            throw new NotValidException("User specialisation not valid " + specialisation);
        }
        try {
            return userDao.findBySpecialisation(specialisation);
        } catch (SQLException e) {
            logger.error("Cannot find user by specialisation " + specialisation, e);
            throw new DaoException("Cannot find user by specialisation " + specialisation, e);
        }
    }

    @Override
    public User findByPhoneNumber(int phoneNumber) {
        if (phoneNumber < 1 || phoneNumber > 12) {
            logger.error("Phone number not valid " + phoneNumber);
            throw new NotValidException("Phone number not valid " + phoneNumber);
        }
        try {
            return userDao.findByPhoneNumber(phoneNumber);
        } catch (SQLException e) {
            logger.error("Cannot find user by phone number " + phoneNumber, e);
            throw new DaoException("Cannot find user by phone number " + phoneNumber, e);
        }
    }

    @Override
    public List<User> findByRoleId(int roleId) {
        if (roleId < 1 || roleId > 5) {
            logger.error("Role id not valid " + roleId);
            throw new NotValidException("Role id not valid " + roleId);
        }
        try {
            return userDao.findByRoleId(roleId);
        } catch (SQLException e) {
            logger.error("Cannot find user by role id " + roleId, e);
            throw new DaoException("Cannot find user by role id " + roleId, e);
        }
    }

    @Override
    public void deleteUser(int id) {
        if (id < 1) {
            logger.error("User id not valid " + id);
            throw new NotValidException("User id not valid " + id);
        }
        try {
            userDao.deleteUser(id);
        } catch (SQLException e) {
            logger.error("Cannot find user by id " + id, e);
            throw new DaoException("Cannot find user by id " + id, e);
        }
    }

    @Override
    public User login(String email, String password) {
        User user = null;
        try {
            User userFromDB = userDao.login(email);
            if (userFromDB != null && userFromDB.getPassword().equals(DigestUtils.sha256Hex(password))) {
                user = userFromDB;
            }
        } catch (DaoException | SQLException e) {
            throw new DaoException("Cannot find user by login " + email, e);
        }

        return user;
    }

    @Override
    public User findByLogin(String login) {
        try {
            return userDao.login(login);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User updateById(int userId, UserDto userDto) {
        try {
            return userDao.updateById(userId, userDto);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<User> selectAllUsers() {
        try {
            return userDao.selectAllUsers();
        } catch (SQLException e) {
            return null;
        }
    }
}
