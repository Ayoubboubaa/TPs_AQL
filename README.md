# TPs AQL - Tests Unitaires et Intégration

Ce repository contient les travaux pratiques du cours AQL.

## TP1 - Tests Unitaires avec Couverture de Code
- Analyse et correction de bugs dans des algorithmes classiques (Palindrome, Anagram, etc.).
- Tests de couverture (Ligne, Branche, Condition).

## TP2 - Tests d'Intégration et Mocking
- Utilisation de **Mockito** pour simuler les dépendances.
- Exercices sur les services, contrôleurs et l'interaction avec les DAO.

## TP3 - Tests d'Intégration avec Docker et Testcontainers
- Utilisation de **Testcontainers** pour des tests robustes avec de vrais services.
- **Exercice 1** : Base de données MySQL conteneurisée pour `OrderRepository`.
- **Exercice 2** : Migration d'une application existante (`task-manager`) vers Testcontainers.

## Analyse de l'Exercice 2 (Task Manager)

### Approche originale
Les tests originaux utilisaient des **Mocks** (via Mockito) pour simuler la couche service et des tests unitaires isolés pour les contrôleurs. Bien que rapides, ces tests ne vérifiaient pas l'interaction réelle avec la base de données.

### Limitations identifiées
- **Fidélité** : Les mocks ne permettent pas de détecter des erreurs SQL ou des problèmes de mapping JPA/Hibernate.
- **Différences d'environnement** : L'utilisation de bases in-memory (H2) peut masquer des comportements spécifiques à MySQL (types de données, contraintes).

### Comparaison avec Testcontainers
- **Couverture** : Testcontainers permet de tester l'application de bout en bout avec une vraie base de données.
- **Fiabilité** : On est certain que le code fonctionnera en production car l'environnement de test est identique.
- **Performance** : Les tests avec Testcontainers sont plus lents car ils nécessitent le démarrage de conteneurs Docker.

---

## Structure du Projet
- `tp1/` : Exercices sur la couverture de code.
- `tp2/` : Exercices sur le mocking avec Mockito.
- `tp3/` : Exercices sur l'intégration avec Testcontainers.
