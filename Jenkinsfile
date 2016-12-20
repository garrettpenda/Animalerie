node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'ls target'
		sh 'env'
		sh 'mvn verify'
		junit 'target/surefire-reports/*.xml'
	}
}
