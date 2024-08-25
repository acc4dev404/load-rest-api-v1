# load-rest-api-v1
REST API service for loading test

## Port
Working on port 8000 

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
`127.0.0.1:8000?login=value1&password=value2`

Response:

```json
{
    "date": "31.12.2024 23:59:59",
    "password": "value2",
    "login": "value1"
}
```
