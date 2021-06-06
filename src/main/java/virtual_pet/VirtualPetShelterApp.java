package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);
        while(playAgain) {
            System.out.println("Welcome to the pet shelter! We have many friends here that may interest you. Take a look and see what you think of them.");

            ArrayList<VirtualPet> shelterPets = new ArrayList<VirtualPet>();

            VirtualPet pet1 = new VirtualPet("Bruce", 50, 50, 50,
                    50, "He's a ghost cat that loves ghost mice.");
            VirtualPet pet2 = new VirtualPet("Wally", 50, 50, 50,
                    50, "A large parrot, won't stop talking.");
            VirtualPet pet3 = new VirtualPet("William", 50, 50, 50,
                    50, "A small goat who just tries to make friends.");
            VirtualPet pet4 = new VirtualPet("Fred", 50, 50, 50,
                    50, "An owl, very boring, just sits.");

            shelterPets.add(pet1);
            shelterPets.add(pet2);
            shelterPets.add(pet3);
            shelterPets.add(pet4);

            for (VirtualPet shelterPet : shelterPets) {
                System.out.println(shelterPet.getPetName() + ". " + shelterPet.getDescription());
            }
            while (shelterPets.size() > 0) {
                System.out.println("----------------------------------------");
                for (VirtualPet shelterPet : shelterPets) {
                    System.out.println(shelterPet.getPetName() + "\t|\t" + shelterPet.getHungerLevel() + "\t|\t" + shelterPet.getThirstLevel() + "\t|\t" + shelterPet.getBoredomLevel() + "\t|\t" + shelterPet.getTiredness() + "\t|");
                }
                System.out.println("----------------------------------------");


                System.out.println("Choose an option:");

                System.out.println("1. Feed pets.");
                System.out.println("2. Water pets.");
                System.out.println("3. Play with a pet.");
                System.out.println("4. Lay pets down for a nap.");
                System.out.println("5. Admit a new pet to the shelter.");
                System.out.println("6. Adopt a pet out to a home.");

                scan.nextLine();

                int careChoice = scan.nextInt();
                scan.nextLine();
                switch (careChoice) {
                    case 1:
                        shelterPets.feedAll();
                        break;
                    case 2:
                        shelterPets.waterAll();
                        break;
                    case 3:
                        shelterPets.play();
                        break;
                    case 4:
                        shelterPets.napAll();
                        break;
                    case 5:
                        shelterPets.admit();
                        break;
                    case 6:
                        shelterPets.adopt();
                        break;
                }

                System.out.println("Congratulations!\nAll the pets have been adopted!\n");
                System.out.println("Would you like to play again? Y/N");
                String yOrN = scan.nextLine();
                if (yOrN.equalsIgnoreCase("Y")) {
                    playAgain = true;
                    break;
                } else {
                    playAgain = false;
                    break;
                }
            }
        }
        System.out.println("Thank you for playing!");
    }


}
