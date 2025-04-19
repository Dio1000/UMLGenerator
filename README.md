<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- ABOUT THE PROJECT -->
## About The Project
This is a small project that generates UML Class Diagrams in plain text from a structured input format.

It takes a simple text input with class name, attributes, and methods, and turns it into a UML diagram shown in plain text.
Good for quick testing or visualizing class structures without needing drawing tools.

## Features

- Converts structured plain text into UML class diagrams in ASCII format,
- Parses class types (interfaces, abstract, enums), class names, attributes, and methods,
- Interprets visibility levels (e.g., public, private) using numeric codes,
- Outputs a clean and readable UML diagram directly in a chosen file,
- No external libraries or dependencies required.

## Example

-- Input --  
Class:  
TestClass  
  
Attributes:  
name, string, 0  
datatype, string, 0  
  
Methods:  
setName, void, 1  
getName, string, 1  
setDataType, void, 1  
getDataType, string, 1  
  
-- Output --  
```
+-----------------------------+
|          TestClass          |
+-----------------------------+
| -name: string               |
| -datatype: string           |
+-----------------------------+
| +setName: void              |
| +getName: string            |
| +setDataType: void          |
| +getDataType: string        |
+-----------------------------+
|           <Class>           |
+-----------------------------+
```

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java**: This project requires Java to run the UML generator. Ensure that you have Java 8 or higher installed on your system. You can download Java from the [official website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
  
- **JAR File**: Download the `UMLGenerator.jar` file from the project repository or build it yourself by following the instructions in the repository.

- **Text Input File**: The tool expects a structured plain text input file. Ensure your input file follows the correct format, including class names, attributes, and methods.

## Usage

To build the `UMLGenerator.jar` file yourself, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Dio1000/UMLGenerator.git
   cd UMLGenerator
   ```
   
2. **Compile the project**:
   ```
   mvn clean install
   ```
After building, the UMLGenerator.jar file will be available in the ```target/``` directory.
   
To convert structured text into an ASCII UML diagram, run the following command:
<pre> java -jar UMLGenerator.jar parse input_file output_file </pre>

<!-- CONTACT -->

## Contact

Darian Sandru - sandru.darian@gmail.com

Project Link: [https://github.com/Dio1000/UMLGenerator](https://github.com/Dio1000/UMLGenerator)
