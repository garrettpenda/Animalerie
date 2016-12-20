node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'ls target'
		sh 'env'
		sh 'mvn clean verify'
		junit 'target/surefire-reports/*.xml'
	}
}
