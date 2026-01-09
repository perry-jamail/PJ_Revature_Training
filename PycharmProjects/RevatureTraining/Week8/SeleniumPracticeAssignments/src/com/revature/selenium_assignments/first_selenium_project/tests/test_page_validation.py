"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""
import pytest
from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from src.com.revature.selenium_assignments.first_selenium_project.utils.driver_factory import create_chrome_driver

@pytest.fixture
def setup():
    with create_chrome_driver(True) as driver:
        yield driver

def test_page_title(setup):
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    setup.get("https://the-internet.herokuapp.com/")
    assert setup.current_url == "https://the-internet.herokuapp.com/"

def test_heading_text(setup):
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    setup.get("https://the-internet.herokuapp.com/")

    heading = setup.find_element(By.TAG_NAME, "h2")

    assert heading.text == "Available Examples"

def test_links_present(setup):
    """Verify that all example links are present on the page."""
    # YOUR CODE HERE
    # Use find_elements to get all links
    # Use list comprehension to extract link texts
    setup.get("https://the-internet.herokuapp.com/")

    allLinks = setup.find_elements(By.TAG_NAME, "a")

    assert len(allLinks) > 0

def test_link_attributes(setup):
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    setup.get("https://the-internet.herokuapp.com/")

    all_links = setup.find_elements(By.XPATH, "//ul/li/a")
    all_hrefs = [link.get_attribute("href") for link in all_links]

    for href in all_hrefs:
        setup.get(href)
        assert href in setup.current_url