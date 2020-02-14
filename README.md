# INVENTORY MANAGEMENT SYSTEM Chris Rea

This is a simple program which allows you to create, read, update, and delete users, items and orders from a remote database.

## Description

This project is an inventory management system using GCP to host an SQL database,
which has CRUD functionality built into classes and methods within Java Eclipse.
This was uploaded to the GitHub remote repository. The methods were then tested using Mockito and JUnit. 
Automation was achieved through the use of the Jenkins CI-server to check for changes to the master branch on GitHub,
and pass that through to SonarQube, which tested the code for bugs and other code smells.
When the quality gates on SonarQube were achieved, a snapshot of the code is pushed to the Nexus remote repository.


Test coverage is currently at 52% according to SonarQube. This includes Mockito testing, as well as Integration testing.

## Getting Started

### Dependencies

*This software is best run on Windows 10, though could in theory be run on any OS.

*A java client is needed to use the software. This was built with [Eclipse](https://www.eclipse.org/downloads/packages/), but in theory any should work.

*An SQL server is needed for the database to run. The syntax used in this build is for [MySQL](https://dev.mysql.com/downloads/workbench/).

*[Maven](https://maven.apache.org/download.cgi) will need to be installed, either on a remote machine or on your local machine.

*A [Jenkins](https://jenkins.io/download/) CI server needs to be utilised for the automatic building of .jar files.

*The software will run through [SonarQube](https://www.sonarqube.org/downloads/) for testing purposes.

*The software will deploy to [Nexus](https://www.sonatype.com/download-nexus-repository-trial?hsCtaTracking=387944e4-949c-403c-a489-bd67e7c31a2a%7Ca59637d2-4904-4eb5-9a0b-5d380c65bf51).

*You will also need to deploy maven and java to your local development environment. Instructions for maven can be found [here](https://tutorials.visualstudio.com/Java/hello-world/install-maven), whilst instructions for Java can be found [here](https://www.javatpoint.com/how-to-set-path-in-java).

### Installing

To install this program, start by pulling the source folder and the pom.xml file from my Github. You will then need to change the
SonarQube, Nexus and Jenkins ip address to your own ones.

### Deploying

To use this in an industrial environment, it is recommended to use either a local hosted database, or a cloud hosted database.
Currently, the url has been hardcoded in, but can be changed easily in the Utils.config class to access any other address.

### Executing program

*Once the installation is finished, press Ctrl+F11 to run the program.

*Enter in the commands that appear in the console to interact with the database. 

*You will first have a choice of selecting which table you wish to edit, and then which function you wish to run.

*Once this choice has been made, follow the onscreen commands to make your changes.

### Walkthrough
If I wanted to add a new customer to the database, I would first press Ctrl+F11 to run the software.
I would then enter in the word "customer" to tell the software to interact with the customer, and
the word "create" to tell the software that I wish to create a new entry.

Once I have done this, I would type in the first name of the new customer, followed by the last name.
The database would then automatically generate a unique ID for this customer, and add his or her details to the database.

## Software Build

If you wish to build your own .jar files from this software, you will need to run a build tool first.
Using the maven program you have already installed, you need to run the command 
```
mvn test
```

This will run a series of tests to ensure that your code not only compiles, but is adequately tested.

The easiest way to do this is to use Jenkins, or a similar CI Server. When creating a new Jenkins project,
ensure that your Github repository is set in the configuration stage, and include 'mvn test' in the Build Execute Shell.

Underneath, you should include a reference to your SonarQube, which will test your code for bugs, vulnerabilities and
general mess. As of this build, the software is of a good quality, though any further changes made by the user
will need to be verified by the software. To achieve all this, simply add the following underneath:
```
mvn sonar:sonar -Dsonar.host.url=<your sonarqube url> -Dsonar.login=<your SonarQube login> -Dsonar.password=<your SonarQube password>  
```
This will allow you to investigate anything that is flagged up by SonarQube.

Lastly, you should run the command
```
mvn deploy
```

This will deploy the new .jar file to your Nexus repository, which you will have defined in your pom.xml during the installation.


## Help

This is a Beta build of the final project, and as such the create and update functionalities do not work
for orders. Whilst snapshots exist of the proof-of-concept builds, they are not stable enough to push through to Github.

## Authors

Contributors names and contact info

Chris Rea
ChristopherRea@academytrainee.com

## Version History

* 0.1
    * Initial Release

## Acknowledgments

Chris, Rhys, and the whole trainer team at QA, who have been invaluable in their assistance, dedication and generosity.
Raf, Sam, Juamal and Tyler, who have 
Elliott Dorrington - Large contributions to the Risk Assessment.
