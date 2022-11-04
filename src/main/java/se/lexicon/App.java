package se.lexicon;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Book oca = new Book("OCA - Oracle Certified Associate Java SE 8 Programmer", "Scott Selikoff");
    Book ocp = new Book("OCP - Oracle Certified Professional Java SE 8 Programmer", "Scott Selikoff, Jeanne Boyarsky");

    Person person1 = new Person("Test1", "Test1");
    person1.loanBook(ocp);
    person1.loanBook(oca);

    System.out.println("BOOK INFORMATION");
    System.out.println(oca.getBookInformation());
    System.out.println(ocp.getBookInformation());

    System.out.println("PERSON INFORMATION");
    System.out.println(person1.getPersonInformation());

    System.out.println("RETURN OCP BOOK");
    person1.returnBook(ocp);

    System.out.println("PERSON INFORMATION");
    System.out.println(person1.getPersonInformation());
    System.out.println(person1.displayBooks());



  }
}
