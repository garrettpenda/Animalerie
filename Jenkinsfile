node{
	chekout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'ls'
		sh 'env'
		sh 'mvn verify'
	}
}
