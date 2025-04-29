package IronLibrary.demo.services;

import IronLibrary.demo.IronLibraryApplication;
import IronLibrary.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Scanner implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    public static void main(String[] args) {
    SpringApplication.run(IronLibraryApplication.class, args);
}

@Override
public void run(String... args) { // también podemos recibir NINGUN argumento
    // es donde ponemos el WHILE LOOP para nuestro menú
    System.out.println("Bienvenido a nuestra app de libros");        // toda la parte de scanner la ponemos por aquí.
    // para que aquí no tengamos toda la lógica metida en 400 líneas. Podemos crear un package de services que gestione partes de la lógica
    // puedo usar el bookRepository o cualquiera de las BEANS de spring framework
    // para salir del proceso:
    System.exit(0);
}


}