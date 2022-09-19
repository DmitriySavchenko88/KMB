pipeline {
  agent any
  environment {
  COMPOSE_FILE = "docker-compose.yml"
  }
  tools {
  maven "Maven 3.6.3"
  jdk "jdk_11.0.16"
  }

  stages {

    stage('run test') {
      steps {
        sh 'mvn -f Task_7_Cucumber/pom.xml clean test'
      }
    }
  }
  post("Allure report and Turn down docker") {
              always {
                  allure([
                          includeProperties: false,
                          jdk              : '',
                          properties       : [],
                          reportBuildPolicy: 'ALWAYS',
                          results          : [[path: 'Task_7_Cucumber/target/allure-results']]
                  ])
                  step([$class: 'DockerBuilderControl', option: [$class: 'DockerBuilderControlOptionStopAll', remove: true]])
              }
          }
      }