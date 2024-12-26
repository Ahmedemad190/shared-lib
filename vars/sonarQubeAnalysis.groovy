#!/usr/bin/env groovy
def call() {
    echo "Running SonarQube Analysis..."
    
    dir('application') {
        // First ensure gradlew is executable
        sh 'chmod +x ./gradlew'
        
        // Clean and build first to ensure we have compiled classes
        sh './gradlew clean build'
        
        withSonarQubeEnv(credentialsId: 'sonar-token', installationName: 'sonarqube-server') {
            sh """
                ./gradlew sonar \
                    -Dsonar.projectKey=ivolve-proj \
                    -Dsonar.projectName=ivolve-proj \
                    -Dsonar.java.source=11
            """
        }
    }
}
