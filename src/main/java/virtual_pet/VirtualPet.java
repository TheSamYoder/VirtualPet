package virtual_pet;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
        //lowestStatDecider();
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


    }





    private void lowestStatDecider() {
        //sets happiness to a value in line with the other 3 stats (0 being good and 100 being bad)
        int happinessComparer = Math.abs(happiness - 100);
        int lowestStat = 0;

        //In the next section we find the lowest stat and then set the lowest stat value associated to binary math
        //i.e. if happiness is the lowest we get a 1, if hunger is the lowest we get a 4, if happiness AND hunger are
        //both equally low, it will return 5 (1+4)
        //compares to see if happiness is the weakest stat by itself
        if(happinessComparer < tiredness && happinessComparer < hunger && happinessComparer < thirst){
            lowestStat = 1;
        }
        //compares to see if tiredness is the weakest stat by itself
        if(tiredness < happinessComparer && tiredness < hunger && tiredness < thirst){
            lowestStat = 2;
        }
        //compares to see if hunger is the weakest stat by itself
        if(hunger < happinessComparer && hunger < tiredness && hunger < thirst){
            lowestStat = 4;
        }
        //compares to see if thirst is the weakest stat by itself
        if(thirst < happinessComparer && thirst < tiredness && thirst < hunger){
            lowestStat = 8;
        }
        //Happiness + Tiredness
        if(happinessComparer == tiredness && happinessComparer < hunger && happinessComparer < thirst){
            lowestStat = 3;
        }
        //Happiness + Hunger
        if(happinessComparer < tiredness && happinessComparer == hunger && happinessComparer < thirst){
            lowestStat = 5;
        }
        //Happiness + Thirst
        if(happinessComparer < tiredness && happinessComparer < hunger && happinessComparer == thirst){
            lowestStat = 9;
        }
        //Happiness + Tiredness + Hunger
        if(happinessComparer == tiredness && happinessComparer == hunger && happinessComparer < thirst){
            lowestStat = 7;
        }
        //Happiness + Tiredness + Thirst
        if(happinessComparer == tiredness && happinessComparer < hunger && happinessComparer == thirst){
            lowestStat = 11;
        }
        //Happiness + Hunger + Thirst
        if(happinessComparer < tiredness && happinessComparer == hunger && happinessComparer == thirst){
            lowestStat = 13;
        }
        //Happiness + Tiredness + Hunger + Thirst
        if(happinessComparer == tiredness && happinessComparer == hunger && happinessComparer == thirst){
            lowestStat = 15;
        }
        //Tiredness + Hunger
        if(tiredness < happinessComparer && tiredness == hunger && tiredness < thirst){
            lowestStat = 6;
        }
        //Tiredness + Thirst
        if(tiredness < happinessComparer && tiredness < hunger && tiredness == thirst){
            lowestStat = 10;
        }
        //Hunger + Thirst
        if(hunger < happinessComparer && hunger < tiredness && hunger == thirst){
            lowestStat = 12;
        }
        //Tiredness + Hunger + Thirst
        if(tiredness < happinessComparer && tiredness == hunger && tiredness == thirst){
            lowestStat = 14;
        }
    }
}
