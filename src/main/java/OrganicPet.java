public class OrganicPet extends VirtualPet implements Playable {
    protected int hunger;
    protected int tiredness;
    protected int boredom;
    protected int thirst;

    public OrganicPet(String name) {
        super(name);
        this.hunger = 50;
        this.tiredness = 50;
        this.boredom = 50;
        this.thirst = 50;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {return tiredness; }

    public int getBoredom() {return boredom; }

    public int getThirst() { return thirst; }

    public void eat() {
        hunger -= 20;
        if(hunger < 0){
            hunger = 0;
        }
    }


    public void sleep() {
        tiredness -= 20;
        if(tiredness < 0){
            tiredness = 0;
        }
    }

    @Override
    public void play() {
        boredom -= 20;
        if(boredom < 0){
            boredom = 0;
        }
    }


    public void drink() {
        thirst -= 20;
        if(thirst < 0){
            thirst = 0;
        }
    }
}
