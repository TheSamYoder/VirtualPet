public class OrganicDog extends OrganicPet implements Walkable{

    public OrganicDog(String name) {
        super(name);

    }


    @Override
    public void walk() {
        boredom -= 50;
    }
}
