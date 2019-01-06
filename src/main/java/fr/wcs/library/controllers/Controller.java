package fr.wcs.library.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.wcs.library.entities.Book;
import fr.wcs.library.repositories.BookRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controller {

	@Autowired
	BookRepository repo;
	
	@RequestMapping("/initialize")
	public List<Book> initialize() {
		Book b1 = new Book("Isaac Asimov", "The Gods Themselves", "One of the best (if not the best) from Asimov. A revolutionary energy generation technology threatens our universe." );
		repo.save(b1);
		
		Book b2 = new Book("Isaac Asimov", "I, Robot", "You know... It's that film with Will Smith. Except it's a book.");
		repo.save(b2);
		
		Book b3 = new Book("Thomas Hobbes", "Leviathan", "A political phylosophy essay about the nature of society.");
		repo.save(b3);
		
		Book b4 = new Book("Konrad Lorenz", "On Aggression", "A behavioural science essay about agression, from fish to man.");
		repo.save(b4);
		
		Book b5 = new Book("John Steinbeck", "Of Mice and Men", "Two farm workers try to survive the great depression.");
		repo.save(b5);
		
		Book b6 = new Book("Jane Austen", "Pride and Prejudice", "Remember kids : hasty judgment is bad !");
		repo.save(b6);
		
		Book b7 = new Book("	Frank Herbert", "Dune", "A classic sci-fi novel. Spice must flow !");
		repo.save(b7);
		
		Book b8 = new Book("George R. R. Martin", "A Game of Thrones", "Winter is coming !");
		repo.save(b8);
		
		return repo.findAll();
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return repo.findAll();
	}
	
	@PostMapping("/books")
    public Book create(@RequestBody Book book){
        return repo.save(book);
    }
	
	@GetMapping("/books/{id}")
    public Book show(@PathVariable Long id){
        return repo.findById(id).get();
    }
	
	@PutMapping("/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        
		Book toUpdate = repo.findById(id).get();
		if (book.getAuthor() != null) toUpdate.setAuthor(book.getAuthor());
		if (book.getTitle() != null) toUpdate.setTitle(book.getTitle());
		if (book.getDescription() != null) toUpdate.setDescription(book.getDescription());
		
        return repo.save(toUpdate);
    }
	
	@DeleteMapping("books/{id}")
    public boolean delete(@PathVariable Long id){
        repo.deleteById(id);
        return true;
    }
	
	@PostMapping("/books/search")
	public List<Book> search(@RequestBody Map<String, String> body){
	    String searchTerm = body.get("text");
	    return repo.findByAuthorContainingOrTitleContaining(searchTerm, searchTerm);
	}
}
