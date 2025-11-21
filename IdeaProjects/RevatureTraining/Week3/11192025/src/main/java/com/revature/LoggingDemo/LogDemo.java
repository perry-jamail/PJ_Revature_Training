package com.revature.LoggingDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogDemo {
    static Logger logger = LoggerFactory.getLogger(LogDemo.class);
    static void main(String[] args) {


        logger.info("This is info");

        logger.warn("This is warn");

        logger.error("This is error");

    }
}
