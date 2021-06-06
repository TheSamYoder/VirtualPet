package virtual_pet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<VirtualPet> petStorage = new ArrayList<VirtualPet>();
        Scanner input = new Scanner(System.in);
        VirtualPet booleanPet = new VirtualPet();
        boolean petIsAlive = (booleanPet.getHungerLevel() < 100 && booleanPet.getBoredomLevel() < 100 && booleanPet.getTiredness() < 100 && booleanPet.getThirstLevel() < 100);
        //Greeting
        while (petIsAlive) {
            introduction();

            //User input for pets name
            String petName = input.nextLine();
            System.out.print("Tell us something about your pet: ");
            String petDescrip = input.nextLine();
            VirtualPet pet = new VirtualPet(petName, 50, 50, 50, 50, petDescrip);
            petStorage.add(pet);
            System.out.println();
            System.out.println("The goal of the game is to care for " + petName + " by keeping his stats low." +
                    "\nIf any of the stats reach 100, " + petName + " will die.");

            while (true) {
                Thread.sleep(3000);
                scoreBoard(pet);


                //Ask user what they'd like to do
                System.out.println("What would you like to do with " + petName + "?");
                System.out.println("1. Feed " + petName + ".");
                System.out.println("2. Give a drink of water to " + petName + ".");
                System.out.println("3. Play fetch with " + petName + ".");
                System.out.println("4. Have " + petName + " take a nap.");
                System.out.println("5. Surrender a new pet to the shelter.");
                System.out.print("Enter a number 1-5 to decide: ");


                //Get user choice
                //Update stats
                int careChoice = input.nextInt();
                input.nextLine();
                switch (careChoice) {
                    case 1:
                        Thread.sleep(1000);
                        pet.giveFood();
                        break;
                    case 2:
                        Thread.sleep(1000);
                        pet.giveWater();
                        break;
                    case 3:
                        Thread.sleep(1000);
                        pet.giveLove();
                        break;
                    case 4:
                        Thread.sleep(1000);
                        pet.giveSleep();
                        break;
                    case 5:
                        Thread.sleep(1000);
                       // petStorage.addNewPet
                }


                pet.tick();
                pet.petSelfCare();
                pet.petStatLimiter();

                if ((pet.getHungerLevel() >= 100) || (pet.getThirstLevel() >= 100) || (pet.getBoredomLevel() >= 100) || (pet.getTiredness() >= 100)) {
                    System.out.println("         .\n" +
                            "                   -|-\n" +
                            "                    |\n" +
                            "                .-'~~~`-.\n" +
                            "              .'         `.\n" +
                            "              |  R  I  P  |\n" +
                            "              |           |\n" +
                            "              |           |\n" +
                            "    \\       \\\\|           |//\n" +
                            "   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
                    System.out.println("R.I.P. " + petName);

                    break;
                }
            }
            System.out.println("Want to take another spin?:  Y/N");
            String yOrN = input.nextLine();
            if (yOrN.equalsIgnoreCase("Y")) {
                continue;
            }
            System.out.println("Thank you for playing!");
            break;
        }

        //Display new stats


    }

    private static void introduction() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("     |\\_/|                  \n" +
                "     | @ @   Woof! \n" +
                "     |   <>              _  \n" +
                "     |  _/\\------____ ((| |))\n" +
                "     |               `--' |   \n" +
                " ____|_       ___|   |___.' \n" +
                "/_/_____/____/_______|");
        Thread.sleep(1000);
        System.out.println("\nHello!");
        Thread.sleep(1000);
        System.out.println("Welcome to your Virtual Pet!");
        Thread.sleep(1000);
        System.out.print("Please input your pets name: ");
    }


    private static void scoreBoard(VirtualPet pet) {
        //Scoreboard stats

        System.out.println("\n----------------------------");
        System.out.println("|  How's your pet doing?   |");
        System.out.println("|--------------------------|");
        System.out.println("| Hunger: " + pet.getHungerLevel() + " --------------|");
        System.out.println("|--------------------------|");
        System.out.println("| Thirst: " + pet.getThirstLevel() + " --------------|");
        System.out.println("|--------------------------|");
        System.out.println("| Boredom: " + pet.getBoredomLevel() + " -------------|");
        System.out.println("|--------------------------|");
        System.out.println("| Tiredness: " + pet.getTiredness() + " -----------|");
        System.out.println("----------------------------");
    }

}
