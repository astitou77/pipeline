pipeline {
    agent any

    stages {
        
        stage('Pull code from Github') {
            steps {
                echo 'Hello World'
            }
        }
        
        stage('Build Maven *.war file') {
            steps {
                echo 'Hello World'
            }
        }
        
        stage('Deploy *.war to app server') {
            steps {
                echo 'Hello World'
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
