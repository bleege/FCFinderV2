## FCFinderV2

Data Server used to power [FCFinderV2 iOS App](https://github.com/bleege/FCFinderV2App).  It organizes football clubs by country, league, and year as a participant in that league (aka relegation and promotion).

### Tech Stack

* Kotlin
* Spark Java Framework
* GraphQL
* PostgreSQL

### Building

```sh
./gradlew clean war
```

### Run On Heroku After Git Push

```sh
./gradlew stage
```
