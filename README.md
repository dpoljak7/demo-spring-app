# demo-spring-app

Demo app with simple features

# About the App
Embedded Mongo Database is used with data inserted on startup.
You can check DemoApplication for that data is being generated.
You can pass parameter int numberOfPurchases that will be generated in database.
Default number of customers is 3.
Default number of items is 4.

# Swagger
You can explore API using Swagger UI when you run the application and open:
http://localhost:8080/swagger-ui/
Exmaple for firstName values in database:
firstName1
firstName2

# Configuration
Properties which include database connection string can be configured
via environmental variables and relaxed binding is supported.
Examples that will work:
demo.mongodbConnectionString
DEMO_MONGODB_CONNECTION_STRING

# Testing
You can debug application buy exploring simple unit and integration tests.

# Logging
CorrelationID is configured via MDC object.
Every request is being logged.
You can configure certain levels of logging in logback.xml file as well as
the pattern that is being logged.
AOP logging could be to be added for repository methods or even service methods

# Mapper
Mapstruct is used to simplify creation of DTOs

# Database model
Simple model that includes automatic ID generation

# Possible improvements
Adding more filtering options.
Adding QueryDSL for filtering options and efficient data retrieval from database.