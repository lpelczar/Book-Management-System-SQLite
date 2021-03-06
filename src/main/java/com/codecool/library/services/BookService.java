package com.codecool.library.services;

import com.codecool.library.dao.BookDAO;
import com.codecool.library.models.Author;
import com.codecool.library.models.Book;
import com.codecool.library.models.BookType;
import com.codecool.library.models.Publisher;
import com.codecool.library.views.BookView;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookService {

    private BookDAO bookDAO;
    private BookView bookView;
    private AuthorService authorService;
    private PublisherService publisherService;
    private BookTypeService bookTypeService;

    public BookService(BookDAO bookDAO, BookView bookView, AuthorService authorService,
                       PublisherService publisherService, BookTypeService bookTypeService) {
        this.bookDAO = bookDAO;
        this.bookView = bookView;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.bookTypeService = bookTypeService;
    }

    public void addNewBook() {
        long bookISBN = bookView.getBookISBNInput();
        if (bookDAO.getByISBN(bookISBN) != null) {
            bookView.displayBookAlreadyExists();
        } else {
            Author author = authorService.getAuthor();
            String title = bookView.getBookTitleInput();
            Publisher publisher = publisherService.getPublisher();
            int year = bookView.getBookPublicationYearInput();
            double price = bookView.getBookPriceInput();
            BookType type = bookTypeService.getBookType();
            if (bookDAO.add(new Book(bookISBN, author, title, publisher, year, price, type))) {
                bookView.displayBookSuccessfullyAdded();
            } else {
                bookView.displayErrorAddingBook();
            }
        }
    }

    public void deleteBook() {

        bookView.displayEntriesNoInput(new ArrayList<>(bookDAO.getAll()));
        if (bookDAO.getAll().isEmpty()) {
            bookView.displayPressAnyKeyToContinueMessage();
            return;
        }

        long bookISBN = bookView.getBookISBNInput();
        if (bookDAO.getByISBN(bookISBN) != null) {
            if (bookDAO.delete(bookDAO.getByISBN(bookISBN))) {
                bookView.displayBookDeletedMessage();
            } else {
                bookView.displayDeleteErrorMessage();
            }
        } else {
            bookView.displayThereIsNoBookMessage();
        }
    }

    public void showAllBooksByGivenAuthor() {
        Author author = authorService.getAuthor();
        bookView.displayEntries(new ArrayList<>(bookDAO.getByAuthor(author)));
    }

    public void showAllBooksSortedByName() {
        List<Book> books = new ArrayList<>(bookDAO.getAll());
        books.sort(Comparator.comparing(Book::getTitle));
        bookView.displayEntries(books);
    }

    public void editBook() {
        bookView.displayEntriesNoInput(new ArrayList<>(bookDAO.getAll()));
        if (bookDAO.getAll().isEmpty()) {
            bookView.displayPressAnyKeyToContinueMessage();
            return;
        }

        long bookISBN = bookView.getBookISBNInput();
        if (bookDAO.getByISBN(bookISBN) != null) {
            updateBook(bookDAO.getByISBN(bookISBN));
        } else {
            bookView.displayThereIsNoBookMessage();
        }
    }

    private void updateBook(Book book) {
        final String UPDATE_AUTHOR = "1";
        final String UPDATE_TITLE = "2";
        final String UPDATE_PUBLISHER = "3";
        final String UPDATE_YEAR = "4";
        final String UPDATE_PRICE = "5";
        final String UPDATE_TYPE = "6";

        switch(bookView.getValueToUpdate(book)) {
            case UPDATE_AUTHOR:
                Author author = authorService.getAuthor();
                book.setAuthor(author);
                showEditResultMessage(bookDAO.update(book));
                break;
            case UPDATE_TITLE:
                String title = bookView.askForTitleInput();
                book.setTitle(title);
                showEditResultMessage(bookDAO.update(book));
                break;
            case UPDATE_PUBLISHER:
                Publisher publisher = publisherService.getPublisher();
                book.setPublisher(publisher);
                showEditResultMessage(bookDAO.update(book));
                break;
            case UPDATE_YEAR:
                int year = bookView.askForYearInput();
                book.setPublicationYear(year);
                showEditResultMessage(bookDAO.update(book));
                break;
            case UPDATE_PRICE:
                double price = bookView.askForPriceInput();
                book.setPrice(price);
                showEditResultMessage(bookDAO.update(book));
                break;
            case UPDATE_TYPE:
                BookType type = bookTypeService.getBookType();
                book.setType(type);
                showEditResultMessage(bookDAO.update(book));
                break;
            default:
                bookView.displayWrongOptionMessage();
        }
    }

    private void showEditResultMessage(boolean isEdit) {
        if (isEdit) {
            bookView.displayValueHasBeenChanged();
        } else {
            bookView.displayErrorChangingTheValue();
        }
    }

    public void searchBook() {
        String searchPhrase = bookView.getSearchPhrase();
        bookView.displayEntries(new ArrayList<>(bookDAO.getBySearchPhrase(searchPhrase)));
    }

    public void showHowManyBooksEachAuthorHasCreated() {
        Map<Author, Integer> authorsBooks = new HashMap<>();
        List<Author> authors = authorService.getAllAuthors();
        for (Author author : authors) {
            List<Book> books = bookDAO.getByAuthor(author);
            authorsBooks.put(author, books.size());
        }
        bookView.displayAuthorsAndTheirBooksQuantity(authorsBooks);
    }

    public void showAllBooksWrittenInTheLastTenYears() {
        List<Book> books = bookDAO.getAll();
        int year = LocalDate.now().getYear() - 10;
        List<Book> lastTenYearsBooks = books.stream()
                .filter(x -> x.getPublicationYear() > year)
                .collect(Collectors.toCollection(ArrayList::new));
        bookView.displayEntries(lastTenYearsBooks);
    }

    public void showMostExpensiveBook() {
        List<Book> books = bookDAO.getAll();
        Book book = books.stream().max(Comparator.comparing(Book::getPrice)).get();
        bookView.displayBook(book);
    }

    public void showAuthorFullNameAndAge() {
        Author author = authorService.getAuthor();
        authorService.displayAuthorFullNameAndAge(author);
    }
}