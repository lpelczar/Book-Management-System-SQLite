# Book management system

Simple book management console system with SQLite database, written using Java JDBC.

### User stories

* As User I would like to add new book to my book collection  
* As User I would like to edit given book's data.  
* As User I would like to delete book from collection  
* As User I would like to search for a books by one of theirs parameters (by ISBN number, title, author, publication year, publisher's name)  
* As User I would like to see all books available in library sorted ascending by name of books 
* As User I would like to see all books written by given author  

### Expected output

* Program is simple console application 
* Program will print simple menu with all available options based on user story  
* Program is foolproof.  
* Program is sql-injection-proof  

### Additional user stories

* As User I would like to see how many books authors created. 
* As User I would like to see all books written in the last 10 years.  
* As User I would like to see which of the books is the most expensive one.  
* As User I would like to display full name of the author and his/her age.

## Technical details

### Code architecture

* You must implement program within MVC structure. 
* Use DAO pattern for data access.  
* Divide code into proper packages 

### Database architecture

* During tables creation use proper data type.  

![diagram](http://i66.tinypic.com/fegb52.png)

### OOP

* Use inheritance within your project structure. 
* Use polimorphysm for the sake of flexibility and data hiding   
* Use encapsulation.  
* Remember about abstraction! 

### Clean code

* Do not forget about basic principles (DRY etc), follow java code guidelines 

### More info

* Written for [Codecool](https://codecool.com/) programming course

