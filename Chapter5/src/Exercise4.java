import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = new Card();
        int myCards;
        boolean repeat = true;
        int num = 2 + (int) (Math.random() * 5);

//        System.out.println(num);
        Scanner input = new Scanner(System.in);
        do {
            deck.shuffle();
            BlackjackHand bHand = new BlackjackHand();
            myCards = 2 + (int) (Math.random() * 5);
            System.out.println("The random number between 2-6 is: " + myCards);
            System.out.println("The current had has:");

            for (int i = 1; i <= myCards; i++) {
                card = deck.dealCard();
//                System.out.println("Card dealt = " + card);
                bHand.addCard(card);
                System.out.println(card);
            }
            System.out.println("The current hand value is " + bHand.getBlackjackValue());
            System.out.println("Do you want to try again? y/n");
            String userChoice = input.next();
            if (userChoice.equals("n")){
                repeat = false;
                System.out.println("Thanks for playing.");
            };
        } while (repeat == true) ;

        }
    }