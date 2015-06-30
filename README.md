# SafeFood

Safefood is a web application deployed on Amazon Cloud and developed on open source technologies.  

### Technical Approach
Agile development methodology is used in the development of FoodGuard, an application providing search capability to retrieve FDA food recall enforcement reports.  The Scrum team consists of the following 
  - Scrum Master - Technical Architect
  - Team - Front End Web Developer, Backend Web Developer and DevOps Engineer
  - Product Owner - TEA

Scrum team meetings are held regularly to complete the product including the following meeting types
  - Backlog Grooming
  - Spring Planning
  - Daily Scrum
  - Sprint Review Meeting
  - Sprint Retrospective Meeting

There are 2 development Sprints.  Sprint 1 consists of the search criteria page development and Sprint 2 consists of the search results page development.  A daily scrum or “stand up” meeting is held at the start of each work day.  The goal of the daily stand up is for each team member to articulate what he/she has done since the previous day, what is planned for the day ahead, and identify if there is any obstacle preventing him/her from doing what is planned. The Scrum Master, Technical Architect, would work to resolve the blocker or impediment.

At the conclusion of each sprint, a Sprint Review meeting is held to demonstrate the working product to the Product Owner or stake holder. This demonstration meeting provide an internal showcase for whole team, demonstrate what is being done, and provide a venue for direct feedback. 

### Work Breakdown 
To describe how we will undertake this effort, the TEA Team uses a work breakdown structure (WBS), a deliverable-oriented decomposition of the project into smaller components. Each element may be a feature of the user interface or backend service, or any combination thereof. 

### Design
At Sprint Planning, we perform business analysis to build a requirements inventory (discovery). We also work to define the system physical construction (hardware, software, broadband access, communications, security issues). The discovery process result in a set of wire frames for user interface development, and use cases for development guidance. 

We build the application for deployment by using a source code repository (GitHub) as part of the configuration management process. 

### Development
We use all open source technologies for development. We use TeamCity as the continuous integration product to obtain metrics on unit test coverage and ensure that we have successful builds. Our development technology stack includes the following
  
##### User Interface Technology Stack
  - JSP - Java Server Pages for web page rendition 
  - JSTL 1.2 - JSP tag handler
  - JQuery - JavaScript framework
  - JQuery EasyUI 1.4.2 - JavaScript framework for HTML5 web page
  
##### Server side Technology Stack
  - Spring 4.1.6 - Model, view, controller framework
  - Logback 1.1.3
  - JUnit 4
  - Gradle 2.4
  - Eclipse Java EE IDE for Web Developers, Luna Service Release 2 (4.4.2)
  - Jetty 9.3.0
  - TeamCity 9.0.4
  - Tomcat 8.0.23

### Deployment 
We provide a deployment plan that defines the sequence of operations that must be carried to deliver changes into the target system environment at the conclusion of each sprint, then in final sprint. We aim to ensure individual operations within the deployment plan can be executed automatically through deployment scripts.

We deploy SafeFood to Amazon cloud on Apache Tomcat 8.0.23.    

The URL of [SafeFood] application is 
http://ec2-54-172-183-7.compute-1.amazonaws.com/safefood/ on Amazon cloud.
[SafeFood]:http://ec2-54-172-183-7.compute-1.amazonaws.com/safefood/

In the event that the application is unavailable due to the an offline Amazon EC2 instance, please contact us at 240-603-6563 and we shall bring the server instance online.
