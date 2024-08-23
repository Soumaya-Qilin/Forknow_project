
# Forknow

## Prérequis


- **Git**
- **PostgreSQL** 
- **Java 17** (JDK)

## Étape 1 : Créer la base de données PostgreSQL

1. Connectez-vous à PostgreSQL en utilisant l'utilisateur `postgres` :

```
psql -U postgres
```

2.Créez la base de données nécessaire pour le projet :

```
CREATE DATABASE forknow;
```

3.Quittez PostgreSQL :
```
\q
```

## Etape 2: Cloner le dépôt GitHub sur ton ordinateur

```
git clone URL_DU_DEPOT_GITHUB
```



## 2. Accéder au répertoire du projet

```
cd nom-du-repertoire
```

## 3. Construire le projet 




  ```bash
  ./gradlew build
  ```

## 4. Lancer le projet



```bash
./gradlew bootrun
```
