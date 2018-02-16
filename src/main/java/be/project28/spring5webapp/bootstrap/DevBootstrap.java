package be.project28.spring5webapp.bootstrap;

import be.project28.spring5webapp.model.Author;
import be.project28.spring5webapp.model.Book;
import be.project28.spring5webapp.model.Publisher;
import be.project28.spring5webapp.repositories.AuthorRepository;
import be.project28.spring5webapp.repositories.BookRepository;
import be.project28.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperc = new Publisher("Harper Collins");
        Book ddd = new Book("Domain Driven Design", "1234", harperc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harperc);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher workx = new Publisher("Workx");
        Book noEJB = new Book("J2EE Development without EJB", "23444", workx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(workx);
        bookRepository.save(noEJB);

    }
}
