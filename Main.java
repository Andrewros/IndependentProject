import javax.swing.*;
import java.io.*;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Andrews Project");
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setMinimumSize(new Dimension(600, 600));
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(Color.BLACK);
    JLabel label = new JLabel("Write the code below here(The class is already provided)                                                                                    ");
    label.setForeground(Color.WHITE);
    JPanel labelPanel = new JPanel();
    labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
    labelPanel.add(label);
    labelPanel.setBackground(Color.black);
    JLabel label2 = new JLabel("public class Main{                                                                                                                              ");
    label2.setForeground(Color.GREEN);
    JPanel label2Panel = new JPanel();
    label2Panel.setLayout(new BoxLayout(label2Panel, BoxLayout.X_AXIS));
    label2Panel.add(label2);
    label2Panel.setBackground(Color.black);
    JLabel label3 = new JLabel("}                                                                                                                                                                                                                                                                                                                                                                                                         ");
    label3.setForeground(Color.GREEN);
    label3.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    JPanel label3Panel = new JPanel();
    label3Panel.setLayout(new BoxLayout(label3Panel, BoxLayout.X_AXIS));
    label3Panel.add(label3);
    label3Panel.setBackground(Color.black);
    String filestring = "";
    try {
        File file = new File("test.java");
        FileInputStream fis = new FileInputStream(file);
        System.out.println("file content: ");
        int r = 0;
        while ((r = fis.read()) != -1) {
          filestring += (char) r;
        }
        filestring = filestring.substring(19, filestring.length()-1);
      } catch (IOException e) {
        System.out.println("There was an error sorry");
      }
      JTextArea textBox;
      if (filestring != "") {
        textBox = new JTextArea(filestring);
      }
    else{
      textBox = new JTextArea("    public static void main(String[] args){\n" + filestring + "\n    }");
  }
    textBox.setForeground(Color.GREEN);
    textBox.setCaretColor(Color.GREEN);
    textBox.setBackground(Color.BLACK);
    textBox.setLineWrap(true);
    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        String code = textBox.getText();
        try {
        FileWriter myWriter = new FileWriter("test.java");
        myWriter.write("public class test{\n"+code+"\n}");
          myWriter.close();
      } catch (Exception IOException) {
        System.out.println("There was an error sorry");
      }
  }
    });
    JPanel saveButtonPanel = new JPanel();
    saveButtonPanel.setLayout(new BoxLayout(saveButtonPanel, BoxLayout.X_AXIS));
    JLabel labelSpace = new JLabel("                                                                                                                                                                                                            "); 
    saveButtonPanel.add(saveButton);
    saveButtonPanel.add(labelSpace);
    saveButtonPanel.setBackground(Color.black);
    JButton runButton = new JButton("Run");
    JLabel label4 = new JLabel("");
    label4.setForeground(Color.WHITE);
    label4.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    JPanel label4Panel = new JPanel();
    label4Panel.setLayout(new BoxLayout(label4Panel, BoxLayout.X_AXIS));
    label4Panel.add(label4);
    label4Panel.setBackground(Color.black);
    runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        String code = textBox.getText();
        try {
        FileWriter myWriter = new FileWriter("test.java");
        myWriter.write("public class test{\n"+code+"\n}");
          myWriter.close();
          Process pro1 = Runtime.getRuntime().exec("javac test.java");  
            pro1.waitFor();  
            Process pro2 = Runtime.getRuntime().exec("java test");  
            pro2.waitFor();
            InputStream inputStream = pro2.getInputStream();
          int b = -1;
          String outputString = "";
          while ((b = inputStream.read()) != -1) {
            outputString += (char) b;
          }
          System.out.println(outputString);
          label4.setText("<html>" + outputString.replace("\n", "<br>") + "</html>");
      } catch (Exception IOException) {
        System.out.println("There was an error sorry");
      }
  }
        });
    JPanel runButtonPanel = new JPanel();
    JLabel labelSpace2 = new JLabel("                                                                                                                                                                                                            "); 
    runButtonPanel.setLayout(new BoxLayout(runButtonPanel, BoxLayout.X_AXIS));
    runButtonPanel.add(runButton);
    runButtonPanel.add(labelSpace2);
    runButtonPanel.setBackground(Color.black);
    panel.add(labelPanel);
    panel.add(label2Panel);
    panel.add(textBox);
    panel.add(label3Panel);
    panel.add(saveButtonPanel);
    panel.add(runButtonPanel);
    panel.add(label4Panel);
    frame.add(panel);
    frame.setVisible(true);
  }
    public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
            }
        });
    }
}
