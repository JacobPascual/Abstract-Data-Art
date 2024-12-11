import org.code.theater.*;
import org.code.media.*;

public class Dog {
  //Instance Variables
  private String name;
  private String breedGroup;
  
  private int maxHeight;
  private int maxWeight;
  private int maxLife;
  private int minLife;

  //Parameterized Constructor to assign attributes to the dog class
  public Dog (String name, String breedGroup, int maxHeight, int maxWeight, int maxLife, int minLife){
    this.name = name;
    this.breedGroup = breedGroup;
    this.maxHeight = maxHeight;
    this.maxWeight = maxWeight;
    this.maxLife = maxLife;
    this.minLife = minLife;
  }
  //Getter Methods
  
  //Returns the dog name
  public String getName(){
    return name;
  }
  //Returns the breed group
  public String getBreedGroup(){
    return breedGroup;
  }
  //returns the max height of a dog
  public int getMaxHeight(){
    return maxHeight;
  }
  //Returns the max weight
  public int getMaxWeight(){
    return maxWeight;
  }
  //Returns the max life
  public int getMaxLife(){
    return maxLife;
  }
  //Returns the minimum life
  public int getMinLife(){
    return minLife;
  }


  //toString to print info about a dog
  public String toString(){
    return "Name: " + name+"   --   Breed Group: "+breedGroup+"   --   Max Height: "+maxHeight+"   --   Max Weight: "+maxWeight+"   --   Max Life: "+maxLife+"   --   Min Life: "+minLife;
  }






  
}