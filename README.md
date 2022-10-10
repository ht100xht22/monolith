# Monolith

## Before you start
1. Create a Docker image of the maven application. Run the script below.
```bash
./mvnw clean spring-boot:build-image -Dspring-boot.build-image.imageName=ht100x/monolith
```
2. Tag your builed image. Run the script below
```bash
docker tag monolith:0.0.1-SNAPSHOT arifjo/ht100x-monolith 
```
4. (OPTIONAL) Push the build image. **Must be logged in** (`docker login`)
```bash
docker push arifjo/ht100x-monolith
```

## Kubernetes with MiniKube
1. Install minikube localy.
2. Start minikube.
```bash
minikube start
```
3. Create a deployment of your docker image.
```bash
kubectl create deployment monolith --image=arifjo/ht100x-monolith
```
4. Start tunnel with minikube on a seperate terminal. Wait for password.
```bash
minikube tunnel
```
5. Expose the deployment service.
```bash
kubectl expose deployment monolith --name=monolith-service --port=8080 --target-port=8080 --type=LoadBalancer
```
6. Get the external ip and browse to `<external-ip>/hello`


## Kubernetes with KIND (Kubernetes-in-Docker)
1. Install KIND.
2. Start a KIND cluster.
```bash
kind create cluster
```
3. Push the build image to KIND.
```bash
kind load docker-image ht100x/monolith
```
4. Create a deployment of your docker image.
```bash
kubectl create deployment monolith --image=ht100x/monolith --dry-run=client -o=yaml > deployment.yaml
```
5. Edit the deployment file, go spec -> template -> spec -> containers -> image. Add `imagePullPolicy: Never` under the name. Have the same identation as the lines before.
```yaml
imagePullPolicy: Never
```
6. Apply the deployment
```bash
kubectl apply -f deployment.yaml
```
7. Expose the deployment service.
```bash
kubectl expose deployment monolith --name=monolith-service --port=8080 --target-port=8080 --type=NodePort
```
8. Find the Internal IP
```bash
kubectl get nodes -o wide
```
9. Find the PORT.
```bash
kubectl get service monolith-service
```
10. Broswe to `<internal-ip>:<external-port>`
