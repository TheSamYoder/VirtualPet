package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //Game opens with an ascii dog, welcomes you to the game, asks for user input for name.
            System.out.println("     |\\_/|                  \n" +
                            "     | @ @   Woof! \n" +
                            "     |   <>              _  \n" +
                            "     |  _/\\------____ ((| |))\n" +
                            "     |               `--' |   \n" +
                            " ____|_       ___|   |___.' \n" +
                            "/_/_____/____/_______|");
            System.out.print("Hello! \nWelcome to your Virtual Pet! \nPlease input your pets name: ");
            String petName = scanner.nextLine();

            //Display initial pet stats to player
            VirtualPet pet = new VirtualPet(petName, 32, 20, 85, 70);
            scoreBoard(pet);
            System.out.println("If Happiness reaches 0, or Tiredness/Hunger/Thirst reaches 100," + petName + " dies.\n");

            //Ask user what they would like to do with their pet in a list format with options
            System.out.println("These are a few of the things you can do with " + petName +
                    ".\nEach one will effect a different stat.");
            while (true) {
                //displays user options
                userChoices(scanner, pet);

                //takes in player choice and changes scoreboard values
                choiceOutcomes(scanner, pet);

                pet.tick();
                //display new current stats
                scoreBoard(pet);
                if (pet.getHappiness() <= 0 || pet.getTiredness() >= 100 || pet.getHunger() >= 100 || pet.getThirst() >= 100) {
                    break;
                }
            }
            System.out.println("I'm sorry, " + petName + " has died.");
            System.out.print("Would you like to play again? Y/N : ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                continue;
            } else if (input.equalsIgnoreCase("N")) {
                System.out.println("Thank you for playing!");
                break;
            }

        }
    }

    private static void choiceOutcomes(Scanner scanner, VirtualPet pet) {
        System.out.print("Pick a number between 1-5 that matches what you like to do with " + pet.getPetName() + ": ");
        int careChoice = scanner.nextInt();
        scanner.nextLine();


        //Based on that choice, return a message, and move stats accordingly
        switch (careChoice) {
            case 1:
                pet.playTime();
                break;
            case 2:
                pet.goToBed();
                break;
            case 3:
                pet.feedingTime();
                break;
            case 4:
                pet.giveWater();
                break;
            case 5:
                pet.dejectedPet();
                break;
        }
    }

    private static void scoreBoard(VirtualPet pet) {
        System.out.println();
        System.out.println("|-----------|    Current Stats   |--------|");
        System.out.println("|-----------|-----------|--------|--------|");
        System.out.println("| Happiness | Tiredness | Hunger | Thirst |");
        System.out.println("|-----------|-----------|--------|--------|");
        System.out.println("|     " + pet.getHappiness() + "    |     " + pet.getTiredness() + "    |   " + pet.getHunger() + "   |   " + pet.getThirst() + "   |");
        System.out.println("|-----------|-----------|--------|--------|");
    }

    private static void userChoices(Scanner scanner, VirtualPet pet) {
        System.out.println("1. Play a game with " + pet.getPetName() + ".");
        System.out.println("2. Let " + pet.getPetName() + " take a nap.");
        System.out.println("3. Feed " + pet.getPetName() + ".");
        System.out.println("4. Give water to " + pet.getPetName() + ".");
        System.out.println("5. Leave " + pet.getPetName() + " alone.\n");
    }

}
