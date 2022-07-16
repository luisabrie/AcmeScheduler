# Acme Scheduler
ACME offers its employees the flexibility to work the hours they want. But due to some external circumstances they need to know which employees have coincided in the office within the same schedule.

The program allows you to output a table containing pairs of employees and how often they have coincided in the office.

## Overview

This is a basic console application that allows ACME to calculate the pairs of employees and the frequency with which they have coincided in the office.

It receives a text file containing on each line the name of an employee and the time they have worked.

It outputs a table detailing the employee pair and the number of matches.

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

The startMinute is the start time of the employee's schedule for that day expressed in minutes.

Finally, the range is the number of minutes elapsed since the startMinute.

The class has a particular method isInRange(TimeFrame) which outputs true if another TimeFrame provided matches in the ranges of each other. 

#### Employee
An employee has:
- name
- schedule
#### Schedule
The schedule has:
- timeFrameList
- timeFrameMap

The schedule is basically many timeFrames tied together in a List and a Map.

The most important method is called compareSchedules(Schedule) that allows the programmer to compare two schedules to see how many matches they both have.

#### Controllers

There are two controllers that allows the programmer to:
- Compare schedules in an employee list. (EmployeeScheduleComparisonController)
- Read a list of employees from a file (ReadEmployeeFileController)

#### The runner program
The main program requests a file name from the user and asks the controllers to process the information it needs, to give the output.
## Problem-solving approach
In order to solve the program, I have done the following steps: 
1. Sketch a basic model of the program.
2. [Sketch](https://i.imgur.com/LYpWoAt_d.webp?maxwidth=760&fidelity=grand) the many ways in which one TimeFrame may or may not match another. 
3. Model the TimeFrame class.
4. Model the Schedule class.
5. Model the Employee class.
6. Create the controller to obtain the matches between employees.
7. Create the controller to obtain the information from a provided file.
8. Create the view in the main program.
9. Unit tests
10. Coverage testing
11. Draw the class diagram.

## Compilation and Usage

- The project was coded and tested in Java 1.18.
- The tests were performed with JUnit 4 and the code coverage was checked in IntelliJ Idea. 
- The project manager is in Maven. 
- The IDE used was IntelliJ IDEA.

In order to compile the project, it is necessary to have Maven installed on the computer. It is also necessary that it is in the PATH of your console.

1. Clone the repository:
```git clone https://github.com/luisabrie/AcmeScheduler.git```
2. Compile the project (it should run the tests automatically): ```mvn package```
3. Move the .jar from the target folder to a folder of your choice.
4. Move the employee.txt file, or any file that uses the same format into the folder that you move the .jar
5. Run the project in the command line using: ```java -jar AcmeScheduler-1.0.jar```

While running the project, the application will prompt you for the name of the file where the employee information resides. Type the name and press ENTER.
If there are no formatting errors, the matches should appear.
