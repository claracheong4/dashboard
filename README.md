# Dashboard

## Backend

Built using Spring Boot in Java.

### API

#### [POSTMAN Documentation] (https://documenter.getpostman.com/view/11560439/UVeGrRML)

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

## Frontend

Built using ReactJS and Bootstrap.

