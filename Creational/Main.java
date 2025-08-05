package Creational;

public class Main {
    public static void main(String[] args) {

        //Singleton
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.showMessage();
        System.out.println(s1 == s2);   //true donecek aynı instance


        //Factory Desing
        AnimalFactory factory = new AnimalFactory();

        Animal dog = factory.getAnimal("dog");
        dog.speak();  // Woof Woof!

        Animal cat = factory.getAnimal("cat");
        cat.speak();  // Meow Meow!

        
    }
}
