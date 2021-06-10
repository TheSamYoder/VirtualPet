public class RoboticPet extends VirtualPet implements Playable{
    protected int battLevel;
    protected int conditionLevel;

    public RoboticPet(String name) {
        super(name);
        this.battLevel = 50;
        this.conditionLevel = 50;
    }

    public int getBattLevel() {
        return battLevel;
    }

    public int getConditionLevel() { return conditionLevel;}

    public void charge(){
        battLevel = 100;
    }

    public void maintenance() {
        conditionLevel += 40;
        if(conditionLevel > 100) {
            conditionLevel = 100;
        }
    }

    @Override
    public void play() {
        battLevel -=30;
        conditionLevel -= 30;
    }
}
