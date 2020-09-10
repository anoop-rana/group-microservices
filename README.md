## Projects are divided into multiple groups
This repo containg microservice related labs

### Group 1: Monolithic Rest Service
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
