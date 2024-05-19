# Library Management System
  the API is for Library Management  The system should allow librarians to manage books, patrons, and borrowing records.

# Api features
- patron signup & login. <br>
- update patrons ,books information. <br>
- authentication using JWT. <br>
- hashing of passwords using BCrypt. <br>
- proper validation for user inputs. <br>
- postgres database integration. <br>
- All endpoint are public except this 2 endpoints need login and valid token to be used: <br>
  ● POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book. <br>
  ● PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron. <br>

 # How to run the app
 install the app and open it on the intellj ide and make sure to but your localhost connection url to on the application.properties file <br>

 # Technologies used
 - Java <br>
 - Spring boot <br>
 - PostgreSQL <br>
 - spring data jpa <br>
 - spring security <br>
 - JWT <br>
 - spring validation <br>

 # To be add next
 - library admins and employees entites. <br>
 - add unit testing to test the app. <br>
 
