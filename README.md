
# JiIaMD laboraory project

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


## Submitting project iteration

Project should be submitted in form of the zip archive.
Archive should contain the whole netbeans project without /target folder (but remember about extracting documentation with show=private + 'generate-sources javadoc:javadoc javadoc:test-javadoc').