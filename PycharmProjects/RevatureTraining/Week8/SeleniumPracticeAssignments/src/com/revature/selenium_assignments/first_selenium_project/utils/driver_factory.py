"""
TODO: Implement a driver factory that:
1. Uses webdriver-manager for automatic driver management
2. Provides a context manager for safe browser cleanup
3. Supports headless mode via parameter
"""

from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@contextmanager
def create_chrome_driver(headless: bool = False):
    # YOUR CODE HERE
    # 1. Create ChromeOptions and configure headless if needed
    options = webdriver.ChromeOptions()
    if headless:
        options.add_argument('--headless')
        options.add_argument('--no-sandbox')
        options.add_argument('--disable-dev-shm-usage')
        options.add_argument("--window-size=1920,1080")
    # 2. Set up Service with ChromeDriverManager
    service = Service(ChromeDriverManager().install())
    # 3. Create driver, yield it, and ensure quit() in finally block
    driver = webdriver.Chrome(service=service, options=options)
    yield driver
    driver.quit()