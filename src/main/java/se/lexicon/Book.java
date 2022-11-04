package se.lexicon;

import java.util.UUID;

public class Book {

  private final String id;
  private String title;
  private String author;
  private boolean available;
  private Person borrower;

  private Book() {
    this.id = UUID.randomUUID().toString();
    this.available = true;
  }

  public Book(String title, String author) {
    this();
    setTitle(title);
    setAuthor(author);
  }

  public Book(String title, String author, Person borrower) {
    this(title, author);
    setBorrower(borrower);
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    if (title == null) throw new IllegalArgumentException("title was null");
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    if (author == null) throw new IllegalArgumentException("author was null");
    this.author = author;
  }

  public boolean isAvailable() {
    return available;
  }

  public Person getBorrower() {
    return borrower;
  }

  public void setBorrower(Person borrower) {
    this.borrower = borrower;
    this.available = (borrower == null);
  }

  public String showPerson() {
    return borrower.getPersonInformation();
  }

  /*public Person showPerson() {
    return borrower;
  }*/

  public String getBookInformation() {
    // Java Ternary Operator
    // https://careerkarma.com/blog/java-ternary-operator/
    // variable = (expression) ? expressionIsTrue : expressionIsFalse;
    return "Book{ id=" + id + ", title=" + title + ", author=" + author + ", available=" + available + ", borrower=" + (borrower != null ? " PersonId: " + borrower.getPersonId() : "-") + " } ";
  }

}
