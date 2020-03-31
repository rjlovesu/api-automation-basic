package pages.pagesLib;

import io.cucumber.datatable.DataTable;

public class BasePage {
  // Methods
  public void doAction(String action, DataTable dataTable) {
    throw new Error(action + " is undefined");
  }
  public void doAction(String action, String data) { throw new Error(action + " is undefined"); }
  // Helper methods
  public String capitalize(String words){
    words = words.toLowerCase().
            replaceAll("[^a-zA-Z0-9]", " ").
            replaceAll("\\s+"," ");
    StringBuilder capitalized = new StringBuilder();
    for(String word: words.split(" ")){
      capitalized.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
    }
    return capitalized.toString().replaceAll("\\s+","");
  }
  public String capitalizeSecond(String words){
    String str = capitalize(words);
    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
  }
}
