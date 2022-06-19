package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    Map<String, String> petData = new HashMap<>();
    Map<String, VirtualPet> petShelter = new HashMap<>();

    public Map getPetShelter() {
        return petShelter;
    }

    public Collection getAllPets() {
        Collection<VirtualPet> allPets = petShelter.values();
        return allPets;

    }

    public Map getPetData() {
        return petData;
    }

    public VirtualPet getPet(String petName) {
        return petShelter.get(petName);
    }

    public void addNewPet(String newPetName, String newPetDescription) {
        petData.put(newPetName, newPetDescription);
        VirtualPet newPet = new VirtualPet(newPetName, newPetDescription);
        petShelter.put(newPetName, newPet);
    }

    public void adoptOutPet(String adoptedPet) {
        petData.remove(adoptedPet);
        petShelter.remove(adoptedPet);
    }

    public void feedAllPets() {
        for (Map.Entry<String, String> entry : petData.entrySet()) {
            VirtualPet needyPet = getPet(entry.getKey());
            needyPet.updatePetHunger(2);
        }
    }

    public void waterAllPets() {
        for (Map.Entry<String, String> entry : petData.entrySet()) {
            VirtualPet thirstyPet = getPet(entry.getKey());
            thirstyPet.updatePetThirst(2);
        }
    }

    public void entertainAllPets() {
        for (Map.Entry<String, String> entry : petData.entrySet()) {
            VirtualPet boredPets = getPet(entry.getKey());
            boredPets.updatePetBoredom(2);
        }
    }

    public void entertainOnePet(String petName) {
        VirtualPet boredPet = getPet(petName);
        boredPet.updatePetBoredom(3);
    }


    public void tick() {
        for (Map.Entry<String, String> entry : petData.entrySet()) {
            VirtualPet hungryPet = getPet(entry.getKey());
            hungryPet.updatePetHunger(-1);
            hungryPet.updatePetThirst(-1);
            hungryPet.updatePetBoredom(-1);
        }
    }

    public void allPetStatus() {
        System.out.format("\n%-25s | %10s | %10s | %10s |", "PET NAME", "HUNGER", "THIRST", "BOREDOM");
        for (Map.Entry<String, String> entry : petData.entrySet()) {
            VirtualPet pet = getPet(entry.getKey());
            System.out.format("\n%-25s | %10d | %10d | %10d |", pet.getPetName(), pet.getPetHunger(), pet.getPetThirst(), pet.getPetBoredom());
        }
        System.out.println("");
    }
}







