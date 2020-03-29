package domain;

public class ProjectNegative{
  private String[] name;

  public String[] getName() {
    return name;
  }

  public void setName(String[] name) {
    this.name = name;
  }
  public String getMessage(){
    return getName()[0];
  }
}
