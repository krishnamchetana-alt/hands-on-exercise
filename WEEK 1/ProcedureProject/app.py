from flask import Flask, jsonify, request
import mysql.connector

app = Flask(__name__)

def get_db_connection():
    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="Vinay@1234",  # <--- Put your MySQL Workbench password here!
        database="bank_procedures_db"
    )

@app.route('/run-procedure', methods=['GET'])
def run_procedure_endpoint():
    try:
        # Get parameter values from your browser URL string
        acc_id = request.args.get('id', default=1, type=int)
        adjustment = request.args.get('amount', default=500.00, type=float)

        conn = get_db_connection()
        cursor = conn.cursor(dictionary=True)

        # 1. This triggers your MySQL Stored Procedure directly from Python!
        cursor.callproc('AdjustAccountBalance', [acc_id, adjustment])
        conn.commit()

        # 2. Fetch the data right back to display the updated numbers on your screen
        cursor.execute("SELECT AccountID, AccountHolder, Balance FROM Accounts")
        updated_records = cursor.fetchall()

        cursor.close()
        conn.close()

        return jsonify({
            "status": "success",
            "message": f"Procedure successfully updated account {acc_id}",
            "data": updated_records
        }), 200

    except mysql.connector.Error as err:
        return jsonify({"status": "error", "message": str(err)}), 500

if __name__ == '__main__':
    app.run(debug=True, port=5001)