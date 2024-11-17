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
                     sh 'mvn ${MAVEN_GOALS}'
                 }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-pass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PSW')]) {
                        sh 'echo $DOCKER_PSW | docker login -u $DOCKER_USER --password-stdin'
                    }
                    image = docker.build("ramya0602/spring_surveyform:${env.IMAGE_TAG}")
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
                         sh """
                            kubectl apply -f deployment.yaml
                            kubectl set image deployment/student-survey-deployment surveydata-container=ramya0602/spring_surveyform:${env.IMAGE_TAG} -n default --record
                            kubectl rollout status deployment/student-survey-deployment -n default
                         """
                         sh 'kubectl apply -f service.yaml'
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