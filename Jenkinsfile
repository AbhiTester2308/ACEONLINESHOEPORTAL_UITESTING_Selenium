pipeline{
agent any
 stages{
 stage('Build'){
 steps{
 echo 'Building the project....'
 bat 'mvn clean install'
 }
 }
 stage('Test'){
 steps{
 echo 'Running tests'
 bat 'mvn test'
 }
 }
 /* stage('Deploy'){
 steps{
 echo 'Deploying application...'
 bat 'scripts\\deploy.bat'
 }
 } */
}
}
