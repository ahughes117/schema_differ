#!bin/bash

cd /path/to/my/jar/

java -jar schema_differ.jar "jdbc:mysql://dbhost1/schema1" "user1" "pass1" "jdbc:mysql://dbhost2/schema2" "user2" "pass2"
