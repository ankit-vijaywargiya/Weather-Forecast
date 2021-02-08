pipeline{
	agent any
	tools{
		jdk 'jdk 1.8'
		maven 'maven-3.6.3'
	}
	stages{
		stage("Build"){
			steps{
				sh "mvn -version"
				sh "mvn clean install"
			}
		}
	}
}