import java.io.*;  
import java.util.Scanner;  
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;

public class copyMain {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    while (true) {
      copyMain mainClass = new copyMain();
      boolean shouldQuit = mainClass.start();
      if (shouldQuit) {
        break;
      }
      System.out.println("--------------------------------------");
    }
  }

  boolean start() {
    try {
        File file = new File("test.java");
        FileInputStream fis = new FileInputStream(file);
        System.out.println("file content: ");
        String filestring = "";
        int r = 0;
        while ((r = fis.read()) != -1) {
          filestring += (char) r;
        }
        System.out.println(filestring);
      } catch (IOException e) {
        System.out.println("There was an error sorry");
        return true;
      }
      copyMain mainClass = new copyMain();
      Scanner newObj = new Scanner(System.in);
      System.out.println(
          "What would you like to do press r to run the code press w to write lines of code and press q to quit");
      String user_input = newObj.nextLine();
      if (user_input.equals("r")) {
        mainClass.run();
      } else if (user_input.equals("w")) {
        mainClass.write();
      }
      else if (user_input.equals("q")) {
        return true;
      }
      return false;
  }
  public void run() {
    try {
      test x = new test();
      x.main(null);
      TimeUnit.SECONDS.sleep(2);
    } catch (Exception e) {

      System.out.println("Error");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (Exception o) {

      }
    }
  }

  public static void write() {
    
    Scanner newObj = new Scanner(System.in);
    System.out.println("Would you like to add new lines of code or delete the last line of code written(input w or d) or press anything else to exit(If you edit the code you will need to refresh to run the new code)");
    String userInput = newObj.nextLine();
    if (userInput.toLowerCase().equals("w")) {
      add();
    } else if (userInput.toLowerCase().equals(userInput)) {
      delete();
    }
    }

    public static void add() {
      try {
        String filestring = "";
        File file = new File("test.java");
        FileInputStream fis = new FileInputStream(file);
        Scanner myObj = new Scanner(System.in);
        System.out.println("What code would you like to add:");
        String userInput = myObj.nextLine();
        int r = 0;
        while ((r = fis.read()) != -1) {
          filestring += (char) r;
        }
        FileWriter myWriter = new FileWriter("test.java");
        myWriter.write(filestring.substring(0, filestring.length() - 2) + userInput + "\n}}");
        myWriter.close();
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (Exception IOException) {
        System.out.println("There was an error sorry");
      }
  }

    public static void delete() {
      try{
        File file = new File("test.java");
        FileInputStream fis = new FileInputStream(file);
        String filestring = "";
        int r = 0;
        while ((r = fis.read()) != -1) {
            filestring += (char) r;
        }
        String[] lines = filestring.split("\n");
        if (lines.length <= 3) {
        }
        else {
            String editedLines = "";
            for (int i = 0; i < lines.length; i++) {
                if (i == lines.length - 2) {
                } else {
                    if (i == 0) {
                        editedLines += lines[i];
                    } else {
                        editedLines += ("\n" + lines[i]);
                    }
                }
            }
            FileWriter myWriter = new FileWriter("test.java");
            myWriter.write(editedLines);
            myWriter.close();
        }
    } catch (IOException e) {
    }
    }
}