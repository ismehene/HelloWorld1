node {
	   environment {
	     PATH = 'C:\\Program Files\\Git\\bin\\git.exe'
	   stage('SCM Checkout'){
	     git 'https://github.com/ismehene/HelloWorld1'
	   }
           agent any triggers { pollSCM('* * * * *') }
	   stage('Compile-Package'){
	      //Get maven home path
	      def mvnHome = tool name: 'C:\\Program Files\\apache-maven-3.6.0', type: 'maven'
	      bat "${mvnHome}/bin/mvn package"
	   }post { success { echo 'Now Archiving...' archiveArtifacts artifacts : '**/target/*.war'
  }
		 }
	   stage('Email Notification'){
              mail bcc: '', body: '''Hi Welcome to jenkins email alerts
              Thanks
              ismehene''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'ismehene.chaouch@gmail.com'
          }
	   } }
           stage ('Deployments_test'){ steps { sh "cp **/target/*.war C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5_Tomcat84\\tomcat-test\\webapps"
	 } } 
           stage ('Deployments_Prod'){ steps { 
              timeout(time :3, unit :'DAYS'){ input message :'Approve PRODUCTION Deployment?' }
	             sh "cp **/target/*.war C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5_Tomcat84\\helloWorld\\webapps" } }
           } 
           stage('Email Notification'){
              mail bcc: '', body: '''Hi You build successfully deployed
              Thanks
              ismehene''', cc: '', from: '', replyTo: '', subject: 'Success', to: 'ismehene.chaouch@gmail.com'
           }
           stage ('Selenium test'){ 
		   steps { 
			   bat "${mvnHome}/bin/mvn test" 
			   sh'Java -cp bin;lib/* org.testng.TestNG testng.xml' } 

           stage('Compile-Package && SonarQube analysis'){ 
		   steps {
			   withSonarQubeEnv('sonar-6'){ 
				   sh "${mvnHome}\\bin\\mvn clean package sonar :sonar" } 
		   } post { success { echo 'Now Archiving...' archiveArtifacts artifacts : '**/target/*.war' } } }
           
           stage('Email Notification'){
              mail bcc: '', body: '''Hi Welcome to jenkins email alerts
              Thanks
              ismehene''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'ismehene.chaouch@gmail.com'
           }
          

