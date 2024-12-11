import org.code.theater.*;
import java.util.Scanner;

public class TheaterRunner {
  public static void main(String[] args) {
    
    //Initialize a DataScene Object
    DataScene myScene = new DataScene("names.txt", "breedGroups.txt", "maxHeight.txt", "maxWeight.txt", "maxLife.txt", "minLife.txt");

    // START OF TEST CALLS
    /*
    System.out.println(myScene.getDogInfo(myScene.getRandomDog()));
    System.out.println(myScene.getSmallDogList());
    System.out.println(myScene.getBigDogList());
    */
    // END OF TEST CALLS
    
    //Start of Scene
    myScene.promptUser();
    Theater.playScenes(myScene);
  





    
  }
}