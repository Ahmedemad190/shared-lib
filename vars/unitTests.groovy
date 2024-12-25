#!/usr/bin/env groovy

def call() {
    echo "Running Unit Test..."
        // Use tr command instead of dos2unix
        sh '''
            tr -d '\r' < ./gradlew > ./gradlew.tmp
            mv ./gradlew.tmp ./gradlew
            chmod +x ./gradlew
            ./gradlew clean test
        '''
    
}
