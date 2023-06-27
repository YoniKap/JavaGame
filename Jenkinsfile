pipeline {
    agent any
    enviorment{
        NEW_VERSION = '1.3.0'
       
    }

    stages{
         
        stage("build"){
            steps{
                echo 'building the application...'
                echo "buildversion = ${new_VERSION}"
            }
        }
        stage("test"){
            when{
                expression{
                    env.BRANCH_NAME == 'main' || 'master'
                }
            }
            steps{
                echo 'testing the application...'
            }
        }
        stage("deploy"){
          steps{
            echo 'deploying the applicatiion...'
          }
        }

        post{
            always{
                echo 'verdict:' 
            }

            success{
                echo 'build sucesseded'               
            }

            failure{
                echo 'build failed'
            }
        }



    }
    
}