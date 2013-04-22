NAME-DIVEY KUMAR GUPTA
EMAIL ID-diveygup@usc.edu
USC ID-8945816572
username on aludra-diveygup

Files submitted:

createdb.sql
dropdb.sql
populate.java
hw2.java
map.jpg

To compile:

1)map.jpg should be present in the current directory.

2)First set classpath that contains the 3 jars

3)Change the jdbc:odbc connection string in populate.java and hw2.java
eg:
Change:::  String URL = "jdbc:oracle:thin:@gilaan.usc.edu:1521:csci585";
to an existing host with oracle


Now execute in the current folder

javac -classpath classes111.jar;sdoapi.zip;sdoapi_javadoc.zip populate.java
java -classpath classes111.jar;sdoapi.zip;sdoapi_javadoc.zip;. populate building.xy people.xy ap.xy

javac -classpath classes111.jar;sdoapi.zip;sdoapi_javadoc.zip hw2.java
java -classpath classes111.jar;sdoapi.zip;sdoapi_javadoc.zip;. hw2
