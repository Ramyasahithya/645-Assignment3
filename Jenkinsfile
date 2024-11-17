pipeline {
    agent any
    environment {
        IMAGE_TAG = "${env.BUILD_ID}"
        MAVEN_GOALS="clean package"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/Ramyasahithya/645-Assignment3'
            }
        }

        stage('Build Maven Project') {
            steps {
                 script {
                     echo 'Building the Maven project...'
                     sh 'mvn ${MAVEN_GOALS}' // This will execute 'mvn clean package'
                 }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-pass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PSW')]) {
                        sh 'echo $DOCKER_PSW | docker login -u $DOCKER_USER --password-stdin'
                    }
                    image = docker.build("ramya0602/surveyform:${env.IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-pass') {
                        image.push()
                    }
                }
            }
        }

        stage('Update Deployment YAML and Deploy') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kuberntes-id', variable: 'KUBECONFIG')]) {
                        echo "Updating the docker image: ramya0602/surveyform:${env.IMAGE_TAG}"
                        def deploymentExists = sh(script: "kubectl get deployment surveyform-deployment -n default --ignore-not-found", returnStatus: true) == 0

                        if (deploymentExists) {
                             echo "Deployment exists. Updating the image."
                             sh """
                                 kubectl set image deployment/surveyform-deployment form-container=ramya0602/surveyform:${env.IMAGE_TAG} -n default --record
                                 kubectl rollout status deployment/surveyform-deployment -n default
                                """
                        } else {
                             echo "Deployment doesn't exist. Creating a new deployment."
                             sh """
                                 kubectl apply -f deployment.yaml  // Ensure this YAML creates the deployment if it doesn't exist
                                 kubectl rollout status deployment/surveyform-deployment -n default
                                 """
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
