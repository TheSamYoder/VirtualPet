import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrganicCatTest {
    private OrganicCat underTest;

    @BeforeEach
    public void setup() {
        underTest = new OrganicCat("TestCat");
    }

    @Test
    public void organicCatHasName(){
        assertEquals("TestCat", underTest.getName());
    }

    @Test
    public void organicCatShouldBeAbleToEat(){
        int initialHungerLevel = underTest.getHunger();
        underTest.eat();
        assertTrue(underTest.getHunger() < initialHungerLevel);
    }

    @Test
    public void organicCatHungerLevelShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.eat();
        }
        assertTrue(underTest.getHunger() == 0);
    }

    @Test
    public void organicCatShouldBeAbleToSleep(){
        int initialTirednessLevel = underTest.getTiredness();
        underTest.sleep();
        assertTrue(underTest.getTiredness() < initialTirednessLevel);
    }

    @Test
    public void organicCatTirednessShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.sleep();
        }
        assertTrue(underTest.getTiredness() == 0);
    }

    @Test
    public void organicCatShouldBeAbleToPlay(){
        int initialBoredom = underTest.getBoredom();
        underTest.play();
        assertTrue(underTest.getBoredom() < initialBoredom);
    }

    @Test
    public void organicCatBoredomShouldNeverGoBelowZero(){
        for(int i =0; i < 20; i++){
            underTest.play();
        }
        assertTrue(underTest.getBoredom() == 0);
    }

    @Test
    public void organicCatShouldBeAbleToDrink(){
        int initialThirst = underTest.getThirst();
        underTest.drink();
        assertTrue(underTest.getThirst() < initialThirst);
    }

    @Test
    public void organicCatThirstShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.drink();
        }
        assertTrue(underTest.getThirst() == 0);
    }



}