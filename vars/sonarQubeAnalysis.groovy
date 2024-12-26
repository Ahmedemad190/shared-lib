#!/usr/bin/env groovy
def call() {
    echo "Running SonarQube Analysis..."
    
    // Debug: List contents of workspace
    sh 'pwd'
    sh 'ls -la'
    
    // If gradlew is in root directory instead of /application
    // dir('application') {
        // Debug: List contents of application directory
        // sh 'ls -la'
        
        withSonarQubeEnv(credentialsId: 'sonar-token', installationName: 'sonarqube-server') {
            sh """
                ./gradlew sonar \
                    -Dsonar.projectKey=ivolve-2 \
                    -Dsonar.projectName=ivolve-2 \
                    -Dsonar.java.source=11
            """
        }
    // }
}
