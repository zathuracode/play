pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            
            environment {
                mvnHOME = tool 'MAVEN_HOME'
            }

            steps {

				sh  "${mvnHOME}/bin/mvn clean package -DskipTests=true"	
            }
        }

		stage ('Run Test') {
            
            environment {
                mvnHOME = tool 'MAVEN_HOME'
            }

            steps {

				sh  "${mvnHOME}/bin/mvn test"	
            }
        }
        
        stage ('Sonar Analysts') {
            
            environment {
                scanerHome = tool 'SONAR_SCANER'
            }

            steps {
            	withSonarQubeEnv('SONAR_LOCAL'){
            		sh  "${scanerHome}/bin/sonar-scanner -e -Dsonar.projectKey=play-backend -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=d4b051dfca4134fa5e660d3bd5e6c249a694f63c -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/src/test/**,**/entity/**,**/dao/**"
            	}					
            }
        }
    }
}