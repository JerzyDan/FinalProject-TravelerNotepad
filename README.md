# Final project - Traveler Notepad

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [API](#api)
* [Webpage](#webpage)

## General info
This project is a simple travel management application.
It allows you to save countries and places in the database. Edit saved data and delete unnecessary. Saved places can be searched by several categories. The app also displays basic statistics about the saved places.

## Technologies
The project was created with help of:
* TypeScript
* Java
* HTML
* CSS
* JavaScript

Backend consist of five microservices, developed with Java. Frontend was created in Angular.

## Setup
To run this project clone Github repository by using link: 
```
https://github.com/JerzyDan/FinalProject-TravelerNotepad.git
```
For the backend create MySQL database named: journeysDB, with user: traveler and password: makeF1rstStep.

Run all microservices. Microservices state is available under link: localhost:8761

To install and run frontend open project and use commands:
```
$ npm install
$ ng serve
```
Frontend is available at url: localhost:4200

## API
The project has divided the functionalities between microservices. The application consists of 5 microservices, including gateway and server. To run the project all microservices should be started - we recommend starting with the server. All endpoints are available from the gateway level, which operates on port 8000.

Method | Endpoint | Description
------ | -------- | -----------
 GET | /api/v1/country | return list of all countries objects from database
 GET | /api/v1/country/{id} | return country object with specific id
 POST | /api/v1/country/add | to create new country and save it in database
 PUT | /api/v1/country/{id} | allow to update country detail information
 DELETE | /api/v1/country/{id} | to remove country from database
 GET | /api/v1/places | return list of all places objects from database
 GET | /api/v1/places/{id} | return place object with specific id
 POST | /api/v1/places/add | to create new place and save it in database
 PUT | /api/v1/places/{id} | allow to update place detail information
 DELETE | /api/v1/places/{id} | to remove place from database
 GET | /api/v1/search/{name}| return information about place with specific name
 GET | /api/v1/search/c/{city} | return list of all places objects having the same city
 GET | /api/v1/search/s/{status} | return list of all places objects in a certain status
 GET | /api/v1/search/d/{days} | return list of all places objects from database, that need days to visit less than or equal to the days parameter
 GET | /api/v1/search/ca/{id} | return list of all places with the same country id
 GET | /api/v1/report/{status} | returns the number of places with the specified status
 GET | /api/v1/report/c/{status} | returns the number of countries with the specified status
 GET | /api/v1/report/d/{status} | return sum of the days needed for places with specified status

## Webpage
The homepage available by default at localhost:4200 contain navbar at the top. From navbar user can choose:

* Home - main page
* Countries - to see list of countries and also adding, updating, removing countries
* Places - to see list of places and also adding, updating, removing places
* Search - to search places using: name, city, status, number of days or country id
* Summary - page with statistics about visited places and countries, favorite places and countries and about number of days needed in the next trip.
