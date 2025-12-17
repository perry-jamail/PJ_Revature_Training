import requests, pytest

@pytest.fixture(scope="module")
def base_url():
    return "https://jsonplaceholder.typicode.com/"

@pytest.fixture(scope="module")
def session():
    session = requests.Session()
    session.headers.update({
        "Accept": "application/json",
        "Content-Type": "application/json"
    })
    yield session
    session.close()

@pytest.fixture(scope="module")
def sample_post():
    return {
        "title": "Test Post",
        "body": "Test Body Content",
        "userId": 1,
    }

class TestBasicRequest:

    def test_get_single_post(self, session, base_url):
        response = session.get(base_url + "/posts/1")
        assert response.status_code == 200

        data = response.json()
        assert data["title"] == "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
        assert "userId" in data

    def test_create_post(self, session, base_url, sample_post):
        response = session.post(f"{base_url}/posts", json=sample_post)
        assert response.status_code == 201

        data = response.json()
        assert data["title"] == "Test Post"

    @pytest.mark.parametrize("post_id", [1, 2, 3])
    def test_get_posts_by_id(self, base_url, session, post_id):
        response = session.get(f"{base_url}/posts/{post_id}")
        assert response.status_code == 200

    @pytest.mark.parametrize("user_id,expected_name", [
        (1, "Leanne Graham"),
        (2, "Ervin Howell"),
        (3, "Clementine Bauch"),
        (4, "Patricia Lebsack"),
        (5, "Chelsey Dietrich")
    ])
    def test_user_names(self, base_url, session, user_id, expected_name):
        """Test user names match expected values"""
        response = session.get(f"{base_url}/users/{user_id}")

        assert response.status_code == 200
        assert response.json()["name"] == expected_name

    @pytest.mark.parametrize("endpoint,expected_count", [
        ("/posts", 100),
        ("/users", 10),
        ("/comments", 500),
        ("/albums", 100),
        ("/photos", 5000),
        ("/todos", 200)
    ])
    def test_resource_counts(self, base_url, session, endpoint, expected_count):
        """Test that each endpoint returns expected number of items"""
        response = session.get(f"{base_url}{endpoint}")

        assert response.status_code == 200
        assert len(response.json()) == expected_count