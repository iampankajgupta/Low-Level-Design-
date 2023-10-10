package LibraryManagementSystem;

public class Member {

  Long id;
  String firtName;
  String lastName;
  Department department;
  boolean blocked;

  public Member(Long id, String firtName, String lastName, Department department, boolean blocker) {
    this.id = id;
    this.firtName = firtName;
    this.lastName = lastName;
    this.department = department;
    this.blocked = blocker;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirtName() {
    return firtName;
  }

  public void setFirtName(String firtName) {
    this.firtName = firtName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public boolean isBlocked() {
    return blocked;
  }

  public void setBlocked(boolean blocked) {
    this.blocked = blocked;
  }
}
