
# JiIaMD laboratory project

## Project's topic

**Caesar cipher**. The program should implement the Caesar cipher. The program should perform both encoding and decoding of texts. The key for encoding/decoding should not be hard-coded (the user should be able to provide it). The encoding/decoding should not change the case of the text and they should allow for multi-word texts. Text containing letters outside of the English alphabet should be considered invalid.

## Scopes of the development iterations

### Prototype no. 1

- run as a standalone console application (no GUI allowed)
- UI uses standard streams
- separated classes for model, view and controller
- use of packages (separate for model, view and controller)

### Final version no. 1

- run as a standalone console application (no GUI allowed)
- initial parameters in the command line
- UI uses standard streams
- separate classes for model, view, and controller
- use of packages (separate for model, view, and controller)
- own exception used in the model
- only private fields
- static elements (except main()) are prohibited
- in case of errors the user should be allowed to correct them (the program should not terminate)
- documentation (Javadoc) - description of all classes, methods, fields, and packages
- documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws
- Java naming convention and English identifiers.

### Prototype no. 2

- scope of the prototype no. 1
- replacing all arrays with collections (or adding a collection if no array was used so far)
- preparation of unit tests method headers (method bodies may be empty) for all public model members,
- use of proper annotations with all test methods, including complete test data sets,

### Final version no. 2

- scope of the final project no. 1,
- use of generic collection in one of the model classes,
- use of the for-each loop (Java 5 or Java 8 version),
- use of one of the following elements:
    - enum type,
    - own generic type,
    - varargs,
    - own annotation (different from the one used in the examples),
    - lambda expression with own functional interface,
- use of streams for collections' data processing,
- unit tests for all public model methods (except for constructors, accessors and mutators)
- unit tests should cover correct, incorrect and border situations,
- parametrized tests,
- documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
- documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
- Java naming convention and English identifiers.

### Prototype no. 3

- scope of the prototypes no. 1 & 2
- at least one complete application view designed in Swing or Java FX
- listener/action methods headers (the body may be empty) for all buttons

### Final version no. 3

- scope of the final projects no. 1 & 2,
- GUI application based on Swing or JavaFX, including:
    - an advanced container (tabbed pane, split pane),
    - message box (JOptionPane for Swing, Alert for JavaFX) to indicate validation errors or information messages,
    - table to store the history of performed operations,
    - menu,
- documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
- documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
- Java naming convention and English identifiers.

### Prototype no. 4

- scope of the prototypes no. 1 & 2 & 3 (model, tests)
- HTML form for the application view
- servlet(s) giving access to the model, without data correctness verification

### Final version no. 4

- scope of the final projects no. 1-3 (model, tests),
- HTML form as the view part, using the POST method,
- servlet(s) providing access to the model,
- use of include or forward method,
- use of session for storing the history of performed operations (the user has to be able to DISPLAY this history),
- use of cookies to store simple statistics, for example, number of errors or visits to the history page,
- same way of handling GET and POST requests,
- data validation and use of sendError in case of invalid data,
- documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
- documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
- Java naming convention and English identifiers.

### Prototype no. 5

- web application with unit tests of the model and access to the model (scope of prototypes 2 and 4).
- data classes in the model (entities in case of JPA, or POJOs for JDBC).
- CRUD operations for all data classes without exception handling and access from the web application.

### Final version no. 5

- scope of the final projects no. 1-4 (model, tests, web application),
- database support using JDBC or JPA,
- automatic database schema creation on the first run of the application,
- database connection should be established only once for the run of the application,
- storing the history of performed operations in the database,
- ability to see all database records through the web application,
- database exceptions handling,
- documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
- documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
- Java naming convention and English identifiers.

## Submitting project iteration

Project should be submitted in form of the zip archive.
Archive should contain the whole netbeans project without /target folder (but remember about extracting documentation with show=private + 'generate-sources javadoc:javadoc javadoc:test-javadoc').
