- - -
# Test APIs

* List  all users
```
curl --location 'localhost:8080/api/user'
```
![List all users](https://raw.githubusercontent.com/lionelgt/nisum-user/main/docs/images/get-api-user-ok.png)

* Create user
```
curl --location 'localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "juan.1@rodriguez.org",
    "password": "Hunter123455.",
    "phones": [
        {
            "number": "1234567",
            "cityCode": "1",
            "countryCode": "57"
        }
    ]
}'
```
![create_user](https://raw.githubusercontent.com/lionelgt/nisum-user/main/docs/images/post-api-user-ok.png)

* User already exist

![create_user](https://raw.githubusercontent.com/lionelgt/nisum-user/main/docs/images/post-api-user-email-exist.png)
- - -
