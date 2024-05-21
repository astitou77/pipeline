pipeline {
    agent any

    environment{
	REPO_URL = 'https://github.com/astitou77/pipeline'
	CREDENTIALS_ID = 'Jenkins_ID_2'
	WAR_FILE = 'target/HelloWorld.war'
   }


    stages {
        
        stage('Clone repo from Github') {
            steps {
                git branch: 'main', url: "${REPO_URL}", credentialsId: "$CREDENTIALS_ID"
            }
        }

	stage('Build Maven App') {
		steps {
			sh 'mvn clean package'
		}	
	}

	stage('Deploy to remote Server'){
		steps {
			sh 'ssh astitou@172.16.25.133 "/home/astitou/Desktop/apache-tomcat-9.0.89/bin/shutdown.sh"'
			sh 'scp ${WAR_FILE} astitou@172.16.25.133:/home/astitou/Desktop/apache-tomcat-9.0.89/webapps"'
			sh 'ssh astitou@172.16.25.133 "/home/astitou/Desktop/apache-tomcat-9.0.89/bin/startup.sh"'
			echo 'deploying app...'
		}
	}
        
    }
    
    post('Build Maven *.war file') {
        success {
            echo 'The Build was Successfull !!!'
        }
        failure{
            echo 'The Build failed...'
        }
    }
    
    
}
