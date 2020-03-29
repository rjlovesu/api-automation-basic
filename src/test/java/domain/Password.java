package domain;

public class Password {
  String[] password;
  Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String[] getPassword() {
    return password;
  }

  public String getMessage(){
    return getPassword()[0];
  }

  public void setPassword(String[] password) {
    this.password = password;
  }
}
