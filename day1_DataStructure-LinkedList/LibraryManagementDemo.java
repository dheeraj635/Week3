
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    public void addBookAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addBookAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addBookAtPosition(String title, String author, String genre, int id, boolean available, int position) {
        if (position <= 1) {
            addBookAtBeginning(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        Book current = head;
        int count = 1;
        while (count < position - 1 && current != null) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            addBookAtEnd(title, author, genre, id, available);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
        }
    }

    public void removeBookById(int bookId) {
        if (head == null) return;
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void searchByTitleOrAuthor(String keyword) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + current.bookId + ", Title: " + current.title +
                        ", Author: " + current.author + ", Genre: " + current.genre +
                        ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found with Title or Author: " + keyword);
    }

    public void updateAvailability(int bookId, boolean availability) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = availability;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Book current = head;
        System.out.println("Books in Forward Order:");
        while (current != null) {
            System.out.println("ID: " + current.bookId + ", Title: " + current.title +
                    ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    public void displayReverse() {
        Book current = tail;
        System.out.println("Books in Reverse Order:");
        while (current != null) {
            System.out.println("ID: " + current.bookId + ", Title: " + current.title +
                    ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books: " + count);
    }
}

public class LibraryManagementDemo {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 1, true);
        library.addBookAtBeginning("The Hobbit", "J.R.R. Tolkien", "Fantasy", 2, true);
        library.addBookAtPosition("To Kill a Mockingbird", "Harper Lee", "Classic", 3, true, 2);

        library.displayForward();
        library.displayReverse();

        library.searchByTitleOrAuthor("George Orwell");
        library.updateAvailability(2, false);
        library.removeBookById(1);

        library.displayForward();
        library.countBooks();
    }
}



