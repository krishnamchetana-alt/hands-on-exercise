import pytest
from app import app

@pytest.fixture
def client():
    app.config['TESTING'] = True
    with app.test_client() as client:
        yield client

def test_procedure_execution_flow(client):
    response = client.get('/run-procedure?id=3&amount=500.00')
    json_data = response.get_json()

    assert response.status_code == 200
    assert json_data['status'] == 'success'
    assert isinstance(json_data['data'], list)