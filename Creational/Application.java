package Creational;

// Abstract Factory Pattern Example

// Ürün arayüzleri
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

// Windows ürünleri
class WinButton implements Button {
    public void paint() {
        System.out.println("Render a Windows button");
    }
}

class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Render a Windows checkbox");
    }
}

// Mac ürünleri
class MacButton implements Button {
    public void paint() {
        System.out.println("Render a MacOS button");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Render a MacOS checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }

    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client kodu
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        // OS belirle (manuel)
        String osName = "Windows";  // Değiştir: "Mac" de yapabilirsin
        GUIFactory factory;

        if (osName.equalsIgnoreCase("Windows")) {
            factory = new WinFactory();
        } else if (osName.equalsIgnoreCase("Mac")) {
            factory = new MacFactory();
        } else {
            throw new RuntimeException("Error! Unknown OS.");
        }

        Application app = new Application(factory);
        app.paint();
    }
}
