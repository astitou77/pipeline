pipeline {
    agent any

    environment{
	REPO_URL = 'https://github.com/astitou77/pipeline'
	CREDENTIALS_ID = 'Jenkins_ID_2'
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
