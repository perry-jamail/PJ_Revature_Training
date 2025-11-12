# Writing binary files:
# Use "wb" mode to write binary data
# (e.g., images, encoded content)

data = bytes([120, 3, 255, 0, 100])
with open("binary.dat", "wb") as file:
    file.write(data)