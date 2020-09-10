## Projects are divided into multiple groups
This repo containg microservice related labs

### Group 1: Monolithic Rest Service [group1-monolithic-rest-service]
* Basic @PathVariable , @RequestBody etc annotation
* Send back newly added item uri using -ServletUriComponentsBuilder
* Exception Handling 
  1. Custom Exception: @ResponseStatus(HttpStatus.NOT_FOUND) [Issue #1]
  2. Generic Exception Handling for all Resources [ResponseEntityExceptionHandler] [Issue #2]
  3. Validated Exception: @Validated, @Min, @Max etc [Issue #3]
* HATEOAS - Resource, EntityModel, ControllerLinkBuilder, WebMvcLinkBuilder etc [Issue #4]
* Spring Security
  1. HTTP BASIC authentication headers
  2. HTTP Digest authentication headers
  3. Auth, OAuth
 
#### Advance Rest Service
  * Internationalized I18N [Issue #5]
    1. LocaleResolver
	2. AcceptHeaderLocaleResolver
  * Content Nagotiation
    1. jackson-dataformat-xml
  * Swagger Configuration
    1. http://localhost:9090/v2/api-docs
	2. http://localhost:9090/swagger-ui.html
  * Versioning
    1. URI Versioning [twitter] @GetMapping("/v1/{name}"),@GetMapping("/v2/{name}")
	2. Parameter/Param request versioning [amazon] @GetMapping(path = "/{name}", params="v2")
	3. Header Versioning [Microsoft] @GetMapping(path = "/{name}", headers="v2")
	4. MediaType Versioning [Github]  @GetMapping(path = "/{name}", produces="application/anu.v2")
  * json filter
  * Documentation
  * monitoring web services [Actuator, HAL Browser]
    1. http://localhost:9090 {HAL Browser}
	2. http://localhost:9090/actuator {Actuator}

#### Richardson Maturity Model

Richardson Maturity Model defines the maturity level of a Restful Web Service. Following are the different levels and their characteristics.

    Level 0 : Expose SOAP web services in REST style. 
              Expose action based services (http://server/getPosts, http://server/deletePosts, http://server/doThis, http://server/doThat etc) using REST.
    Level 1 : Expose Resources with proper URI’s (using nouns). 
              Ex: http://server/accounts, http://server/accounts/10. However, HTTP Methods are not used.
    Level 2 : Resources use proper URI’s + HTTP Methods. 
              For example, to update an account, you do a PUT to . The create an account, you do a POST to . Uri’s look like posts/1/comments/5 and accounts/1/friends/1.
    Level 3 : HATEOAS (Hypermedia as the engine of application state). 
              You will tell not only about the information being requested but also about the next possible actions that the service consumer can do. When requesting information about a facebook user, a REST service can return user details along with information about how to get his recent posts, how to get his recent comments and how to retrieve his friend’s list.


