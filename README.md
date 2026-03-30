# Battleship: Steroid Edition

Welcome to the naval warfare simulator that actively judges your tactical incompetence. This is a 10x10 console-based Java application built to prove that graphical user interfaces are a crutch for the weak. 

You will deploy a fleet, manage limited heavy munitions, and fight an AI that actually knows how to hunt you down.

## Features That Matter

* **Skynet-Lite AI:** The enemy uses a Stack-based state machine. It guesses randomly until it draws blood, then systematically targets adjacent coordinates until your hull is vaporized.
* **Asymmetrical Warfare:** You are armed with standard artillery, a single Tactical Nuke, and two Sonar pings. Resource management is mandatory.
* **Object-Oriented Carnage:** Built using the Strategy Pattern for the weapon systems and strict inheritance for the fleet. The codebase is as rigid as naval discipline.
* **Performance Reviews:** A brutal post-game scoring system that will explicitly tell you if you belong in a court-martial.

## The Arsenal

| Weapon System | Inventory | Tactical Effect |
| :--- | :--- | :--- |
| **Standard Shell** | Infinite | Hits a single 1x1 coordinate. Boring, but reliable. |
| **Tactical Nuke** | 1 | Obliterates the target coordinate and all four adjacent cardinal tiles. |
| **Sonar Ping** | 2 | Scans a 3x3 grid and reports the exact number of intact enemy hulls. |

## The Fleet

* **Carrier** (Size: 5)
* **Battleship** (Size: 4)
* **Submarine** (Size: 3)
* **Destroyer** (Size: 3)
* **Patrol Boat** (Size: 2)

## How to Run This Disaster

1. Ensure you have a functioning Java Development Kit (JDK) installed. 
2. Clone this repository to your local machine.
3. Open your terminal and navigate to the source folder.
4. Compile the fleet: `javac *.java`
5. Initiate the war loop: `java GameEngine`
6. Prepare to lose to a random number generator.

## Architecture & Tech Stack

* **Language:** Pure Java
* **UI:** Unforgiving Console ASCII
* **Dependencies:** Zero. We don't need Maven or Gradle to sink ships.