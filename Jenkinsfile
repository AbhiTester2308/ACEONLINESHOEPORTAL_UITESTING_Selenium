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
 bat """
 powershell -NoProfile -Command ^
  "$u='http://localhost:4444/status'; ^
   for($i=0;$i -lt 60;$i++){ ^
     try{ ^
       $r=Invoke-RestMethod -TimeoutSec 2 $u; ^
       if($r.value.ready -eq $true){ exit 0 } ^
     } catch{} ^
     Start-Sleep -Seconds 2 ^
   } ^
   Write-Host 'Selenium Grid not ready in time'; ^
   exit 1"
 """
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
