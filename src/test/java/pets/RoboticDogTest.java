package pets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoboticDogTest {

    private RoboticDog roboticDog;
    @BeforeEach
    void setUp() {
        roboticDog = new RoboticDog( "Test Robotic Dog", "Sample test description for Robotic Dog" );
    }

    @Test
    void test_robotic_dog_constructor() {
        assertAll( ()->assertNotNull( roboticDog ),
                   ()->assertEquals( 50, roboticDog.oilLevel , "Default oil level value" ),
                   ()->assertEquals( 50, roboticDog.getMood() , "default mood value"),
                   ()->assertEquals( 50, roboticDog.getHealth(), "default Health" )
        );
    }
    @Test
    void play() {
        roboticDog.play();
        assertAll( ()->assertNotNull( roboticDog ),
                   ()->assertEquals( 45, roboticDog.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 70, roboticDog.getMood() , " mood value"),
                   ()->assertEquals( 50, roboticDog.getHealth(), " Health" )
        );
    }

    @Test
    void tick() {
        roboticDog.tick();
        assertAll( ()->assertNotNull( roboticDog ),
                   ()->assertTrue( 50 > roboticDog.getOilLevel() , " oil level value" ),
                   ()->assertTrue( 50 > roboticDog.getMood() , " mood value"),
                   ()->assertEquals( 50, roboticDog.getHealth(), " Health" )
        );
    }

    @Test
    void oilPet() {
        roboticDog.oilPet();
        assertAll( ()->assertNotNull( roboticDog ),
                   ()->assertEquals( 70, roboticDog.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 50, roboticDog.getMood() , " mood value"),
                   ()->assertEquals( 50, roboticDog.getHealth(), " Health" )
        );
    }


    @Test
    void recharge() {
        roboticDog.recharge();
        assertAll( ()->assertNotNull( roboticDog ),
                   ()->assertEquals( 50, roboticDog.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 60, roboticDog.getMood() , " mood value"),
                   ()->assertEquals( 60, roboticDog.getHealth(), " Health" )
        );
    }

    @Test
    void walk() {
        roboticDog.walk();
        assertAll( ()->assertNotNull( roboticDog ),
                   ()->assertEquals( 45, roboticDog.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 70, roboticDog.getMood() , " mood value"),
                   ()->assertEquals( 60, roboticDog.getHealth(), " Health" )
        );
    }
}