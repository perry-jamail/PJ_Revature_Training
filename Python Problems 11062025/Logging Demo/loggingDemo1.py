import logging
# setting the level sets which logging levels show up when running the different logs.
# format allows for more detail in the log messages.
# specifying a filename sets the logs to output in that file instead of the console.
logging.basicConfig(filename="mylog.log",
                    level=logging.WARNING,
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

# Logging levels
logging.debug("Debug message")
logging.info("Info message")
logging.warning("Warning message")
logging.error("Error message")
logging.critical("Critical message")