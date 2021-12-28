node {
    def ant
    stage('clone the code') {
        git 'https://github.com/harichinn/ant_proj.git'
        ant = tool 'ant'
    }
    stage('Build the code') {
        withEnv(["ant=$ant"]) {
              sh "$ant/bin/ant" 
        }
    } 
     stage('deploye the code') {
         sh '''
         pwd
         ls -l
         sudo cp /var/lib/jenkins/workspace/ant_pipeline/dist/AntExample.war /var/lib/tomcat8/webapps/
         '''
     }
}
