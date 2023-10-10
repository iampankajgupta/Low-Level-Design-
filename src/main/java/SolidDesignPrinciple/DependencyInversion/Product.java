package SolidDesignPrinciple.DependencyInversion;

public class Product {

  private String productName;
  private Long productPrice;

  public Product(String productName, Long productPrice) {
    this.productName = productName;
    this.productPrice = productPrice;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Long getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Long productPrice) {
    this.productPrice = productPrice;
  }
}
