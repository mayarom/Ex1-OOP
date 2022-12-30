# Ex1-OOP
EX1 Observer UndoableStringBuilder
This project is a Java implementation of an observer design pattern using an undoable string builder. The observer design pattern allows objects (i.e., observers) to register for and receive notifications from a subject when the subject's state changes. In this project, the GroupAdmin class represents the subject and the ConcreteMember class represents the observers. The UndoableStringBuilder class is a wrapper class for the Java StringBuilder class that adds undo functionality.

The GroupAdmin class has methods for registering and unregistering observers, performing operations on the string builder (e.g., inserting, deleting, replacing, and appending strings), and undoing the last operation on the string builder. It also has a method for notifying all registered observers of the current state of the string builder.

The ConcreteMember class is a concrete implementation of the observer interface. It has a method for receiving updates from the subject and printing the current state of the string builder to the console.

The UndoableStringBuilder class has methods for inserting, deleting, replacing, and appending strings to the string builder, as well as a method for undoing the last operation on the string builder.

To test the code, you can run the GroupAdminTest class, which performs a series of operations on the string builder and verifies the correct behavior of the observer design pattern and the undo functionality.

#Member
The Member interface has the following method:

update(String str): Receives an update from the subject.
ConcreteMember
The ConcreteMember class is a concrete implementation of the Member interface. It has the following methods:

ConcreteMember(): Constructs a new ConcreteMember object.
update(String str): Receives an update from the subject and prints the current state of the string builder to the console.

#GroupAdmin
The GroupAdmin class has the following methods:

GroupAdmin(): Constructs a new GroupAdmin object with an empty string builder.
GroupAdmin(String str): Constructs a new GroupAdmin object with a string builder initialized with the given string.
register(Member member): Registers a new observer to the subject.
unregister(Member member): Unregisters an observer from the subject.
insert(int index, String str): Inserts the given string at the given index in the string builder.
delete(int start, int end): Deletes the characters from the given start index to the given end index in the string builder.
replace(int start, int end, String str): Replaces the characters from the given start index to the given end index with the given string in the string builder.
append(String str): Appends the given string to the string builder.
undo(): Undoes the last operation on the string builder.
updateMembers():
