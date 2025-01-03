When creating another module, change its parents according to the template pom.xml</br>

    <parent>
        <groupId>sead.assignment2</groupId>
        <artifactId>backend</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
    
Then add it as a dependency in the main module pom.xml, like this<br/>

    <dependencies>
        <dependency>
            <groupId>sead.assignment2</groupId>
            <artifactId>template</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        ...here
    </dependencies>


Then add it as a module in the project pom.xml like this:

    <modules>
        <module>main</module>
        <module>template</module>
        <module>template2</module>
        ...here
    </modules>


Build:
```
mvn clean install
```

Run (with Docker):
```
docker-compose up --build
```


