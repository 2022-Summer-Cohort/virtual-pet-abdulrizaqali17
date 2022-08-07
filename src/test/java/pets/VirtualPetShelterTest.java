package pets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualPetShelterTest {

    private VirtualPetShelter virtualPetShelter;
    @BeforeEach
    void setUp() {
       virtualPetShelter = new VirtualPetShelter();
    }

    @Test
    void test_constructor(){
        assertAll( ()-> assertNotNull( virtualPetShelter ),
        ()->assertEquals( 50, virtualPetShelter.getLitterBox(), "Default LitterBox")
        );
    }


    @Test
    void test_cleanLitterBox() {
        virtualPetShelter.cleanLitterBox();
        assertEquals( 0, virtualPetShelter.getLitterBox(), "Litterbox should be 0" );
    }

    @Test
    void maintainAllRobo() {
    }

    @Test
    void cleanDogCages() {
    }

    @Test
    void tick() {
    }

    @Test
    void intake() {
    }

    @Test
    void testIntake() {
    }

    @Test
    void pets() {
    }

    @Test
    void feedAllOrganic() {
    }

    @Test
    void waterAllOrganic() {
    }

    @Test
    void getPet() {
    }

    @Test
    void adoptPet() {
    }

    @Test
    void walkDogs() {
    }

    @Test
    void tickAllPets() {
    }

    @Test
    void playOne() {
    }

    @Test
    void allPetStatus() {
    }

    @Test
    void addNewPet() {
    }

    @Test
    void adoptOutPet() {
    }

    @Test
    void entertainOnePet() {
    }

    @Test
    void entertainAllPets() {
    }

    @Test
    void waterAllPets() {
    }

    @Test
    void feedAllPets() {
    }
}