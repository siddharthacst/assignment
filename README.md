# assignment
The Pizza Handler takes in a pizza order and sorts it and converts it into human readable format.
```
Input:
Order		time
Meat		1506176687
pizza		1477578287
p1zza		1477491887
Bread		1477405487
Pizza		1477319087
bread		1477232687
bread		1474640687
meatMeaT	1474295087
VegVeg		1474295087


Output:
Order	 Time 
Bread	Sat Jan 17 20:23:25 CST 1970
Meat	Sun Jan 18 04:22:56 CST 1970
Pizza	Sat Jan 17 20:21:59 CST 1970
VegVeg	Sat Jan 17 19:31:35 CST 1970
bread	Sat Jan 17 20:20:32 CST 1970
bread	Sat Jan 17 19:37:20 CST 1970
meatMeaT	Sat Jan 17 19:31:35 CST 1970
p1zza	Sat Jan 17 20:24:51 CST 1970
pizza	Sat Jan 17 20:26:18 CST 1970
```

It is made up of loosely coupled components:
1. Service which handles the input requests
2. Data Access

The Service can be invoked from a rest controller with the pizza order coming over http requests.
The generic DataAccess implementation can be easily modified to save to a database.

All the components have been unit tested


Running the project(Assuming mvn is installed):

To build the maven project and run all the unit test:
$ mvn clean install

To run the integration test from cmd line:
$ mvn exec:java -Dexec.mainClass="com.assignment.service.PizzaHandlerIntegration" -Dexec.args="sample_data_ordered.txt sorted_data.txt"


Assumptions:

1. mvn is installed
2. jre atleast 1.7
3. Sorted the pizza order by names. If same name pizza order comes(duplicates) we keep them in order
4. Assuming first line is description skipping it. May need to check specifically later
5. Considered only the non blank lines
6. Epoch time in Long can be changed into human readable format.
7. Skipping this line if only one column found
8. Skips line if line is empty.

Running for businees users:(Minimum requirement JRE in machine)

1. Download the .jar file in the project and keep the pizza text file in the same directory.
2. $java -jar pizzahandler.jar sample_data_ordered.txt sorted_data.txt. Check the output file for verifying