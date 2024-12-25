#!usr/bin/env groovy
def call() {
	echo "checking Git Repo..."
	git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/Ahmedemad190/MultiCloudDevOpsProject.git'	
}
