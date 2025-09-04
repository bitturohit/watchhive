# register a user
POST http://localhost:8080/api/users/register

BODY: 
{
  "username": "Jacob Jetkins",
  "email": "random1@gmail.com",
  "password": "1Aa!",
  "profilePicture": "avatar1.png",
  "bio": "avid movie watcher"
}

# send a bad request
POST http://localhost:8080/api/users/register

BODY:
{
  "username": "",
  "email": "bad-email",
  "password": "123"
}
