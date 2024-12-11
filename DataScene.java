import org.code.theater.*;
import java.util.Scanner;
public class DataScene extends Scene {
  
    //Instance Variable
  public Dog[] dogList;

    //Filtered Instance Variables
  public Dog[] smallDog;
  public Dog[] bigDog;

    //Constructors
  public DataScene(String name, String breedGroup, String maxHeight, String maxWeight, String maxLife, String minLife){
    dogList = makeDogObjects(name, breedGroup, maxHeight, maxWeight, maxLife, minLife);
    filterDogs();
  }


  //Returns a list of dog objects given the correct text files
  public Dog[] makeDogObjects(String nameFile, String breedGroupFile, String maxHeightFile, String maxWeightFile, String maxLifeFile, String minLifeFile){
    String[] name = FileReader.toStringArray(nameFile);
    String[] breedGroup = FileReader.toStringArray(breedGroupFile);
    int[] maxHeight = FileReader.toIntArray(maxHeightFile);
    int[] maxWeight = FileReader.toIntArray(maxWeightFile);
    int[] maxLife = FileReader.toIntArray(maxLifeFile);
    int[] minLife = FileReader.toIntArray(minLifeFile);


    Dog[] temp = new Dog[name.length];
    for(int i = 0; i < temp.length; i++){
      temp[i] = new Dog(name[i], breedGroup[i], maxHeight[i], maxWeight[i], maxLife[i], minLife[i]);
    }
    return temp;
  }
  public Dog[] getSmallDogList2(){
    return smallDog;
  }
  public Dog[] getBigDogList2(){
    return bigDog;
  }
  public String getDogList(){
    String ret = "";
    for(int i = 0; i < dogList.length; i++){
      ret += dogList[i] + "\n";
    }
    return ret;
  }


  //Returns information about a given dog object name
  public Dog getDogInfo(String name){
    Dog temp = dogList[0];
    for(int i = 0; i < dogList.length; i++){
      if(dogList[i].getName().equals(name)){
        temp = dogList[i];
      }
    }
    return temp;
  }

//Returns a random dog by multiplying Math.random() by dogList.length and using that number to choose a dog
  public String getRandomDog(){
    int ran = (int) (Math.random() * dogList.length);
    return dogList[ran].getName();
  }

  //Returns a random dog from a given list
  public String getRandomDogFromList(Dog[] temp){
    int ran = (int) (Math.random() * temp.length);
    return temp[ran].getName();
  }

  /*
   If a given dog's max size is below 18 inches, this method will return true, indicating that the dog
    is small in size. If it returns false, the dog is big in size
  */
  public boolean isSmall(String name){
    int count = 0;
    boolean ret = true; 
    for(int i = 0; i < dogList.length; i++){
      if(dogList[i].getName().equals(name)){
        count = i;
      }
    }
    if(dogList[count].getMaxHeight() > 18){
      ret = false;
    }
    return ret;
  }

  /*
  Filters the dogs based on their size and splits them into two different lists. It uses an if statement and for loop to create list lengths based on
  the amount of small and big dogs that there are, and then uses those amounts to initialize lists. It then uses a seperate if statement and for loop to initialize 
  the indexes of the small and big list to the correct values.
  */
  public void filterDogs(){
    int small = 0;
    int big = 0;
    for(int i = 0; i < dogList.length; i++){
      if(isSmall(dogList[i].getName()) == true){
        small++;
      }else{
        big++;
      }
    }
    Dog[] tempSmall = new Dog[small];
    Dog[] tempBig = new Dog[big];
    int NUM1 = 0;
    int NUM2 = 0;
    for(int i = 0; i < dogList.length; i++){
      if(isSmall(dogList[i].getName()) == true){
        tempSmall[NUM1] = dogList[i];
        NUM1++;
        
      }else{
        tempBig[NUM2] = dogList[i];
        NUM2++;
      }
    }
    smallDog = tempSmall;
    bigDog = tempBig;
  }
  
  public String getSmallDogList(){
    String t = "";
   for(int i = 0; i < smallDog.length; i++){
     t += smallDog[i] + "\n";
   }
    return t;
  }
    public String getBigDogList(){
    String t = "";
   for(int i = 0; i < bigDog.length; i++){
     t += bigDog[i] + "\n";
   }
    return t;
  }



  /*Method that controls the entire user interface, takes
   user input to run a series of events based on their choices
  */
  public void promptUser(){
    System.out.println("Hello, User #"+ (int)(Math.random() * 10000000) + "!");
    System.out.println("Select a roll option: \n1: Random Dog\n2: Random Small Dog\n3: Random Big Dog");
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    if(a == 1){
      pause(0.5);
      clear("white");
      Dog temp = getDogInfo(getRandomDog());
      System.out.println(temp);
      drawText("Random Dog Name: " + temp.getName(), 0, 18);
      drawText("Breed Group: " + temp.getBreedGroup(), 0, 40);
      drawText("Minimum Life Time: " + temp.getMinLife() + " years", 0, 72);
      drawText("Maximum Life Time: " + temp.getMaxLife() + " years", 0, 104);
      drawText("Maximum Weight: " + temp.getMaxWeight() + " pounds", 0, 136);
      drawText("Maximum Height: " + temp.getMaxHeight() + " inches", 0, 168);
      drawRectangle(100, 263, 200, 100);
      playNote(70, 3);
      System.out.println("Reroll?\n1: Yes\n2: No");
      int b = input.nextInt();
      if(b == 1){
        promptUser();
      }
    }else if(a == 2){
      pause(0.5);
      clear("blue");
      Dog temp = getDogInfo(getRandomDogFromList(getSmallDogList2()));
      System.out.println(temp);
      drawText("Random Dog Name: " + temp.getName(), 0, 18);
      drawText("Breed Group: " + temp.getBreedGroup(), 0, 40);
      drawText("Minimum Life Time: " + temp.getMinLife() + " years", 0, 72);
      drawText("Maximum Life Time: " + temp.getMaxLife() + " years", 0, 104);
      drawText("Maximum Weight: " + temp.getMaxWeight() + " pounds", 0, 136);
      drawText("Maximum Height: " + temp.getMaxHeight() + " inches", 0, 168);
      drawRectangle(130, 263, 100, 100);
      playNote(70, 2);
      System.out.println("Reroll?\n1: Yes\n2: No");
      int b = input.nextInt();
      if(b == 1){
        promptUser();
      }
    }else if(a ==3){
      pause(0.5);
      clear("orange");
      Dog temp = getDogInfo(getRandomDogFromList(getBigDogList2()));
      System.out.println(temp);
      drawText("Random Dog Name: " + temp.getName(), 0, 18);
      drawText("Breed Group: " + temp.getBreedGroup(), 0, 40);
      drawText("Minimum Life Time: " + temp.getMinLife() + " years", 0, 72);
      drawText("Maximum Life Time: " + temp.getMaxLife() + " years", 0, 104);
      drawText("Maximum Weight: " + temp.getMaxWeight() + " pounds", 0, 136);
      drawText("Maximum Height: " + temp.getMaxHeight() + " inches", 0, 168);
      drawRectangle(50, 263, 300, 100);
      playNote(70, 4);
      System.out.println("Reroll?\n1: Yes\n2: No");
      int b = input.nextInt();
      if(b == 1){
        promptUser();
      }
    }else{
      System.out.println("This is not a valid option, please try again.");
      
    }
  }
  

  
  

  
}