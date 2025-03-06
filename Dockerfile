# Use a base image with Java installed
FROM openjdk:20-jdk

# Make a directory for our project
RUN mkdir -p /home/EcommApp

# Copy the JAR file from our host into the container
COPY target/EcommApp-0.0.1-SNAPSHOT.jar /home/EcommApp

# Set the working directory
WORKDIR /home/EcommApp

# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "EcommApp-0.0.1-SNAPSHOT.jar"]