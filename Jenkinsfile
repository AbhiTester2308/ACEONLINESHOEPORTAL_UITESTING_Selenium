pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Compiling project...'
                bat 'mvn -q -DskipTests compile test-compile'
            }
        }
        stage('Start Selenium Grid (Docker)') {
            steps {
                echo 'Starting Selenium Grid containers...'
                bat 'docker compose -f docker-compose.yaml up -d'
                bat 'powershell -NoProfile -ExecutionPolicy Bypass -File scripts\\wait-selenium-grid.ps1'
            }
        }
        stage('Test') {
            steps {
                echo 'Running smoke tests against Grid...'
                bat 'mvn -q -Dtest=TestRunner -Dcucumber.filter.tags=@smoke -Dselenium.remote.url=http://localhost:4444/wd/hub test'
            }
        }
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/cucumber-html-report/**,target/ExtentReport/**,target/screenshots/**', allowEmptyArchive: true
            bat 'docker compose -f docker-compose.yaml down --remove-orphans'
        }
    }
}
