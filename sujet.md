#Test d'IHM et langage Java

**Test du samedi 6 juin 2015 – Durée 2 heures – Documents autorisés**

L'objet de ce test est l'écriture en Java de l'IHM d'une version simplifiée du jeu Mastermind. Le Mastermind est un jeu de société pour deux joueurs dont le but est de trouver un code. C'est un jeu de réflexion, et de déduction, inventé par Mordecai Meirowitz dans les années 1970.

Il se présente sous la forme d'un plateau perforé de 10 rangées de quatre trous pouvant accueillir des pions de couleurs.

Le nombre de pions de couleurs différentes est de 8 et les huit couleurs sont généralement : rouge ; jaune ; vert ; bleu ; orange ; marron ; violet ; fuchsia.

Il y a également des pions de score blancs et rouges (ou noirs) utilisés pour donner des indications à chaque étape du jeu.

## Règles du jeu

Dans ce jeu, les joueur endossent à tour de role un comportement actif ou passif. Un des deux joueur commence par placer son choix de pions sans qu'ils soient vus de l'autre joueur à l'arrière d'un cache qui les masquera à la vue de celui-ci jusqu'à la fin de la manche. Ce joeur sera appelé joueur passif car une fois la combinaison choisie, il est surtout dans un rôle d'attente.

Le joueur qui n'a pas sélectionné les pions doit trouver quels sont les quatre pions, c'est-à-dire leurs couleurs et positions. Ce joueur est désigné comme joueur actif.

Pour cela, à chaque tour, le joueur actif doit se servir de pions pour remplir une rangée selon l'idée qu'il se fait des pions dissimulés.

Une fois les pions placés, le joueur passif indique :

1. le nombre de pions de la bonne couleur bien placés en utilisant le même nombre de pions de score rouges ;
2. le nombre de pions de la bonne couleur, mais mal placés, avec les pions de score blancs.

Il arrive donc surtout en début de partie qu'il ne fasse rien concrètement et qu'il n'ait à dire qu'aucun pion ne correspond, en couleur ou en couleur et position.

La tactique du joueur actif consiste à sélectionner en fonction des coups précédents, couleurs et positions, de manière à obtenir le maximum d'informations de la réponse du partenaire puisque le nombre de propositions est limité par le nombre de rangées de trous du jeu. Dans la plupart des cas, il s'efforce de se rapprocher le plus possible de la solution, compte tenu des réponses précédentes, mais il peut aussi former une combinaison dans le seul but de vérifier une partie des conclusions des coups précédents et de faire en conséquence la proposition la plus propice à la déduction d'une nouvelle information.

Le joueur actif gagne cette manche s'il donne la bonne combinaison de pions sur la dernière rangée ou avant.

## Travail à réaliser
Votre travail dans la suite de ce sujet sera d'écrire pas à pas plusieurs classes importantes :
- Un objet `MastermindIHM` est une fenêtre de jeu avec laquelle les joueurs interagiront pour faire une partie.
- Un objet `Plateau` représente le plateau de jeu composé des 10 rangées de 4 case.
- Un objet `Pion` représente le pion que le joueur actif déposera dans une case.
- Un objet `CasePion` représente une case du plateau de jeu où le joueur actif pourra déposer un pion.
- Un objet `Rangée` permet de regrouper les cases dans lesquels le joueur actif propose ses combinaisons de couleurs.
- Un objet `Score` représente le pion de score que le joueur passif déposera dans une case.
- Un objet `CaseScore` représente une case du plateau de jeu où le joueur passif pourra déposer un pion de score.
- Un objet `MarquageScore` permet de regrouper les cases dans lesquels le joueur passif donne les indications sur la  combinaison proposée par le joueur actif.
- Un objet `Combinaison` permet de manipuler une combinaison de couleur.

Il y aura aussi plusieurs classes de moindre importance qui serviront d'outils pour les classes principales.

L'objectif de ce test est d'évaluer votre capacité à écrire une IHM à l'aide du langage Java, les méthodes complexes 
car trop algorithmiques n'auront pas à être implémentées. Vous pourrez retrouver une proposition de correction à l'adresse suivante : https://github.com/IUTInfoAix/TestIHM2015/

Le résultat attendu devra ressembler à la fenêtre suivante :
![IHM](screenshoot.png)


### Implémentation de la classe `Pion`
La classe `Pion` permet de représenter les pions de couleurs utilisés par le joueur actif. La responsabilité principale de cette classe est de conserver l'ensemble des pions ainsi que leur apparence.

1. Écrire la classe `Pion` ayant pour commencer, une seule donnée membre privée. Elle se nommera `icon` de type `Icon` permettra de conserver l'image affichée dans les cases.
2. Écrire le constructeur `Pion(String fileName)` qui crée l'`ImageIcon` à partir du nom de fichier passé en paramètre.
3. Écrire l'accésseur `public Icon getIcon()` qui retourne la donnée membre `icon`.
3. Les couleurs de pion étant connus à l'avance (`ROUGE`, `BLEU`, `FUCHSIA`, `JAUNE`, `MARRON`, `ORANGE`, `VERT` et `VIOLET`), leur création peut être faite de manière statique. Pour éviter d'avoir à complexifier notre code avec des valeurs nulles, un pion virtuel (`VIDE`) sera ajouté. Écrire la déclaration statiques des 9 couleurs de pions  (`ROUGE`, `BLEU`, `FUCHSIA`, ...) qui devront utiliser les images appelées "rouge.png", "bleu.png", "fuchsia.png", ... .
4. Écrire la méthode `public Pion suivant()` qui retourne le pion `BLEU` si le pion est `ROUGE` et `FUCHSIA` si le pion est `BLEU` et ainsi de suite. Pour vous faciliter l'écriture de cette méthode, il peut être astucieux de stocker vos pions précédement crée dans un tableau.

### Implémentation de la classe `CasePion`
Pour réaliser le plateau de jeu, il nous faut des boutons sur lesquels on pourra déposer des pions. 

Écrire la classe publique `CasePion` qui représente les boutons de notre plateau de jeu. Cette classe aura les caractéristiques suivantes :
- Elle étend la classe `JButton`.
