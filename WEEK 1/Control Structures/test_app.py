import pytest
from app import app

@pytest.fixture
def client():
    app.config['TESTING'] = True
    with app.test_client() as client:
        yield client

def test_update_vip_status_endpoint(client):
    """Test that the API successfully executes and processes data."""
    response = client.get('/update-vip')
    json_data = response.get_json()

    assert response.status_code == 200
    assert json_data['status'] == 'success'
    assert isinstance(json_data['data'], list)