
package virtual_pet;

import java.util.Random;

public class VirtualPet {

    private String petName;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private int tiredness;
    private String description;

    public VirtualPet() {
    }

    public VirtualPet(String petName, String description) {
        this.petName = petName;
        this.description = description;
    }

    public VirtualPet(String petName, int hungerLevel, int thirstLevel, int boredomLevel, int tiredness, String description) {
        this.petName = petName;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
        this.tiredness = tiredness;
        this.description = description;
    }

    // Getters
    public String getPetName() {
        return petName;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public int getTiredness() {
        return tiredness;
    }

    public String getDescription() {
        return description;
    }


    public void giveFood() {
        hungerLevel -=  20;
    }

    public void giveWater() {
        thirstLevel -= 20;
    }

    public void giveLove() {
        System.out.println("\nYou give " + petName + " some love.");
        boredomLevel -= 20;
    }

    public void giveSleep() {
        System.out.println("\nYou give " + petName + " some sleep.");
        tiredness -= 20;
    }

    public void tick() {
        hungerLevel += 7;
        thirstLevel += 7;
        boredomLevel += 7;
        tiredness += 7;
    }

    public void petStatLimiter() {
        if (hungerLevel < 0) {
            hungerLevel = 0;
        } else if (hungerLevel > 80) {
            System.out.println("\n" + petName + " is begging for food!");
        }


        if (thirstLevel < 0) {
            thirstLevel = 0;
        } else if (thirstLevel > 80) {
            System.out.println("\n" + petName + " is begging for a drop of water!");
        }


        if (boredomLevel < 0) {
            boredomLevel = 0;
        } else if (boredomLevel > 80) {
            System.out.println("\n" + petName + " is dying of boredom... literally!");
        }


        if (tiredness < 0) {
            tiredness = 0;
        } else if (tiredness > 80) {
            System.out.println("\n" + petName + " is exhausted and needs a rest!");
        }
    }

    public void petSelfCare() {
        //In the next section we find the lowest stat and then set the lowest stat value associated to binary math
        //i.e. if happiness is the lowest we get a 1, if hunger is the lowest we get a 4, if happiness AND hunger are
        //both equally low, it will return 5 (1+4)
        //compares to see if happiness is the weakest stat by itself
        Random randomNumber = new Random();
        int upperbound = 10;
        //generate a random value between 0-9
        int chance = randomNumber.nextInt(upperbound);
        if (chance == 9) {
            //Happiness + Tiredness + Hunger + Thirst
            if (boredomLevel == tiredness && boredomLevel == hungerLevel && boredomLevel == thirstLevel) {
                System.out.println(petName + " also finds peace in life.");
                boredomLevel = (boredomLevel + 3);
                tiredness = (tiredness - 3);
                hungerLevel = (hungerLevel - 3);
                thirstLevel = (thirstLevel - 3);
            }
            //Happiness + Tiredness + Hunger
            else if (boredomLevel == tiredness && boredomLevel == hungerLevel && boredomLevel > thirstLevel) {
                System.out.println(petName + " also has wonderful dreams of beef jerky.");
                boredomLevel = (boredomLevel + 4);
                tiredness = (tiredness - 4);
                hungerLevel = (hungerLevel - 4);
            }
            //Happiness + Tiredness + Thirst
            else if (boredomLevel == tiredness && boredomLevel > hungerLevel && boredomLevel == thirstLevel) {
                System.out.println(petName + " also has wonderful dreams of swimming in a pond.");
                boredomLevel = (boredomLevel + 4);
                tiredness = (tiredness - 4);
                thirstLevel = (thirstLevel - 4);
            }
            //Happiness + Hunger + Thirst
            else if (boredomLevel > tiredness && boredomLevel == hungerLevel && boredomLevel == thirstLevel) {
                System.out.println(petName + " also finds extra lunch laying around!");
                boredomLevel = (boredomLevel + 4);
                hungerLevel = (hungerLevel - 4);
                thirstLevel = (thirstLevel - 4);
            }
            //Tiredness + Hunger + Thirst
            else if (tiredness > boredomLevel && tiredness == hungerLevel && tiredness == thirstLevel) {
                System.out.println(petName + " also finds an energy drink and energy bar on the counter.");
                tiredness = (tiredness - 4);
                hungerLevel = (hungerLevel - 4);
                thirstLevel = (thirstLevel - 4);
            }
            //Happiness + Tiredness
            else if (boredomLevel == tiredness && boredomLevel > hungerLevel && boredomLevel > thirstLevel) {
                System.out.println(petName + " also takes a quick nap with his favorite toy.");
                boredomLevel = (boredomLevel + 5);
                tiredness = (tiredness - 5);
            }
            //Happiness + Hunger
            else if (boredomLevel > tiredness && boredomLevel == hungerLevel && boredomLevel > thirstLevel) {
                System.out.println(petName + " is also delighted to find a treat under the couch!");
                boredomLevel = (boredomLevel + 5);
                hungerLevel = (hungerLevel - 5);
            }
            //Happiness + Thirst
            else if (boredomLevel > tiredness && boredomLevel > hungerLevel && boredomLevel == thirstLevel) {
                System.out.println(petName + " also finds that the toilet seat is left up!");
                boredomLevel = (boredomLevel + 5);
                thirstLevel = (thirstLevel - 5);
            }
            //Tiredness + Hunger
            else if (tiredness > boredomLevel && tiredness == hungerLevel && tiredness > thirstLevel) {
                System.out.println(petName + " also finds an energy bar you left on the counter.");
                tiredness = (tiredness - 5);
                hungerLevel = (hungerLevel - 5);
            }
            //Tiredness + Thirst
            else if (tiredness > boredomLevel && tiredness > hungerLevel && tiredness == thirstLevel) {
                System.out.println(petName + " also finds an energy drink you left on the counter.");
                tiredness = (tiredness - 5);
                thirstLevel = (thirstLevel - 5);
            }
            //Hunger + Thirst
            else if (hungerLevel > boredomLevel && hungerLevel > tiredness && hungerLevel == thirstLevel) {
                System.out.println(petName + " also plays with a bone to cheer up!");
                thirstLevel = (thirstLevel - 5);
                hungerLevel = (hungerLevel - 5);
            } else if (boredomLevel > tiredness && boredomLevel > hungerLevel && boredomLevel > thirstLevel) {
                System.out.println(petName + " also plays with a bone to cheer up!");
                boredomLevel = (boredomLevel + 10);
            }
            //compares to see if tiredness is the weakest stat by itself
            else if (tiredness > boredomLevel && tiredness > hungerLevel && tiredness > thirstLevel) {
                System.out.println(petName + " also falls asleep watching the nature channel.");
                tiredness = (tiredness - 10);
            }
            //compares to see if hunger is the weakest stat by itself
            else if (hungerLevel > boredomLevel && hungerLevel > tiredness && hungerLevel > thirstLevel) {
                System.out.println(petName + " also finds some food that fell out of the bowl!");
                hungerLevel = (hungerLevel - 10);
            }
            //compares to see if thirst is the weakest stat by itself
            else if (thirstLevel > boredomLevel && thirstLevel > tiredness && thirstLevel > hungerLevel) {
                System.out.println(petName + " also takes a pit stop at the water bowl.");
                thirstLevel = (thirstLevel - 10);
            }
        }
    }


}