# EventPlanner
The Event Planner Application is a web-based application that allows users to create and manage events. It provides an API for creating events with various details such as name, tagline, schedule, description, moderator, category, subcategory, and attendee list.

## Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot with JPA
- MySQL
- Maven
- Swagger UI

## Modules
- User 
- Event

## MySql database details

Install and connect with database

```bash
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:8888/event
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=port
```

## Payload for creat event
{
  "attendees": [
    {
      "id": 1,
      "name": "Kapil",
      "email": "kapil@gmail.com",
      "password": "kapil@123"
    },
    {
      "id": 2,
      "name": "Deepak",
      "email": "deepak@gmail.com",
      "password": "deepak@123"
    }
  ],
  "category": "Conference",
  "description": "Join us for an exciting conference on the latest trends in technology.",
  "id": 1,
  "image": "https://example.com/event_image.jpg",
  "moderator": {
    "id": 4,
    "name": "Muzan",
    "email": "muzan@gmail.com",
    "password": "muzan@123"
  },
  "name": "Tech Conference 2023",
  "rigorRank": 8,
  "schedule": "2023-05-31T06:31:01.136Z",
  "subCategory": "Technology",
  "tagline": "Explore the future of technology"
}

## Swagger-UI(API's)
![WhatsApp Image 2023-05-31 at 4 05 37 PM](https://github.com/Kapil7982/EventPlanner/assets/103938868/1d64fe33-33d8-43fa-8c3e-e02190863568)

![WhatsApp Image 2023-05-31 at 4 06 54 PM](https://github.com/Kapil7982/EventPlanner/assets/103938868/5cd4b080-6163-44b4-a567-214bf01dff5f)

