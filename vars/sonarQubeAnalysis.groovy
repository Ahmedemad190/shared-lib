#!/usr/bin/env groovy
def call() {
    echo "Running SonarQube Analysis..."
    
    dir('application') {
        // First ensure gradlew is executable
        sh 'chmod +x ./gradlew'
        
        withSonarQubeEnv(credentialsId: 'sonar-token', installationName: 'sonarqube-server') {
            // Use gradlew with explicit Java options
            sh """
                ./gradlew sonar \
                    -Dsonar.projectKey=ivolve-proj \
                    -Dsonar.projectName=ivolve-proj \
                    -Dsonar.sourceEncoding=UTF-8 \
                    -Dsonar.sources=src/main \
                    -Dsonar.tests=src/test \
                    -Dsonar.java.binaries=build/classes \
                    -Dsonar.gradle.skipCompile=false
            """
        }
        
        // Optional: Wait for quality gate
        timeout(time: 1, unit: 'HOURS') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }
}
