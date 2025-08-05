package Behavioral;

// 1. State Arayüzü
interface State {
    void pressPlay(PlayerContext context);
}

// 2. Concrete States
class PlayingState implements State {
    public void pressPlay(PlayerContext context) {
        System.out.println("Pausing the song...");
        context.setState(new PausedState());
    }
}

class PausedState implements State {
    public void pressPlay(PlayerContext context) {
        System.out.println("Resuming the song...");
        context.setState(new PlayingState());
    }
}

class StoppedState implements State {
    public void pressPlay(PlayerContext context) {
        System.out.println("Starting the song...");
        context.setState(new PlayingState());
    }
}

// 3. Context
class PlayerContext {
    private State state;

    public PlayerContext() {
        state = new StoppedState(); // Başlangıç durumu
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPlay() {
        state.pressPlay(this);
    }
}

// 4. Client
public class StatePatternExample {
    public static void main(String[] args) {
        PlayerContext player = new PlayerContext();

        player.pressPlay(); // Stopped -> Playing
        player.pressPlay(); // Playing -> Paused
        player.pressPlay(); // Paused -> Playing
    }
}

