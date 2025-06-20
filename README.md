# Epic Console RPG

A text-based role-playing game built in Java featuring turn-based combat, multiple character classes, and enemy encounters.

## Features

- **3 Character Classes**: Choose from Warrior, Mage, or Ninja, each with unique stats
- **Turn-based Combat**: Strategic battle system with multiple action options
- **Multiple Enemies**: Face Goblins, Trolls, and Dragons with varying difficulty
- **Special Abilities**: Use mana-based special attacks for increased damage
- **Health System**: Manage health with potions earned through victories
- **Progress Tracking**: View victories and save game results to file
- **Professional UI**: Clean console interface with emojis and formatting

## Getting Started

### Prerequisites

- Java 21
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/timlapov/java-console-epic-rpg.git
   cd java-console-epic-rpg
   ```

2. **Compile the project**
   ```bash
   javac -d out src/art/lapov/rpg/**/*.java
   ```

3. **Run the game**
   ```bash
   java -cp out art.lapov.rpg.Main
   ```

### Alternative: Using an IDE

1. Import the project into your Java IDE
2. Set the source folder to `src`
3. Run the `Main.java` file located at `src/art/lapov/rpg/Main.java`

## How to Play

1. **Character Creation**: Enter your hero's name and choose from three character classes:
   - **Warrior**: High health and defense, moderate attack
   - **Mage**: High mana and magic damage, lower defense
   - **Ninja**: Balanced stats for versatile gameplay

2. **Combat Actions**: During battle, choose from:
   - **Attack**: Deal basic damage to enemy
   - **Use Potion**: Restore 5-25 health points
   - **Special Ability**: Powerful magic attack (costs 10 mana)
   - **Skip**: Pass your turn

3. **Victory Rewards**: Each defeated enemy grants:
   - Victory counter increase
   - Additional health potion
   - Mana restoration (+5)

4. **Game End**: The game continues until your hero is defeated. Final results are saved to `scores.txt`

## Project Structure

```
src/art/lapov/rpg/
   Main.java                 # Entry point and game loop
   characters/
      Character.java        # Base character class
      Hero.java            # Player character implementation
      Enemy.java           # Base enemy class
      Dragon.java          # Boss enemy (60 HP, 10 DEF, 25 ATK)
      Goblin.java          # Weak enemy
      Troll.java           # Standard enemy
   enums/
      HeroActions.java     # Player action definitions
   exceptions/
      HeroOutOfRangeException.java
   interfaces/
      SpecialAbility.java  # Special ability contract
   utils/
      CombatManager.java   # Game logic and combat system
```

## Technical Details

- **Language**: Java 21
- **Architecture**: Object-oriented design with inheritance and interfaces
- **Design Patterns**: Factory pattern for character creation, Strategy pattern for abilities
- **Exception Handling**: Custom exceptions for input validation
- **File I/O**: Game results persistence to `scores.txt`

## Development

### Key Classes

- **Character**: Abstract base class for all game entities
- **Hero**: Player character with mana, potions, and special abilities
- **Enemy**: Base class for all opponents
- **CombatManager**: Handles game logic, combat mechanics, and file operations
- **SpecialAbility**: Interface for implementing character abilities

### Future Enhancements

- Complete CyberNinja character implementation
- Additional enemy types and boss battles
- Equipment and inventory system
- Save/load game functionality
- Multiplayer support

## License

This project is open source and available under the MIT License.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Contact

For questions or suggestions, please open an issue on GitHub.

---
