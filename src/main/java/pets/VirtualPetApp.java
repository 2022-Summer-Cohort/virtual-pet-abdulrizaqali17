package pets;

import java.util.Scanner;

public class VirtualPetApp{

    public static void main(String[] args) {

        VirtualPetShelter shelter = new VirtualPetShelter();
        Scanner input = new Scanner(System.in);

        OrganicPet steve = new OrganicDog("Organic Dog", "This is my Organic Dog!");
        shelter.intake(steve);
        RoboticPet paul = new RoboticDog("Robotic Dog", "This is my Robotic Dog!");
        shelter.intake( paul);
        OrganicPet jess = new OrganicCat("Organic Cat", "This is my Organic Cat!");
        shelter.intake(jess);
        RoboticPet oly = new RoboticCat("Robotic Cat", "This is my Robotic Cat!");
        shelter.intake( oly);

        boolean quit = false;

        do {//test for litterbox overflow
            if (shelter.getLitterBox() >= 100) {
                System.out.println("\nThe litterbox is overflowing and it's negatively affecting the health of all organic cats in the shelter.");
                for (VirtualPet pet : shelter.pets()) {
                    if (pet instanceof OrganicCat) {
                        ((OrganicCat) pet).decreaseHealth();
                    }
                }
            }//test each dog cage messiness
            for (VirtualPet pet : shelter.pets()) {
                if (pet instanceof OrganicDog) {

                    if (((OrganicDog) pet).getCageMessiness() >= 100) {
                        System.out.println("\nThe organic dog " + pet.getName()
                                + "'s cage needs cleaning and it's currently negatively affecting their health.");
                        ((OrganicDog) pet).decreaseHealth();
                    }
                }
            }//test robotic pets for maintenance issues
            for (VirtualPet pet : shelter.pets()) {
                if (pet instanceof RoboticPet) {

                    if (((RoboticPet) pet).getOilLevel() <= 10) {
                        System.out.println("\nThe robotic pet " + pet.getName()
                                + "'s needs oil and it's currently negatively affecting their health.");
                        pet.decreaseHealth();
                    }
                }
            }

            System.out.println("\n\t\t********** Welcome to Virtual Pet Shelter **********");
            System.out.println("\nThis is the status of your pets: ");
            System.out.format("\n%-25s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |", "PET NAME", "MOOD", "HEALTH", "HUNGER", "THIRST", "OIL LEVEL", "CAGE MESS");

            for (VirtualPet currentPet : shelter.pets()) {
                System.out.format("\n%-25s | %-10d | %-10d |", currentPet.getName(), ((VirtualPet) currentPet).getMood(),
                        ((VirtualPet) currentPet).getHealth());
                if (currentPet instanceof OrganicPet) {
                    System.out.format(" %-10d | %-10d | %-10s |", ((OrganicPet) currentPet).getHunger(),
                            ((OrganicPet) currentPet).getThirst(), "N/A");
                } else if (currentPet instanceof RoboticPet) {
                    System.out.format(" %-10s | %-10s | %-10d |", "N/A", "N/A", ((RoboticPet) currentPet).getOilLevel());
                }
                if (currentPet instanceof OrganicDog) {
                    System.out.format(" %-10d |", ((OrganicDog) currentPet).getCageMessiness());
                } else {
                    System.out.format(" %-10s |", "N/A");
                }
            }

            System.out.println("\n\nThe litterbox messiness level (0-100) is: " + shelter.getLitterBox());
            System.out.println("\nWhat would you like to do next?");
            System.out.println(
                    "\n1.Feed the organic pets \n2.Water the organic pets \n3.Play with a pet \n4.Adopt a pet \n5.Admit a pet \n6.Clean Cages \n7.Clean Litterbox \n8.Walk Dogs \n9.Maintain all RoboPets \n10.Do nothing \n11.Quit");
            System.out.print("Please enter your choice: ");
            String response = input.nextLine();

            switch (response) {
                case "1":
                    shelter.feedAllOrganic();
                    System.out.println("\nThank you! You fed all the organic pets!");
                    break;
                case "2":
                    shelter.waterAllOrganic();
                    System.out.println("\nThank you! You watered all the organic pets!");
                    break;
                case "3": // play
                    System.out.println("Ok, so you'd like to play with a pet. Please choose one:\n");
                    displayPets(shelter);
                    System.out.println("\nWhich pet would you like to play with?");
                    String petName = input.nextLine();
                    try {
                        shelter.playOne(shelter.getPet(petName));
                        System.out.println("\nOK, you play with " + shelter.getPet(petName).getName() + ". ");
                    } catch (Exception e) {
                        System.out.println("\nSorry! we do not have " + petName + " in our shelter. Please play with other pets.");
                    }
                    break;
                case "4": // adopt
                    System.out.println("Ok, so you'd like to adopt a pet. Please choose one:\n");
                    displayPets(shelter);
                    System.out.println("\nWhich pet would you like to adopt");
                    String nameToAdopt = input.nextLine();
                    try {
                        VirtualPet pet = shelter.getPet(nameToAdopt);
                        shelter.adoptPet(pet);
                        System.out.println("You adopted " + pet.getName() + ". Please take good care of him/her!");
                    } catch (Exception e) {
                        System.out.println("\nSorry! we do not have " + nameToAdopt + " in our shelter. Please adopt some other pets.");
                    }
                    break;
                case "5":// intake
                    System.out.println("Ok you have a pet for us! Is it organic or robotic?");
                    String response2 = input.next();
                    if (response2.equalsIgnoreCase("organic")) {
                        System.out.println("Great! is your organic pet a cat or a dog?");
                        String response3 = input.next();
                        input.nextLine();
                        if (response3.equalsIgnoreCase("dog")) {
                            System.out.println("Great! What is the dog's name?");
                            String name = input.nextLine();
                            System.out.println("Great! What is a short description of the dog?");
                            String description = input.nextLine();
                            OrganicPet x = new OrganicDog(name, description);
                            shelter.intake(x);
                            System.out.println("Thanks! We'll take good care of " + x.getName() + ".");
                        } else if (response3.equalsIgnoreCase("cat")) {
                            System.out.println("Great! What is the cat's name?");
                            String name = input.nextLine();

                            System.out.println("Great! What is a short description of the cat?");
                            String description = input.nextLine();
                            OrganicPet y = new OrganicCat(name, description);
                            shelter.intake(y);
                            System.out.println("Thanks! We'll take good care of " + y.getName() + ".");
                        }

                    } else if (response2.equalsIgnoreCase("robotic")) {
                        System.out.println("Great! is your robotic pet a cat or a dog?");
                        String response3 = input.next();
                        input.nextLine();

                        if (response3.equalsIgnoreCase("dog")) {
                            System.out.println("Great! What is the dog's name?");
                            String name = input.nextLine();
                            System.out.println("Great! What is a short description of the dog?");
                            String description = input.nextLine();
                            RoboticPet r = new RoboticDog(name, description);
                            shelter.intake((OrganicPet) r);
                            System.out.println("Thanks! We'll take good care of " + r.getName() + ".");

                        } else if (response3.equalsIgnoreCase("cat")) {
                            System.out.println("Great! What is the cat's name?");
                            String name = input.nextLine();
                            System.out.println("Great! What is a short description of the cat?");
                            String description = input.nextLine();
                            RoboticPet w = new RoboticCat(name, description);
                            shelter.intake((OrganicPet) w);
                            System.out.println("Thanks! We'll take good care of " + w.getName() + ".");
                        }
                    }
                    break;
                case "6":
                    shelter.cleanDogCages();
                    System.out.println("You clean all the organic dog cages!");
                    break;
                case "7":
                    shelter.cleanLitterBox();
                    System.out.println("You cleaned the litterbox!");
                    break;
                case "8":
                    shelter.walkDogs();
                    System.out.println("You walked all the dogs!");
                    break;
                case "9":
                    shelter.maintainAllRobo();
                    System.out.println("You maintained all robotic pets!");
                    break;
                case "10":
                    // tick
                    break;
                case "11":
                    System.out.println("Thank you for using our shelter!");
                    System.exit(0);
                default:
                    System.out.println("Sorry, I didn't understand you. Try again.");
                    break;
            }
            shelter.tickAllPets();

        } while (!quit);
        input.close();
    }

    private static void displayPets(VirtualPetShelter shelter) {
        for (VirtualPet currentPet : shelter.pets()) {
            System.out.println("" + currentPet);
        }
    }
}
