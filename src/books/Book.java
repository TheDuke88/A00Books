package books;

/**
 * 
 * @author Ryan Wheeler
 *         CSIS 2420
 *         A00Book 
 *         
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book> {

	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {

		System.out.printf("%s by %s (%d)", title, author, year);
		return "";
	}

	// reads in file to list
	public static List<Book> getList(String file) {
		List<Book> books = new ArrayList<>();

		String line = null;

		try (Scanner reader = new Scanner(Book.class.getResourceAsStream("books.csv"))) {

			while (reader.hasNext()) {
				line = reader.nextLine();
				Book myBook = readBook(line);
				if (myBook != null) {
					books.add(myBook);
				}
			}
		}

		

		return books;
	}

	// Organizes and catches any exceptions
	private static Book readBook(String nextLine) {

		String[] line = nextLine.split(",");
		Book newBook = null;

		try {
			newBook = new Book(line[0], line[1], Integer.parseInt(line[2]));
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.err.println("Problem reading in " + "\"" + nextLine + "\"");
		}
		return newBook;
	}

	// compares objects in the list
	@Override
	public int compareTo(Book o1) {

		return this.getTitle().compareTo(o1.getTitle());
	}
}
	        