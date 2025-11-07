# Copy image from 1 file to another

with open("DSC_0021.JPG", "rb") as data:
    binary = data.read()
    with open("copiedimage.jpg", "wb") as copied_data:
        copied_data.write(binary)