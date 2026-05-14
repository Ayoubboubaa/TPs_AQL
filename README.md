# TP1 - Tests Unitaires avec Couverture de Code

## Bugs trouvés dans le code original

### Exo1 - Palindrome
- **Bug** : `j++` et `i--` sont inversés → boucle infinie
- **Correction** : remplacer par `i++` et `j--`
- **Fichier corrigé** : `Palindrome.java` (voir aussi `Exo1Correction.java`)

### Exo2 - Anagram
- **Bug** : `i <= s1.length()` provoque un `StringIndexOutOfBoundsException`
- **Correction** : `i < s1.length()`

### Exo3 - BinarySearch
- **Bug** : `low < high` ne trouve pas l'élément quand il est seul ou au bord
- **Correction** : `low <= high` et `array[mid] < element` (strict)

### Exo5 - RomanNumeral
- **Bug** : `i <= symbols.length` provoque un `ArrayIndexOutOfBoundsException`
- **Correction** : `i < symbols.length` et `n >= values[i]`

### Exo6 - FizzBuzz
- **Bug** : `n <= 1` rejette `n=1` alors qu'il devrait retourner "1"
- **Correction** : `n < 1`

## Critères de couverture identiques

- **Exo4 (QuadraticEquation)** : Les critères Branch et Condition donnent les mêmes tests car toutes les conditions sont simples (pas de `&&` ou `||`).
- **Exo6 (FizzBuzz)** : Même raison que Exo4.
```

---

### 📌 Résumé visuel dans IntelliJ
```
📁 src/main/java/
Palindrome.java        ← coller le code corrigé
Anagram.java
BinarySearch.java
QuadraticEquation.java
RomanNumeral.java
FizzBuzz.java

📁 src/test/java/TP01
📁 LineCoverageTest/
Exo1Test.java ... Exo6Test.java
📁 BranchCoverageTest/
Exo1Test.java ... Exo6Test.java
📁 ConditionCoverageTest/
Exo1Test.java ... Exo6Test.java

README.md  ← à la racine

---

# TP2 - Tests d'Intégration et Mocking

Ce TP porte sur l'implémentation de tests d'intégration en utilisant **JUnit 5** et **Mockito** pour simuler les dépendances.

## Exercices Réalisés

### Exercice 1 : Interaction Simple entre Modules
- Implémentation de `UserService` et `UserRepository`.
- Test unitaire avec Mockito pour vérifier l'interaction entre le service et le repository.

### Exercice 2 : Interaction avec une Base de Données (Mocks)
- Création de la chaîne `OrderController` -> `OrderService` -> `OrderDao`.
- Test JUnit vérifiant que les appels sont correctement propagés du contrôleur jusqu'au DAO.

### Exercice 3 : Intégration d'API avec Mocking
- Implémentation de `ProductService` utilisant un `ProductApiClient` externe.
- Tests couvrant plusieurs scénarios :
  - Récupération réussie d'un produit.
  - Échec de l'appel API (Exception).
  - Données incompatibles (Retour null).

## Structure du Projet TP2
```
📁 tp2/src/main/java/
   Order.java
   OrderController.java
   OrderDao.java
   OrderService.java
   Product.java
   ProductApiClient.java
   ProductService.java
   User.java
   UserRepository.java
   UserService.java

📁 tp2/src/test/java/
   OrderControllerTest.java
   ProductServiceTest.java
```