package Structural;
// Alt sistem sınıfları
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player ON");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
    public void off() {
        System.out.println("DVD Player OFF");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier ON");
    }
    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
    public void off() {
        System.out.println("Amplifier OFF");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector ON");
    }
    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }
    public void off() {
        System.out.println("Projector OFF");
    }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Amplifier amp;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvd, Amplifier amp, Projector projector) {
        this.dvd = dvd;
        this.amp = amp;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting movie theater down...");
        dvd.off();
        amp.off();
        projector.off();
    }
}

// Client
public class FacadePatternExample {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Amplifier amp = new Amplifier();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, amp, projector);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}

