from sqlalchemy import create_engine, text
from mysql.connector import (connection)

engine = create_engine(url="mysql+mysqlconnector://root:admin@127.0.0.1:3306/mydb")
with engine.connect() as conn:
    result = conn.execute(text("SELECT * FROM contacts"))
    for row in result:
        print(row)