package virtual_pet;

import java.util.Random;

public class VirtualPet {

    private String petName;
    private int hunger;
    private int thirst;
    private int tiredness;
    private int happiness;


    public VirtualPet(String petName, int hunger, int thirst, int tiredness, int happiness) {
        this.petName = petName;
        this.hunger = hunger;
        this.thirst = thirst;
        this.tiredness = tiredness;
        this.happiness = happiness;
    }

    public String getPetName() {
        return petName;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getHappiness() {
        return happiness;
    }

    public void feedingTime() {
        System.out.println("You give " + petName + " some kibble.");
        hunger = (hunger - 20);
    }

    public void giveWater() {
        System.out.println("You give " + petName + " some water.");
        thirst = (thirst - 20);
    }

    public void playTime() {
        System.out.println("You play a riveting game of TicTacToe with " + petName + ".");
        happiness = (happiness + 20);
    }

    public void goToBed() {
        System.out.println("You give " + petName + " his favorite stuffed toy for a nap.");
        tiredness = (tiredness - 20);
    }

    public void dejectedPet() {
        System.out.println(petName + " stares at you dejectedly.");
        happiness = (happiness - 20);
    }

    public void tick() {
        happiness = (happiness - 7);
        tiredness = (tiredness + 7);
        thirst = (thirst + 7);
        hunger = (hunger + 7);
        petSelfCare();
        petStatLimiter();
/*
        Stats hungerStat = new Stats("hunger", hunger);
        Stats thirstStat = new Stats("thirst", thirst);
        Stats tirednessStat = new Stats("tiredness", tiredness);
        Stats happinessStat = new Stats("happiness", happiness);
        ArrayList<Stats> traitsList = new ArrayList<Stats>();
        traitsList.add(happinessStat);
        traitsList.add(hungerStat);
        traitsList.add(thirstStat);
        traitsList.add(tirednessStat);

        traitsList.sort(new StatSorter());
        System.out.println(traitsList);
*/


    }

    private void petStatLimiter() {
        if (happiness > 100){
            happiness = 100;
        }
        if (tiredness < 0){
            tiredness = 0;
        }
        if (thirst < 0){
            thirst = 0;
        }
        if (hunger < 0){
            hunger = 0;
        }
    }

    private void petSelfCare() {
        //sets happiness to a value in line with the other 3 stats (0 being good and 100 being bad)
        int happinessComparer = Math.abs(happiness - 100);
        //In the next section we find the lowest stat and then set the lowest stat value associated to binary math
        //i.e. if happiness is the lowest we get a 1, if hunger is the lowest we get a 4, if happiness AND hunger are
        //both equally low, it will return 5 (1+4)
        //compares to see if happiness is the weakest stat by itself
        Random randomNumber = new Random();
        int upperbound = 5;
        //generate a random value between 0-9
        int chance = randomNumber.nextInt(upperbound);
        if (chance == 4) {
            //Happiness + Tiredness + Hunger + Thirst
            if (happinessComparer == tiredness && happinessComparer == hunger && happinessComparer == thirst) {
                System.out.println(petName + " also finds peace in life.");
                happiness = (happiness + 3);
                tiredness = (tiredness - 3);
                hunger = (hunger - 3);
                thirst = (thirst -3);
            }
            //Happiness + Tiredness + Hunger
            else if (happinessComparer == tiredness && happinessComparer == hunger && happinessComparer > thirst) {
                System.out.println(petName + " also has wonderful dreams of beef jerky.");
                happiness = (happiness + 4);
                tiredness = (tiredness - 4);
                hunger = (hunger - 4);
            }
            //Happiness + Tiredness + Thirst
            else if (happinessComparer == tiredness && happinessComparer > hunger && happinessComparer == thirst) {
                System.out.println(petName + " also has wonderful dreams of swimming in a pond.");
                happiness = (happiness + 4);
                tiredness = (tiredness - 4);
                thirst = (thirst - 4);
            }
            //Happiness + Hunger + Thirst
            else if (happinessComparer > tiredness && happinessComparer == hunger && happinessComparer == thirst) {
                System.out.println(petName + " also finds extra lunch laying around!");
                happiness = (happiness + 4);
                hunger = (hunger - 4);
                thirst = (thirst - 4);
            }
            //Tiredness + Hunger + Thirst
            else if (tiredness > happinessComparer && tiredness == hunger && tiredness == thirst) {
                System.out.println(petName + " also finds an energy drink and energy bar on the counter.");
                tiredness = (tiredness - 4);
                hunger = (hunger - 4);
                thirst = (thirst - 4);
            }
            //Happiness + Tiredness
            else if (happinessComparer == tiredness && happinessComparer > hunger && happinessComparer > thirst) {
                System.out.println(petName + " also takes a quick nap with his favorite toy.");
                happiness = (happiness + 5);
                tiredness = (tiredness - 5);
            }
            //Happiness + Hunger
            else if (happinessComparer > tiredness && happinessComparer == hunger && happinessComparer > thirst) {
                System.out.println(petName + " is also delighted to find a treat under the couch!");
                happiness = (happiness + 5);
                hunger = (hunger - 5);
            }
            //Happiness + Thirst
            else if (happinessComparer > tiredness && happinessComparer > hunger && happinessComparer == thirst) {
                System.out.println(petName + " also finds that the toilet seat is left up!");
                happiness = (happiness + 5);
                thirst = (thirst - 5);
            }
            //Tiredness + Hunger
            else if (tiredness > happinessComparer && tiredness == hunger && tiredness > thirst) {
                System.out.println(petName + " also finds an energy bar you left on the counter.");
                tiredness = (tiredness - 5);
                hunger = (hunger - 5);
            }
            //Tiredness + Thirst
            else if (tiredness > happinessComparer && tiredness > hunger && tiredness == thirst) {
                System.out.println(petName + " also finds an energy drink you left on the counter.");
                tiredness = (tiredness - 5);
                thirst = (thirst - 5);
            }
            //Hunger + Thirst
            else if (hunger > happinessComparer && hunger > tiredness && hunger == thirst) {
                System.out.println(petName + " also plays with a bone to cheer up!");
                thirst = (thirst - 5);
                hunger = (hunger - 5);
            }
            else if (happinessComparer > tiredness && happinessComparer > hunger && happinessComparer > thirst) {
                System.out.println(petName + " also plays with a bone to cheer up!");
                happiness = (happiness + 10);
            }
            //compares to see if tiredness is the weakest stat by itself
            else if (tiredness > happinessComparer && tiredness > hunger && tiredness > thirst) {
                System.out.println(petName + " also falls asleep watching the nature channel.");
                tiredness = (tiredness - 10);
            }
            //compares to see if hunger is the weakest stat by itself
            else if (hunger > happinessComparer && hunger > tiredness && hunger > thirst) {
                System.out.println(petName + " also finds some food that fell out of the bowl!");
                hunger = (hunger - 10);
            }
            //compares to see if thirst is the weakest stat by itself
            else if (thirst > happinessComparer && thirst > tiredness && thirst > hunger) {
                System.out.println(petName + " also takes a pit stop at the water bowl.");
                thirst = (thirst - 10);
            }
        }
    }
}
