# Intro to JDBC

- This is a sample project to demonstrate the use of JDBC (Java Database Connectivity) for connecting Java applications to a database.
- It includes examples of how to establish a connection, execute queries, and handle results.
- The project uses a PostgreSQL database for demonstration purposes, but the concepts can be applied to other databases as well.

## Prerequisites

- Java Development Kit (JDK) installed
- PostgreSQL database installed and running
- JDBC driver for PostgreSQL (usually included as a dependency in your project)

## Getting Started

1. Clone the repository to your local machine.

    ```bash
    git clone https://github.com/pranulkbv28/Intro-to-JDBC.git
    ```

2. Navigate to the project directory.

    ```bash
    cd Intro-to-JDBC
    ```

## Running the Application

### Explaining the Project Structure

- This project contains two main folders:
  - `src`: This folder is the Java Source Path, as in here we will write all our Java Code.
  - `lib`: This folder contains all the libraries that are required to run this project.

- Inside the `src` folder, we have two packages:
  - `jdbc`: this package contains a single file names `IntroToJDBC.java`, which contains simple code to connect to a database using JDBC and also some simple ways to execute queries to fetch and manipulate data in the database.
  - `jdbcdao`: this package contains multiple files that demonstrate the **DAO** `(Data Access Object)` design pattern using `JDBC`. It includes classes for managing **database connections**, performing **CRUD operations**.

### Steps to Run

- Since `src` is the Java Source Path, we will be running the commands to compile and run from one level above it. In this case, it is the root directory of the project.

#### Compiling Code for `jdbc` package

- Compilation Command:

    ```bash
    javac -cp "lib/*" -d out src/jdbc/IntroToJDBC.java
    ```

- Run Command:

    ```bash
    java -cp "lib/*:out" jdbc.IntroToJDBC
    ```

**Explaining the commands and the flags used**:

- `javac`: This is the Java Compiler command used to compile Java source files into bytecode.
- `-cp "lib/*"`: This flag sets the classpath to include all JAR files in the `lib` directory. This is necessary to include the JDBC driver and any other libraries required for the project.
- `-d out`: This flag specifies the output directory for the compiled classes. In this case, the compiled classes will be placed in the `out` directory.
- `java -cp "lib/*:out" jdbc.IntroToJDBC`: This command runs the compiled Java program. The classpath includes both the `lib` directory (for libraries) and the `out` directory (for compiled classes). The main class to be executed is `jdbc.IntroToJDBC`.

#### Compiling Code for `jdbcdao` package

- Compilation Command:

    ```bash
    javac -cp "lib/*" \
    --source-path src \
    -d out \
    src/jdbcdao/IntroToJDBCDAO.java
    ```

- Run Command:

    ```bash
    java -cp "lib/*:out" jdbcdao.IntroToJDBCDAO
    ```

**Explaining the commands and the flags used**:

- `javac`: This is the Java Compiler command used to compile Java source files into bytecode.
- `-cp "lib/*"`: This flag sets the classpath to include all JAR files in the `lib` directory. This is necessary to include the JDBC driver and any other libraries required for the project.
- `--source-path src`: This flag specifies the source path where the Java source files are located. In this case, it is the `src` directory. This is used when files that are being compiled have imports. So when we use this flag, it tells the compiler to look for other source files in the specified source path, in our case, the `src` directory.
- `-d out`: This flag specifies the output directory for the compiled classes. In this case, the compiled classes will be placed in the `out` directory.
- `java -cp "lib/*:out" jdbcdao.IntroToJDBCDAO`: This command runs the compiled Java program. The classpath includes both the `lib` directory (for libraries) and the `out` directory (for compiled classes). The main class to be executed is `jdbcdao.IntroToJDBCDAO`.
