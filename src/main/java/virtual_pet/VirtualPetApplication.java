package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method
        VirtualPet pet = new VirtualPet("John",5,5,5);
        Scanner input = new Scanner(System.in);



        System.out.println("Hello user welcome to virtual pet");
        String action = "";
        while (!action.equalsIgnoreCase("quit")) {
            pet.status();
            System.out.println("Enter action: Feed, Play, Water, Quit");
            action = input.nextLine();
            if (action.equalsIgnoreCase("feed")) {
                pet.feed();
            } else if (action.equalsIgnoreCase("water")) {
                pet.water();
            } else if (action.equalsIgnoreCase("play")) {
                pet.play();
            } else {
                System.out.println("Invalid selection");
            }
            pet.tick();
        }

    }

}
