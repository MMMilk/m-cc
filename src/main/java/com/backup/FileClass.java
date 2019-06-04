package com.backup;


public class FileClass {

/**
 * server:
 port: 8080
 spring:
 datasource:
 url: jdbc:mysql://localhost:3306/milk
 username: root
 password:
 driver-class-name: com.mysql.jdbc.Driver
 jooq:
 sql-dialect: mysql
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
 <modelVersion>4.0.0</modelVersion>
 <parent>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-parent</artifactId>
 <version>1.5.10.RELEASE</version>
 <relativePath/> <!-- lookup parent from repository -->
 </parent>
 <groupId>com</groupId>
 <artifactId>cc</artifactId>
 <version>0.0.1-SNAPSHOT</version>
 <name>cc</name>
 <description>Demo project for Spring Boot</description>

 <properties>
 <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
 <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
 <java.version>1.8</java.version>
 <maven.compiler.source>1.8</maven.compiler.source>
 <maven.compiler.target>1.8</maven.compiler.target>
 </properties>

 <dependencies>
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-web</artifactId>
 </dependency>

 <dependency>
 <groupId>mysql</groupId>
 <artifactId>mysql-connector-java</artifactId>
 <scope>runtime</scope>
 <version>5.1.41</version>
 </dependency>

 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-test</artifactId>
 <scope>test</scope>
 </dependency>

 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter</artifactId>
 </dependency>

 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-jooq</artifactId>
 </dependency>

 <dependency>
 <groupId>org.jooq</groupId>
 <artifactId>jooq</artifactId>
 <version>3.9.6</version>
 </dependency>
 <dependency>
 <groupId>org.jooq</groupId>
 <artifactId>jooq-meta</artifactId>
 <version>3.9.6</version>
 </dependency>
 <dependency>
 <groupId>org.jooq</groupId>
 <artifactId>jooq-codegen</artifactId>
 <version>3.9.6</version>
 </dependency>

 <dependency>
 <groupId>org.projectlombok</groupId>
 <artifactId>lombok</artifactId>
 <optional>true</optional>
 </dependency>

 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-configuration-processor</artifactId>
 <optional>true</optional>
 </dependency>

 </dependencies>

 <build>
 <resources>
 <resource>
 <directory>${project.basedir}/src/main/java</directory>
 </resource>
 <resource>
 <directory>${project.basedir}/src/main/resources</directory>
 </resource>
 <resource>
 <directory>${project.basedir}/target/generated-sources</directory>
 </resource>
 </resources>

 <plugins>
 <plugin>
 <groupId>org.jooq</groupId>
 <artifactId>jooq-codegen-maven</artifactId>
 <version>3.9.6</version>
 <executions>
 <execution>
 <phase>generate-sources</phase>
 <goals>
 <goal>generate</goal>
 </goals>
 </execution>
 </executions>

 <configuration>
 <jdbc>
 <driver>com.mysql.jdbc.Driver</driver>
 <url>jdbc:mysql://localhost:3306/milk</url>
 <username>root</username>
 <password></password>
 </jdbc>
 <generator>
 <database>
 <name>org.jooq.util.mysql.MySQLDatabase</name>
 <includes>.*</includes>
 <inputSchema>milk</inputSchema>
 </database>
 <generate>
 <pojos>true</pojos>
 <daos>true</daos>
 <records>true</records>
 <springAnnotations>true</springAnnotations>
 <jpaAnnotations>false</jpaAnnotations>
 </generate>
 <target>
 <packageName>com.db</packageName>
 <directory>/target/generated-sources/</directory>
 </target>
 </generator>
 </configuration>
 </plugin>


 </plugins>
 </build>

 </project>

 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */


}