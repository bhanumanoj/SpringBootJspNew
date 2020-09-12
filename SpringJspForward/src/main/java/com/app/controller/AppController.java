package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.model.Book;
import com.app.model.Library;
import com.app.service.LibraryService;



@Controller
public class AppController {
	
	@Autowired
	LibraryService libraryService;
	
	
	@RequestMapping("/")
	public void home()
	{
		System.out.println("hi");
	}
	
	@RequestMapping("/home")
	public String index()
	{
		System.out.println("index");
		return "index.jsp";
	}
	
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public ModelAndView addBook(Library library,Book book)
	{			
		ModelAndView mv=new ModelAndView("Added.jsp");
		book.setLibrary(library);
		library.getBook().add(book);	
		Library library2=libraryService.add(library);
		mv.addObject(library2);
		return mv;
		
	}
	
	@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
	public String deleteBook(@RequestParam int libraryId) 
	{
		libraryService.deleteBook(libraryId);
		return "Deleted.jsp";
	}
	
	@RequestMapping(value="/searchBook",method=RequestMethod.GET)
	public ModelAndView searchBook(@RequestParam int libraryId,@RequestParam int bookId) 
	{
		ModelAndView mv=new ModelAndView("SearchedLib.jsp");
		Library library=libraryService.findBook(libraryId);
		Book book=libraryService.findBookId(bookId);
		mv.addObject(library);
		mv.addObject(book);
		return mv;
	}
		
	
	@RequestMapping(value="/updateBook",method=RequestMethod.POST)
	public ModelAndView updateBook(@RequestParam int bookId,@RequestParam String bookName,@RequestParam String author,@RequestParam String publisher) 
	{
		ModelAndView mv=new ModelAndView("Updated.jsp");
		Book book=libraryService.updateBookDetails(bookId,bookName,author,publisher);
		mv.addObject(book);
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@RequestParam int libraryId,@RequestParam String libraryName,Book book)
	{
		Library library=libraryService.findBook(libraryId);
		library.setLibraryName(libraryName);		
		book.setLibrary(library);
		library.getBook().add(book);
		libraryService.add(library);
		return "Added.jsp";
	
	}


}
