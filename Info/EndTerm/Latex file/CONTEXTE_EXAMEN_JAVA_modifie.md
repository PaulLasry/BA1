# CONTEXTE_EXAMEN_JAVA.md
**Sujet :** Révision Examen Programmation Orientée Objet (Java)
**Date Examen :** 13 Décembre
**Durée :** 1h45 (Documentation ouverte)
**Objectif :** Synthèse technique pour résolution d'exercices de conception et d'analyse de code.

---

## 1. FONDAMENTAUX & PIÈGES SYNTAXIQUES

### 1.1 Comparaison & Égalité
* **Primitifs** (`int`, `double`, `boolean`) : Utiliser `==`.
* **Objets** (`String`, Tableaux, Instances) :
    * `==` : Compare les **références** (adresses mémoire).
    * `.equals(b)` : Compare le **contenu** (sémantique). Toujours l'utiliser pour `String` et Collections.
* **String Pool** : Les littéraux `String s = "A"` sont mis en cache. `new String("A")` crée une nouvelle référence.
    * `"A" == "A"` -> `true`.
    * `new String("A") == "A"` -> `false`.

### 1.2 Structures de Données
| Caractéristique | Tableau (Array) | ArrayList (List) |
| :--- | :--- | :--- |
| **Déclaration** | `int[] t = new int[5];` | `List<Integer> l = new ArrayList<>();` |
| **Taille** | Fixe (`t.length`) | Dynamique (`l.size()`) |
| **Accès** | `t[i]` | `l.get(i)` |
| **Modification** | `t[i] = val` | `l.set(i, val)` |
| **Type** | Primitifs ou Objets | Objets uniquement (Wrapper: `Integer`) |

> **Note Exam** : Préférer `List<Type> l = new ArrayList<>()` (Coder vers l'interface) plutôt que `ArrayList<Type> l = ...`.

### 1.3 Division Entière
* `1 / 2` -> `0` (int).
* `1.0 / 2` -> `0.5` (double).

---

## 2. PROGRAMMATION ORIENTÉE OBJET (CŒUR)

### 2.1 Constructeurs & Initialisation
* **Défaut** : Fourni par Java uniquement si **aucun** constructeur n'est défini.
* **Chainage `this(...)`** : Appelle un autre constructeur de la *même* classe. Doit être la **1ère ligne**.
* **Chainage `super(...)`** : Appelle un constructeur du *parent*. Doit être la **1ère ligne**. C'est la manifestation du **polymorphisme en construction** : l'objet se construit "de la base vers le dérivé".
* **Ordre d'exécution** :
    1.  Constructeurs Parents (du plus haut au plus bas).
    2.  Initialisation des attributs.
    3.  Corps du constructeur courant.
* **Piège Exam** : Si la 1ère ligne n'est pas `this` ou `super`, Java insère `super()` implicite. Si le parent n'a pas de constructeur vide -> **Erreur de compilation**.

### 2.2 Visibilité (Encapsulation)
| Modificateur | Classe | Package | Sous-Classe | Monde |
| :--- | :---: | :---: | :---: | :---: |
| **public** | OK | OK | OK | OK |
| **protected** | OK | OK | OK | NO |
| *(default)* | OK | OK | NO | NO |
| **private** | OK | NO | NO | NO |

* **Règle d'or** : Attributs toujours `private` sauf exception rare.
* **Redéfinition** : On ne peut pas restreindre la visibilité d'une méthode héritée (ex: `public` -> `protected` est interdit).

### 2.3 Static vs Final
* **static** : Lié à la classe. Appelé via `Classe.methode()`. Pas d'accès à `this`.
* **final (variable)** : Constante (assignation unique).
* **final (méthode)** : Interdit `@Override`.
* **final (classe)** : Interdit `extends`.

---

## 3. HÉRITAGE & POLYMORPHISME (RÉSOLUTION DES LIENS)

### 3.1 Mécanisme de Résolution
Soit `A a = new B();` où `B extends A`.
1.  **Compilation (Type Statique)** : Le compilateur vérifie si la méthode existe dans **A**. Sinon -> Erreur.
2.  **Exécution (Type Dynamique)** : La JVM exécute la version de la méthode définie dans **B** (si redéfinie).
3.  **Appel impossible** : Une méthode définie uniquement dans `B` (et pas dans `A`) ne peut pas être appelée sur la référence `a`. Le type statique `A` fait loi à la compilation.
4.  **Attributs** : Toujours liés au type **statique** (pas de polymorphisme sur les champs).

**Exemple développé pour le point 3 :**

```java
class Animal {
    public void manger() {
        System.out.println("L'animal mange.");
    }
}

class Chien extends Animal {
    @Override
    public void manger() {
        System.out.println("Le chien mange sa gamelle.");
    }

    public void aboyer() {
        System.out.println("Woof !");
    }
}

public class TestPolymorphisme {
    public static void main(String[] args) {
        // --- Polymorphisme classique ---
        // Type statique : Animal
        // Type dynamique : Chien
        Animal monAnimal = new Chien();

        // La méthode manger() existe dans Animal, donc la compilation passe.
        // À l'exécution, la JVM choisit la version de Chien.
        monAnimal.manger(); // Affiche: "Le chien mange sa gamelle."

        // --- Appel impossible ---
        // La méthode aboyer() n'existe PAS dans la classe Animal.
        // Le compilateur refuse l'appel, même si l'objet réel est un Chien.
        // monAnimal.aboyer(); // ERREUR DE COMPILATION

        // Pour résoudre ça, il faut une référence du bon type.
        // Soit directement :
        Chien monChien = new Chien();
        monChien.aboyer(); // OK

        // Soit par un "cast" (conversion de type)
        if (monAnimal instanceof Chien) {
            Chien monChienCaste = (Chien) monAnimal;
            monChienCaste.aboyer(); // OK, car on a dit au compilateur que c'est un Chien
        }
    }
}
```

### 3.2 Interfaces vs Classes Abstraites
* **Interface** : Contrat pur. Pas d'état (attributs), sauf constantes `static final`. Méthodes `public` par défaut. Peut avoir méthodes `default` (Java 8).
* **Classe Abstraite** : Peut avoir des attributs et un constructeur. Relation "Est un".
* **Héritage Multiple** : Interdit pour les classes (`extends`), autorisé pour les interfaces (`implements I1, I2`).

---

## 4. EXCEPTIONS

### 4.1 Hiérarchie
* **Throwable** -> **Error** (Fatal, ex: OutOfMemory) & **Exception**.
* **Checked Exception** (ex: `IOException`) : Doit être gérée (`try-catch`) ou déclarée (`throws`). Le compilateur vérifie.
* **Unchecked Exception** (`RuntimeException`, ex: `NullPointer`) : Pas d'obligation.

### 4.2 Syntaxe
```java
try {
    // Code risqué
} catch (SpecificException e) {
    // Gestion précise (toujours avant Exception générique)
} catch (Exception e) {
    // Gestion globale
} finally {
    // Exécuté DANS TOUS LES CAS (même si return dans try)
}
```
---
