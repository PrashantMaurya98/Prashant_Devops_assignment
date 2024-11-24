pipeline {   
    agent any 
    tools{
        jdk 'jdk17'
        maven 'maven'
    }

    stages {
        stage('Git checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PrashantMaurya98/Prashant_Devops_assignment.git'
            }
        }
        
        stage('Compile') {
            steps {
                sh "mvn compile"
                 }
        }
        
        stage('Package') {
            steps {
                sh "mvn clean package"
                
                 }
        }
        stage('Deploy to Tomcat') {
            steps {
        // Deploy to Tomcat
                sh 'cp target/webapp.war /path/to/tomcat/webapps/'
                 }      
        }
}
