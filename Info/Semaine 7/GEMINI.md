# Project: Java Exercises - Semaine 7

## Project Overview

This directory contains a collection of Java exercises for a university-level programming course, likely corresponding to "Week 7" of the curriculum. The project is structured as an IntelliJ IDEA project.

The exercises cover fundamental Object-Oriented Programming (OOP) concepts, with each sub-directory (`Ex1`, `Ex3`, etc.) representing a distinct problem or topic. The progression of exercises demonstrates a shift from procedural programming towards more encapsulated, object-oriented solutions.

**Key Technologies:**
*   **Language:** Java
*   **Build/IDE:** IntelliJ IDEA

## Building and Running

### Using IntelliJ IDEA (Recommended)

The simplest way to run the exercises is to open the project in IntelliJ IDEA. Each `main` method within the `.java` files can be run directly from the editor.

### Using the Command Line

You can also compile and run each exercise manually from the terminal.

**General Pattern:**

1.  **Compile:**
    ```bash
    # Example for Ex6
    javac -d out/production/"Semaine 7" src/Ex6/Geometrie.java
    ```

2.  **Run:**
    ```bash
    # Example for Ex6
    java -cp out/production/"Semaine 7" Ex6.Geometrie
    ```
    *Note: The `-cp` flag sets the classpath to the output directory where compiled files are located.*

## Development Conventions

*   **Language:** All code, including variable names, method names, comments, and console output, is written in **French**.
*   **Packaging:** Each exercise is isolated in its own package (e.g., `package Ex1;`, `package Ex6;`).
*   **File Structure:** For simplicity, related classes (e.g., `Point`, `Triangle`, `Geometrie`) are often grouped within the same `.java` file.
*   **OOP Principles:** The exercises serve to illustrate core OOP ideas:
    *   `Ex1/ManipRectangle.java`: Basic class definition and methods.
    *   `Ex3/Surfaces.java`: Encapsulation, with helper classes calculating parts of a whole.
    *   `Ex5/Banque1.java` vs. `Banque2.java`: Shows the refactoring of a procedural approach into an object-oriented one using a `Client` class.
    *   `Ex6/Geometrie.java`: Use of `static` methods as factories (`creerTriangleDepuisLaConsole`) and composition of objects (`Triangle` is composed of `Point`s).
    *   `Ex7/Supermarche.java`: Simulates a more complex system with multiple interacting classes (`Article`, `Achat`, `Caddie`, `Caisse`).
*   **Dependencies:** The project relies only on the standard Java SE Development Kit (JDK) and does not have external dependencies.
