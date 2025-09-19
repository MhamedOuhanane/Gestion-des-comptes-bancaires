# Gestion des comptes bancaires 
***

## 📌 Description
Ce projet est une **application console en Java 8** qui permet de gérer les comptes bancaires d’une banque.  
L’objectif est d’automatiser la gestion des comptes (courant et épargne) ainsi que leurs opérations (versements, retraits, virements).

## 🏗️ Structure de l’application
- **Couche présentation (UI/Menu)** : interaction avec l’utilisateur via la console.
- **Couche métier (services et logique de gestion)** : gestion des comptes et opérations.
- **Couche utilitaire** : outils (formatage, validation, génération de code, etc.).

## 📂 Contenu des classes principales

### 🔹 Compte (abstraite)
- **Attributs** : `code`, `solde`, `listeOperations`
- **Méthodes abstraites** : `retirer()`, `calculerInteret()`, `afficherDetails()`

### 🔹 CompteCourant
- Hérite de `Compte`
- Attribut supplémentaire : `decouvert`
- **Règle** : le solde peut être négatif mais limité par le découvert autorisé.
- **Intérêts** = `0`.

### 🔹 CompteEpargne
- Hérite de `Compte`
- Attribut supplémentaire : `tauxInteret`
- **Règle** : retrait possible uniquement si le solde ≥ montant à retirer.
- **Intérêts** calculés sur le solde.

### 🔹 Operation (abstraite)
- **Attributs** : `numero (UUID)`, `date`, `montant`.

### 🔹 Versement
- Hérite de `Operation`
- Attribut supplémentaire : `source`.

### 🔹 Retrait
- Hérite de `Operation`
- Attribut supplémentaire : `destination`.

## ⚙️ Fonctionnalités principales
- ✅ Créer un compte (courant ou épargne)
- ✅ Effectuer un versement
- ✅ Effectuer un retrait
- ✅ Effectuer un virement entre comptes
- ✅ Consulter le solde d’un compte
- ✅ Consulter la liste des opérations d’un compte

## 🚀 Technologies utilisées
- **Langage** : Java 8
- **Paradigme** : Programmation Orientée Objet (POO)
- **Interface** : Console (UI textuelle)



## Conception :
- Diagramme de classe :
  ![Diagrame de class](UML/Diagrame%20de%20class.jpg)

## Captures d’écran :
| ![Captur1](CapturesEcran/Capture%20d'écran%201.png) | ![Captur2](CapturesEcran/Capture%20d'écran%202.png) |
|------------------------------------------------|------------------------------------------------|
| ![Captur3](CapturesEcran/Capture%20d'écran%203.png) | ![Captur4](CapturesEcran/Capture%20d'écran%204.png) |

## ▶️ Exécution

### Compilation
Si tes fichiers `.java` sont directement dans le dossier :
```bash
javac *.java

java Main
