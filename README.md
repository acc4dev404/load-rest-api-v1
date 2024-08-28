# load-rest-api-v1
REST API service for loading test

## Port
Working on port 8000 

## Endpoints
### GET
`127.0.0.1:8000`

Response: `200`

```json
{
  "login": "static",
  "password": "Static",
  "date": "31.12.2024 23:59:59"
}
```
### POST
`127.0.0.1:8000/class` on base class User

Request:
```json
{
  "login": "login",
  "password": "password"
}
```

Response: `200`

```json
{
  "login": "login",
  "password": "password",
  "date": "31.12.2024 23:59:59"
}
```

Error: `400`

```json
{
  "timestamp": "2024-12-31T23:59:59.999+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/class"
}
```

`127.0.0.1:8000/map` on base Map<String, String>

Request:
```json
{
  "login": "login",
  "password": "password"
}
```

Response: `200`

```json
{
  "login": "login",
  "password": "password",
  "date": "31.12.2024 23:59:59"
}
```

Error: `400`

```json
```
