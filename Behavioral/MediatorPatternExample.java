package Behavioral;   // varsa
import java.util.*;

// 1. Mediator interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// 2. Concrete Mediator
class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

// 3. Colleague
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String message);
    abstract void receive(String message);
}

// 4. Concrete Colleague
class ConcreteUser extends User {
    public ConcreteUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + " received: " + message);
    }
}

// 5. Client - public class = dosya adı
public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User ali = new ConcreteUser(chatRoom, "Ali");
        User veli = new ConcreteUser(chatRoom, "Veli");
        User zeynep = new ConcreteUser(chatRoom, "Zeynep");

        chatRoom.addUser(ali);
        chatRoom.addUser(veli);
        chatRoom.addUser(zeynep);

        ali.send("Selam millet!");
        zeynep.send("Merhaba Ali!");
    }
}
