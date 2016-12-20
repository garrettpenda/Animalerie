stage "test"
node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'ls target'
		sh 'env'
		sh 'mvn clean verify'
		junit 'target/surefire-reports/*.xml'
	}
}
stage "confirm deployment"

timeout(time:1,unit:'HOURS'){
	input "deploy to production?"
}
stage "deploy"
node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'ls target'
		sh 'env'
		sh 'mvn clean verify'
		junit 'target/surefire-reports/*.xml'
	}
}
