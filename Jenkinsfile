pipeline{
agent any
 stages{
 stage('Build'){
 steps{
 echo 'Building the project....'
 bat 'mvn clean install'
 }
 }
 stage('Start Selenium Grid (Docker)'){
 steps{
 echo 'Starting Selenium Grid containers...'
 bat 'docker compose -f docker-compose.yaml up -d'

 echo 'Waiting for Selenium Grid to be ready...'
 bat 'powershell -NoProfile -ExecutionPolicy Bypass -File scripts\\wait-selenium-grid.ps1'
 }
 }
 stage('Test'){
 steps{
 echo 'Running tests'
 bat 'mvn -Dselenium.remote.url=http://localhost:4444/wd/hub test'
 }
 }
 /* stage('Deploy'){
 steps{
 echo 'Deploying application...'
 bat 'scripts\\deploy.bat'
 }
 } */
}
 post{
   always{
     echo 'Stopping Selenium Grid containers...'
     bat 'docker compose -f docker-compose.yaml down --remove-orphans'
   }
 }
}
