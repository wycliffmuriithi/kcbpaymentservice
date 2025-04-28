# Payment Service Application - Version 1

that integrates with mobile money platforms in Kenya to complete a Business-to-Consumer (B2C) transaction and sends a notification SMS to the recipient upon success or failure.
## Features:
- Supports in-memory H2 database for development and testing purposes.
- Payment processing endpoints to initiate payments and get payment status.
- Secure authentication using JWT tokens.
- Simple configuration via environment variables.

---

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Setup Instructions](#setup-instructions)
3. [Environment Variables](#environment-variables)
4. [Running the Application](#running-the-application)
5. [Testing the Application](#testing-the-application)
6. [License](#license)

---

## Prerequisites

Before getting started, ensure you have the following installed on your machine:

- [Docker](https://www.docker.com/get-started) - for building and running the application in a container.
- [Docker Compose](https://docs.docker.com/compose/) - for easier management of multi-container Docker applications.

---

## Setup Instructions

1. Clone this repository to your local machine.

   ```bash
   git clone https://github.com/yourusername/paymentservice.git
   cd paymentservice
2. Build the payment service to generate the jar file to be used later on in building docker image.

   ```bash
   mvn package

3. Use Docker Compose to build, set up the container and start the application.

   ```bash
   docker-compose up --build
   
4. The service will now be running and accessible at http://localhost:9000.

## Environment Variables

The following environment variables can be set in the docker-compose.yml file or as part of your Docker run command:

- DB_URL: URL for the database (default: jdbc:h2:mem:testdb).
- DB_USERNAME: The username to connect to the database (default: sa).
- DB_PASSWORD: The password to connect to the database (default: password).
- USER_NAME: The username used for authenticating API requests (default: user).
- USER_PASSWORD: The password used for authenticating API requests (default: password).

## Running the Application

Once the service is up and running, you can access the following endpoints:

1. Authenticate User
- POST /oauth2/token
    ```bash
  curl -X POST http://localhost:9000/oauth2/token \
  -H "Authorization: Basic <base64(client_id:client_secret)>" \
  -d "grant_type=password&username=user&password=password"

2. Initiate Payment
The API pushes a payment to user through a predefined platform e.g mpesa, airtelmoney.
- POST /payment/init
   ```bash
    curl -X POST http://localhost:9000/payment/init -H "Authorization: Bearer <your-jwt-token>"  -d '{    "msisdn":"254715702887",    "amount":100.40, "description":"223545451223",    "provider":"mpesa"}'

    