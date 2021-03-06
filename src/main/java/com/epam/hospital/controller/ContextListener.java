package com.epam.hospital.controller;

import com.epam.hospital.dao.connectionpool.ConnectionPool;
import com.epam.hospital.dao.connectionpool.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Class, that gets notified about ServletContext lifecycle changes
 */
public class ContextListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Application is starting.");
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            logger.error("Unable to initialize connection pool.", e);
            throw new RuntimeException("Unable to initialize connection pool.", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Application is shutting down.");
        ConnectionPool.getInstance().dispose();
    }
}