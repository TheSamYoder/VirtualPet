package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PetShelterTest {
    VirtualPetShelter newShelter;
    ArrayList underTest;
    @BeforeEach
        public void beforeAllTests(){
            newShelter = new VirtualPetShelter();
            underTest = newShelter.petStorage;
    }

    @Test
    public void shouldAddPetToShelter(){
        underTest.add("Cat");
        assertTrue(underTest.size() !=0);

    }

    @Test
    public void returnAllPetsInShelter(){
        underTest.add("Bruce");
        underTest.add("Fred");
        underTest.add("Mow");
        //assertEquals(Arrays.asList("Bruce", "Fred", "Mow"), petStorage);
        assertTrue(underTest.contains("Bruce")&& underTest.contains("Fred")&& underTest.contains("Mow"));

       }

    @Test
    public void doesVirtualPetShelterClassExist() {
        VirtualPetShelter newShelter = new VirtualPetShelter();
    }

//    @Test
//    public void allAnimalsAreFed() {
//        underTest.feedAll();
//        assertEquals();
//        }
//    }

}


