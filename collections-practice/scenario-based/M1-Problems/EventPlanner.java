package M1-Problems;

import java.util.*;

// Base class
abstract class Festival {
    String name;
    String location;
    String date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void displayDetails();
}

// MUSIC Festival
class MusicFestival extends Festival {
    String headliner;
    String musicGenre;
    int ticketPrice;

    MusicFestival(String name, String location, String date,
                  String headliner, String musicGenre, int ticketPrice) {
        super(name, location, date);
        this.headliner = headliner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    @Override
    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + musicGenre);
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

// FOOD Festival
class FoodFestival extends Festival {
    String cuisine;
    int numStalls;
    int entryFee;

    FoodFestival(String name, String location, String date,
                 String cuisine, int numStalls, int entryFee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    @Override
    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
    }
}

// ART Festival
class ArtFestival extends Festival {
    String artType;
    int numArtists;
    int exhibitionFee;

    ArtFestival(String name, String location, String date,
                String artType, int numArtists, int exhibitionFee) {
        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    @Override
    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: " + exhibitionFee);
    }
}

public class EventPlanner {
    private static Map<String, Festival> festivals = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("EXIT")) break;

            String[] parts = line.split("\\s+");
            String command = parts[0];

            if (command.equals("ADD_FESTIVAL")) {
                String type = parts[1];
                switch (type) {
                    case "MUSIC":
                        festivals.put(parts[2],
                            new MusicFestival(parts[2], parts[3], parts[4],
                                              parts[5], parts[6], Integer.parseInt(parts[7])));
                        break;
                    case "FOOD":
                        festivals.put(parts[2],
                            new FoodFestival(parts[2], parts[3], parts[4],
                                             parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
                        break;
                    case "ART":
                        festivals.put(parts[2],
                            new ArtFestival(parts[2], parts[3], parts[4],
                                            parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
                        break;
                }
            } else if (command.equals("DISPLAY_DETAILS")) {
                String name = parts[1];
                Festival f = festivals.get(name);
                if (f != null) {
                    f.displayDetails();
                }
            }
        }
        sc.close();
    }
}