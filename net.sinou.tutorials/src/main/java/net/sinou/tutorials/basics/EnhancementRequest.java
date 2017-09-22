package net.sinou.tutorials.basics;

/**
 * Exercise from Oracle Tutorial, see:
 * https://docs.oracle.com/javase/tutorial/java/annotations/QandE/questions.html
 * 
 * Define an annotation type for an enhancement request with elements id,
 * synopsis, engineer, and date. Specify the default value as unassigned for
 * engineer and unknown for date.
 */

public @interface EnhancementRequest {

	long id();

	String synopsis();

	String engineer() default "[unassigned]";

	String date() default "[unknown]";

}
