

Module: Attendances Manange
--------------------------------------------------------------------------------
Child Prompt 1: Attendances Creation Feature
Using the parent prompt guidelines, create a complete attendances creation feature that includes:
1. **Controller Method**: Handle POST, GET request for mark a attendances
2. **Repository Methods**: Custom queries for search functionality
3. **Service Method**: Business logic for Retrieve attendance records for a specific day, Retrieve attendance history for an employee. Modify an existing attendance record.
4. **JSP Form**: Attendance get list and button for input form with proper validation and employee wise search
5. **Error Handling**: Display validation errors, empty results, and search criteria to users
6. **Logging**: Audit trail for product creation
Requirements:
- Attendance  must have: employee id, date, checkin time, checkout time etc
- Must data search by employee id
- Follow all architecture patterns from parent prompt
Expected deliverables: Controller class, Service method, JSP page, and any supporting code.

Deliver: Complete feature implementation with proper architecture layers


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Module: Employee Manange
-------------------------------------------------------------------------------------------------
Child Prompt 2: Employee Creation Feature
Using the parent prompt guidelines, create a employee creation feature that includes:
 
1. **Controller Method**: Handle POST request for creating a new employee
2. **Service Method**: create interface with employee creation dto
3. **Service Implementation Method**: Business logic for product validation and saving
3. **Thyemeleaf Form**: Employee creation form with proper validation
4. **Error Handling**: Display validation errors to employee
5. **Logging**: Audit trail for employee creation
 
Requirements:
- Employee must have: name, dateOfBirth, NID, address, designation and project
- project will be another entity that must have: projectName, employee, duration, stratdate,enddate
- project and employee will have one to many releation
- there will be unique id on each employee and project
- Include proper error handling and user feedback
- Follow all architecture patterns from parent prompt
 
Expected deliverables: Controller class, Service interface,Service implementation method, Thyemeleaf page, and any supporting code.




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


Module: Employee Manange
------------------------------------------------------------------------------------------------------------------
Child Prompt 3 : Get All Employee Feature
 
Using the parent prompt guidelines, create a complete get all employees API feature that includes:
 
 
1. **Controller Method**: Handle Get request for getting all employees
 
2. **Service Method**: Business logic for getting all employees
 
3. **Thymeleaf Form**: Getting all employees page
 
4. **Error Handling**: Display any validation
 
5. **Logging**: Use proper logging with Log4j 2
 
 
Requirements:
 
- Must return all employee list
 
- Include proper error handling
 
- Follow all architecture patterns from parent prompt
 
 
Expected deliverables: Controller class, Service method, Service Implementation, Thymeleaf page and any supporting code.
 
 
 
 
 
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


Module: Employee Manange
------------------------------------------------------------------------------------------------------------------
Child Prompt 4 : Get All Employee Feature
 
Using the parent prompt guidelines, create a complete get all employees API feature that includes:
 
 
1. **Controller Method**: Handle Get request for getting all employees
 
2. **Service Method**: Business logic for getting all employees
 
3. **Thymeleaf Form**: Getting all employees page
 
4. **Error Handling**: Display any validation
 
5. **Logging**: Use proper logging with Log4j 2
 
 
Requirements:
 
- Must return all employee list
 
- Include proper error handling
 
- Follow all architecture patterns from parent prompt
 
 
Expected deliverables: Controller class, Service method, Service Implementation, Thymeleaf page and any supporting code.
 
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 Module: Employee Manange
------------------------------------------------------------------------------------------------------------------

Child Prompt 5: Employee Update Feature 
Following the parent prompt standards, implement an employee profile update API :
1.	Repository Methods: Custom queries for employee profile updates
2.	Service Layer: Business logic for updating employee profiles
3.	Controller: Handle update requests, including form submissions
4.	Thyemeleaf Form:
                   - Results table with edit option
                   - Update form pre-filled with selected employee details
5.	Error Handling:
                   -Handle invalid or missing update fields
                   -Display user-friendly error messages
 
Update Fields:
•	First name
•	Last name
•	Email (with format validation)
•	Phone number
•	Department
•	Job title
•	Status (active/inactive)
 
Additional Requirements:
•	Proper logging at each layer (INFO for success, WARN for invalid input, ERROR for system failures)
•	Input validation using standard validation annotations and custom checks where required
•	Follow clean code practices: method naming, separation of concerns, error messages, etc.

Expected deliverables: Controller class, Service method, Service Implementation, Thymeleaf page and any supporting code.


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 Module: Employee Manange
------------------------------------------------------------------------------------------------------------------

Child Prompt 6: Delete Employee by id

Using the parent prompt guidelines, create a complete feature of employee deletion by their id that includes:

1. **Controller Method**: Handle DELETE request for employee deletion by their id.
 
2. **Repository Methods**: Use Spring Data JPA built in repository method.
 
3. **Service Method**: Business logic for deleting employees using their id.
 
3. **Thymeleaf Form**: Provide Delete button for employee deletion.

4. **Error Handling**: Display any validation

5. **Logging**: Use proper logging with Log4j 2


Requirements:

- Must delete employees by id

- Include proper error handling for employee deletion

- Follow all architecture patterns from parent prompt


Expected deliverables: Controller class, Service method, Service Implementation, Thymeleaf page and any supporting code.
 
 
 
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
  
# Child Prompt 7: Department List with Pagination and Search Feature
 
## Objective
Implement a feature to display all departments with pagination, sorting, and search capabilities. This includes both backend (Controller, Service, Repository) and frontend (Thymeleaf with Bootstrap 5).
 
## Requirements
 
### Backend Requirements
1. Create a repository method to find departments with filtering and pagination
2. Implement service layer with:
   - Pagination and sorting support
   - Input validation for sort fields and search text
   - Protection against SQL injection
3. Create a controller endpoint to handle:
   - Search text parameter
   - Page number and size parameters
   - Sorting field and direction parameters
 
### Frontend Requirements
1. Create a Thymeleaf template with Bootstrap 5 styling
2. Implement a search form with:
   - Text input for search queries
   - Dropdown for selecting page size
3. Display departments in a table with:
   - Sortable columns (clickable headers)
   - Visual indicators for sort direction
4. Add pagination controls:
   - First, Previous, Next, Last buttons
   - Page number indicators
   - Current page highlighting
5. Include action buttons for each department:
   - View department details
   - Edit department
   - View employees in department
 
### Validation and Security
1. Sanitize search input to prevent SQL injection
2. Validate sort field names against an allowlist
3. Ensure page numbers and sizes are within valid ranges
4. Apply proper error handling
 
### Relationship Handling
1. Show action to view employees belonging to a department
2. Consider the one-to-many relationship between departments and employees
 
## Expected Output
A fully functional department listing page with search, pagination, and sorting capabilities that follows the project's architecture patterns and coding standards.
 
## Technical Context
- Spring Boot 2.7.5 with Java 8
- H2 in-memory database
- Thymeleaf templating with Bootstrap 5
- Spring Data JPA for data access
- RESTful API design principles
 
 
 
