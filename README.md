## TP Hibernate – Gestion des Salles et Machines


**Objectif du TP**

Ce TP a pour but de développer une application Java utilisant Hibernate pour gérer la persistance des objets dans une base de données MySQL.
L’application manipule deux entités principales : Salle et Machine, liées par une relation One-To-Many.

## Structure du projet


```text
src/
 ├── main/
 │   ├── java/com/example/
 │   │       ├── dao
 │   │       ├── entities
 │   │       ├── services
 │   │       ├── test
 │   │       └── util
 │   └── resources/hibernate.cfg.xml
 └── test/java/com/example/tests
```

## Étapes du TP


### 1️. Configuration Maven

- Ajout des dépendances nécessaires :

- Hibernate Core

- MySQL Connector

- JPA API

- JUnit (tests)

### 2️. Création de l’interface DAO

- Définition d’une interface générique pour les opérations CRUD :

- create

- findById

- update

- delete

- findAll

### 3️. Création des entités JPA

**Deux entités :**

**- Salle**

- Identifiant auto-généré

- Code de la salle

- Liste des machines associées

**- Machine**

- Identifiant auto-généré

- Référence

- Date d’achat

- Salle associée

- Requêtes nommées (@NamedQuery, @NamedNativeQuery)

### 4️. Configuration Hibernate (hibernate.cfg.xml)

**Le fichier de configuration contient :**

- URL de la base MySQL

- Identifiant et mot de passe

- Dialecte Hibernate

- Option hbm2ddl.auto=update

- Mapping des entités

### 5️. Classe utilitaire Hibernate

**Création d'une classe HibernateUtil permettant :**

- de construire une unique SessionFactory

- de gérer la connexion Hibernate

- de fermer proprement la session

### 6. Création des services

Deux services implémentant l’interface DAO :

SalleService

MachineService

Ils contiennent :

les méthodes CRUD

les transactions Hibernate

une méthode supplémentaire : findBetweenDate (Machine)

### 7️. Classe Test (Main)

**Une classe main() permettant :**

d’insérer des salles

d’insérer des machines

d’afficher salles et machines

de tester la recherche entre deux dates

Cette classe permet de vérifier que la configuration Hibernate fonctionne correctement.

### 8️. Tests unitaires JUnit

**Deux classes de test :**

- SalleServiceTest

- MachineServiceTest

**Elles permettent de valider :**

- create

- findById

- update

- delete

- findAll

- findBetweenDate (Machine)

**Chaque test utilise :**

- @Before pour insérer des objets de test

- @After pour nettoyer la base après test


# Tests Machine
MachineServiceTest
