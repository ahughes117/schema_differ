Schema Differ
=============

Diffs two relational database schemas. Really handy to compare development and production versions of databases.

I kept it very laconic and simple because I am tired to bloated applications crashing for a simple task like this.

Contains a Graphical User Interface as well as a Command Line Interface.

The Command Line Interface solves the problem of not being able to connect to a database from an external host. Just upload the file and run it on the server that mysqld is running.

Any suggestions and contributions are welcome.

=============

How to use the CLI:

You need 6 arguments in the following order:

java -jar schema_differ.jar "uri1" "user1" "password1" "uri2" "user2" "password2"

You will get a created report.txt file which contains the report of the diff. This is usually produced in the folder of the jar file, unless you initiate the schema differ from another folder like that: "java -jar /home/my_user/schema_differ.jar". I don't know where the report will be produced then, you are on your own. Prefer to "cd" to the jar's folder for ease of use.

As I am using a linux bash shell, and I've got a sample bash script included for this reason. Probably Apple users can use it as well.

I am sure that you can work your way around with Windows batch files as well, but I can't be bothered to write one.
