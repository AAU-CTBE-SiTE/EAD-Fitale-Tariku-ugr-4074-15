JPA Lab — Student CRUD and JPQL
This Maven project follows the supplied JPA lab handout: Jakarta Persistence API, Hibernate, MySQL, a Student entity, persistence.xml, CRUD operations, and JPQL examples.
Requirements
- JDK 17 or later
- Maven (IntelliJ can import the project from pom.xml)
- MySQL Server
Setup
1. Create a MySQL database:CREATE DATABASE IF NOT EXISTS jpadb1;
2. Open this folder in IntelliJ IDEA as a Maven project.
3. Wait for Maven to download dependencies.
4. Set environment variables MYSQL_USER and MYSQL_PASSWORD to your local MySQL credentials.
   - Windows PowerShell for the current terminal:$env:MYSQL_USER="root"
     $env:MYSQL_PASSWORD="YOUR_LOCAL_MYSQL_PASSWORD"
   - Replace the example password with your own. Do not commit your password to GitHub.
5. Run com.craft.App.
Hibernate is configured with hibernate.hbm2ddl.auto=update, so it creates/updates the student table in jpadb1 on startup.
Implemented
- Student entity with generated ID, name, and technology
- Create a student
- Find a student by ID
- List all students
- JPQL filter by technology
- Update a student
- Delete a student by ID
- JPQL count query
Troubleshooting
- If jakarta is red in IntelliJ, ensure the project is imported/reloaded as Maven and pom.xml is at the project root.
- If login fails, check MySQL Server is running and use the correct local MySQL credentials.
- This project has not been executed against your local MySQL installation; verify it on your machine before claiming it ran successfully.
