# WCSLibrary
Un exercice sur la création d'API restful

## Commandes

- TOUT VERBES HTTP : [http://localhost:8080/initialize](http://localhost:8080/initialize)

Créé 8 livres dans la base de donnée pour commencer à manipuler l'application. Retourne la liste complète des livres aprés l'opération.

- GET : [http://localhost:8080/books](http://localhost:8080/books)

Retourne la liste complète des livres.

- POST : ```http://localhost:8080/books```

Corp de la requête :
```JSON
{
  "author":"string",
  "title":"string",
  "description":"string"
}
```

Ajoute une entrée à la base de donnée. Retourne l'entrée créée.

- GET : ```http://localhost:8080/books/{id}```

Retourne l'entrée au chiffre entré à la place de ```{id}```.

- PUT : ```http://localhost:8080/books/{id}```

Corp de la requête :
```JSON
{
  "author":"string",
  "title":"string",
  "description":"string"
}
```

Met à jour l'entrée à l'indice renseigné par le chiffre à la place de ```{id}```. Toutes les entrées du corps de la requêtes sont optionnelles. Seules les propriétés renseignées seront mise à jour. Les entrées absentes sont ignorées. Retourne l'entrée mise à jour.

- DELETE : ```http://localhost:8080/books/{id}```

Supprime l'entrée à l'indice renseigné par le chiffre à la place de ```{id}```. Retourne un booléen ```true```.

- POST : ```http://localhost:8080/books/search```

Corp de la requête :
```JSON
{
  "text":"string"
}
```
Retourne l'entrée ou la liste des entrées contenant dans le titre ou dans l'auteur le texte rensigné dans le corps de la requête.
