pipeline{
    agent any
        
        stages{
    
            stage("Build"){
                steps{
                    echo("build the project")
                }
            }
            stage("dev"){
                steps{
                    echo("deploying to Dev env")
                }
            }
            stage("QA"){
                steps{
                    echo("deploy to QA")
                }
            }
            stage("Run regression automation TCs"){
                steps{
                    echo("Run regression automation TCs")
                }
            }
            stage("Stage"){
                steps{
                    echo("deploy to Stage")
                }
            }
            stage("Run Sanity automation TCs"){
                steps{
                    echo("Run Sanity automation TCs")
                }
            }
            stage("Prod"){
                steps{
                    echo("deploy to Prod env")
                }
            }
        }
}
 