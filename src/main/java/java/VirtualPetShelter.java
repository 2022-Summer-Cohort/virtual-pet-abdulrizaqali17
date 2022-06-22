package java;

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

    public void intake(OrganicPet steve) {
    }

    public VirtualPet[] pets() {
        return new VirtualPet[0];
    }

    public void feedAllOrganic() {
    }

    public void waterAllOrganic() {
    }

    public VirtualPet getPet(String petName) {
        return null;
    }


    public void adoptPet(VirtualPet pet) {
    }

    public void walkDogs() {
    }

    public void tickAllPets() {
    }

    public void playOne(VirtualPet pet) {
    }

    public void allPetStatus() {
    }

    public void addNewPet(Object petName, Object petDescription) {
    }

    public void adoptOutPet(String petToAdopt) {
    }

    public void entertainOnePet(String petToEntertain) {
    }

    public void entertainAllPets() {
    }

    public void waterAllPets() {
    }

    public void feedAllPets() {
    }
}


