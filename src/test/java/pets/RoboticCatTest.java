package pets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoboticCatTest {

    private RoboticCat roboticCat;
    @BeforeEach
    void setUp() {
        roboticCat = new RoboticCat( "Test Robotic cat", "Sample test description for Robotic cat" );
    }

    @Test
    void test_robotic_cat_constructor() {
        assertAll( ()->assertNotNull( roboticCat ),
                   ()->assertEquals( 50, roboticCat.oilLevel , "Default oil level value" ),
                   ()->assertEquals( 50, roboticCat.getMood() , "default mood value"),
                   ()->assertEquals( 50, roboticCat.getHealth(), "default Health" )
                   );
    }
    @Test
    void play() {
        roboticCat.play();
        assertAll( ()->assertNotNull( roboticCat ),
                   ()->assertEquals( 45, roboticCat.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 70, roboticCat.getMood() , " mood value"),
                   ()->assertEquals( 50, roboticCat.getHealth(), " Health" )
        );
    }

    @Test
    void tick() {
        roboticCat.tick();
        assertAll( ()->assertNotNull( roboticCat ),
                   ()->assertTrue( 50 > roboticCat.getOilLevel() , " oil level value" ),
                   ()->assertTrue( 50 > roboticCat.getMood() , " mood value"),
                   ()->assertEquals( 50, roboticCat.getHealth(), " Health" )
        );
    }

    @Test
    void oilPet() {
        roboticCat.oilPet();
        assertAll( ()->assertNotNull( roboticCat ),
                   ()->assertEquals( 70, roboticCat.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 50, roboticCat.getMood() , " mood value"),
                   ()->assertEquals( 50, roboticCat.getHealth(), " Health" )
        );
    }


    @Test
    void recharge() {
        roboticCat.recharge();
        assertAll( ()->assertNotNull( roboticCat ),
                   ()->assertEquals( 50, roboticCat.getOilLevel() , " oil level value" ),
                   ()->assertEquals( 60, roboticCat.getMood() , " mood value"),
                   ()->assertEquals( 60, roboticCat.getHealth(), " Health" )
        );
    }
}