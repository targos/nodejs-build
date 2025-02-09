pipeline {
    agent {
        label 'jenkins-workspace'
    }

    stages {
        stage("Setup repository") {
            steps {
                checkout changelog: false, poll: false, scm: scmGit(
                    branches: [[name: "$params.GIT_REMOTE_REF"]],
                    userRemoteConfigs: [[
                        credentialsId: 'github-app-node-js-ci',
                        url: "https://github.com/${params.GITHUB_ORG}/${params.REPO_NAME}.git"
                    ]]
                )
            }
        }

        stage("Test") {
            steps {
                sh "ls"
            }
        }
    }
}
