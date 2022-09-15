pipeline {
    agent any
    environment {
        MVN_GOAL = 'clean verify'
        M2_HOME = '/usr/share/maven'
        X_SCREEN = '1920x1080x16'
    }
    stages {
        stage('Execute tests') {
            steps {
              script{allure includeProperties: false,
              jdk: '',
              results: [[path: 'target/allure-results']]}
                }
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                    reportName           : 'Report',
                    reportDir            : 'target/site/serenity',
                    reportFiles          : 'index.html',
                    keepAll              : true,
                    alwaysLinkToLastBuild: true,
                    allowMissing         : false
            ])
        }
    }
}