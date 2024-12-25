#!usr/bin/env groovy
def call() {
	echo "checking Git Repo..."
	git branch: 'main', credentialsId: 'GitHub', url: 'https://github.com/Ahmedemad190/MultiCloudDevOpsProject.git'	
}
