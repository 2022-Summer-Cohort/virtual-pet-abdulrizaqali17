package virtual_pet;

public class VirtualPetShelterDisplay {

    public static void initialInstructions() {
        System.out.println("\n\t\t********** Welcome to Virtual Pet Shelter **********\n");

    }

    public static void mainMenu() {
        System.out.println("\npress 0 to view the status of your pets!");
        System.out.println("press 1 to feed pets!");
        System.out.println("press 2 to water pets!");
        System.out.println("press 3 to entertain pets!");
        System.out.println("press 4 to entertain a pet of your choosing!");
        System.out.println("press 5 to adopt out a pet!");
        System.out.println("press 6 to admit a new pet to the shelter!");
        System.out.println("press any button to quit!\n");
    }

    public static void displayEntertainOnePet(String petName) {
        System.out.println("Thank you for entertaining " + petName + "!");
    }

    public static void displayAdoptPet(String petName) {
        System.out.println("Thank you for adopting " + petName + "!\nIt Looks like " + petName + " found their forever home. neat!");
    }

    public static void displayEntertainPets() {
        System.out.println("Thank you for entertaining the pets!");
    }

    public static void displayWaterPets() {
        System.out.println("Thank you for watering the pets!");
    }

    public static void displayFeedPets() {
        System.out.println("Thank you for fedding the pets!");
    }

    public static void userCommandError() {
        System.out.println("sorry, you've typed something I don't understand!");
        System.out.println("please type a number between 0-6!");
    }

    public static void displaySelectPet() {
        System.out.print("Enter the name of the pet you want to entertain: ");
    }

    public static void displayAdoptionPrompt() {
        System.out.print("Enter the name of the pet you want to adopt: ");
    }

    public static void displayNewPetNamePrompt() {
        System.out.print("Enter the name of the pet you want to admit: ");
    }

    public static void displayNewPetDescriptionPrompt() {
        System.out.print("Please describe the new pet briefly: ");
    }

    public static void displayAdmitPet(String newPetName) {
        System.out.println("I am sure that " + newPetName + " will be very happy and safe here.");
    }
}