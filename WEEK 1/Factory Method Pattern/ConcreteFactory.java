public class ConcreteFactory extends DocumentFactory {
    @Override
    public Product createProduct(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("A")) {
            return new ConcreteProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ConcreteProductB();
        }
        return null;
    }
}
