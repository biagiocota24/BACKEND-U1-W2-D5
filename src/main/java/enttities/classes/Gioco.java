package enttities.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Gioco {
    private static final AtomicLong counter = new AtomicLong(1);
    private long gameId;
    private String title;
    private int releaseYear;
    private double price;

    public Gioco(String title, double price) {
        this.gameId = counter.getAndIncrement();
        this.title = title;
        this.releaseYear = LocalDate.now().getYear();
        this.price = price;
    }

    public long getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "gameId=" + gameId +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                '}';
    }
}
