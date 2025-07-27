package LibraryManagementSystem.Searcher;

import LibraryManagementSystem.BookCopy;
import LibraryManagementSystem.Member;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService{
  @Override
  public List<BookCopy> searchBookByName(String bookName) {
    // Business Logic


    return new ArrayList<>();
  }

  @Override
  public List<BookCopy> searchBookByAuthorName(List<String> authorName) {
    return null;
  }

  @Override
  public List<Member> searchMemberByMembername(String memberName) {
    return null;
  }

  @Override
  public List<BookCopy> searchBookByBookId(Long bookId) {
    return null;
  }
}
