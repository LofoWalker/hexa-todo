# Projet : Application de gestion de tâches (To-Do List)

**Objectif** : Créer une API REST avec Quarkus pour gérer une liste de tâches. Cette API permettra d’ajouter, de modifier, de supprimer et de lister des tâches pour différents utilisateurs authentifiés.

---

## Spécifications

### 1. Fonctionnalités principales

1. **CRUD des tâches** :
    - **Créer une tâche** : Permet de créer une nouvelle tâche avec un titre, une description, une date d'échéance, et un statut (ex : "à faire", "en cours", "terminée").
    - **Lire les tâches** : Permet de lister toutes les tâches d'un utilisateur ou d’afficher les détails d’une tâche spécifique.
    - **Mettre à jour une tâche** : Permet de modifier une tâche (changement de titre, description, date d’échéance, ou statut).
    - **Supprimer une tâche** : Permet de supprimer une tâche de la liste.

2. **Gestion des utilisateurs** :
    - **Authentification** : Utiliser JWT pour authentifier les utilisateurs.
    - **Rôles utilisateur** : Chaque utilisateur a un rôle (par exemple, "user" ou "admin").
    - **Accès restreint** : Les tâches sont visibles uniquement pour le propriétaire (l’utilisateur authentifié). Seul un utilisateur "admin" peut voir et gérer toutes les tâches.

### 2. Structure des entités et modèles de données

1. **Entité User** :
    - `id` : Identifiant unique de l'utilisateur.
    - `username` : Nom d'utilisateur.
    - `password` : Mot de passe chiffré.
    - `role` : Rôle de l'utilisateur (ex : "user" ou "admin").

2. **Entité Task** :
    - `id` : Identifiant unique de la tâche.
    - `title` : Titre de la tâche (obligatoire).
    - `description` : Description de la tâche (optionnelle).
    - `dueDate` : Date d'échéance (optionnelle).
    - `status` : Statut de la tâche (`"à faire"`, `"en cours"`, `"terminée"`).
    - `userId` : L'identifiant de l'utilisateur propriétaire de la tâche (lien vers l’entité `User`).

### 3. Endpoints de l’API

Voici les endpoints à créer pour l’API REST :

1. **Gestion des utilisateurs** :
    - `POST /users/register` : Créer un nouvel utilisateur.
    - `POST /users/login` : Authentifier l'utilisateur et générer un token JWT.

2. **Gestion des tâches** :
    - `POST /tasks` : Créer une nouvelle tâche (seulement pour l’utilisateur connecté).
    - `GET /tasks` : Lister toutes les tâches de l’utilisateur (ou toutes si l’utilisateur est un admin).
    - `GET /tasks/{id}` : Afficher les détails d'une tâche spécifique (si elle appartient à l’utilisateur ou si l’utilisateur est admin).
    - `PUT /tasks/{id}` : Mettre à jour une tâche (seulement pour le propriétaire ou un admin).
    - `DELETE /tasks/{id}` : Supprimer une tâche (seulement pour le propriétaire ou un admin).

---

## 4. Sécurité

1. **Authentification avec JWT** :
    - Ajouter l’extension `quarkus-smallrye-jwt` pour gérer les tokens JWT.
    - Protéger les endpoints pour qu’ils soient accessibles uniquement par les utilisateurs authentifiés.
    - `@RolesAllowed("user")` pour restreindre certains endpoints aux utilisateurs, et `@RolesAllowed("admin")` pour donner des privilèges aux administrateurs.

2. **Autorisation par rôle** :
    - Les utilisateurs peuvent gérer uniquement leurs propres tâches, sauf s'ils sont admin (dans ce cas, ils peuvent voir et modifier toutes les tâches).

---

## 5. Tests

1. **Tests Unitaires** :
    - Créer des tests pour la logique métier, comme la création et la mise à jour des tâches.
    - Vérifier que les règles de validation des tâches (titre obligatoire, statut valide, etc.) sont bien respectées.

2. **Tests d’intégration avec RESTAssured** :
    - Vérifier chaque endpoint (authentification, création, lecture, mise à jour, suppression).
    - Tester les accès restreints et les rôles avec des utilisateurs différents pour valider la sécurité.

3. **Tests en mode natif** (optionnel) :
    - Exécuter les tests en mode natif pour vérifier que tout fonctionne correctement après la compilation native.

---

## 6. Stack technique et extensions nécessaires

1. **Extensions Quarkus** :
    - `quarkus-resteasy` : Pour créer les endpoints REST.
    - `quarkus-hibernate-orm-panache` : Pour gérer la persistance avec Panache.
    - `quarkus-jdbc-postgresql` : Pour la base de données PostgreSQL (ou `h2` en mémoire pour les tests).
    - `quarkus-smallrye-jwt` : Pour la sécurité avec JWT.

2. **Base de données** :
    - Utiliser PostgreSQL pour la persistance en local, ou H2 pour un démarrage rapide.

3. **Environnement de tests** :
    - `JUnit` pour les tests unitaires et d'intégration.
    - `RESTAssured` pour tester les endpoints REST.

---

## 7. Récapitulatif des étapes de développement

1. **Configurer le projet** :
    - Créer le projet avec Gradle et ajouter les extensions nécessaires.
    - Configurer la connexion à la base de données dans `application.properties`.

2. **Développer les entités et services** :
    - Créer les entités `User` et `Task` avec Panache.
    - Implémenter les services pour gérer la logique métier (ex: `UserService`, `TaskService`).

3. **Créer les endpoints REST** :
    - Développer les endpoints pour gérer les tâches et l’authentification.
    - Appliquer les annotations de sécurité (`@RolesAllowed`, `@PermitAll`).

4. **Tester l’application** :
    - Écrire des tests unitaires et d'intégration.
    - Exécuter les tests en mode natif pour valider le comportement en production.

---

## Objectif final

À la fin de cet exercice, tu auras une API complète pour gérer des tâches, avec authentification et autorisation, et une couverture de tests solide. Ce projet te servira de base pour te familiariser avec Quarkus et ses principales fonctionnalités de développement d’API REST.

