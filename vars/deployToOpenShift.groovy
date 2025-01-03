#!/usr/bin/env groovy

//OpenShiftCredentialsID can be credentials of service account token or KubeConfig file 
def call(String OpenShiftCredentialsID, String openshiftClusterurl, String openshiftProject, String imageName, String BUILD_NUMBER) {
    
    // login to OpenShift Cluster via cluster url & service account token
    withCredentials([string(credentialsId: "${OpenShiftCredentialsID}", variable: 'OpenShift_CREDENTIALS')]) {
            sh "oc login --server=${openshiftClusterurl} --token=${OpenShift_CREDENTIALS} --insecure-skip-tls-verify"
            sh "oc apply -f /var/jenkins_home/workspace/last/deployment.yml"
            sh "oc apply -f /var/jenkins_home/workspace/last/service.yml"
            sh "oc expose svc ivolve-project-service"
    }

}
