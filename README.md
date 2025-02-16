# Sudoku solver
Online app using backtracking and multithreading for efficient puzzle solution, avaliable at:

https://sudoku.mpdgr.com/solve

Input sudoku matrix is transformed into six variants/rotations and each variant is passed to separate concurrent thread. The thread which finds the solution first, returns the results, which are transposed back to original matrix and passed as the output.

User can input the numbers for sudoku or can load random examples from the database.

Written in Java using Spring Boot and Thymeleaf template engine.


![ss](https://user-images.githubusercontent.com/95987591/192069693-c09b851b-6350-4053-9037-0d3f7bb28afd.JPG)
