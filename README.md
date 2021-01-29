
# Project : INVENTORY MANAGEMENT SYSTEM (IMS)

Link to Jira - (https://qatraineeacadamy.atlassian.net/jira/software/c/projects/QIP/boards/3/roadmap?shared=&atlOrigin=eyJpIjoiMmVlYTE5OWJiMWU1NDNhZGJlMTg3N2NiMDk5MzhlYTQiLCJwIjoiaiJ9)

Uses a CRUD functionality for managing a database for Customers, Items and Orders

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
1.MySQL database 
2.JDK 11 and Eclipse IDE
3.Gitbash
```

### Installing and Running


```
1.Clone this repository to your local repository using Gitbash
2.Open the Eclipse IDE and open the project folder from your local repository
3.Development of the code can be done in "/src/main/java"
4.Open a console and change directory to the project folder and in console type "cd target" to move to the target folder and then type - "java -jar ims-0.0.1-jar-with-dependencies.jar" (fat.jar)
5.Make sure in MySql the database follows the sql schema of provided in "src/main/resources"
6.Running the fat.jar from step 4 will allow to start the IMS program
```
## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

These Tests make sure the base code does what it requires to do and does a coverage test to compare expected result to actual results
using JUnit

```
1.In the src/test/java you can run a coverage test
2. Can modify tests (do not modify OrderDao causes build failures)
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Nick Johnson** - *Base Starter and fixes* - [nickrstewarttds](https://github.com/nickrstewarttds)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* **Nick Johnson** - [nickrstewarttds](https://github.com/nickrstewarttds)

