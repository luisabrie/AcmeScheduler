# Acme Scheduler
The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame

The program allows you to output a table containing pairs of employees and how often they have coincided in the office.

## Overview

It's a basic console application that allows ACME to calculate  pairs of employees and how often they have coincided in the office.

It receives a textfile containing in each line the name of an employee and the schedule they worked

It outputs a table detailing the employee pair and the number of coincidences.

<details><summary>Example</summary>

### Input
```
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
CAMILA=MO07:00-12:00,TU08:00-13:00,WE09:00- 12:00,TH14:00-16:00,SU19:00-23:59
JUAN=FR07:00-12:00,TU08:00-13:00
```
### Output
```
ANDRES-CAMILA        2
ANDRES-JUAN          0
ASTRID-ANDRES        3
ASTRID-CAMILA        2
ASTRID-JUAN          0
CAMILA-JUAN          1
RENE-ANDRES          2
RENE-ASTRID          2
RENE-CAMILA          3
RENE-JUAN            1
```
</details>

## Architecture
To describe the architecture I will use a UML Class Diagram.

![UML Class Diagram](https://imgur.com/8xkXOcN.png)

Three models were identified.

#### TimeFrame
A timeframe has:
- day
- startMinute
- range.

The day is in the form of "MO".

The startMinute is the start time of the employee schedule for that day expressed in minutes.

Finally the range is the number of minutes passed from the startMinute.

The class has a particular method isInRange(TimeFrame) that tells if another TimeFrame coincides in the each others ranges 
#### Employee
An employee has:
- name
- schedule
#### Schedule
The schedule has:
- timeFrameList
- timeFrameMap

The schedule is basically many timeFrames tied together in a list and a Map.

The most important method is called compareSchedules(Schedule) that allows the programmer to compare two schedules to see how many coincidences both have.

#### Controllers

There are two controllers that allows the programmer to:
- Compare schedules in an employee list. (EmployeeScheduleComparisonController)
- Read an employee list from a file (ReadEmployeeFileController)

#### The runner program
The main program ask for a file name to the user and ask the controllers to process the information that it needs, in order to render the output.
## Problem-solving approach
In order to solve the program, I have done the following steps: 
1. Sketch a basic model of the program.
2. Sketch the numerous ways a TimeFrame could coincide or not with another one.
3. Model the TimeFrame Class.
4. Model the Schedule Class
5. Model the Employee Class
6. Create the controller to obtain the coincidences between employees.
7. Create the controller to obtain the information from a file provided.
8. Render the view in the main program.
9. Unit Testing
10. Coverage Testing
11. Draw the class diagram.

## Compilation and Usage

- The project was coded and test in Java 1.18.
- Testing was done using JUnit 4 and code Coverage was verified in IntelliJ Idea. 
- The project manager is in Maven. 
- The IDE used was IntelliJ IDEA.

In order to compile the project, you need to have installed in your computer maven. It also needs to be in the PATH of your console.

1. Clone the repository:
```git clone https://github.com/luisabrie/AcmeScheduler.git```
2. Compile the project (it should run the tests automatically): ```mvn package```
3. Move the .jar from the target folder to a folder of your choice.
4. Move the employee.txt file, or any file that uses the same format into the folder that you move the .jar
5. Run the project in the command line using: ```java -jar AcmeScheduler-1.0.jar```

While you are running the project, the app would ask you for the name of the file in which the employees information resides. Type the name and press ENTER.
If there are no format errors, the coincidences should appear.