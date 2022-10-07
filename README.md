# Monolith

## Before you start
1. Create a Docker image of the maven application. Run the script below.
```bash
./mvnw clean spring-boot:build-image
```
2. Tag your builed image. Run the script below
```bash
docker tag monolith:0.0.1-SNAPSHOT arifjo/ht100x-monolith 
```
3. Push the builed image. **Must be logged in** (`docker login`)
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
