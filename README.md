# Test Automation Framework for FeDex

- Example Test Automation Framework
    * [Overview](#overview)
        + [Requirements](#requirements)
        + [Project architecture](#architecture)
        + [safeguarding and monitoring the reliability](#safeguarding)
        + [STLC](#STLC)


<a name="overview"></a>
## Overview
The project has been developed with java. It is a BDD project written by using Cucumber

<a name="requirements"></a>
###Requirements
- Java JDK 17 or higher
- Maven 3.8.5 or higher

Before run start you should run the docker image first 

``docker run -p 8080:8080 -it casumo/devowelizer:latest``

<a name="architecture"></a>
## Project architecture

The project is a simple BDD project developed by using Cucumber as BDD tool

<a name="safeguarding"></a>
## Safeguarding and monitoring the reliability

to ensure the reliability of the build each release should test. If I would be in charge, I would prepare three test suites.
- 1 Smoke Test
- 2 Sanity Test
- 3 Regression

#### 1 Reggresion Test Suite
Including all automated test scenarios. It would be run in a period for instance, hourly. Don’t integrate it into the CI pipeline because it probably will take so long time. So it is a good choice to run it periodically. If it catches any bug it will send notifications to the team.

#### 2 Sanity Test Suite
it is the regression test separated according to functions. what I mean is that imagine that we have microservices as a  product and you've developed a feature just related to one of the microservices so if you want to check only that service you can call the related sanity test suite.

It should be executable in the developer's local environment so they can test their development on their locally with the Sanity Test Suite.

#### 3- Smoke Test Suite

Includes some basic scenarios to check if the overall system is stable or not. It shouldn't take a long time to execute and should test just important parts of the product

I would integrate the smoke tests into the CI pipeline to measure the built stability.

### STLC
Should be like this.
- QA Team gets involved in to process from the Planning stage to give to the team a QA perspective.
- If possible QA would test the analysis document of the new features to prevent the product bug before it's coded.
- The developer executed the Sanity test after development is completed.
- QA Team executes an exploratory test on the new feature and decides whether to add it to the test suite or not.
- The smoke test is run as the CI Pipeline process
- If there is still a bug it will be caught by regression tests.

<a name="STLC"></a>
## Failed Scenario

There must be a pre-planned plan to be prepared for any failure scenario.

For example;
There should be a map about who has more confidence in which service.
And there should be a notification service to notify the responsible person about the failure. 
For example, I've added a Slack notification feature to the project. It will send notifications to slack when the regression test failed. But it is not enough. there should be other monitoring tools as well

#### Additional notes: 

There is a bug in the service. The service doesn't remove the vowels of the input in upper case. Also, there should be proper service messages instead of internal server errors.

I wasn't able to prepare a proper bug report because of the time.

