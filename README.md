# Distributed Cache - Node

A single node for a distributed cache application.

## Setup (MacOS)

First, create an `.env` file by coping the existing `.env.example`, and modify it as needed.

Then, source the `.env` file by running the following command:

```
source .env
```

Then, run docker compose with the following command:

```
docker compose up -d
```

Finally, run the application with the following command:

```
./gradlew bootRun
```

## Run the tests
To run the tests with Gradle use the following command:

```sh
$ gradlew clean test
```

## API endpoints

The following API endpoints are available:

- GET `/cache/{key}` - Retrieves a cache entry
  - Throws a 404 exception if key is not found
- PUT `/cache/{key}` - Creates, or updates, a specific cache entry
- DELETE `/cache/{key}` - Deletes a specific cache entry
  - Throws a 404 exception if key is not found

## Postman

In the `postman` folder you can find a collection and an environment file that you can import in Postman, or similar tool (?), to easily test the API.
