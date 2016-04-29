# Simulation of Distributed  EcoRecycle System.

* Technology Used: Java using Eclipse IDE, Swing (front end) & MySQL(back-end)

Prerequisites
1. JDK version 1.7
2. Create MySQL DBname - "OOAD_db".
	- CREATE DATABASE OOAD_db;
	-Update "DBConnection.java" with MySQL user name and password
	- RMOS loginid- “admin” password- “admin123”

3. Create Queries for all tables present in SQL_QUERIES.txt in Resource folder
4. Database template -  “.OOAD_db_2015-12-04.sql”

Functionality
1. This EcoRecycle system consists of a number of geographically distributed Recycling machines (RCM), designed to accept recyclable items of various types.and generate small amount of money(cash/coupon) for the items recycled. 
2. Recycling Monitoring Station (RMOS) manage RCMs, add/remove recyclable items, provide view of RCM recycling statistics and change a number of parameters of the recycling machines.
3. The RMOS and RCMs have a GUI developed using Java swings.The data from all the recycling machines is visualized graphically in a variety of graphs.
4. All the entities in the simulation interact with each other via a central MySql database. Using the Model View Controller pattern, the GUI is updated as soon as the data in the database is updated.
