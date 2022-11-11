
node {

   stage 'checkout'
   git url: 'https://github.com/serhatozdursun/test.casumo.git'
   sh 'git clean -fdx; sleep 4;'

   def mvnHome = tool 'mvn'

   stage 'build'
   // set the version of the build artifact to the Jenkins BUILD_NUMBER so you can
   // map artifacts to Jenkins builds
   sh "${mvnHome}/bin/mvn versions:set -DnewVersion=${env.BUILD_NUMBER}"

   stage 'test'
   parallel 'test': {
     sh "${mvnHome}/bin/mvn test; sleep 2;"
   }, 'verify': {
     sh "${mvnHome}/bin/mvn verify; sleep 3"
   }

   stage 'archive'
   archive 'target/*.jar'
}
