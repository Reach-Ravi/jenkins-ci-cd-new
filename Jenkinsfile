pipeline {
    agent any
    tools {
    maven "maven"
    }
    stages {
    stage('SCM Checkout') {
    steps {
    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Reach-Ravi/jenkins-ci-cd-new.git']])
}

}
    stage('Build process') {
    steps {
        script {
            bat 'mvn clean install'
     }
    }
}
    stage('build image') {
    steps {
    script {
        bat 'docker build -t coolravi/springcicdnew:1.0 .'
}
}


}

}

}