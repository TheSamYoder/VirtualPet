package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    VirtualPet pet;

    @BeforeEach
    public void beforeAllTests(){
        pet = new VirtualPet("Name", 50, 50, 50, 50, "description");
    }

    @Test
    public void doesHungerChangeWhenGivenFood(){
        pet.giveFood();
        assertEquals(30,pet.getHungerLevel());
    }

    @Test
    public void doesThirstChangeWhenGivenWater(){
        pet.giveWater();
        assertEquals(30, pet.getThirstLevel());
    }

    @Test
    public void doesBoredomChangeWhenGivenLove(){
        pet.giveLove();
        assertEquals(30, pet.getBoredomLevel());
    }

    @Test
    public void doesTirednessChangeWhenGivenSleep(){
        pet.giveSleep();
        assertEquals(30, pet.getTiredness());
    }

    @Test
    public void doesTickChangeStatValuesOfPet(){
        pet.tick();
        assertEquals(57, pet.getHungerLevel());
        assertEquals(57, pet.getThirstLevel());
        assertEquals(57, pet.getBoredomLevel());
        assertEquals(57, pet.getTiredness());
    }
    @Test
    public void doesStatsStopAtZero() {
        for(int i = 0; i<3;i++) {
            pet.giveSleep();
            pet.giveFood();
            pet.giveLove();
            pet.giveWater();
        }
        pet.petStatLimiter();
        assertEquals(0, pet.getHungerLevel());
        assertEquals(0, pet.getThirstLevel());
        assertEquals(0, pet.getBoredomLevel());
        assertEquals(0, pet.getTiredness());
    }


}
