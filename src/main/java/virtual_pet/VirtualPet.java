package virtual_pet;

public class VirtualPet {
    private String petName;
    private String petDescription;
    private int petHunger;
    private int petThirst;
    private int petBoredom;

    public VirtualPet(String petName, String petDescription) {

        this.petName = petName;
        this.petDescription = petDescription;
        this.petHunger = 5;
        this.petThirst = 5;
        this.petBoredom = 5;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public int getPetHunger() {
        return petHunger;
    }

    public int getPetThirst() {
        return petThirst;
    }

    public int getPetBoredom() {
        return petBoredom;
    }

    public void updatePetHunger(int numberToAdd) {
        petHunger = petHunger + numberToAdd;

    }

    public void updatePetThirst(int numberToAdd) {
        petThirst = petThirst + numberToAdd;
    }

    public void updatePetBoredom(int numberToAdd) {
        petBoredom = petBoredom + numberToAdd;

    }
}
