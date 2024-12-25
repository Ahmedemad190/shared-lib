def call() {
    echo "Running Unit Test..."
    sh 'chmod +x ./gradlew'  // Add this line to make gradlew executable
    sh './gradlew clean test'
}
