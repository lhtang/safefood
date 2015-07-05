# SafeFood

Safefood is a web application deployed on Amazon Cloud and developed on open source technologies.  

### Technical Approach
Agile development methodology is used in the development of SafeFood, an application providing search capability to retrieve FDA food recall enforcement reports. Safefood is a mobile application and web application supporting multiple devices including personal computers, tablets and smartphones.  Safefood consumes data from FDA food recall RESTful service.

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
  - Apache Commons 3
  - JUnit 4
  - Mockito 1.9.5
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

In the event that the application is unavailable due to the an offline Amazon EC2 instance, please contact us at admin@tea-llc.com and we shall bring the server instance online.

### Build and Installation
The following software tools must be installed on the computer in order to build and install the web application
  - Gradle 2.4
  - Eclipse Java EE IDE for Web Developers, Luna Service Release 2 (4.4.2)
  - Jetty 9.3.0
  - Tomcat 8.0.23

Build and installation instructions are follows 
  - Open DOS command line prompt and CD to SafeFood project folder.  
  - Execute "gradle eclipse" to setup development environment.
  - Execute "gradle jettyRun" to run application. Jetty shall provide the application URL (e.g. http://localhost:8082/safefood).  Use your web browser to launch application URL.
  - Execute "gradle build" to build the war file for deployment.
