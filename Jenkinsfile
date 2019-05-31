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
	  
	   } }
          
