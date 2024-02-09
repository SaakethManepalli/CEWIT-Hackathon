import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
// Declare Scanner
    Scanner scan = new Scanner(System.in);
// 
    System.out.println("Welcome to TimeWise!");
    //System.out.println("How many hours do you want to organize?");
    //String hrs = scan.nextLine();
    //int hrsInt = Integer.parseInt(hrs);
    //time day starts of first index of arrlist
    System.out.println("What time does your day start (in 2-digit Military Time, ex: 18)?");
    String timeStart = scan.nextLine();
    int timeStartInt = Integer.parseInt(timeStart);

    //num of events
    System.out.println("How many 1-hr event(s) do you have?");
    String numEvents = scan.nextLine();
    int numEventsInt = Integer.parseInt(numEvents);

    //loop to gather as many events there are to put them in arraylists of name and time


    // loop through, instatiate and set
    ArrayList<Evt> events = new ArrayList<Evt>();
    int count = 0;

    for (int i = 0; i < numEventsInt; i++)
    {
      System.out.println("What is event " + (i+1) + "'s name?");
      String name = scan.nextLine();
      //events.get(i).setName(name);

      System.out.println("What is the preferred time of event " + (i+1) + " (in 2-digit Military Time, ex: 18)?");
      String time = scan.nextLine();
      //events.get(i).setPreferredTime(time);

       events.add(new Evt(Integer.parseInt(time), name));

    }
    SelectionSort(events);
    for (int i = 1; i < numEventsInt; i++) 
    {
      if (events.get(i).getPrefTime() == events.get(i - 1).getPrefTime()) 
      {
        events.get(i).setPrefTime(events.get(i).getPrefTime() + 1);
      }
      SelectionSort(events);
    }
    // Converting Military Time to Standard Time
    String strlist[] = new String[events.size()];
    for (int i = 0; i < events.size(); i++)
    {
      if(events.get(i).getPrefTime()<12)
      {
        strlist[i] = events.get(i).getPrefTime() + "am";
      }
      else if(events.get(i).getPrefTime()==12)
      {
        strlist[i] = 12 + "pm";
      }
      else if(events.get(i).getPrefTime()>12&&events.get(i).getPrefTime()<24)
      {
        strlist[i] = (events.get(i).getPrefTime() - 12) + "pm";
      }        
      else if(events.get(i).getPrefTime()==24)
      {
        strlist[i] = 12 + "am";
      }
    }
    // Printing out the events
    System.out.println("TimeWise presents... Your Schedule: ");
    for (int i = 0; i < events.size(); i++)
    {
      System.out.println((i+1) + ":\t Name: " + events.get(i).getName() + "\t Time:" + strlist[i]);

    }
    scan.close();
  }

  //Sort through list
  public static void SelectionSort(ArrayList<Evt> events) 
  {
      int eventlistLength = events.size();
      for (int i = 0; i < eventlistLength-1; i++) 
      {
        int minIndex = i;

        for (int j = i+1; j < eventlistLength; j++)
          {
            if (events.get(j).getPrefTime() < 
                events.get(minIndex).getPrefTime())
            {
              minIndex = j;
            }

          }
        Evt temp = events.get(minIndex);
          events.set(minIndex, events.get(i));
          events.set(i, temp);
      }


  }

}
