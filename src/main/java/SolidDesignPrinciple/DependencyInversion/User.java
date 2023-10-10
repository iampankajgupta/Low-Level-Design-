package SolidDesignPrinciple.DependencyInversion;

public class User {

  private String firstName;
  private String lastName;
  private String AddressName;


  public User(String firstName, String lastName, String addressName) {
    this.firstName = firstName;
    this.lastName = lastName;
    AddressName = addressName;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddressName() {
    return AddressName;
  }

  public void setAddressName(String addressName) {
    AddressName = addressName;
  }
}
