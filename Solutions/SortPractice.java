import java.util.*;

public class SortPractice {
	
	protected static class Book implements Comparable<Book> {
		String name;
		int age;
		
		Book (String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		
		@Override
		public int compareTo(Book book2) {
			return Integer.compare(this.age, book2.age);
		}
		
	}
	
	public static void main(String []args) {
		List<Book> books = Arrays.asList(new Book("The Great Gatsby", 12), new Book("Harry Potter", 5), new Book(
				"A Series of Unfortunate Events", 30), new Book("The Great Gatsby", 12));
		Collections.sort(books);
		for (Book book : books) {
			System.out.println(book.name);
		}
	}
	
}
