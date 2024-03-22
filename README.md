# ChatApp & Application de messagerie RMI et gRPC

## ChatApp - Application de messagerie avec sockets

### Prérequis

- Java JDK 8 ou supérieur

### Installation

1. **Cloner le dépôt :**

    ```bash
    git clone https://github.com/sabrinek8/MiniProjet_SysRep.git
    ```

2. **Accéder au répertoire du projet :**

    ```bash
    cd chatapp
    ```

### Déploiement du serveur

1. **Compiler le serveur :**

    ```bash
    javac ChatServer.java
    ```

2. **Démarrer le serveur :**

    ```bash
    java ChatServer
    ```

    Le serveur de chat écoute maintenant sur le port 8081.

### Utilisation du client

1. **Compiler le client :**

    ```bash
    javac ChatClient.java
    ```

2. **Exécuter le client :**

    ```bash
    java ChatClient
    ```

    Suivez les instructions pour rejoindre le salon de discussion et envoyer/recevoir des messages.

## Application de messagerie RMI

### Prérequis

- Java JDK 8 ou supérieur

### Installation

1. **Cloner le dépôt :**

    ```bash
    git clone https://github.com/sabrinek8/MiniProjet_SysRep.git
    ```

2. **Accéder au répertoire du projet :**


### Déploiement du serveur

1. **Compiler le serveur :**

    ```bash
    javac RMIServer.java
    ```

2. **Démarrer le registre RMI :**

    ```bash
    start rmiregistry
    ```

3. **Démarrer le serveur :**

    ```bash
    java RMIServer
    ```

    Le serveur de messagerie est maintenant en cours d'exécution.

### Utilisation du client

1. **Compiler le client :**

    ```bash
    javac RMIClient.java
    ```

2. **Exécuter le client :**

    ```bash
    java RMIClient
    ```

    Suivez les instructions pour envoyer et recevoir des messages.

## Messaging Service avec gRPC

### Prérequis

- Java JDK 8 ou supérieur
- Maven

### Installation

1. **Cloner le dépôt :**

    ```bash
    git clone https://github.com/sabrinek8/MiniProjet_SysRep.git
    ```

2. **Accéder au répertoire du projet :**

    ```bash
    cd messaging-service
    ```

3. **Compiler le projet avec Maven :**

    ```bash
    mvn clean package
    ```

### Déploiement du serveur

1. **Démarrer le serveur :**

    ```bash
    java -jar target/messaging-service.jar
    ```

2. Le serveur de messagerie gRPC écoute maintenant sur le port 50051.

### Utilisation du client

1. **Exécuter le client :**

    ```bash
    java -cp target/messaging-service.jar com.example.grpc.MessagingClient
    ```

2. Suivez les instructions pour envoyer et recevoir des messages.
