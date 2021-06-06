package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelter {
    ArrayList<VirtualPet> petStorage = new ArrayList<VirtualPet>();

    public void admit(VirtualPet pet){
        petStorage.add(new VirtualPet(pet.getPetName(),pet.getDescription()));
    }


   public void feedAll(){
        for(VirtualPet petsNeedFood: petStorage.size()){
            petsNeedFood.giveFood();
        }
   }


}

