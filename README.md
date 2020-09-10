## Projects are divided into multiple groups
This repo containg microservice related labs

#### Group 1: Monolithic Rest Service
* Basic @PathVariable , @RequestBody etc annotation
* Send back newly added item uri using -ServletUriComponentsBuilder
* Exception Handling 
  1. Custom Exception: @ResponseStatus(HttpStatus.NOT_FOUND) [Issue #1]
  2. Generic Exception Handling for all Resources [ResponseEntityExceptionHandler] [Issue #2]
  3. Validated Exception: @Validated, @Min, @Max etc [Issue #3]
* HATEOAS - Resource, EntityModel, ControllerLinkBuilder, WebMvcLinkBuilder etc [Issue #4]
 
###### Advance Rest Service
  * Internationalized I18N [Issue #5]
    1. LocaleResolver
	2. AcceptHeaderLocaleResolver
  * Content Nagotiation
    1. jackson-dataformat-xml
  * Swagger Configuration
    1. http://localhost:9090/v2/api-docs
	2. http://localhost:9090/swagger-ui.html
  * Versioning
    1. URI Versioning [twitter]
	2. Parameter/Param request versioning [amazon]
	3. Header Versioning [Microsoft]
	4. MediaType Versioning [Github]
  * json filter
  * Documentation
  * monitoring web services [Actuator, HAL Browser]
    1. http://localhost:9090 {HAL Browser}
	2. http://localhost:9090/actuator {Actuator}
