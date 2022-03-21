# Logiciel de gestion de personnel de ligues


## Présentation

Un des responsables de la M2L, utilise une application pour gérer les employés des ligues. L’application est mise à votre disposition par le biais des ressources suivantes :

1) Le code source sur  [Github](https://github.com/oussamadabachil/personnel/tree/master/Personnel)


2) Une bibliothèque logiciel de dialogue en ligne de commande, disponible [ici](https://github.com/alexandreMesle/CommandLine)

# Spécification du besoin

Les niveaux d’habilitation des utilisateurs sont les suivants :

1) Un simple employé de ligue peut ouvrir l’application et s’en servir comme un annuaire, mais il ne dispose d’aucun droit d’écriture.

2) Un employé par ligue est admininstrateur et dispose de droits d’écriture peut gérer la liste des emloyés de sa propre ligue avec une application bureau.

3) Le super-admininstrateur a accès en écriture à tous les employés des ligues. Il peut aussi gérer les comptes des administrateurs des ligues avec une application accessible en ligne de commande. L’application doit être rendue multi-utilisateurs grace à l’utilisation d’une base de données. Les trois niveaux d’habilitation ci-dessus doivent être mis en place.
