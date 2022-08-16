package pets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualPetShelter {
    // Map of pets and attributes
    private int litterBox = 50;

    private List<VirtualPet> virtualPetsStore = new ArrayList<>(  );

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

    public void intake(VirtualPet steve) {
        virtualPetsStore.add( steve );
    }


    public List<VirtualPet> pets() {
        return virtualPetsStore;
    }

    public void feedAllOrganic() {
        virtualPetsStore.stream().filter( vp->vp instanceof OrganicPet ).forEach( ovp->((OrganicPet) ovp).feed() );
    }

    public void waterAllOrganic() {
        virtualPetsStore.stream().filter( vp->vp instanceof OrganicPet ).forEach( ovp->((OrganicPet) ovp).water() );
    }

    public VirtualPet getPet(String petName) {
        return  virtualPetsStore.stream().filter( vp->vp.getPetName().equals( petName ) ).findFirst().orElse( null );
    }


    public void adoptPet(VirtualPet pet) {
        virtualPetsStore.remove( pet );
    }

    public void walkDogs() {
        virtualPetsStore.stream().filter( vp->vp instanceof Dog ).forEach( ovp->((Dog) ovp).walk() );
    }

    public void tickAllPets() {
        virtualPetsStore.stream().forEach( pet->{

            if(pet instanceof  RoboticPet){
                ((RoboticPet) pet).tick();
            }else {
                ((OrganicPet)pet).tick();
            }
        } );
    }

    public void playOne(VirtualPet pet) {
        pet.play();
    }

}


