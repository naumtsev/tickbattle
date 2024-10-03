# Tick Battle

## Project Idea
The goal of this project is to adapt the [web game Generals.io](www.generals.io) to Android, adding new features and enhancing the gameplay experience.

## Game Description
Tick Battle is a strategy game played on a rectangular field divided into different types of squares. Between 2 to 8 players can battle simultaneously on the field. Each player starts with a single square containing a fortress, and they expand their territory by capturing adjacent lands using their troops.

Every few seconds, the player-owned lands generate army units. The main objective of the game is to capture other players' fortresses while protecting your own.

### Types of Squares
- **Fortress**: The main square of the player, which generates 1 army unit per tick (~1 second).
- **Mountain**: An obstacle square that cannot be moved through or captured.
- **Neutral Square**: A square that, once captured, generates 1 army unit every 5 ticks.
- **Farm**: Initially a neutral square that can be captured by spending 40 troops. After capture, it provides 1 army unit per tick (1 second).

## Game Mechanics
Players move an "active square" across the map to create a sequence of moves for each tick. To capture a square, players must gather the required number of troops displayed on it and move the "active square" into that target. At any point, the player can cancel the move queue and start a new sequence of moves.

## Result
For a quick demonstration of the game, click the link below:

[![Tick Battle Gameplay](https://img.youtube.com/vi/d0uize6Gyo4/0.jpg)](https://www.youtube.com/watch?v=d0uize6Gyo4)
