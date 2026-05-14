# TP1 - Tests Unitaires avec Couverture de Code

**Auteur : KELAIAIA AYOUB**  
**Spécialité : Réseaux et Systèmes Distribués**

## Bugs trouvés dans le code original

### Exo1 - Palindrome
- **Bug** : `j++` et `i--` sont inversés → boucle infinie
- **Correction** : remplacer par `i++` et `j--`

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