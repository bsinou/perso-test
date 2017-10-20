# VARIOUS QUESTIONS TO BE DUG

Here is a notepad with various questions where we need to dig a little bit more

###  What is an efficient way to implement a singleton pattern in java
Since java5 the best way to do it is to use an enum:  
enum Singleton {
   INSTANCE
}

### What is the best way to determine the size of an object in Java 
The java.lang.instrument.Instrumentation class provides a nice way to get the size of a Java Object, but it requires you to define a main and run your program with a java agent.