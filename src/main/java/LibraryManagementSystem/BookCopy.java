package LibraryManagementSystem;

import java.util.Date;
import java.util.List;

public class BookCopy {
  Long bookId;
  String name;
  Date publicationDate;
  List<String> authorsName;

  public BookCopy(Long bookId, String name, Date publicationDate, List<String> authorsName) {
    this.bookId = bookId;
    this.name = name;
    this.publicationDate = publicationDate;
    this.authorsName = authorsName;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public List<String> getAuthorsName() {
    return authorsName;
  }

  public void setAuthorsName(List<String> authorsName) {
    this.authorsName = authorsName;
  }
}
