# Assessment1
Introduction: 
    REST API application using SPRINGBOOT with the dependencies (WEB, MYSQL DRIVE, SPRING DATA JPA) which has the ability to perform data retrieval manipulation and deletion of data inside the database. Performing different HTTP methods to perform CRUD Operations (CREATE, READ, UPDATE, DELETE) of a client detail.
    
DATABASE SCHEMAS:
      DATABASE NAME: asmt1
        PRIMARY KEY: id
        FOREIGN KEY: addid
        
     TABLE NAME: 
  1.	contact_detail

        •	id(PK)
        •	firstName
        •	lastName
        •	contactNo
        •	mailId
        •	addid (FK)
        •	status
  2: addressdetails
  
        •	Id(addid)(PK)	
        •	street1	
        •	street2	
        •	city	
        •	state	
        •	country 
        •	zipcode
        
HTTP Methods
  GET Request=
      contactlist: It will provide all the details in sorting manner by firstName. If found similar name then by lastName.
      contactlist/id: It will provide the data by mentioning the id.
      orderlist: It will give the records as last in first out.
      
  POST Request=
      Add: It is used to add the records in the table.
      
  PUT Request=
      edit: it is used for editing the existing data/records in the database.
      
  DELETE Request=
      delete/id: It is used for deleting the records by mentioning the id.

