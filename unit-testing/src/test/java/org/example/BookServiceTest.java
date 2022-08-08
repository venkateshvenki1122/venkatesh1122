package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.Set;

import org.example.model.Book;
import org.example.service.BookService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BookServiceTest {
	
	BookService service=null;


	@BeforeAll
	public static void init(TestInfo info) {
	System.out.println(info.getDisplayName()+"called");
	}
	@BeforeEach
	public void setUp() {
	service = new BookService();
	}

	@Test
	@DisplayName("The getBookList method should not null")
	void testGetBookList() {
		
		BookService service = new BookService();
		
		Object actual = service.getBookList();
		
		assertNotNull(actual);
				
	}
	
	@Test
	@DisplayName(value = "addBook method should return 1 for success and 0 for failure")
	void testAddMethodReturn() {
		
		BookService service = new BookService();
		Book book = new Book(101, "venki", 1000);
		
		Object actual = service.addBook(book);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName(value = "addBook method should not accept Duplicate value")
	void testAddMethodDuplicate() {
		
		
		
		Book book1=new Book(1001, "Java", 700);
		
		Book book2=new Book(1001, "Java", 700);
		
		service.addBook(book1);
		 
		int result=service.addBook(book2);
		 int expected = 0;
		assertEquals(expected, result);
	}
	
	@DisplayName(value = "If the element is not found in the collection "
			+ "removeBook method should throw runtime exception with message "
			+ "element not found")
	@Test
	
	void testRemoveMethod() {
		
		Book book=new Book(3, "Kambaramayanam", 100.0);
		
		//boolean result=service.removeBook(book);
		
		Throwable exception=assertThrows(RuntimeException.class,
				()-> service.removeBook(book));
		assertEquals("Element Not Found",exception.getMessage());
	}
	
	@DisplayName(value = "Test if getBestBook method has the value  "
			+ "Head First Java in one first three positions")
	@ParameterizedTest
	@ValueSource(ints= {0,1,2,3})
	void testGetBestBook(int indxs) {
		
		//assumeTrue(System.getProperty("os.name").equals("windows 8"));
		assertEquals("Head First Java", service.getBestBooks().get(indxs));
		
	}
	
	
}
