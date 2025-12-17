import requests

def test_basics():
    response = requests.get("https://jsonplaceholder.typicode.com/users/1")
    print(response.status_code)
    print(response.json())
    print(response.text)

    assert response.status_code == 200

def test_parameters():
    # https://jsonplaceholder.typicode.com/comments?postId=1
    params = {"postId": 1}
    response = requests.get("https://jsonplaceholder.typicode.com/comments", params=params)
    # Missing assertion

def test_post_with_params():
    params = {"postId": 1}
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/comments", params=params)
        response.raise_for_status()
        print(f" Success: {response.json()}")
    except requests.exceptions.HTTPError as e:
        print(f" HTTPError: {e}")