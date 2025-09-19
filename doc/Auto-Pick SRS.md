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
The purpose of this Software Requirements Document is to outline the system requirements for the Auto-Pick application from both the client’s and the developer’s perspectives. Client-oriented requirements present the system from the user’s viewpoint, detailing the various types of users the system is designed to serve. Developer-oriented requirements provide a detailed overview of the system from a technical perspective, covering functional, data, performance, and other critical aspects of the application.

### 1.2 Product Scope
The purpose of the Auto-Pick system is to help users find or sell vehicles at a specific dealership in a simple and convenient way. It’s a web-based platform designed to make vehicle management and discovery easier for both buyers and the dealership. The system will be focused on supporting the dealership's inventory, allowing them to list and manage their cars. Our goal is to provide a smooth, user-friendly experience while offering the best vehicle options and deals available from the dealership.

### 1.3 Definitions, Acronyms and Abbreviations                                                                                                                           
| Reference   | Definition                                                                                                                                                                         |
|-------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java        | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for LocalHarvest Hub                 |
| PostgreSQL  | Open-source relational database management system.                                                                                                                                 |
| SpringBoot  | An open-source Java-based framework used to create a microservice. This will be used to create and run our application.                                                           |
| Spring MVC  | Model-View-Controller. This is the architectural pattern that will be used to implement our system.                                                                                |
| Spring Web  | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system.                                                                      |
| API         | Application Programming Interface. This will be used to interface the backend and the frontend of our application.                                                                  |
| HTML        | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                         |
| CSS         | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                                  |
| JavaScript  | An object-oriented computer programming language commonly used to create interactive effects within web browsers. Will be used in conjunction with HTML and CSS to make the web app. |
| VS Code     | An integrated development environment (IDE) for Java. This is where our system will be created.                                                                                    |


### 1.4 References
                                                                                      
https://spring.io/guides
https://www.nhtsa.gov/nhtsa-datasets-and-apis

### 1.5 Document Overview
Section 1 gives an overall introduction to the document for all readers. Section 2 describes the product and its features, mainly for customers and business stakeholders. Section 3 details the requirements and constraints for the product and development process, and is meant for all stakeholders, especially the development team.


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
* FR0: The system will allow users to create accounts as either customer or seller  
    * Each account will have a unique identifier at time of creation  
* FR1: The system shall allow customer accounts to browse through all available vehicles  
    * There should be filter and search options available  
* FR2: The system shall allow the customer to like/save available vehicles as they desire  
    * There should be a button to like/save attached to each vehicle  
* FR3: The system shall allow customers to contact sellers directly in app  
    * There should be a direct messaging system  
* FR4: All users shall be able to edit thier profile at any time  
* FR5: The system shall allow customers to leave ratings and reviews after purchasing a vehicle from seller  
* FR6: The system shall let sellers list vehicles for sale.  
    * Sellers should be able to add and update details about their vehicles. 
* FR7: The system shall let sellers set vehicles as available or unavailable.  
* FR8: The system must allow sellers to view their sales statistics.  
    * The statistics should include details like total sales, total revenue, and other key metrics.ber of vehicle impressions, etc. 
* FR9: The system shall allow seller to reply to reviews. 

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

NFR0: The Auto-Pick system will consume less than 50 MB of memory  
NFR1: A novice user will be able to browse cars, view details, and contact the dealership in less than 5 minutes.  
NFR2: An expert user will be able to complete the browse cars, view details, and complete contact the dealership tasks in less than 2 minutes.  

#### 3.2.2 Security
NFR3: Only authorized provider (dealer) will be able to make changes to the inventory, requiring secure authentication via username and password.

#### 3.2.3 Reliability

#### 3.2.4 Availability
NFR4: Auto-Pick App will be available 24/7, with no more than 2 hours of scheduled downtime per month for maintenance and updates.

#### 3.2.5 Compliance

#### 3.2.6 Cost
NFR5: We expect to spend zero dollars on this project.

#### 3.2.7 Deadline
NFR6: The final product must be delivered by December 2025.

