package virtual_pet;

public class VirtualPet {
   private String name;
   private int hungerLevel;
   private int thirstLevel;
   private int boerdemLevel;

    public VirtualPet(String name, int hungerLevel, int thirstLevel, int boerdemLevel) {
        this.name = name;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boerdemLevel = boerdemLevel;
    }
    public void feed(){
        hungerLevel = 0;

    }
    public void water(){
        thirstLevel = 0;
    }
     public void play(){
        boerdemLevel = 0;
     }
    public void status(){
        //Fido- hunger:5 thirst:5 boredom:5
        System.out.println(name+"- hunger:"+ hungerLevel+ " thirst:"+ thirstLevel+"boredom"+ boerdemLevel);
    }
    public void tick(){
        hungerLevel = hungerLevel + 2;
        thirstLevel += 2;
        boerdemLevel += 2;
    }
    public String getName() {
        return name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoerdemLevel() {
        return boerdemLevel;
    }
}
