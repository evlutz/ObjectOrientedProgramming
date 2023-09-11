import java.util.LinkedList;

class Snowfall2 {
  Snowfall2(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum >= 101; } // Jan 1st
  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) { return ((int)( dateNum / 100)); }


  /*
  Takes in a list of data and a given month and returns a class with each day with snow recorded in the month followed
  by the maximum amount of snowfall on that given day
  @Param LinkedList<Double>, int
  @Return LinkedList<MaxInchReport>
   */

  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data,
                                                    int month){
  LinkedList<MaxInchReport> monthReport = new LinkedList<>();
    for(int i = 0; i < data.size();i++ ){
    if(isDate(data.get(i)) && month == extractMonth(data.get(i))){
      double max = 0;
      for(int k = 1; !isDate(data.get(i+k)) && i+k < data.size()-1; k++){
        if(data.get(i) < 0){
          continue;
        }
        if(data.get(i+k) > max){
          max = data.get(i+k);
        }
      }
      monthReport.add(new MaxInchReport(data.get(i),max));


    }

  }



   return monthReport;
}
}