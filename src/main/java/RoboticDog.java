public class RoboticDog extends RoboticPet implements Walkable{
    public RoboticDog(String name) {
        super(name);
    }

    @Override
    public void walk() {
        battLevel -= 40;
        conditionLevel -=20;
    }
}
