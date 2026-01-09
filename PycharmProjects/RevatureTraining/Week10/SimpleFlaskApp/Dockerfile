# start creating an image based on the official Python 3.9 slim image
# From is the instruction that sets the base image for subsequent instructions in the Dockerfile
# From is the first instruction in a Dockerfile
FROM python:3.9-slim

# set the working directory in the container to /SimpleFlaskApp
WORKDIR /SimpleFlaskApp

# copy the requirements.txt file from the host machine to the working directory in the container
COPY requirements.txt .

# install the dependencies specified in the requirements.txt file
RUN pip install --no-cache-dir -r requirements.txt

# copy the rest of the application code from the host machine to the working directory in the container
COPY . .

# expose port 5000 for the application
EXPOSE 5000

# run the application using the command below when the container starts
CMD ["python", "Hello.py"]
