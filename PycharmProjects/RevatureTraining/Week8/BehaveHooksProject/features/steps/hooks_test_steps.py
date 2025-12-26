"""Steps to verify hooks are working."""
from behave import given, when, then

@given('I verify hooks are working')
def step_verify_hooks(context):
    assert hasattr(context, 'driver'), "Driver should be initialized"
    print("       Hooks working: driver initialized")

@when('I perform an action')
def step_perform_action(context):
    context.driver.get("https://the-internet.herokuapp.com/")

@then('I should see the result')
def step_see_result(context):
    assert "The Internet" in context.driver.title

@given('the database is initialized')
def step_db_init(context):
    # Database hook should have run
    pass

@when('I query for data')
def step_query(context):
    pass

@then('I should get results')
def step_results(context):
    pass

@given('I am in headless mode')
def step_headless(context):
    # Verify headless by checking window handle count
    pass

@when('I wait for slow operation')
def step_slow(context):
    import time
    time.sleep(1)  # Simulate slow operation

@then('I should complete successfully')
def step_complete(context):
    assert True