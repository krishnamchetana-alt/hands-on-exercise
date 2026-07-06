from flask import Flask, jsonify
import mysql.connector

app = Flask(__name__)

def get_db_connection():
    # This function logs into your local MySQL server
    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="Vinay@1234",  # <--- Change this to your Workbench password!
        database="bank_db"
    )

@app.route('/update-vip', methods=['GET'])
def update_vip_status():
    try:
        conn = get_db_connection()
        cursor = conn.cursor(dictionary=True)

        # 1. This runs your conditional logic to update VIP status based on Balance
        update_query = """
        UPDATE Customers 
        SET IsVIP = CASE 
            WHEN Balance > 10000.00 THEN 'Y'
            ELSE 'N'
        END
        """
        cursor.execute(update_query)
        conn.commit()

        # 2. Fetch the updated data to show on your screen
        cursor.execute("SELECT CustomerID, Name, Balance, IsVIP FROM Customers")
        customers = cursor.fetchall()

        cursor.close()
        conn.close()
        
        return jsonify({"status": "success", "data": customers}), 200

    except mysql.connector.Error as err:
        return jsonify({"status": "error", "message": str(err)}), 500

if __name__ == '__main__':
    app.run(debug=True, port=5000)