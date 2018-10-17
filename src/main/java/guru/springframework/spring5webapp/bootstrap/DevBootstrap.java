package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Create by lh on 10/17/18
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher hc = new Publisher("Harper Collins", "address1");
        Book ddd = new Book("Domain Driven Design", "12345", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(hc);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rob", "Johnson");
        Publisher wrox = new Publisher("Wrox", "Address 2");
        Book noEJB = new Book("J2EE Development without EJB", "34567", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(wrox);
        bookRepository.save(noEJB);



    }
}
