public class Main {
    public static void main(String[] args) {
        DocumentFactory factory = new ConcreteFactory();

        // Let the factory create Product A
        Product p1 = factory.createProduct("A");
        p1.display();

        // Let the factory create Product B
        Product p2 = factory.createProduct("B");
        p2.display();
    }
}
