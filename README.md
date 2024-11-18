# Distributed Cache - Node

A single node for a distributed cache application.

## Setup

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

## API endpoints

The following API endpoints are available:

- GET `{host}/cache/{key}` - Retrieves a cache entry
  - Throws a 404 exception if key is not found
- PUT `{host}/cache/{key}` - Creates, or updates, a specific cache entry

## Postman

In the `postman` folder you can find a collection and an environment file that you can import in Postman, or similar tool (?), to easily test the API.
