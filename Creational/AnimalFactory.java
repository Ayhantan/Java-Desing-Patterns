package Creational;

// 1. Ortak interface
interface Animal {
    void speak();
}

// 2. Concrete classes
class Dog implements Animal {
    public void speak() {
        System.out.println("Woof Woof!");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow Meow!");
    }
}

// 3. Factory
class AnimalFactory {
    public Animal getAnimal(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }
}
