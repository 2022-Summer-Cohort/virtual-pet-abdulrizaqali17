package pets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganicCatTest {

   private OrganicCat organicCat;
    @BeforeEach
    void setUp() {
        organicCat = new OrganicCat( "Test Organic Cat", "Sample test description for organic cat" );
    }

    @Test
    void test_organic_cat_constructor() {
       assertAll( ()->assertNotNull( organicCat ),
                  ()->assertEquals( 50, organicCat.getHunger() , "Default hunger value" ),
                  ()->assertEquals( 50, organicCat.getThirst() , "default thirst value"));
    }

    @Test
    void test_water() {
     organicCat.water();
     assertAll( ()->assertEquals( 30, organicCat.getThirst(), "Thirst value decreased" ),
                ()->assertEquals( 60, organicCat.getMood(), "mood value increased" ));

    }

 @Test
 void test_feed() {
  organicCat.feed();
  assertAll( ()->assertEquals( 30, organicCat.getHunger(), "Hunger value decreased" ),
             ()->assertEquals( 10, organicCat.getMood(), "mood value increased" ));

 }

    @Test
    void test_play() {
     organicCat.play();
     assertAll( ()->assertEquals( 60, organicCat.getThirst(), "Thirst value increased" ),
                ()->assertEquals( 70, organicCat.getMood(), "mood value increased" ),
                ()->assertEquals( 60, organicCat.getHunger(), "hunger increased" ));
    }

    @Test
    void tick() {
     int tick = organicCat.tick();
     assertNotEquals( tick,0 );
        assertAll(
                ()->assertTrue( 50 > organicCat.getMood() , " mood value"),
                ()->assertTrue( 50 < organicCat.getHunger(), " Hunger" )
        );
    }

}