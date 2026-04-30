# Console Cricket Game 🏏

A Java console-based cricket game project featuring toss, innings simulation, score calculation, wickets, overs display, and final match results.

## Features

* Toss system (Heads / Tails)
* Choice to Bat or Bowl after winning toss
* Player vs Computer gameplay
* Score tracking with wickets and overs
* Boundary messages for FOUR and SIX
* Wicket messages when batsman gets out
* Match result messages (Win / Lose / Tie)
* Match summary after every game
* Computer innings delay using `Thread.sleep()` for realistic gameplay

## Technologies Used

* Java
* OOP Concepts
* Scanner Class
* Random Class
* Thread.sleep()

## How to Run

1. Copy the code into a file named:

`Cricket.java`

2. Compile the program:

```bash
javac Cricket.java
```

3. Run the program:

```bash
java Cricket
```

## Game Rules

* Total match length: 10 overs (60 balls)
* Maximum wickets: 10
* Runs are generated randomly
* Values from 0 to 6 = runs scored
* Value 7 = wicket (player gets out)
* Player can press `P` to continue batting

## Example Gameplay

```text
---------- Toss time ----------
Press H for heads or T for tails: H

You've won the toss!!
Enter your choice:
1 for batting or 2 for bowling
: 1

----------Player score----------
Press p to hit the ball

BOOM! That's a massive SIX!
Score: 6/0 (0.1)
```

## Match Result Examples

* You won by 25 runs
* You won by 6 wickets
* Lost by 3 wickets
* Match tied

## Future Improvements

* Difficulty levels (Easy / Medium / Hard)
* Super Over in case of tie
* Player name input
* Replay option
* Full scoreboard
* Strike rotation system
* Better AI for computer batting

## Author

**Vaibhav Kumar**  
Java Developer | Student | Project Creator
Created as a Java mini project for practice and learning.
