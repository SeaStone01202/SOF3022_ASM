# Internet Services Architectures

Project contains examples for Internet Services Architectures classes conducted at the FPT POLYTECHNICH of Technology.

## Requirements

The list of tools required to build and run the project:

* Open JDK 17.x+
* Apache Maven 3.9.x+

## Building

In order to build project use:

```bash
mvn clean package
```

If your default `java` is not from JDK 11 or higher use:

```bash
JAVA_HOME=<path_to_jdk_home> mvn package
```

## Running

In order to run using Open Liberty Application server use:

```bash
java -jar target/'project-name'-SNAPSHOT.jar
```

If your default `java` is not from JDK 17 or higher use:

```bash
<path_to_jdk_home>/bin/java -jar target/'project-name'-SNAPSHOT.jar
```
## Swagger Ui

http://localhost:8080/swagger-ui.html

Project is licensed under the [MIT](LICENSE) license. 

## License

Project is licensed under the [MIT](LICENSE) license.  

## Author

Copyright &copy; 2023, Shop Phone Web
