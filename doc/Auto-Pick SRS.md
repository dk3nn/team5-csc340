# Software Requirements Specification
## For <Auto-Pick>

Version 0.1  
Prepared by <Davin Kennaley, >  
<CSC 340, Group 5>  
<September 19, 2025> 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
| Davin|   9/19  |    Initial SRS      |     1,0   |
|      |         |                     |           |
|      |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Document (SRD) is to describe the client-view and developer-view requirements for the Auto-Pick application.
Client-oriented requirements describe the system from the client’s perspective. These requirements include a description of the different types of users served by the system.
Developer-oriented requirements describe the system from a software developer’s perspective. These requirements include a detailed description of functional, data, performance, and other important requirements.

### 1.2 Product Scope
The purpose of the Auto-Pick system is to assist users in either finding a vehicle or selling a vehicle and to create a convenient and easy-to-use application for every parties involved in the car buying process. The system is a web-based application to simplify its vehicle management, and vehicle discovory functions. We will have a server supporting sellers of different vehicles. Above all, we hope to provide a comfortable user experience along with the best offerings available.

### 1.3 Definitions, Acronyms and Abbreviations                                                                                                                           
| Reference  | Definition                                                                                                                                                                         |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java       | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for LocalHarvest Hub                 |
| Postgresql | Open-source relational database management system.                                                                                                                                 |
| SpringBoot | An open-source Java-based framework used to create a micro Service. This will be used to create and run our application.                                                           |
| Spring MVC | Model-View-Controller. This is the architectural pattern that will be used to implement our system.                                                                                |
| Spring Web | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system.                                                                      |
| API        | Application Programming Interface. This will be used to interface the backend and the fronted of our application.                                                                  |
| HTML       | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                         |
| CSS        | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                                  |
| JavaScript | An object-oriented computer programming language commonly used to create interactive effects within web browsers.Will be used in conjuction with HTML and CSS to make the web app. |
| VS Code    | An integrated development environment (IDE) for Java. This is where our system will be created.                                                                                    |
|            |                                                             |

### 1.4 References
                                                                                      
https://spring.io/guides
https://www.nhtsa.gov/nhtsa-datasets-and-apis
### 1.5 Document Overview
Section 1 is a general introduction to the document, intended for any readers. Section 2 is focused on the product and its features. This section is for customers and business stakeholders. Section 3 specifies the requirements and constraints for the product and development process. This section is intended for all stakeholders, especially the development team.


## 2. Product Overview
Auto-Pick is a web-based platform designed to help consumers discover their next vehicle. Customers can browse vehicles, view details about each vehicle, save vehicles, and get in contact with the seller, and leaeve reviews when finished. Sellers manage their vehicles, update information about their vehicle and its status, and track their sales statistics. The system supports multiple user roles including customers, providers, and administrators; each with tailored services to ensure a simple, transparent, purchasing and selling experience.

### 2.1 Product Functions
Auto-Pick allows sellers to create and customize the vehicles they offer. They can manage and track their vehicles and sales in an intuitive way. Customers can look for and save any vehicles of their choosing, and easily manage them from their dashboard. 

### 2.2 Product Constraints
At this point, the program will only run on a computer with Java jdk 21 installed. The full scope of the project is hopefully realized, however the team has a deadline of about 10 weeks, which could lead to feature cuts. The program would have a challenge scaling, as the current plan is to use a free version of a Postgresql database to store the information.
  
### 2.3 User Characteristics
Our website application does not expect our users to have any prior knowledge of a computer, apart from using a web browser. As long as users know what vehicles they are interested in, they should be expert level within several uses of the application.

### 2.4 Assumptions and Dependencies
We will be using Java, with our program and an exteranl NHTSA API to access general and specific vehicle information, that will help sellers and users find information like safety ratings about their vehicle. 

## 3. Requirements

### 3.1 Functional Requirements 
*FR0: The system will allow users to create accounts as either customer or seller
    * Each account will have a unique identifier at time of creation
*FR1: The system shall allow customer accounts to browse through all available vehicles
    * There should be filter and search options available
*FR2: The system shall allow the customer to like/save available vehicles as they desire
    * There should be a button to like/save attached to each vehicle
*FR3: The system shall allow customers to contact sellers directly in app
    * There should be a direct messaging system
*FR4: All users shall be able to edit thier profile at any time
*FR5: The system shall allow customers to leave ratings and reviews after purchasing a vehicle from seller
*FR6: The system shall allow sellers to list vehicles for sale
    * Sellers should be able to add information about their vehicle
FR7: The system shall allow sellers to make vehicles available or unavailable
FR8: The system shall allow sellers to veiw thier sale statistics
    * The statistics section should include information shuch as total sales, total revenue, number of vehicle impressions, etc.

#### 3.1.1 User interfaces
Web pages using HTML, CSS, and JavaScript.

#### 3.1.2 Hardware interfaces
Devices that have web browser capabilities.

#### 3.1.3 Software interfaces
Java jdk 21
PostgreSQL 17
SpringBoot 3.4.5

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance


#### 3.2.2 Security


#### 3.2.3 Reliability


#### 3.2.4 Availability


#### 3.2.5 Compliance


#### 3.2.6 Cost


#### 3.2.7 Deadline

