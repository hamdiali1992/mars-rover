# Mars Rrover Problem- Java
## Problem statement
A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously rectangular, must be navigated by the
rovers so that their on-board cameras can get a complete view of the
surrounding terrain to send back to Earth.
A rover's position and location is represented by a combination of x and y
co-ordinates and a letter representing one of the four cardinal compass
points. The plateau is divided up into a grid to simplify navigation. An
example position might be 0, 0, N, which means the rover is in the bottom
left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The
possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90
degrees left or right respectively, without moving from its current spot.
'M' means move forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).

INPUT:

OUTPUT:
The output for each rover should be its final co-ordinates and heading.

INPUT AND OUTPUT
Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Expected Output:
1 3 N
5 1 E

COMMAND LINE:
The program will be runned with this command line:

> 	java -jar rover.jar input.txt

# Execution
### To create the jar in ` out ` directory
* Go to File -> Project structure -> Artifacts -> `+` -> JAR -> From modules with dependency -> select Main class
* Then Build -> Build artifacts ... -> Rover:jar -> Build
And The Rover.jar will be generated in the `out` directory of the project.

> ## Test coverage: 91%
