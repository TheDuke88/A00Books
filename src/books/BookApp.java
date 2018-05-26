package books;

/**
 * 
 * @author Ryan Wheeler
 *         CSIS 2420
 *         A00Book 
 *         
 */
import java.util.Collections;
import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		//sorts, prints list 
		List<Book> books = Book.getList("books.csv");
		Collections.sort(books);
		System.out.println("Sorted book list:");
		printM(books);
		System.out.println("\nReverse order:");
		Collections.sort(books, Collections.reverseOrder());
		printM(books);

	}
	//puts books into print statement 
	private static void printM(List<Book> books) {

		for (Book b : books) {
			System.out.println(b.toString());

		}
	}
}
