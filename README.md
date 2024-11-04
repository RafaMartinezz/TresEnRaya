# Tic-Tac-Toe Console Game

This Java project implements a classic **Tic-Tac-Toe** game in which a human player competes against the computer in a 3x3 grid. The game offers adjustable difficulty levels and features a console-based interface that guides the player through each move and displays the current game board.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Class Structure](#class-structure)
- [Game Flow](#game-flow)
- [Example Output](#example-output)

---

## Overview

The project consists of a console-based Tic-Tac-Toe game where the player and the computer take turns placing pieces on a 3x3 grid. The human player starts first, and the game alternates turns until one player aligns three pieces in a row (vertically, horizontally, or diagonally) or the board is fully occupied, resulting in a draw.

## Features

- **Adjustable Difficulty**: 
  - Choose from three difficulty levels: Easy, Intermediate, and Hard. (Currently, only Easy is fully implemented).
- **Turn-Based Gameplay**: 
  - The player and computer alternate turns, with clear prompts guiding each move.
- **Board Display**:
  - The current game board is displayed after each move to show the latest game state.
- **Win and Draw Detection**:
  - The game detects and announces a winner or draw, ending the game when conditions are met.

## Class Structure

- **`TresEnRaya`**: 
  - Core game logic class that manages the board state, player moves, win conditions, and game-ending logic.
- **`Tablero`**:
  - Represents the 3x3 board where the game is played. Provides access to the board matrix for tracking moves.
- **`InterfaceConsola`**: 
  - Console-based user interface that guides the player, displays game instructions, prints the board, and handles alternating turns.

## Game Flow

1. **Welcome and Instructions**:
   - The game starts by presenting instructions and setting the game difficulty level.
2. **Player and Computer Turns**:
   - The player makes the first move by choosing a row and column, followed by the computer's move.
   - The board updates after each move, showing the current game state.
3. **End of Game**:
   - The game checks for three-in-a-row after each move. If one player wins, the game announces the winner.
   - If the board is full and no player has three in a row, the game ends in a draw.
   
## Example Output

The following output shows a sample gameplay session:

```plaintext
Welcome to the magic of Tic-Tac-Toe! Prepare for an unforgettable experience!
The game board is 3x3, and the game ends when one of us gets three in a row.
I’ll win, of course, because you’re just a rookie!
We’ll take turns placing a piece in a square on the board.
You’ll need to specify the row and column of the square you want to choose.
Let’s get started!

What difficulty level do you choose? EASY: 'F', INTERMEDIATE: 'I', or HARD: 'D'?
> F
You have chosen difficulty: EASY

_ _ _
_ _ _
_ _ _

It's your turn, Player!
Please enter the row and column.
> 0 0

X _ _
_ _ _
_ _ _

It's my turn!
_ O _
_ _ _
_ _ _

It's your turn, Player!
Please enter the row and column.
> 1 1

X _ _
_ X _
_ _ _

...

The winner is Player!
```

This example showcases:
- The initial game instructions and difficulty selection.
- Alternating turns between the player and computer.
- The real-time board display after each move.
- Announcement of the game result once a winner is determined.
