# Springboot Playwright UI and End-to-End Testing

## Ultimate UI and End-to-End Testing with

* ### [Springboot test](https://spring.io/projects/spring-boot)
* ### [Kotlin](https://kotlinlang.org/)
* ### [Kotest](https://kotest.io/)
* ### [Playwright](https://playwright.dev/java/docs/intro)

### CMD run tests

```` bash
.\mvnw test
````

### CMD run tests with tags and spring profile

```` bash
.\mvnw test -DargLine="-Dkotest.tags='TodoApp' -Dspring.profiles.active=ci"
````
