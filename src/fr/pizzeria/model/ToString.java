package fr.pizzeria.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
	boolean uppercase() default false;

}
/*RetentionPolicy.RUNTIME : Les annotations seront enregistrées dans le fichier .class par le compilateur et seront utilisables par la JVM pendant l'exécution de votre programme, grâce à l'introspection.*/
