package LibraryManagementSystem.Searcher;

import LibraryManagementSystem.BookCopy;
import LibraryManagementSystem.Member;

import java.util.List;

public interface SearchService {
  public List<BookCopy> searchBookByName(String bookName);
  public List<BookCopy> searchBookByAuthorName(List<String> authorName);
  public List<Member> searchMemberByMembername(String memberName);
  public List<BookCopy> searchBookByBookId(Long bookId);
}
