# Dashboard

## Backend

Built using Spring Boot in Java.

### API

#### [POSTMAN Documentation](https://documenter.getpostman.com/view/11560439/UVeGrRML)


#### Schema

##### IBX

| Field Name | Type    | Description                 |
| ---------- | ------- | --------------------------- |
| id         | Integer | Identifies an ibx.          |
| name       | String  | Name of an ibx.             |
| country    | String  | Country that the ibx is in. |
| region     | String  | Region that the ibx is in.  |

##### Customer

| Field Name | Type    | Description            |
| ---------- | ------- | ---------------------- |
| id         | Integer | Identifies a customer. |
| name       | String  | Name of a customer.    |

##### Visit

| Field Name | Type          | Description              |
| ---------- | ------------- | ------------------------ |
| id         | Integer       | Identifies a visit.      |
| customer   | Customer      | Visting customer.        |
| ibx        | IBX           | Ibx visited.             |
| startTime  | LocalDateTime | Start time of the visit. |
| endTime    | LocalDateTime | End time of the visit.   |
| purpose    | String        | Purpose of the visit.    |

### Setup

Run the server: `./mvnw spring-boot:run`

Open [http://localhost:8080/visits](http://localhost:8080/visits) to view all visits in the browser.

## Frontend

Built using ReactJS and Bootstrap.

### Features

![Demo](./docs/dashboard_demo.gif)

#### Monitor Visitor Traffic

- View the current number of visitors to all ibxs.

- View the numbee of visitors to all ibxs today.

#### Viualise Visitor Traffic

- View number of visitors by hour in a graphical format.

#### View all Visits

- Filter and sort all visits by:
  - Visit ID
  - Customer ID
  - Customer Name
  - IBX ID
  - IBX Name
  - Region
  - Country
  - Start Time
  - End Time
  - Purpose

### Setup

Install dependencies: `npm install`

Run the app in development mode: `npm start`

Open [http://localhost:3000](http://localhost:3000) to view it in the browser.
