pipeline {
  agent {
    kubernetes {
      label 'my-docker'
      idleMinutes 5
      yamlfile 'build-pod.yaml'
      defaultContainer 'docker'
    }
  }
  stages {
    stage('Pull Scanner and Test Image') {
      sh 'echo "Pull Alpine and Trivy from Dockerhub"'
    }
    stage('Scan Test Image') {
      sh 'echo "Scanning Test Image"'
    }
    stage('Show Results and Push to Repo') {
      sh 'echo "Show scan Results"'
    }
  }
}
