# WordLadder Well!
> 🌐 Word Ladder Solver

[![Java](https://img.shields.io/badge/language-Java-red.svg)](https://java.com)
[![issues](https://img.shields.io/github/issues/rizqikapratamaa/Tucil3_13522126)](https://github.com/rizqikapratamaa/Tucil3_13522126/issues)
[![forks](https://img.shields.io/github/forks/rizqikapratamaa/Tucil3_13522126)](https://github.com/rizqikapratamaa/Tucil3_13522126/network/members)
[![stars](https://img.shields.io/github/stars/rizqikapratamaa/Tucil3_13522126)](https://github.com/rizqikapratamaa/Tucil3_13522126/stargazers)

This project implements the classic Word Ladder game solver using three different algorithms: Uniform Cost Search (UCS), Greedy Best First Search, and A*. The solver finds the shortest transformation sequence from a start word to an end word, changing one letter at a time, with each intermediate word being a valid dictionary word.

## Table of Contents
- [Project Structure](#project-structure)
- [Contributor](#contributor)
- [Installation](#installation)
- [Usage](#usage)

## Contributor
| Nama | NIM |
|---|---|
| Rizqika Mulia Pratama | 13522126 |

## Project Structure
```bash
Tucil3_13522126
├── bin
│   ├── WordLadder.jar
│   └── words_dictionary.txt
├── doc
│   └── Tucil3_13522126.pdf
├── src
│   ├── Astar.java
│   ├── GreedyBFD.java
│   ├── Main.java
│   ├── UCS.java
│   ├── WordLadder.java
│   └── words_dictionary.txt
├── test
│   ├── A-Star
│   │   ├── 1.txt
│   │   ├── 2.txt
│   │   ├── 3.txt
│   │   ├── 4.txt
│   │   ├── 5.txt
│   │   └── 6.txt
│   ├── GBFS
│   │   ├── 1.txt
│   │   ├── 2.txt
│   │   ├── 3.txt
│   │   ├── 4.txt
│   │   ├── 5.txt
│   │   └── 6.txt
│   └── UCS
│       ├── 1.txt
│       ├── 2.txt
│       ├── 3.txt
│       ├── 4.txt
│       ├── 5.txt
│       └── 6.txt
└── README
```

## Installation


```bash
# Clone the repository
git clone https://github.com/rizqikapratamaa/Tucil3_13522126.git
```

## Usage
```bash
# Navigate to the project directory
cd Tucil3_13522126

# Option 1: Directly execute the executable file
## Navigate to bin folder
cd bin
## Execute the file
java -jar WordLadder.jar


#Option 2: Compile then execute
## Navigate to bin
cd src
## Compile the source code
javac Main.java Astar.java GreedyBFS.java UCS.java WordLadder.java
## Run the compiled code
java Main
```
## Dependencies
- [Java](https://www.java.com/en/download/)
- [Java Development Kit](https://www.oracle.com/java/technologies/downloads/)