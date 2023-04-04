# 776_Backend
Instruction to get the code running
1. git clone url
2. Ensure the path to  JAVA_HOME(Java version 11) and MAVEN_HOME are set
3. Open the project in Eclipse as "Existing maven projects"
4. Browse to the folder with pom.xml in terminal, run the following commands

    mvn clean install
5. This will create jar in the target folder : quality-0.0.1-SNAPSHOT.jar , run the following command to start the server

  java -jar quality-0.0.1-SNAPSHOT.jar 
