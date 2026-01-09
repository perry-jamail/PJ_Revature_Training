"""
Test navigation functionality using Python Selenium.

Implement tests that:
1. Navigate to https://the-internet.herokuapp.com/
2. Click on "Form Authentication" link
3. Verify URL changed to /login
4. Use back/forward navigation
5. Capture screenshots at key points
"""
import pytest
from selenium.webdriver.common.by import By
import sys

from com.revature.selenium_assignments.first_selenium_project.utils import driver_factory
from src.com.revature.selenium_assignments.first_selenium_project.utils.driver_factory import create_chrome_driver


sys.path.insert(0, '..')


@pytest.fixture
def setup():
    with create_chrome_driver(True) as driver:
        yield driver

def test_navigate_to_login_page(setup):
    """
    Test: Navigate from home to login page

    Steps:
    1. Go to the-internet homepage
    2. Find and click "Form Authentication" link
    3. Assert URL contains "/login"
    4. Assert page contains "Login Page" heading
    """
    # YOUR CODE HERE
    setup.get("https://the-internet.herokuapp.com/")

    element = setup.find_element(By.XPATH, "//a[text()='Form Authentication']")
    element.click()

    assert "/login" in setup.current_url
    assert setup.find_element(By.TAG_NAME, "h2").text == "Login Page"


def test_back_forward_navigation(setup):
    """
    Test: Browser navigation (back/forward)

    Steps:
    1. Navigate to homepage
    2. Click a link to go to another page
    3. Use driver.back() to return
    4. Assert you're on homepage
    5. Use driver.forward() to go forward
    6. Assert you're on the second page again
    """
    # YOUR CODE HERE
    setup.get("https://the-internet.herokuapp.com/")

    element = setup.find_element(By.XPATH, "//a[text()='Dropdown']")
    element.click()

    assert "/dropdown" in setup.current_url

    setup.back()

    assert setup.current_url == "https://the-internet.herokuapp.com/"

    setup.forward()

    assert "/dropdown" in setup.current_url


def test_capture_screenshot(setup):
    """
    Test: Screenshot capture

    Steps:
    1. Navigate to any page
    2. Take a full page screenshot
    3. Save it to screenshots/homepage.png
    """
    # YOUR CODE HERE
    setup.get("https://the-internet.herokuapp.com/")

    result = setup.save_screenshot("screenshots/homepage.png")
    print(result)