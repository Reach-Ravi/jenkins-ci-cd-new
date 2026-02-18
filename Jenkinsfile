pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Reach-Ravi/jenkins-ci-cd-new.git']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t coolravi/devops-integration:1.0 .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-token', variable: 'DOCKER_TOKEN')]) {
                       bat '''
                           if "%DOCKER_TOKEN%"=="" (
                               echo TOKEN IS EMPTY
                           ) else (
                               echo TOKEN RECEIVED
                           )
                       '''
                   bat 'docker login -u coolravi --password-stdin'
                   bat 'docker push coolravi/devops-integration:1.0'
                }
            }
        }
        /*stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        }*/
    }
    }
}