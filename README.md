# load-rest-api-v1
REST API service for loading test (Spring Boot 3.3.3 Maven)

## Port
Working on port 8000 `(src/main/resources/application.properties)`

## Endpoints
### GET
`127.0.0.1:8000`

Response:

```json
{
    "date": "Datetime connection",
    "password": "Your password",
    "login": "Your login"
}
```
### POST
`127.0.0.1:8000`

Request Body:

```json
{
    "password": "value2",
    "login": "value1"
}
```

Response:

```json
{
    "date": "31.12.2024 23:59:59",
    "password": "value2",
    "login": "value1"
}
```
