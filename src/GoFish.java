import java.util.Scanner;

public class GoFish {
    public static Scanner input = new Scanner(System.in);
    public GoFish(){}

    public static void main(String[] args) {
        boolean running = true;

        do {
            System.out.println("\n\n\n [1] Test Deck Hand Class\n" +
                    " [2] Play Go Fish\n[3] Exit");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    testDeck();
                    break;
                case 2:
                    new GoFishHand();
                    break;
                case 3:
                    running = false;
            }
        } while (running);

        System.out.println("Goodbye!");
    }

    public static void testDeck() {
        boolean runningF = true;

        do {
            System.out.println("Which Deck would you like to manipulate?\n" +
                    " [1] Empty Hand\n " +
                    " [2] Full Deck\n" +
                    "Enter the Corresponding number");
            int hand = input.nextInt();
            switch (hand) {
                case 1:
                    Deck emptyHand = new Deck();
                    runningF = testDeck(emptyHand);
                    break;
                case 2:
                    Deck fullDeck = new Deck();
                    fullDeck.fillDeck();
                    runningF = testDeck(fullDeck);
            }
        } while (runningF);


    }

    public static boolean testDeck(Deck deck) {
        boolean repDeckTest = true;

        do {
            System.out.println(" [1] Insert card\n" +
                    " [2] Delete card \n " +
                    " [3] Delete random card\n " +
                    " [4] Test number times a specific value happens\n " +
                    " [5] Print Total number of Cards in Deck\n " +
                    " [6] Display Entire Deck hand\n " +
                    " [7] Change/Restart Decks\n" +
                    " [8] Exit Test");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    System.out.println(" Please enter the Card ID you would like to insert \n"+
                            " Both Value and Suit are represented by Integers\n" +
                            "\tSuits:\n\t1 = Clubs\n\t2 = Diamonds\n\t3 = Hearts\n\t4 = Spades\nEnter the Integer Corresponding to the Suit");
                    int suit = input.nextInt();
                    System.out.println("Enter the Value for the Card: ");
                    int value = input.nextInt();
                    Card insert = new Card(value, suit);
                    deck.insertCard(insert);
                    System.out.println("Card inserted!");
                    break;
                case 2:
                    System.out.println("Which card Value would you like to Delete?\n" +
                            "Enter the Value: ");
                    int deleteVal = input.nextInt();
                    Card deleteCard = deck.deleteValue(deleteVal);

                    if (deleteCard == null) {
                        System.out.println("Card not found.");
                    } else {
                        System.out.println("Card Deleted: " + deleteCard);
                    }
                    break;
                case 3:
                    Card randomDelete = deck.deleteAnyCard();

                    if (randomDelete == null) {
                        System.out.println("You don't have anything on your hand");
                    } else {
                        System.out.println("Card deleted : " + randomDelete);
                    }
                    break;
                case 4:
                    System.out.println("Which value would you like Search for?");
                    int searchVal = input.nextInt();
                    int searchValue = deck.getCount(searchVal);
                    System.out.println("That value occurs " + searchValue + " times in the Deck Hand");
                    break;
                case 5:
                    System.out.println("Total number of Cards in Deck : " + deck.getSize());
                    break;
                case 6:
                    System.out.println(deck);
                    break;
                case 7:
                    repDeckTest = false;
                    return true;
                case 8:
                    repDeckTest = false;
                    return false;
            }
        } while (repDeckTest);

        return true;
    }
}
