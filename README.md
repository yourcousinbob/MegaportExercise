## Summary 
This is a programming exercise provided my Megaport as part of their hiring process. It is a simple command line application which sorts an input file of names by the last name and then the first name. The application takes one argument which is the file to be sorted and creates an output file with the names sorted with the suffix -sorted. An example usage would be as follows.

./sort.sh <input_file>

For example, if the input file contains:

BAKER, THEODORE

SMITH, ANDREW

KENT, MADISON

SMITH, FREDRICK

Then the output file would be:

BAKER, THEODORE

KENT, MADISON

SMITH, ANDREW

SMITH, FREDRICK

Example of console log:

BAKER, THEODORE

KENT, MADISON

SMITH, ANDREW

SMITH, FREDRICK

Finished: created <input_file>-sorted.txt

## Testing 

To run tests you will need an updated version of JUnit, to run them utilise the compiled classes in the out/test/MegaportExercise/com/megaport/test directory and run them with the JUnit jar file. (Would reccomend utilising and IDE for this).

## Dependencies 
SDK - open-jdk-17.0.1 

JUnit - 5.8.1
