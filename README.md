# Application de Gestion des Rendez-vous

## Aperçu du Projet

Ce projet est une application Spring MVC conçue pour gérer les rendez-vous (`RendezVous`) associés à des individus (`Personne`). Elle fournit une API RESTful pour créer, récupérer, mettre à jour et supprimer des rendez-vous, permettant ainsi aux utilisateurs de planifier et de gérer efficacement leurs réunions.

## Technologies Utilisées

- **Java** : Langage de programmation principal utilisé pour l'application.
- **Spring Framework** : Pour construire l'architecture MVC et les API RESTful.
- **JPA (Java Persistence API)** : Pour gérer les données relationnelles dans les applications Java.
- **MySQL** : Base de données relationnelle utilisée pour le stockage des données.
- **Lombok** : Pour réduire le code boilerplate en générant automatiquement les getters, setters et autres méthodes communes.
- **Postman** : Pour tester les points de terminaison de l'API.

## Entités

### Personne

L'entité `Personne` représente un individu qui peut planifier un ou plusieurs rendez-vous.

#### Attributs :
- `id` : Identifiant unique pour la personne (généré automatiquement).
- `name` : Prénom de la personne.
- `surname` : Nom de famille de la personne.
- `email` : Adresse e-mail de la personne.
- `phone` : Numéro de téléphone de la personne.
- `rendezVous` : Liste des rendez-vous associés (relation un-à-plusieurs).

### RendezVous

L'entité `RendezVous` représente un rendez-vous programmé par une `Personne`.

#### Attributs :
- `id` : Identifiant unique pour le rendez-vous (généré automatiquement).
- `date` : Date du rendez-vous.
- `location` : Lieu où le rendez-vous aura lieu.
- `duration` : Durée du rendez-vous en minutes.
- `description` : Informations supplémentaires sur le rendez-vous.
- `personne` : La `Personne` associée qui a programmé le rendez-vous (relation plusieurs-à-un).

## Points de Terminaison de l'API

L'application fournit les points de terminaison RESTful suivants :

### Points de Terminaison Personne
- `GET /api/personnes` : Récupérer une liste de toutes les personnes.
- `POST /api/personnes` : Créer une nouvelle personne.
- `GET /api/personnes/{id}` : Récupérer une personne par ID.
- `PUT /api/personnes/{id}` : Mettre à jour les détails d'une personne.
- `DELETE /api/personnes/{id}` : Supprimer une personne par ID.

### Points de Terminaison RendezVous
- `GET /api/rendezvous` : Récupérer une liste de tous les rendez-vous.
- `POST /api/rendezvous` : Créer un nouveau rendez-vous.
- `GET /api/rendezvous/{id}` : Récupérer un rendez-vous par ID.
- `PUT /api/rendezvous/{id}` : Mettre à jour les détails d'un rendez-vous.
- `DELETE /api/rendezvous/{id}` : Supprimer un rendez-vous par ID.

## Exemples de Requêtes JSON

### Création d'une Personne et d'un rendezvous

```json
{
    "name": "Amine",
    "surname": "Bakhtaoui",
    "email": "amine.bk2001@gmail.com",
    "phone": "0773843388"
}
{
    "date": "2024-11-10",
    "location": "Oujda Hay zitoune",
    "duration": 20,
    "description": "Rendez-vous de suivi",
    "personId": 1
}



