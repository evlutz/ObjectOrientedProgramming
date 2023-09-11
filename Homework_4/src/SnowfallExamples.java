//ewlutz
//Evan Lutz
//brmarsh
//Ben Marsh
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  Snowfall2 E1 = new Snowfall2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxInchReport> DecReports = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> NovReports = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> JanReports = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> MayReports = new LinkedList<MaxInchReport>();
  
  public SnowfallExamples() {
    threeDates.add(101.0);
    threeDates.add(2.0);
    threeDates.add(503.0);
    threeDates.add(-4.0);
    threeDates.add(1113.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(1120.0);
    threeDates.add(4.0);
    threeDates.add(5.0);
    threeDates.add(4.5);
    threeDates.add(1201.0);
    threeDates.add(6.0);
    threeDates.add(-0.5);



    DecReports.add(new MaxInchReport(1201.0,6.0));
    NovReports.add(new MaxInchReport(1113.0,10.0));
    NovReports.add(new MaxInchReport(1120.0,5.0));
    JanReports.add(new MaxInchReport(101.0,2));
    MayReports.add(new MaxInchReport(503.0,0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(DecReports,
                 E1.dailyMaxForMonth(threeDates, 12));
  }

  @Test
  public void monthElevenTest() {
    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void januaryFirstTest() {
    assertEquals(JanReports,
            E1.dailyMaxForMonth(threeDates, 1));
  }

  @Test
  public void negativeInchesTest() {
    assertEquals(MayReports,
            E1.dailyMaxForMonth(threeDates, 5));
  }


}

/*
    Make linked list to collect MaxInchesReports
	Cycle through data
	Find dates
	Ignore all dates not in the given month
	Ignore all data from days not from the given month
	Take all data in days from the given month
	Find the maximum snowfall on a certain day in the given month
	Add date and associated maximum snowfall to a class
	Add the new class to the linked list
	Cycle through data again to find more dates from the given month
 */

