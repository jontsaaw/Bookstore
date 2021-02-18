package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping("/index")
    public String bookstore() {
        return "index";
    }
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks (Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	

}
	// tyhjän autolomakkeen muodostaminen
		@RequestMapping(value = "/newbook", method = RequestMethod.GET)
		public String getNewCarForm(Model model) {
			model.addAttribute("book", new Book()); // "tyhjä" auto-olio
			return "bookform";
		}

		// autolomakkeella syötettyjen tietojen vastaanotto ja tallennus
		@RequestMapping(value = "/savebook", method = RequestMethod.POST)
		public String saveBook(@ModelAttribute Book book) {
			// talletetaan yhden auton tiedot tietokantaan
			bookRepository.save(book);
			return "redirect:/books";
		}

		// auton poisto
		@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId) {
			bookRepository.deleteById(bookId);
			return "redirect:../books";
		}
		
		
		

	}


