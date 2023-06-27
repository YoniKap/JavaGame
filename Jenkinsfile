pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
    }

    stages {
        stage("build") {
            steps {
                echo 'building the application...'
                echo "buildversion = ${NEW_VERSION}"
            }
        }
        stage("test") {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'master'
                }
            }
            steps {
                echo 'testing the application...'
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying the application...'
            }
        }
    }

    post {
        always {
            echo 'verdict:'
        }

        success {
            echo 'build succeeded'
        }

        failure {
            echo 'build failed'
        }
    }
}