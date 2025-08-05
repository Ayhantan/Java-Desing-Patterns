package Behavioral;

import java.util.ArrayList;
import java.util.List;

// 1. Observer Arayüzü
interface Observer {
    void update(String message);
}

// 2. Concrete Observer
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

// 3. Subject Arayüzü
interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers(String message);
}

// 4. Concrete Subject
class Channel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : subscribers) {
            o.update(message);
        }
    }

    // İş mantığı
    public void uploadNewVideo(String title) {
        System.out.println("\nNew video uploaded: " + title);
        notifyObservers(title);
    }
}

// 5. Client
public class ObserverPatternExample {
    public static void main(String[] args) {
        Channel techChannel = new Channel();

        Observer ali = new Subscriber("Ali");
        Observer veli = new Subscriber("Veli");
        Observer zeynep = new Subscriber("Zeynep");

        techChannel.subscribe(ali);
        techChannel.subscribe(veli);

        techChannel.uploadNewVideo("Observer Pattern Tutorial");
        techChannel.uploadNewVideo("Java Design Patterns 101");

        techChannel.unsubscribe(veli);
        techChannel.subscribe(zeynep);

        techChannel.uploadNewVideo("Strategy Pattern in Action");
    }
}

