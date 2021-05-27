package virtual_pet;

public class Stats {
    public String petTrait;
    public int level;
    public int compareVal;



    public Stats(String petTrait, int level){
        this.petTrait = petTrait;
        this.level = level;
        if(petTrait.equalsIgnoreCase("happiness")){
            compareVal = Math.abs(100 - level);
        }
        else{
            compareVal = level;
        }
    }

    public String getPetTrait() {
        return petTrait;
    }

    public int getLevel() {
        return level;
    }
}
