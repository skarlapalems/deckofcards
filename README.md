# deckofcards api test automation
This Test automation project uses the following libraries.
1. TestNG for writing test cases and test suite.
2. Rest Assured used for making rest api calls
3. Jackson used for serialization and deserialization of json to java objects
4. Maven is used for dependency management and executing the test suite

Usage
-------

From inside the project directory, run the following:

```
mvn test

```

Please note that the POST invocation for creating a deck with jokers is FAILING due to server side looking for CSRF cookies. When the tests are executed this shows up as failed test case, see below for sample output.

Tests run: 4, Failures: 1, Errors: 0, Skipped: 0

Description
-----

The project is organized into 4 packages

1. model, contains the java classes for mapping the json.
2. service, contains the reusable rest assured logic for invoking apis
3. test, contains actual TestNG test cases
4. util, contains util class for loading the configs (serverurl) from properties file.


