# SpringBootRepo
This repo containg spring boot related labs

Note: 
1. Reactive Repositories are not supported by JPA. #2

https://stackoverflow.com/questions/52480271/spring-webflux-jpa-reactive-repositories-are-not-supported-by-jpa

If you want all the benefits of reactive, async / non-blocking, you'll need to make the whole stack async / non-blocking. JDBC is indeed inherently a blocking API, so you can't build a fully reactive / non-blocking app if you need to access the database through JDBC.

But you still you need relational database then will recommend to use rxjava2-jdbc and here is full example of using RxJava and RxJava jdbc spring-webflux-async-jdbc-sample

Seems currently Spring webflux support Mongodb, Redis, etc nosql reactive so instead of JPA use spring-boot-starter-data-mongodb-reactive
