# prudentia

> Prudentia a pour objectif de rendre lisible et accessible les données "open data" de l'assemblée nationale. 

## Prudentia et Prudentia-front
Il existe 2 projets github :

Prudentia (https://github.com/jgardette/prudentia) : Ce projet est la partie "back" qui a pour but de parser les fichiers de données et d'exposer les API

Prudentia-front (https://github.com/jgardette/prudentia-front) : Ce projet est la partie "front" et appel les API du back pour ensuite afficher les résultats

## Données sources
L'ensemble des données mise à disposition par l'assemblée nationale sont ici http://data.assemblee-nationale.fr/
Actuellement, prudentia exploite les fichiers suivants :
- Députés en exercice : fichier AMO10_deputes_actifs_mandats_actifs_organes_XIV.json 
accessible à http://data.assemblee-nationale.fr/acteurs/deputes-en-exercice dont le nom est "Fichier json (composite)"

## Getting Started
L'application est accessible via l'url suivante https://prudentia-front.herokuapp.com

Sinon, vous pouvez cloner les 2 projets en local
