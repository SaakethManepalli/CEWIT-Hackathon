public class Evt
  {
    int pref_time = 0000;
    String name = "";
    public Evt(int hour, String inName)
    {
      pref_time = hour;
      name = inName;
    }
  public int getPrefTime()
    {
      return pref_time;
    }
  public void setPrefTime(int ntime)
    {
      pref_time = ntime;
    }
  public String getName()
    {
      return name;
    }
  public void setName(String nName)
    {
      name = nName;
    }
    public String toString()
    {
      return "name: " + name + " pref_time:" + pref_time;
    }
  }
