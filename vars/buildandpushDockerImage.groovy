#!usr/bin/env groovy
def call(String imageName, String buildNumber) {
    echo "Building Docker image..."
    sh "docker build -t ${imageName}:${buildNumber} ."
}
