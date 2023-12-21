- - -
# Run

* Download Base Image
```
docker pull openjdk:17 
```
* Build Image: run these commands in base of project to create the image 
```
mvn clean package
docker build -t nisum-user:0.0.1-SNAPSHOT .
```
* Run container
```
docker run -p 8080:8080 nisum-user:0.0.1-SNAPSHOT
```

![By docker](https://raw.githubusercontent.com/lionelgt/nisum-user/main/docs/images/run-by-docker-container.png)

![By IDE](https://raw.githubusercontent.com/lionelgt/nisum-user/main/docs/images/run-by-ide.png)


- - -
