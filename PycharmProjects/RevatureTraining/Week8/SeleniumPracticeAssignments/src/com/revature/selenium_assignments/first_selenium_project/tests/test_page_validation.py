"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""

from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from src.com.revature.selenium_assignments.first_selenium_project.utils.driver_factory import create_chrome_driver


def test_page_title():
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    pass

def test_heading_text():
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    pass

def test_links_present():
    """Verify that all example links are present on the page."""
    # YOUR CODE HERE
    # Use find_elements to get all links
    # Use list comprehension to extract link texts
    pass

def test_link_attributes():
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    pass