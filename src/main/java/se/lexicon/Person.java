package se.lexicon;

import java.util.Arrays;

public class Person {

  private final int personId;
  private String firstName;
  private String lastName;

  private Book[] borrowedBooks;

  private Person() {
    this.personId = PersonSequencer.getNextId();
  }

  public Person(String firstName, String lastName) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void loanBook(Book book) {
    if (borrowedBooks == null) borrowedBooks = new Book[0];
    if (book == null) throw new IllegalArgumentException("Book was null");

    if (book.isAvailable()) {
      book.setBorrower(this);
      Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
      newArray[newArray.length - 1] = book;
      borrowedBooks = newArray;
    } else {
      throw new IllegalArgumentException("Book was not available");
    }
  }

  public void returnBook(Book book) {
    if (book == null) throw new IllegalArgumentException("Book was null");

    Book[] newArray = new Book[borrowedBooks.length - 1];
    int counter = 0;
    for (Book elementArray : borrowedBooks) {
      if (elementArray.getId().equals(book.getId())) {
        book.setBorrower(null);
        continue;
      }
      newArray[counter++] = elementArray;
    }
    borrowedBooks = newArray;
  }

  public String getPersonInformation() {
    return "Person{ personId=" + personId + ", firstName='" + firstName + ", lastName='" + lastName + ",number of borrowedBooks=" + borrowedBooks.length + '}';
  }

  public String displayBooks() {
    String stringBuilder = "";
    if (borrowedBooks != null) {
      for (Book book : borrowedBooks) {
        System.out.println(book.getBookInformation());
      }
      return stringBuilder.toString();
    }
    return null;
  }


  public int getPersonId() {
    return personId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    if (firstName == null) throw new IllegalArgumentException("firstName was null");
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    if (lastName == null) throw new IllegalArgumentException("lastName was null");
    this.lastName = lastName;
  }

}
