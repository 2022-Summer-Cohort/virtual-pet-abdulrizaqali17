package virtual_pet;

import java.util.HashMap;
import java.util.Scanner;

class VirtualPetShelterApp {

    static VirtualPetShelter myShelter = new VirtualPetShelter();
    static int userCommand = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        shelterSetup();
        VirtualPetShelterDisplay.initialInstructions();
        VirtualPetShelterDisplay.mainMenu();
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                userCommand = input.nextInt();
            } catch (Exception e) {
                exit();
            }
            gameLoop(userCommand);
        }
    }

    public static void shelterSetup() {
        VirtualPet honeyFace = new VirtualPet("Honeyface", "Very small, likes people");
        myShelter.addNewPet(honeyFace.getPetName(), honeyFace.getPetDescription());
        VirtualPet badgerNose = new VirtualPet("BadgerNose", "Eats lots of carrots ^");
        myShelter.addNewPet(badgerNose.getPetName(), badgerNose.getPetDescription());
        VirtualPet bigOlBuster = new VirtualPet("Big Ol' Buster", "HUGE rabbit. Just, ginormous.");
        myShelter.addNewPet(bigOlBuster.getPetName(), bigOlBuster.getPetDescription());
    }

    public static void determineAction(int userCommand) {
        switch (userCommand) {
            case 0:
                myShelter.allPetStatus();
                break;
            case 1:
                feedPets();
                VirtualPetShelterDisplay.displayFeedPets();
                gameLoop();
                break;
            case 2:
                ;
                waterPets();
                VirtualPetShelterDisplay.displayWaterPets();
                gameLoop();
                break;
            case 3:
                entertainPets();
                VirtualPetShelterDisplay.displayEntertainPets();
                gameLoop();
                break;
            case 4:
                VirtualPetShelterDisplay.displaySelectPet();
                String petToEntertain = getUserInput();
                entertainOnePet(petToEntertain);
                VirtualPetShelterDisplay.displayEntertainOnePet(petToEntertain);
                gameLoop();
                break;
            case 5:
                VirtualPetShelterDisplay.displayAdoptionPrompt();
                String adoptedPet = getUserInput();
                adoptPet(adoptedPet);
                VirtualPetShelterDisplay.displayAdoptPet(adoptedPet);
                break;
            case 6:
                ;
                VirtualPetShelterDisplay.displayNewPetNamePrompt();
                String newPetName = getUserInput();
                VirtualPetShelterDisplay.displayNewPetDescriptionPrompt();
                String newPetDescription = getUserInput();
                admitPet(newPetName, newPetDescription);
                VirtualPetShelterDisplay.displayAdmitPet(newPetName);
                break;
            default:
                System.exit(0);
        }
        VirtualPetShelterDisplay.mainMenu();
    }

    private static String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void gameLoop() {

        myShelter.tick();
    }

    public static void gameLoop(int userInput) {
        determineAction(userInput);
    }

    public static void feedPets() {
        myShelter.feedAllPets();
    }

    public static void waterPets() {
        myShelter.waterAllPets();
    }

    public static void entertainPets() {
        myShelter.entertainAllPets();
    }

    public static void entertainOnePet(String petToEntertain) {
        myShelter.entertainOnePet(petToEntertain);
    }

    public static void adoptPet(String petToAdopt) {
        myShelter.adoptOutPet(petToAdopt);
    }

    public static void admitPet(String petName, String petDescription) {
        VirtualPet newPet = new VirtualPet(petName, petDescription);
        myShelter.addNewPet(petName, petDescription);
    }

    public static void exit() {
        System.exit(0);
    }

}
