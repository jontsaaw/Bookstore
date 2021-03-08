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
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/index")
    public String bookstore() {
        return "index";
    }
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks (Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	

}
	
		@RequestMapping(value = "/addbook", method = RequestMethod.GET)
		public String getNewCarForm(Model model) {
			model.addAttribute("book", new Book()); 
			model.addAttribute("categories", categoryRepository.findAll());
			return "addbook";
		}

		
		@RequestMapping(value = "/savebook", method = RequestMethod.POST)
		public String saveBook(@ModelAttribute Book book) {
			
			bookRepository.save(book);
			return "redirect:/booklist";
		}

		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long id) {
			bookRepository.deleteById(id);
			return "redirect:../booklist";
		}
		
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String editBook(@PathVariable("id") Long id, Model model) {
			model.addAttribute("book", bookRepository.findById(id).get());
			model.addAttribute("categories", categoryRepository.findAll());
			return "editbook";
		}
		

	}


