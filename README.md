Schema Differ
=============

Diffs two relational database schemas. Really handy to compare development and production versions of databases.

I kept it very laconic and simple because I am tired of bloated applications crashing whilst executing a simple task like this.

Comes with a Graphical User Interface as well as a Command Line Interface.

The Command Line Interface solves the problem of not being able to connect to a database from an external host. Just upload the jar file and run it on the server that mysqld is running.

Any suggestions and contributions are welcome.

Download the jar (executable) for the application via the downloads folder and rename it to .jar instead of .jarr. 

The reason I altered the extension is in order for it to not be caught by the .gitignore file. I wasn't in the mood of changing the .gitignore to ignore specific folders, so all jar files are ignored by default. 

Live with it! :-)

=============

How to use the CLI:

You need 6 arguments in the following order:

java -jar schema_differ.jar "uri1" "user1" "password1" "uri2" "user2" "password2"

A report.txt file will be created, which contains the report of the diff. 

This is usually produced in the folder of the jar file, unless you initiate the schema differ jar file from a different folder or an absolute path like that: "java -jar /home/my_user/schema_differ.jar". 

I don't know where the report will be generated then, you are on your own. Prefer to "cd" to the jar's folder for ease of use.

As I am using a linux bash shell, and I've got a sample bash script included for this reason. Probably Apple users can use it as well.

I am sure that you can work your way around with Windows batch files as well, but I can't be bothered to write one.
