//ewlutz
//Evan Lutz

//brmarsh
//Ben Marsh
import static org.junit.Assert.*;
import org.junit.Test;



public class Examples {

	
	
	//LITERARIAN EVAN
	BooksRead brNFEvan = new BooksRead(9);
	BooksRead brFEvan = new BooksRead(15);
	
	ReadingResult rrEvan = new ReadingResult(1, brFEvan, brNFEvan);
	WritingResult wrEvan = new WritingResult(60000, 21);
	
	ChallengeResult crEvan = new ChallengeResult(rrEvan, wrEvan);
	
	Literarian Evan = new Literarian(crEvan);
	
	
	
	
	//LITERARIAN BEN
	BooksRead brNFBen = new BooksRead(10);
	BooksRead brFBen= new BooksRead(2);
	
	ReadingResult rrBen = new ReadingResult(1, brNFBen, brFBen);
	WritingResult wrBen = new WritingResult(3000, 19);
	
	ChallengeResult crBen = new ChallengeResult(rrBen, wrBen);
	
	Literarian Ben = new Literarian(crBen);
	
	
	
	
	//LITERARIAN Di
	BooksRead brNFDi = new BooksRead(41);
	BooksRead brFDi= new BooksRead(21);
	
	ReadingResult rrDi = new ReadingResult(2, brNFDi, brFDi);
	WritingResult wrDi = new WritingResult(6000, 30);
	
	ChallengeResult crDi = new ChallengeResult(rrDi, wrDi);
	
	Literarian Di = new Literarian(crDi);
	
	
	
	
	  //Reading Result #########################################################
	
	//averagePerDay() **********
    @Test 
    public void averagePerDay_TestR() {
    	assertEquals(rrEvan.averagePerDay(), .77419, .01);
    }
    
    @Test 
    public void averagePerDay_TestR2() {
    	assertEquals(rrBen.averagePerDay(), .387, .01);
    }

    @Test 
    public void averagePerDay_TestR3() {
    	assertEquals(rrDi.averagePerDay(), 2, .01);
    }
    
    //differenceFromGoal ********
    @Test 
    public void differenceFromGoal_TestR() {
    	assertEquals(rrEvan.differenceFromGoal(), .2258, .01);
    }
    
    @Test 
    public void differenceFromGoal_Test2R() {
    	assertEquals(rrBen.differenceFromGoal(), .613, .01);
    }
 
    @Test 
    public void differenceFromGoal_Test3R() {
    	assertEquals(rrDi.differenceFromGoal(), 0, .01);
    }
    
    
    
    
      //Writing Result #########################################################
    @Test 
    public void averagePerDayTestW() {
    	assertEquals(wrEvan.averagePerDay(), 2857.142, .01);
    }

    
    @Test 
    public void averagePerDay_Test2W() {
    	assertEquals(wrBen.averagePerDay(), 157.89, .01);
    }

    @Test 
    public void averagePerDay_Test3W() {
    	assertEquals(wrDi.averagePerDay(), 200, .01);
    }
    
    
    //differenceFromGoal() *************
    @Test 
    public void differenceFromGoal_TestW() {
    	assertEquals(wrEvan.differenceFromGoal(), -1000, .01);
    }
    
    @Test
    public void differenceFromGoal_Test2W() {
    	assertEquals(wrBen.differenceFromGoal(), 3916.66, .01);
    }
   
    @Test
    public void differenceFromGoal_Test3W() {
    	assertEquals(wrDi.differenceFromGoal(), 44000, .01);
    }
    
    
    
    
    
    
    //ChallengeResults #######################################################
    //howClose() &*********
    @Test
    public void howClose_Test() {
    	assertEquals(crEvan.howClose(), 1258.06, .01);
    }
    
    @Test
    public void howClose_Test2() {
    	assertEquals(crBen.howClose(), 10045.69, .01);
    }
    
    @Test
    public void howClose_Test3() {
    	assertEquals(crDi.howClose(), 44000, .01);
    }
    
    
    
    
    
    
    
    //Literarian ##############################################################
    //betterBookworm() *********
    @Test
    public void betterBookworm_Test() {
    	assertTrue(Evan.betterBookworm(Ben));
    }
    @Test
    public void betterBookworm_Test2() {
    	assertFalse(Ben.betterBookworm(Evan));
    }
    @Test
    public void betterBookworm_Test3() {
    	assertTrue(Di.betterBookworm(Ben));
    }
    @Test
    public void betterBookworm_Test4() {
    	assertFalse(Ben.betterBookworm(Di));
    }
    
    @Test
    public void betterBookworm_Test5() {
    	assertFalse(Evan.betterBookworm(Di));
    }
    
    //wittierWordsmith ********
    @Test
    public void wittierWordsmith_Test() {
    	assertTrue(Evan.wittierWordsmith(Di));
    }
    
    @Test
    public void wittierWordsmith_Test2() {
    	assertTrue(Evan.wittierWordsmith(Ben));
    }
    
    @Test
    public void wittierWordsmith_Test3() {
    	assertFalse(Ben.wittierWordsmith(Di));
    }
    
    
    //successfulScholar ********
    @Test
    public void successfulScholar_Test() {
    	assertFalse(Ben.wittierWordsmith(Di));
    }
    
    @Test
    public void successfulScholar_Test2() {
    	assertTrue(Evan.wittierWordsmith(Di));
    }
    
    @Test
    public void successfulScholar_Test3() {
    	assertTrue(Di.wittierWordsmith(Ben));
    }
 
}
