# EX1 Observer UndoableStringBuilder

# Introduction

The Ex1 - observer undoablestringbuilder program, created by Avichai Mizrahi and Maya Rom, is a Java program that implements an observer design pattern using an undoable string builder. The goal of the program is to allow a group administrator to modify a string builder and notify a group of members of the current state of the string builder, with the ability to undo the last operation on the string builder.

# Interfaces
The project includes the following interfaces:

# Member
The Member interface is the observer interface in the observer design pattern. It has the following method:

- update(String str): Receives an update from the subject.

# Sender
The Sender interface is implemented by the GroupAdmin class and defines the methods that the GroupAdmin class uses to communicate with the observers. It has the following methods:

- register(Member obj): Registers a new observer to the subject.
- unregister(Member obj): Unregisters an observer from the subject.
- insert(int offset, String obj): Inserts the given string at the given index in the string builder.
- append(String obj): Appends the given string to the string builder.
- delete(int start, int end): Deletes the characters from the given start index to the given end index in the string builder.
- undo(): Undoes the last operation on the string builder.

# Classes

# ConcreteMember
The ConcreteMember class is a concrete implementation of the Member interface. It has the following fields and methods:

Fields:
- usb: An instance of the UndoableStringBuilder class that represents the undoable string builder for the ConcreteMember object.
- name: A string that represents the name of the member.

Methods:
- ConcreteMember(String name): Constructs a new ConcreteMember object with the given name and an empty undoable string builder.
- update(UndoableStringBuilder usb): Prints a message to the console with the current state of the undoable string builder.

# GroupAdmin
The GroupAdmin class is the subject in the observer design pattern. It has the following fields and methods:

Fields:
- undoableStringBuilder: An instance of the UndoableStringBuilder class that represents the string builder for the GroupAdmin object.
- members: A list of the members that are registered to the GroupAdmin object.

Main&important methods:

- GroupAdmin(): Constructs a new GroupAdmin object with an empty string builder.
- GroupAdmin(String str): Constructs a new GroupAdmin object with a string builder initialized with the given string.
- register(Member member): Registers a new observer to the subject.
- unregister(Member member): Unregisters an observer from the subject.
- insert(int index, String str): Inserts the given string at the given index in the string builder.
- delete(int start, int end): Deletes the characters from the given start index to the given end index in the string builder.
- replace(int start, int end, String str): Replaces the characters from the given start index to the given end index with the given string in the string builder.
- append(String str): Appends the given string to the string builder.
- undo(): Undoes the last operation on the string builder.
-  UpdateMembers(): update the member kisr to the new string.

# Other Classes
# UndoableStringBuilder

The UndoableStringBuilder class is a wrapper class for the Java StringBuilder class that adds undo functionality. 
The UndoableStringBuilder class has methods for inserting, deleting, replacing, and appending strings to the string builder, as well as a method for undoing the last operation on the string builder.

# Testing - JVM & JUNIT

To test the code, you can run the GroupAdminTest class, which performs a series of operations on the string builder and verifies the correct behavior of the observer design pattern and the undo functionality.

The Tests class contains JUnit tests for the GroupAdmin and ConcreteMember classes. It uses the JVM (Java Virtual Machine) to test the performance and memory usage of the program.
These tests verify the correct behavior of the observer design pattern and the undo functionality in the GroupAdmin, ConcreteMember, and UndoableStringBuilder classes.

The tests are located in the Tests class and are organized into the following methods:

- register(): Tests the register() method of the GroupAdmin class. It adds a new member to the group and checks if the member was added correctly. It also logs the       memory usage and performance of the JVM during the test.
- unregister():Tests the unregister() method of the GroupAdmin class. It adds a new member to the group, then removes the member and checks if the member was removed     correctly. It also logs the memory usage and performance of the JVM during the test.

- insert():Tests the insert() method of the GroupAdmin class. It inserts a string at a specific index in the string builder and checks if the insert was successful. It   also logs the memory usage and performance of the JVM during the test.
- append(): Tests the append method in the GroupAdmin class by appending a string to the end of the string builder and verifying that the append was successful.
- delete(): Tests the delete method in the GroupAdmin class by deleting a range of characters from the string builder and verifying that the delete was successful.
- undo(): Tests the undo method in the GroupAdmin class by performing a series of operations on the string builder and undoing the last operation.

# UML Diagram

In this UML diagram, the GroupAdmin class implements the Sender interface and the Member interface. The ConcreteMember class implements the Member interface. The GroupAdmin class maintains a list of ConcreteMember objects as observers. The UndoableStringBuilder class provides the implementation for the string builder operations in the Sender interface.

                             +-------------------+
                             |     GroupAdmin    |
                             +-------------------+
                             | - observers:      |
                             |   List<Member>    |
                             | - stringBuilder:  |
                             |   UndoableStringBuilder |
                             +-------------------+
                             | + register(       |
                             |   Member member)  |
                             | + unregister(     |
                             |   Member member)  |
                             | + insert(int,     |
                             |   String)         |
                             | + delete(int,     |
                             |   int)            |
                             | + replace(int,    |
                             |   int, String)    |
                             | + append(String)   |
                             | + undo()          |
                             | + notifyObservers()|
                             +-------------------+
                                       |
                                       | implements
                                       |
                        +---------------+---------------+
                        |  + update(Subject)              |
                        |                                 |
               +-------------------+                  +-------------------+
               |  ConcreteMember   |                  |       Sender      |
               +-------------------+                  +-------------------+
                                       |
                                       | implements
                                       |
                               +-------------------+
                               |       Member      |
                               +-------------------+
                               | + update(Subject) |
                               +-------------------+
# Run
To run our project- you must have JDK and Maven installed (in your IDE).

click this command: https://github.com/mayarom/Ex1-OOP.git
 
Then, open the project via IntelliJ and select build -> Rebuild project.
Let the project be rebuilt, and then you can run the Tests.java class to see the functionality of the project.


# Contact Information
- Maya Rom : maya5660@gmail.com
- Avichai Mizrahi : avichaim@gmail.com
 
We are happy to answer any questions or provide additional information about the Ex1 - observer undoablestringbuilder project. Please don't hesitate to contact us via email if you have any questions or feedback.


