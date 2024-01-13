# 2ème Rapport de Conception - Projet Mastermind

**Antonin Goisque, Leo Kiefner**

## Introduction

Ce rapport de conception présente les choix de conception que nous avons faits pour le développement du jeu Mastermind en Java, en respectant les principes de l'architecture MVC (Modèle-Vue-Contrôleur) et en intégrant une interface graphique en Swing. Notre objectif est de créer une application de jeu Mastermind qui soit à la fois fonctionnelle et bien structurée.

## Modèle

### Classes et Structures

- **MastermindGame** : Coeur du modèle. Gère l'état de la partie, incluant la génération de la combinaison secrète, le suivi des tentatives du joueur, et la vérification des conditions de victoire ou défaite.
- **Combination** : Représente une combinaison de pions dans le jeu, utilisée pour la combinaison secrète et les tentatives du joueur.
- **Color** : Énumération des différentes couleurs de pions disponibles dans le jeu.
- **Hint** et **HintSuccess** : Fournissent des retours sur les tentatives du joueur, indiquant les succès et les erreurs.

### Mécanismes et Fonctionnalités

- Génération aléatoire de la combinaison secrète.
- Calcul et affichage des indices en fonction des tentatives du joueur.
- Gestion des différents modes d'affichage des indices (Facile, Classique, Numérique) grâce au patron Strategy. Nous avons également choisi d'utiliser une Factory pour la création des différents composants du jeu.

## Vue

### Écrans et Composants

- **StartScreen** : Écran de démarrage permettant au joueur de configurer les paramètres de la partie (nombre de manches, nombre de pions, etc.).
- **GameScreen** : Interface principale du jeu où le joueur fait ses tentatives et reçoit des indices.
- **EndScreen** : Écran de fin de partie affichant le score du joueur et les options pour recommencer ou quitter le jeu.

### Interactions Utilisateur

- Sélection et validation des combinaisons de pions.
- Affichage dynamique des indices en réponse aux actions du joueur.
- Navigation entre les différents écrans du jeu.

## Contrôleur

### Responsabilités

- **MastermindController** : Sert de pont entre le modèle et la vue. Gère la logique de jeu, les interactions de l'utilisateur et met à jour la vue en conséquence.

### Fonctionnalités

- Démarrage du jeu et initialisation des paramètres.
- Réception des entrées de l'utilisateur et mise à jour du modèle.
- Mise à jour de la vue en fonction de l'état du jeu.

## Choix de Conception

1. **Pattern Observer** : Utilisé pour la mise à jour de la vue en fonction des changements dans le modèle. Permet une communication efficace entre le modèle et la vue sans couplage fort.
2. **Gestion des Événements Swing** : Utilisée pour gérer les interactions de l'utilisateur avec l'interface graphique.
3. **Encapsulation et Séparation des Concerns** : Chaque classe a une responsabilité claire et définie, favorisant la maintenabilité et l'extensibilité du code.
4. **Strategy et Factory Patterns** : Nous avons choisi d'utiliser le patron Strategy pour gérer différents modes d'affichage des indices et le patron Factory pour la création des composants du jeu, offrant une plus grande flexibilité et facilitant les extensions futures.

## Conclusion

Le projet Mastermind a été structuré en suivant rigoureusement l'architecture MVC, avec une attention particulière portée à la modularité, la réutilisabilité et la clarté du code. Les choix de conception, tels que l'utilisation des patterns MVC, Observer, Strategy et Factory, ainsi que la structuration claire des classes et des interactions, ont permis de créer une application robuste et flexible, prête à évoluer et à s'adapter à de futures extensions ou modifications.

