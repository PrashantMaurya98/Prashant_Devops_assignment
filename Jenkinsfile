pipeline {   
    agent any 
    tools{
        jdk 'jdk17'
        maven 'maven'
    }
    environment {
        SCANNER_HOME = tool 'sonar-scanner'
    }

    stages {
        stage('Git checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PrashantMaurya98/Prashant_Devops_assignment.git'
            }
        }
        
        stage('Compile') {
            steps {
                sh "mvn clean compile"
                 }
        }
        stage('Sonarqube Analysis') {
            steps {
               sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.url=http://3.19.74.188:9000/ -Dsonar.login=squ_0dbe68dbee1fb33ebf9d46975a892aee5d414927 -Dsonar.projectName=PrashantApp \
                    -Dsonar.java.binaries=. \
                    -Dsonar.projectKey=PrashantApp '''
            }
        }
        
        stage('Package') {
            steps {
                sh "mvn clean package"                
                 }
        }
        stage('OWASP Dependency Check') {
            steps {
                dependencyCheck additionalArguments: '--scan target/', odcInstallation: 'owasp'
            }
        }
        stage('Publish OWASP Dependency Check Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'dependency-check-report.html',
                    reportName: 'OWASP Dependency Check Report'
                ])
            }
        }
        stage('Deploy to Tomcat') {
            steps {
        // Deploy to Tomcat
                sh 'sudo cp target/PrashantApp.war /opt/apache-tomcat-11.0.0-M25/webapps/'
                 }      
        }
    }
}
