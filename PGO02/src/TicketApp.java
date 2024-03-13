import java.util.Scanner;

class TicketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kolejno: imię, wiek, czy jesteś mieszkańcem Warszawy? (tak/nie), czy bilet został zakupiony w czwartek? (tak/nie)");

        String name = scanner.next();
        int age = scanner.nextInt();
        boolean residentOfWarsaw = scanner.next().equalsIgnoreCase("tak");
        boolean purchasedOnThursday = scanner.next().equalsIgnoreCase("tak");

        double ticketPrice = calculateTicketPrice(age, residentOfWarsaw, purchasedOnThursday);
        displayTicketInformation(name, age, residentOfWarsaw, purchasedOnThursday, ticketPrice);
    }

    public static double calculateTicketPrice(int age, boolean residentOfWarsaw, boolean purchasedOnThursday) {
        double basePrice = 40.0;
        double ticketPrice = basePrice;

        if (age < 10) {
            ticketPrice = 0;
        } else if (age >= 10 && age <= 18) {
            ticketPrice /= 2;
        }

        if (residentOfWarsaw) {
            ticketPrice *= 0.9;
        }

        if (purchasedOnThursday) {
            ticketPrice = 0;
        }

        return ticketPrice;
    }

    public static void displayTicketInformation(String name, int age, boolean residentOfWarsaw, boolean purchasedOnThursday, double ticketPrice) {
        System.out.println("Dane klienta:");
        System.out.println("Imię: " + name);
        System.out.println("Wiek: " + age);
        System.out.println("Mieszkaniec Warszawy: " + (residentOfWarsaw ? "Tak" : "Nie"));
        System.out.println("Kupiony w czwartek: " + (purchasedOnThursday ? "Tak" : "Nie"));
        System.out.println("Cena biletu po zniżce: " + ticketPrice + " PLN");
    }
}

