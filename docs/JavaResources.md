# Java resources.

## Disclaimer
The Java world is a very rich and complex environment. So one might regularly refer to resources, documentation and tutorials in order to efficiently solve day to day problems.
 
Furthermore, Java is a living language that constantly evolves. A developer should then always keep learning and experimenting with latest trends and APIs. 

So I have listed hereafter the best resources I have found on the internet.
This list is firstly for me to efficiently find information on a specific Java issue, being able to reach trusted sources quickly, but, as a big open-source fan and as these information are anyway freely available, I see no point in not letting it freely available.

As usual, I will took no responsibility of any kind about using the below information, that might sometimes be false or deprecated. (You should contact me or send a pull request if you see errors or have interesting additional resources to suggest).


## Resources by topic
Here are specific links that are specially relevant for a given topic. Some links or website might appear more than once if they are relevant for the sub-category there are listed in...  

### PMO
- [Ways to Make Code Reviews More Effective](https://www.infoq.com/articles/effective-code-reviews)
- [Oracle reference for javadoc](http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html)

### Packaging and deployment
- [Self-contained application tutorial @Oracle](https://docs.oracle.com/javase/8/docs/technotes/guides/deploy/self-contained-packaging.html)

#### Docker
- [Step by Step high Availability with Docker 1/2](https://community.oracle.com/docs/DOC-998210)
- [Step by Step high Availability with Docker 2/2](https://community.oracle.com/docs/DOC-1008824)

### The JVM
- [An easy to read overview of the JVM](http://www.artima.com/insidejvm/ed2/jvm.html) - Yet a little bit out-dated for java 8+
- [Another clear and concise overview on DZone](https://dzone.com/articles/jvm-architecture-explained)
- [JVM details overview](http://www.letustweak.com/tutorials/jvm-details/)

### Memory management 
- [A trail about specific management of memory for Strings](http://www.javamex.com/tutorials/memory/string_memory_usage.shtml)
- [A very basic overview of the difference between heap and stack memory](http://net-informations.com/java/cjava/memory.htm)

### Garbage collection
- [Java Garbage Collection Basics](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html): A basic tutorial on GC on the Oracle website, that cannot been accessed through the generic tutorial pages.
- [The G1GC basics](http://www.oracle.com/technetwork/tutorials/tutorials-1876574.html) on Oracle's website
- [Taming G1GC](http://product.hubspot.com/blog/g1gc-fundamentals-lessons-from-taming-garbage-collection)

### Security
- [A cheat sheet with overview of security tools](https://docs.oracle.com/javase/8/docs/technotes/guides/security/SecurityToolsSummary.html)

About OAuth:
- [Nice overview from Jenkov](http://tutorials.jenkov.com/oauth2/index.html)
- [A famous vulgarisation from Aaron Parecki](https://aaronparecki.com/oauth-2-simplified/)

### QA
- [JUnit basics](http://www.vogella.com/tutorials/JUnit/article.html)
- [Mockito basics](http://www.vogella.com/tutorials/Mockito/article.html)
- To get the [difference between Mock and Stub](https://martinfowler.com/articles/mocksArentStubs.html) 

### Documentation 
- [The official Oracle How-To](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html): rules and best practices to write correct JavaDoc 
- The wiki markdown [cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#code) on github

### Eclipse IDE
- [How to setup remote debugging in Eclipse](http://javarevisited.blogspot.de/2011/02/how-to-setup-remote-debugging-in.html#axzz4lmgRkvUo)

### Rest API
- [5 basic guide lines](http://blog.restcase.com/5-basic-rest-api-design-guidelines)
- [7 Rules for REST API URI Design](https://dzone.com/articles/7-rules-for-rest-api-uri-design-1)
- [A look at the concurrence: GraphQL](https://apihandyman.io/and-graphql-for-all-a-few-things-to-think-about-before-blindly-dumping-rest-for-graphql/)

### Patterns
- [Functional Programming vs GoF](https://blog.jooq.org/2016/07/04/how-functional-programming-will-finally-do-away-with-the-gof-patterns/)

### Regexp
- [A good overview with a cheat sheet](http://regexr.com/)

### Java 8
- [the lambda FAQ](http://www.lambdafaq.org)
- An [interesting JavaOne 2017 conference](https://www.youtube.com/watch?v=PbIBYxVyWNs) on Lambda expressions
- An introduction to [Spliterators](https://blog.logentries.com/2015/10/java-8-introduction-to-parallelism-and-spliterator/)

### Java 9
- [Introduction to Jigsaw](http://openjdk.java.net/projects/jigsaw/quick-start)

### Scripting language
- [A quick overview of the YAML syntax](http://docs.ansible.com/ansible/YAMLSyntax.html)

## Java tutorials

- The must-read for any Java developer: [The Java tutorials on Oracle website](http://docs.oracle.com/javase/tutorial/index.html)
- [A very good alternative from J. Jenkov](http://tutorials.jenkov.com/java)
- [Official JavaEE 8 tutorial](https://javaee.github.io/tutorial/) on Github

## DevOps

### Gradle
- Gradle [User Guide](https://docs.gradle.org/current/userguide/userguide.html)
- [the Groovy language](http://docs.groovy-lang.org/latest/html/documentation/index.html#_introduction)

### Maven

## Spring Framework resources
Main documentation for reference, with among other:
- [The reference documentation](https://spring.io/docs/reference)
- [Many tutorials](https://spring.io/guides)

### Good generic overviews
- [An in depth explanation](https://docs.spring.io/spring/docs/5.0.0.RELEASE/spring-framework-reference/core.html#spring-core) of Spring framework core concepts (IoC and AOP)
- [About annotations](https://dzone.com/articles/a-guide-to-spring-framework-annotations)
- [About @RequestMapping annotation](https://springframework.guru/spring-requestmapping-annotation/)
- [An introduction to thymeleaf](http://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#introducing-thymeleaf): a module developed by Daniel Fernandez [@danfez](http://twitter.com/danfenz), a spanish guy who also contributed [jasypt](http://jasypt.org/) the encryption basic plugin for the SpringFramework (rien que ca :)...

### Spring configuration
- A [comparaison](https://blog.codecentric.de/en/2012/07/spring-dependency-injection-styles-why-i-love-java-based-configuration/) between XML and annotation defined configuration 

### Spring Batch
- A [very complete list of resources](https://www.petrikainulainen.net/spring-batch-the-ultimate-resource/#get-started) to dive in.
- The [reference documentation](https://docs.spring.io/spring-batch/trunk/reference/html) on [spring.io](https://docs.spring.io) website
- An in-depth [introduction to batch within Java EE 7](https://jaxenter.com/java-ee-7-introduction-to-batch-jsr-352-106192.html)
- Another [Overview of the underlying JSR 352 concepts](https://blogs.oracle.com/arungupta/batch-applications-in-java-ee-7-undertanding-jsr-352-concepts:-totd-192) that are now implemented by the Spring Batch project 
- A very easy to understand [first round](http://malsolo.com/blog4java/?p=260), using same data as everybody else. 


## To go further

### Some important Java libraries
- [CGLib](https://dzone.com/articles/cglib-missing-manual): the byte code instrumentation library used by Spring, among others


### Discussion and debates
- [JavaEE vs Spring](https://www.linkedin.com/pulse/j2ee-javaee-vs-spring-hibernate-ian-dai/)
