//Sarai Misidjan
//Programma om je playlist met titel en lengte mee te geven.
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Playlist {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> titels = new ArrayList<String>();
    ArrayList<Integer> lengths = new ArrayList<Integer>();
    int tracks = 0;

    //Get total amount of tracks and validate the users input.
    public void tracks() {
        boolean validInput = false;

        // do while function for validating the users input.
        // keeps asking until the input is an int from 2 till 20.
        do {
            System.out.println("Hoeveel tracks staan er op de playlist? Vul een getal van 2 tot en met 20 in.");
            try {
                tracks = Integer.parseInt(scanner.nextLine());
                if (tracks < 2 || tracks > 20) {
                    System.out.println("Dit is geen getal van 2 tot en met 20.");
                }
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Vul eem getal in.");
            }
        } while (!validInput || tracks < 2 || tracks > 20);
    }

    // function where the user can enter the title of the tracks
    public void titles() {
        int i = 0;

        do {
            System.out.println("Wat is de title van track " + (i + 1));
            titels.add(scanner.nextLine());
            i++;
        } while (i < tracks);
    }

    // function where the user can enter the length of the tracks
    public void length() {
        int i = 0;

        do {
            System.out.println("Wat is de lengte van " + titels.get(i) + ". Vul de lengte in secondes in.");
            lengths.add(scanner.nextInt());
            i++;
        } while (i < tracks);
    }

    // function where the user gets the total length and the title with the highest length
    public void totalLength() {
        int tot = 1;

        for (Integer length : lengths) {
            tot = tot + length;
        }

        int highestNumber = Collections.max(lengths);
        int index = lengths.indexOf(highestNumber);
        String titleOfHighestNumber = titels.get(index);

        System.out.println("De totale duur van de playlist is " + tot + " seconden. De langste track is: " + titleOfHighestNumber);
    }

    // function where the user gets the title with seconds.
    public void totalInfo() {
        System.out.println("De playlist bestaat uit de volgende nummers:");
        int i = 0;

        for (String title : titels) {
            System.out.println(title + ": " + lengths.get(i) + " seconden");
            i++;
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        System.out.println("Sarai Misidjan, 500882350");

        playlist.tracks();
        playlist.titles();
        playlist.length();
        playlist.totalLength();
        playlist.totalInfo();
    }
}
