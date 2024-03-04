
## API Reference

- #### Get all employee

```http
  GET /employee
```
API to get all employee including salary, bonus and total salary calculation 

Response example `200`:
```
[
    {
        "name": "Hana",
        "id": 1,
        "level": {
            "name": "staff",
            "id": 1,
            "bonusPercentage": 3.0
        },
        "salary": 400000.0,
        "salaryBonus": 11999.999731779099,
        "salaryTotal": 411999.9997317791
    },
    {
        "name": "Dodit",
        "id": 2,
        "level": {
            "name": "staff",
            "id": 1,
            "bonusPercentage": 3.0
        },
        "salary": 500000.0,
        "salaryBonus": 14999.999664723873,
        "salaryTotal": 514999.9996647239
    }
]
```

- #### Create Employee

```http
  POST /employee
```

| JSON Field | Type     | Description           |
| :--------  | :------- | :-------------------- |
| `name`     | `string` | Employee's name       |
| `salary`   | `double` | Base salary           |
| `level`    | `int`    | ID of employee_level  |

Api to add/create new employee, make sure employee_level is exist

Success Response Example `201`:
```
{
    "name": "Arya",
    "id": 52,
    "level": {
        "name": "supervisor",
        "id": 2,
        "bonusPercentage": 6.0
    },
    "salary": 800000.0,
    "salaryBonus": 47999.998927116394,
    "salaryTotal": 847999.9989271164
}
```


- #### Update Employee

```http
  PATCH /employee/${employeeId}
```

| JSON Field  | Type      | Description                         |
| :--------   | :-------  | :--------------------------------   |
| `name`      | `string`  | **Optional** - Employee's name      |
| `salary`    | `double`  | **Optional** - Base salary          |
| `level`     | `int`     | **Optional** - ID of employee_level |

API to update existing employee data

Success Response Example `200`:
```
{
    "name": "Arya Wiguna",
    "id": 52,
    "level": {
        "name": "supervisor",
        "id": 2,
        "bonusPercentage": 6.0
    },
    "salary": 800000.0,
    "salaryBonus": 47999.998927116394,
    "salaryTotal": 847999.9989271164
}
```



- #### Delete Employee

```http
  DELETE /employee/${employeeId}
```
API to delete employee data


