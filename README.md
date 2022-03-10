# Datenbanken_II

Mein kleines feines Repository zu Datenbankn II

## Setup 

### Datenbank aufsetzen 

1. Install Docker (https://docs.docker.com/get-docker/)
2. Terminal:
  - docker pull mysql
  - docker run --name mysql_db -p3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

### Intellij aufsetzen 

1. Install Intellij (https://www.jetbrains.com/de-de/idea/download/#section=windows)

### Projekt aufsetzen 

1. New Projekt 
2. Maven
3. Select Project SDK : Download SDK

  ![image](https://user-images.githubusercontent.com/88632681/156148075-23e628e7-cf0d-4f93-964b-3fcaf290ef46.png)
  
  ![image](https://user-images.githubusercontent.com/88632681/156148206-5d52746c-a4af-4771-8a6e-96d526c8b545.png)
  
  Download
4. Select Name and Location
5. Finish 

### Maven aufsetzen 

1. pom.xml anpassen 

```
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.25</version>
    </dependency>
</dependencies>
```
hinzufügen 

![image](https://user-images.githubusercontent.com/88632681/156148801-b4f3cd38-bd74-4510-8038-3aefb521d35c.png)


### Datenbank aufsetzen 

1. Download mysql workbench (https://dev.mysql.com/downloads/workbench/)
2. Safe the sql script from moodle to a example.sql file
3. Follow this [Guide](https://www.tutorialspoint.com/how-to-run-sql-script-in-mysql#:~:text=To%20run%20SQL%20script%20in%20MySQL%2C%20use%20the%20MySQL%20workbench,need%20to%20open%20MySQL%20workbench.&text=Now%2C%20File%20%2D%3E%20Open%20SQL,to%20open%20the%20SQL%20script.&text=Note%20%E2%88%92%20Press%20OK%20button%20twice%20to%20connect%20with%20MySQL.)

### Copy Code (if you want)

1. copy Folder com.company 
2. paste Folder com.company
