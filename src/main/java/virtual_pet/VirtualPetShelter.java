package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    // Map of pets and attributes
    private int litterBox = 50;

    private Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();

    public int getLitterBox() {
        return litterBox;
    }

    public void cleanLitterBox() {
        litterBox = 0;
    }

    public void maintainAllRobo() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof RoboticPet) {
                ((RoboticPet) pet).oilPet();
                ((RoboticPet) pet).recharge();
            }
        }
    }




    public void cleanDogCages() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).cleanCage();
            }
        }
    }


    public void tick() {
    }
}


