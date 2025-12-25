package Practice.VendingMachine;

public class UserRequest {
    private String productId;
    private int quantity;


    public UserRequest(Builder builder) {
        this.productId = builder.productId;
        this.quantity = builder.quantity;
    }

    public static class Builder {
        private String productId;
        private int quantity;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public UserRequest build() {
            return new UserRequest(this);
        }

    }
}
