

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
