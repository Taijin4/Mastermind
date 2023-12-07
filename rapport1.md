# 1er Rapport de Conception - Projet Mastermind

**Antonin Goisque, Leo Kiefner**

## Introduction

Ce rapport de conception présente les choix de conception que nous avons faits pour le développement du jeu Mastermind en Java, en respectant les principes de l'architecture MVC (Modèle-Vue-Contrôleur) et en intégrant une interface graphique en Swing. Notre objectif est de créer une application de jeu Mastermind qui soit à la fois fonctionnelle et bien structurée.

## Modèle

Le modèle de l'application est représenté par la classe `MastermindGame`. Cette classe gère la logique du jeu, y compris la génération de la combinaison secrète, la génération des indices associés à une combinaison proposée par le joueur, la vérification de la victoire ou de la défaite du joueur, la gestion des manches et des parties, ainsi que le calcul du score.

Nous avons choisi de représenter la combinaison secrète et les combinaisons tentées par le joueur à l'aide de la classe `Combination`. Chaque combinaison est composée d'une liste de couleurs, représentée par l'énumération `Color`. Cette approche nous permet de gérer facilement les différents éléments du jeu, tels que les couleurs, les indices et les tentatives.

La classe `Hint` est utilisée pour stocker les indices associés à une combinaison proposée par le joueur. Elle contient le nombre de pions correctement placés (`correctPositions`) et le nombre de pions corrects mais mal placés (`correctColors`). Ces informations sont essentielles pour aider le joueur à déduire la combinaison secrète.

## Vue

L'interface utilisateur de l'application est gérée par les classes de la vue. Nous avons choisi d'implémenter une interface graphique en utilisant Swing. La classe `MastermindSwingView` hérite de l'interface `MastermindView` et implémente les méthodes nécessaires pour afficher les écrans de démarrage, de jeu et de fin de partie. Elle permet également à l'utilisateur de choisir les couleurs pour sa prochaine combinaison, de valider la combinaison, de remettre à zéro la combinaison en cours et de modifier le mode d'affichage des indices.

## Contrôleur

Le contrôleur de l'application est représenté par la classe `MastermindController`. Cette classe est responsable de la communication entre le modèle (`MastermindGame`) et la vue (`MastermindView`). Elle gère le démarrage du jeu, le déroulement des manches, la validation des combinaisons proposées par le joueur, le calcul du score et la réinitialisation du jeu.

## Choix de Conception

1. **Modèle-Vue-Contrôleur (MVC)** : Nous avons choisi d'adopter l'architecture MVC pour assurer une séparation claire des responsabilités dans notre application. Le modèle gère la logique du jeu, la vue gère l'interface utilisateur, et le contrôleur assure la coordination entre les deux.

2. **Utilisation de Classes pour Représenter les Combinaisons** : En utilisant la classe `Combination`, nous avons créé une structure claire pour stocker les combinaisons de couleurs. Cela facilite la manipulation des combinaisons secrètes, des tentatives du joueur et des indices.

3. **Utilisation d'une Interface pour la Vue** : En définissant l'interface `MastermindView`, nous assurons une flexibilité dans l'implémentation de différentes vues. La classe `MastermindSwingView` implémente cette interface pour créer une interface graphique en Swing, mais d'autres implémentations pourraient être envisagées.

## Conclusion

Ce rapport de conception présente les principaux choix de conception que nous avons faits pour le développement du jeu Mastermind en Java. Nous avons utilisé l'architecture MVC pour organiser notre code de manière modulaire et avons défini des classes et des interfaces pour représenter les éléments clés du jeu. Ces choix nous permettront de développer une application robuste, extensible et facile à maintenir.