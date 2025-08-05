package Behavioral;
import java.util.*;

// 1. Aggregate (Koleksiyon) arayüzü
interface ChannelCollection {
    void addChannel(Channel c);
    void removeChannel(Channel c);
    ChannelIterator iterator();
}

// 2. Iterator arayüzü
interface ChannelIterator {
    boolean hasNext();
    Channel next();
}

// 3. Concrete Aggregate
class ChannelCollectionImpl implements ChannelCollection {
    private List<Channel> channelsList;

    public ChannelCollectionImpl() {
        channelsList = new ArrayList<>();
    }

    public void addChannel(Channel c) {
        channelsList.add(c);
    }

    public void removeChannel(Channel c) {
        channelsList.remove(c);
    }

    public ChannelIterator iterator() {
        return new ChannelIteratorImpl(channelsList);
    }
}

// 4. Concrete Iterator
class ChannelIteratorImpl implements ChannelIterator {
    private List<Channel> channelsList;
    private int position = 0;

    public ChannelIteratorImpl(List<Channel> channelsList) {
        this.channelsList = channelsList;
    }

    public boolean hasNext() {
        return position < channelsList.size();
    }

    public Channel next() {
        return channelsList.get(position++);
    }
}

// 5. Channel
class Channel {
    private double frequency;
    private String name;

    public Channel(double frequency, String name) {
        this.frequency = frequency;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Channel{" + "frequency=" + frequency + ", name='" + name + '\'' + '}';
    }
}

// 6. Client
public class IteratorPatternExample {
    public static void main(String[] args) {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, "Kanal 1"));
        channels.addChannel(new Channel(99.5, "Kanal 2"));
        channels.addChannel(new Channel(100.5, "Kanal 3"));

        ChannelIterator iterator = channels.iterator();
        while (iterator.hasNext()) {
            Channel c = iterator.next();
            System.out.println(c);
        }
    }
}

