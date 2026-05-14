# TP2 - Tests d'Intégration et Mocking

**Auteur : KELAIAIA AYOUB**  
**Spécialité : Réseaux et Systèmes Distribués**

## Exercices Réalisés

### Exercice 1 : Interaction Simple entre Modules
- Implémentation de `UserService` et `UserRepository`.
- Test unitaire avec Mockito pour vérifier l'interaction entre le service et le repository.

### Exercice 2 : Interaction avec une Base de Données (Mocks)
- Création de la chaîne `OrderController` -> `OrderService` -> `OrderDao`.
- Test JUnit vérifiant que les appels sont correctement propagés du contrôleur jusqu'au DAO.

### Exercice 3 : Intégration d'API avec Mocking
- Implémentation de `ProductService` utilisant un `ProductApiClient` externe.
- Tests couvrant plusieurs scénarios : Récupération réussie, échec API, données incompatibles.
