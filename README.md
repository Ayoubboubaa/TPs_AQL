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
- **Exercice 1** : Base de données MySQL conteneurisée pour `OrderRepository` et API Mockée avec **WireMock**.
- **Exercice 2** : Migration de l'application `task-manager` vers Testcontainers.

---

## Analyse de l'Exercice 2 (Task Manager) - TP3

### 1. Approche originale des tests
Le projet `task-manager` utilisait principalement des **Mocks** (Mockito) avec `MockMvc` en mode `standalone`. L'accès aux données était simulé, évitant ainsi le besoin d'une base de données réelle pendant les tests unitaires.

### 2. Limitations identifiées
- **Fidélité** : Les tests ne vérifient pas si les requêtes SQL générées par Hibernate sont compatibles avec le moteur de base de données cible.
- **Contraintes** : Les contraintes de clé étrangère, d'unicité et les triggers ne sont pas testés avec des mocks.
- **H2 vs MySQL** : Bien que H2 soit utile, il possède des types de données et des fonctions différents de MySQL, ce qui peut mener à des "faux positifs" (tests qui passent sur H2 mais échouent en prod).

### 3. Comparaison (Tests originaux vs Testcontainers)
| Critère | Tests avec Mocks | Tests avec Testcontainers |
| :--- | :--- | :--- |
| **Couverture** | Partielle (logique métier uniquement) | Complète (de la route HTTP à la DB) |
| **Lisibilité** | Simple, mais beaucoup de "boilerplate" de setup de mocks | Très lisible, approche "boîte noire" |
| **Maintenabilité** | Difficile (nécessite de mettre à jour les mocks si le service change) | Facile (le test dépend du comportement, pas de l'implémentation) |
| **Fiabilité** | Moyenne (dépend de la précision des mocks) | Très haute (environnement identique à la prod) |

### 4. Avantages et Inconvénients de Testcontainers
**Avantages :**
- **Isolation totale** : Chaque test démarre dans un environnement propre.
- **Reproductibilité** : Élimine le problème du "ça marche sur ma machine".
- **Intégration réelle** : Teste les interactions avec de vrais services (DB, Redis, API).

**Inconvénients :**
- **Lenteur** : Temps de démarrage des conteneurs non négligeable.
- **Ressources** : Nécessite Docker et consomme plus de CPU/RAM.

---

## Structure du Projet
- `tp1/` : Exercices sur la couverture de code.
- `tp2/` : Exercices sur le mocking avec Mockito.
- `tp3/` : Exercices sur l'intégration avec Testcontainers.
