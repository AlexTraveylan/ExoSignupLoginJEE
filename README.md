# Exercice dans le cadre de la formation JavaEE avec M2i

- Création de compte, avec inscription dans la base de donnée (configurer avec la votre : nom_table, utilisateur, et mdp).
- Affichage de la liste des users.
- Possibilité de supprimer ou de modifier un user.
- Protection contre les injections sql avec des requetes préparées.
- Utilisation d'une fonction de hashage pour sécuriser les mdps.
- Simplification des servlets avec une classe UsersDAO qui gere toutes les actions de connexion.
- Utilisation des tags pour un header.
- Modification de la classe User pour mettre en place un design patter et instancier les User avec un Builder.

# Versions

- Jdk 17.0.5
- Tomcat 8.5.83

# Inclusion dans le dossier lib de Tomcat

- mysql-connector-java-8.0.30.jar
- protobuf-java-3.19.4.jar
