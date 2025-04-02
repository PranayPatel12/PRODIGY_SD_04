# PRODIGY_SD_04
Sudoku Solver 🧩
Overview
This Sudoku Solver is a Java-based program that solves Sudoku puzzles using the Backtracking algorithm. It allows users to input an incomplete Sudoku puzzle, validates the input, and automatically finds a solution if one exists.

Features
✅ Accepts 9x9 Sudoku grid input from the user
✅ Backtracking algorithm to solve the puzzle efficiently
✅ Validates input to ensure numbers are between 0 and 9
✅ Prints the board before and after solving
✅ Displays a message if no solution exists

How It Works
The user enters a 9x9 Sudoku puzzle, using 0 to represent empty spaces.

The program verifies the input and ensures all numbers are between 0 and 9.

The Backtracking algorithm attempts to fill empty cells recursively.

If a valid solution exists, the solved puzzle is displayed.

If the puzzle is unsolvable, the user is notified.

Algorithm Explanation
The Backtracking approach follows these steps:

Find an empty cell (represented as 0).

Try numbers 1 to 9 and check if placing a number is valid.

If valid, recursively proceed to the next empty cell.

If a dead-end is reached, backtrack (undo the last move) and try a different number.

The process continues until the puzzle is solved or deemed unsolvable.

Technologies Used
Java for the core logic

Scanner for user input

Backtracking algorithm for solving

Author
Pranay Javvaji

