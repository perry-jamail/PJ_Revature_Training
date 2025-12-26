from behave import given, when, then
from behave.exception import StepNotImplementedError
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

BASE_URL = "https://the-internet.herokuapp.com/"

@given('the application is running')
def the_application_is_running(context):
    options = Options()
    options.add_argument('--start-maximized')

    context.driver = webdriver.Chrome(options=options)
    context.wait = WebDriverWait(context.driver, 10)

    context.driver.get(BASE_URL)

    heading = context.wait.until(EC.visibility_of_element_located((By.TAG_NAME, "h1")))
    assert heading.text == "Welcome to the-internet"

@given(u'the test database is already seeded with users')
def step_database_seeded(context):
    return True

@given(u'the user is on the login page')
def step_user_on_login_page(context):
    context.driver.get(BASE_URL + "/login")
    heading = context.wait.until(EC.visibility_of_element_located((By.TAG_NAME, "h2")))
    assert heading.text == "Login Page"

@when(u'the user enters username "tomsmith"')
def step_user_enter_username(context):
    username_input = context.wait.until(EC.visibility_of_element_located((By.ID, "username")))
    username_input.clear()
    username_input.send_keys("tomsmith")


@when(u'the user enters password "SuperSecretPassword!"')
def step_user_enter_password(context):
    password_input = context.wait.until(EC.visibility_of_element_located((By.ID, "password")))
    password_input.clear()
    password_input.send_keys("SuperSecretPassword!")

@when(u'the user clicks the login button')
def step_click_button(context):
    login_button = context.wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "radius")))
    login_button.click()

@then(u'the user should be redirected to the secure area')
def step_redirected_to_secure_area(context):
    context.wait.until(EC.url_contains("/secure"))
    assert "/secure" in context.driver.current_url


@then(u'the page should display a message containing "You logged in"')
def step_verify_success_message(context):
    flash_message = context.wait.until(EC.visibility_of_element_located((By.ID, "flash")))
    assert "You logged in" in flash_message.text

    context.driver.quit()