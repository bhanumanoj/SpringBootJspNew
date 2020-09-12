package com.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Book;
import com.app.model.Library;
import com.app.repository.BookRepository;
import com.app.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public Library add(Library library)
	{
		return libraryRepository.save(library);
		
	}
	
	public void deleteBook(Integer libraryId)
	{
		System.out.println("ser1");
		Library l =findBook(libraryId);
		libraryRepository.delete(l);
		System.out.println("ser2");
	}

	public Library findBook(Integer libraryId) { 
		
		//return  libraryRepository.findById(libraryId);
		System.out.println("ser0");
		Optional<Library> optional =libraryRepository.findById(libraryId);
		Library library=optional.get();
		return library;
		
				
			 
}
	

	
public Book findBookId(Integer bookId) { 
		
		//return  bookRepository.findById(bookId);
		
		Optional<Book> optional =bookRepository.findById(bookId);
		Book book=optional.get();
		return book;
							 
}

public Book updateBookDetails(int nbId, String nBName, String nBauthr, String nBpubshr) {
	// TODO Auto-generated method stub
	
	Book b =findBookId(nbId);
	
    b.setBookName(nBName);
	b.setAuthor(nBauthr);
	b.setPublisher(nBpubshr);
	bookRepository.save(b);
	return b;
}



}