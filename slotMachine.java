import java.util.Scanner;

public class slotMachine {
    private int chips; // in dollars

    public slotMachine() {
        chips = 2000;
    }

    // returns true if bet goes through, false if illegal bet
    // this return isnt even needed for the program
    public boolean bet(int bet) {
        if (bet > chips || bet < 0) {
            System.out.println(
        "Illegal Bet! (you bet more than you had or bet a negative amount of chips)"
            );
            return false;
        }
        System.out.println("You Bet: $"+bet);
        
        int num1 = (int)(Math.random()*6) + 2;
        int num2 = (int)(Math.random()*6) + 2;
        int num3 = (int)(Math.random()*6) + 2;
        System.out.println("Rolls: "+num1+", "+num2+", "+num3);

        if (num1 == 7 && num2 == 7 && num3 == 7) {
            chips += bet * 10;
            System.out.println("777 woohoo bet x10");
        }
        else if (num1 == num2 && num2 == num3) {
            chips += bet * 5;
            System.out.println("3 of the same :D bet x5");
        }
        else if (num1 == num2 || num2 == num3 || num3 == num1) {
            chips += bet * 3;
            System.out.println("2 of the same yay bet x3");
        }
        else {
            chips -= bet;
            System.out.println("no win :( you lost your bet");
        }
        System.out.println("Current Chip Count (after bet): $" + chips);
        return true;
    }
    
    public void mainMenu() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Player's Chips: $" + chips);
        System.out.println();
        System.out.println("1) Play Slots");
        System.out.println("2) Credits");
        System.out.println("3) Quit Slot Machine");
        System.out.println();
        System.out.println("What would you like to do? (enter a number): ");
        String input = scan.nextLine();
        if (input.equals("1")) {
            System.out.println();
            System.out.println(
                "Bet Amount? (must be less than your current chips and positive): "
            );
            input = scan.nextLine();
            System.out.println();
            bet(Integer.parseInt(input));
            System.out.println();
            mainMenu();
        }
        if (input.equals("2")) {
            System.out.println();
            mainMenu();
        }
        if (input.equals("3")) {
            System.out.println();
            System.out.println("Goodbye :(");
        }
    }
}