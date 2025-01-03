When creating another module, change its parents according to the template in pom.xml</br>
Then add it as a dependency in the main module pom.xml, like this<br/>

    <parent>
        <groupId>sead.assignment2</groupId>
        <artifactId>backend</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

Then add its execution in the build process for installing the jar file as a dependency in the main module pom.xml, like this:</br>

    <execution>
        <id>install-template2</id>
        <goals>
            <goal>install-file</goal>
        </goals>
        <configuration>
            <groupId>sead.assignment2</groupId>
            <artifactId>template2</artifactId>
            <version>1.0</version>
            <packaging>jar</packaging>
            <file>../template2/target/template2-0.0.1-SNAPSHOT.jar</file>
            <generatePom>true</generatePom>
        </configuration>
    </execution>

Build:
```
mvn clean packages -DskipTests
```

Run (with Docker):
```
docker-compose up --build
```


