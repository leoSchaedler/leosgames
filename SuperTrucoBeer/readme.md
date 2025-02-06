# SuperTrucoBeer

## Overview
SuperTrucoBeer is a **Top Trumps (Super Trunfo)**-style card game based on different types of beers. Each card represents a beer style and contains statistics related to the beer, which are used to compete against other players.

## Features
- **Turn-based card gameplay** similar to Top Trumps.
- **Diverse beer deck**, with real-world beer types and attributes.
- **AI opponent support**, allowing single-player matches.
- **Decision Tree-based logic** to enhance AI decisions.

## Installation
### Prerequisites
- Java 8 or later
- IDE such as IntelliJ IDEA, Eclipse, or VS Code with Java support

### Running the Game
1. Obtaining game files.
2. Open the project in your preferred Java IDE.
3. Ensure dependencies are resolved and build the project.
4. Run the `Jogo.java` main class to start the game.

## Data & Assets
- **Beer data**: Found in `src/br/puc/pr/Data/`, includes CSV and Excel files with beer statistics.
- **Beer images**: Located in `src/br/puc/pr/Data/Beers/Beers/`, providing visuals for the game.

## Gameplay
1. Each player starts with a deck of beer cards.
2. Players take turns choosing a statistic (e.g., Alcohol Percentage, Bitterness).
3. The player with the better statistic wins the round and takes the opponent's card.
4. The game continues until one player has all the cards.

