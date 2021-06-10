import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrganicDogTest {
    private OrganicDog underTest;

    @BeforeEach
    public void setup() {
        underTest = new OrganicDog("TestDog");
    }

    @Test
    public void organicDogHasName() {
        assertEquals("TestDog", underTest.getName());
    }

    @Test
    public void organicDogShouldBeWalkable(){
        int initialBoredomLevel = underTest.getBoredom();
        underTest.walk();
        assertTrue(underTest.getBoredom() < initialBoredomLevel );
    }

    @Test
    public void organicDogShouldBeAbleToEat(){
        int initialHungerLevel = underTest.getHunger();
        underTest.eat();
        assertTrue(underTest.getHunger() < initialHungerLevel);
    }

    @Test
    public void organicDogHungerLevelShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.eat();
        }
        assertTrue(underTest.getHunger() == 0);
    }

    @Test
    public void organicDogShouldBeAbleToSleep(){
        int initialTirednessLevel = underTest.getTiredness();
        underTest.sleep();
        assertTrue(underTest.getTiredness() < initialTirednessLevel);

    }

    @Test
    public void organicDogTirednessShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.sleep();
        }
        assertTrue(underTest.getTiredness() == 0);
    }

    @Test
    public void organicDogShouldBeAbleToPlay(){
        int initialBoredom = underTest.getBoredom();
        underTest.play();
        assertTrue(underTest.getBoredom() < initialBoredom);
    }

    @Test
    public void organicDogBoredomShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.play();
        }
        assertTrue(underTest.getBoredom() == 0);
    }

    @Test
    public void organicDogShouldBeAbleToDrink(){
        int initialThirst = underTest.getThirst();
        underTest.drink();
        assertTrue(underTest.getThirst() < initialThirst);
    }

    @Test
    public void organicDogThirstShouldNeverGoBelowZero(){
        for(int i = 0; i < 20; i++){
            underTest.drink();
        }
        assertTrue(underTest.getThirst() == 0);
    }

}
