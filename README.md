
# TP Design Patterns en Java

Ce dépôt contient le code source pour les travaux pratiques du cours **Conception Orientée Objet et Design Patterns** à **CPE Lyon** pour l'année universitaire 2023-2024. Le but de ce projet est de concevoir et de développer une application Java en appliquant des principes de programmation orientée objet (POO) et les **principes SOLID** pour mettre en œuvre des **Design Patterns** adaptés.

## Contexte du Projet

Le projet est une version simplifiée d'un site de e-commerce simulant la gestion d'un panier, le choix de produits et le paiement. L'application met en œuvre une IHM en console permettant des interactions simulées avec le client.

### Objectifs du TP

- Utiliser les piliers de la POO : **abstraction**, **encapsulation**, **héritage**, et **polymorphisme**
- Appliquer les principes **SOLID** :
  - **SRP** - Principe de Responsabilité Unique
  - **OCP** - Principe d'Ouverture/Fermeture
  - **LSP** - Principe de Substitution de Liskov
  - **ISP** - Principe de Ségrégation des Interfaces
  - **DIP** - Principe d'Inversion de Dépendances
- Identifier, adapter et mettre en œuvre les **Design Patterns** pour répondre à des problématiques récurrentes de conception.

## Fonctionnalités

- **Ajout au panier** : Permet de sélectionner des produits et de les ajouter au panier en quantités variables.
- **Annulation et rétablissement des actions** : Le client peut annuler et rejouer des actions (simulées à des fins pédagogiques).
- **Calcul et choix du mode de paiement** : Calcul du montant total et sélection entre différents modes de paiement simulés (carte bancaire, PayPal, etc.).

## Liste des Design Patterns étudiés

Les Design Patterns sont abordés en plusieurs ateliers. Ils incluent, entre autres :
1. **Atelier 1** : MVC et SOLID - Familiarisation avec la structure et les principes de conception.
2. **Atelier 2** : Adapter, Decorator, Facade, Observer, Singleton, Strategy, Template Method
3. **Atelier 3** : Abstract Factory, Command, Composite, Factory Method, Iterator, Mediator, Memento
4. **Atelier 4 et 5** (avancé) : Iterator, Prototype, Proxy, Builder, Bridge, Flyweight, Chain of Responsibility, Visitor

## Structure du Code

- **IView, IProduct, IOrder** : Interfaces définissant les principales fonctionnalités et comportements de l'application.
- **ViewConsole, Simulator** : Composants de l'IHM en console pour gérer les interactions avec le client.
- **Product, Order** : Classes gérant les produits et les commandes.
- **Diagrammes UML** : Inclus pour visualiser l'architecture du projet et les interactions entre les composants.

## Prérequis

- **Java 11** ou une version ultérieure.
- **IDE Java** tel qu'Eclipse ou IntelliJ IDEA.
- Connaissances de base en programmation orientée objet et en Design Patterns.

## Exécution du TP

Chaque atelier comporte des instructions spécifiques que vous pouvez suivre pour implémenter les Design Patterns et analyser leurs impacts sur la qualité et la maintenabilité de l'application.

### Atelier 1 - Étude Préliminaire

Revoyez les principes SOLID et le pattern **MVC**. Analysez la structure du code existant et identifiez les responsabilités de chaque composant.

### Atelier 2 - Études de Patterns Comportementaux et Structurels

Implémentez les Design Patterns assignés en équipe. Utilisez des diagrammes UML pour illustrer chaque pattern (intention, structure de classe, et interactions).

### Atelier 3 - Design Patterns de Création et de Comportement

Travaillez sur des patterns plus complexes, tels que **Abstract Factory** et **Memento**, en analysant leur impact sur la flexibilité et l’extensibilité de l'application.

## Ressources Utiles

- [OpenClassrooms - MVC et SOLID en Java](https://openclassrooms.com/fr/courses/6810956-ecrivez-du-code-java-maintenable-avec-mvc-et-solid)
- [Refactoring Guru - Design Patterns](https://refactoring.guru/fr/design-patterns)
- **Livres recommandés** :
  - *Design Patterns: Elements of Reusable Object-Oriented Software* - Erich Gamma, et al.
  - *Design Patterns - Tête la première* - Eric Freeman et al.
