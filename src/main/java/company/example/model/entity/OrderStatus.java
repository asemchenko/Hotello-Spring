package company.example.model.entity;

public enum OrderStatus {
    PAYMENT_EXPECTED, PAID, CANCELED;

    public String getName() {
        return name();
    }

    @Override
    public String toString() {
        return this.name();
    }
}