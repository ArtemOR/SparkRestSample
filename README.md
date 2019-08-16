"# SparkRestSample" 
This in sample of RESTFUL service using Spark framework

- Run main method
- Send the request

Create user stub:
POST localhost:8081/users
{
    "name": "ArtemOR",
    "email": "artyomryzhov87@gmail.com"
}

Retrieve all created users:
GET localhost:8081/users