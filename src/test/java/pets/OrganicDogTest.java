package pets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganicDogTest {

    private OrganicDog organicDog;

    @BeforeEach
    void setUp() {
        organicDog = new OrganicDog( "Test Organic Dog", "Sample test description for organic Dog" );
    }

    @Test
    void test_organic_dog_constructor() {
        assertAll( ()->assertNotNull( organicDog ),
                   ()->assertEquals( 50, organicDog.getHunger() , "Default hunger value" ),
                   ()->assertEquals( 50, organicDog.getThirst() , "default thirst value"),
                   ()->assertEquals( 50, organicDog.getCageMessiness(), "Default value of cagemissiness" ));
    }

    @Test
    void test_feed() {
        organicDog.feed();
        assertAll(
                ()->assertEquals( 30, organicDog.getHunger() ),
                ()->assertEquals( 60, organicDog.mood ),
                ()->assertEquals( 60, organicDog.getCageMessiness() )
        );
    }

    @Test
    void test_water() {
        organicDog.water();
        assertAll(
                ()->assertEquals( 50, organicDog.getHunger(), "Hunger value" ),
                ()->assertEquals( 60, organicDog.getMood(), "Mood value" ),
                ()->assertEquals( 30, organicDog.getThirst(), "thirst value" ),
                ()->assertEquals( 60, organicDog.getCageMessiness(), "cagemessiness" )
        );
    }

    @Test
    void walk() {
        organicDog.walk();
        assertAll(
                ()->assertEquals( 55, organicDog.getHunger(), "Hunger value" ),
                ()->assertEquals( 70, organicDog.getMood(), "mood value" ),
                ()->assertEquals( 30, organicDog.getCageMessiness(), "cagemessiness" ),
                ()->assertEquals( 60, organicDog.getHealth(), "Health should increase" ),
                ()->assertEquals( 55, organicDog.getThirst(), "thirst value" )
        );
    }

    @Test
    void test_play() {
        organicDog.play();
        assertAll(
                ()->assertEquals( 60, organicDog.getHunger(), "Hunger value" ),
                ()->assertEquals( 70, organicDog.getMood(), "mood value" ),
                ()->assertEquals( 50, organicDog.getCageMessiness(), "cagemessiness" ),
                ()->assertEquals( 60, organicDog.getHealth(), "Health should increase" ),
                ()->assertEquals( 60, organicDog.getThirst(), "thirst value" )
        );
    }

    @Test
     void test_cleanCage() {
         organicDog.cleanCage();
         assertAll(
                 ()->assertEquals( 50, organicDog.getHunger(), "Hunger value" ),
                 ()->assertEquals( 60, organicDog.getMood(), "mood value" ),
                 ()->assertEquals( 0, organicDog.getCageMessiness(), "cagemessiness" ),
                 ()->assertEquals( 60, organicDog.getHealth(), "Health should increase" ),
                 ()->assertEquals( 50, organicDog.getThirst(), "thirst value" )
         );
    }

    @Test
    void test_tick() {
        organicDog.tick();
        assertAll(
                   ()->assertTrue( 50 > organicDog.getMood() , " mood value"),
                   ()->assertTrue( 50 < organicDog.getHunger(), " Hunger" ),
                   ()->assertTrue( 50 < organicDog.getCageMessiness(), "cagemessiness" )

        );
    }

}