from mysql.connector import (connection)

cnx = connection.MySQLConnection(user='root', password='admin', host='localhost', database='mydb')
print("Connected to the database")

cursor = cnx.cursor()
cursor.execute("select * from contacts")
results = cursor.fetchall()
for row in results:
    print(row)

cursor.close()
cnx.close()