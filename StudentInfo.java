import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;


public class StudentInfo extends JFrame {

    String name;
    String id;
    String department;
    String batch;
    String section;

    private Container c;
    private JLabel headerLabel;
    private JLabel nameLabel;
    private JLabel departmentLabel;
    private JLabel batchLabel;
    private JLabel sectionLabel;
    private JLabel idLabel;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField batchField;
    private JTextField sectionField;
    private JTextField idField;
    private JButton submitButton;
    private JButton showInfoButton;

    public StudentInfo(String name, String id, String department, String batch, String section){
        this.name = name;
        this.id = id;
        this.department = department;
        this.batch = batch;
        this.section = section;
    }
    
    public StudentInfo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 50, 500, 400);
        setTitle("Project");

        initComponent();
    }

    public void initComponent(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GREEN);

        headerLabel = new JLabel("Student Information Form");
        headerLabel.setBounds(75, 10, 400, 20);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(headerLabel);

        // name 
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(90, 75, 50, 20);
        c.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 75, 140, 20);
        c.add(nameField);
        
        // Id 
        idLabel = new JLabel("ID:");
        idLabel.setBounds(90, 105, 50, 20);
        c.add(idLabel);

        idField = new JTextField();
        idField.setBounds(180, 105, 140, 20);
        c.add(idField);

        // department 
        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(90, 135, 100, 20);
        c.add(departmentLabel);

        departmentField = new JTextField();
        departmentField.setBounds(180, 135, 140, 20);
        c.add(departmentField);

        // batch 
        batchLabel = new JLabel("Batch:");
        batchLabel.setBounds(90, 165, 100, 20);
        c.add(batchLabel);

        batchField = new JTextField();
        batchField.setBounds(180, 165, 140, 20);
        c.add(batchField);
        
        // Section 
        sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(90, 195, 100, 20);
        c.add(sectionLabel);

        sectionField = new JTextField();
        sectionField.setBounds(180, 195, 140, 20);
        c.add(sectionField);

        // submit button 
        submitButton = new JButton("Submit Form");
        submitButton.setBounds(125, 250, 150, 30);
        c.add(submitButton);

        showInfoButton = new JButton("Student Info");
        showInfoButton.setBounds(125, 290, 150, 30);
        c.add(showInfoButton);

        // submit student informations
        submitButton.addActionListener(new ActionListener(){

            String nameStr = String.format("%s", nameField.getText());
            String idStr = String.format("%s", idField.getText());
            String departmentStr = String.format("%s", departmentField.getText());
            String batchStr = String.format("%s", batchField.getText());
            String sectionStr = String.format("%s", sectionField.getText());

            public void actionPerformed(ActionEvent e){
                CreateTextFile.openFile();
                CreateTextFile.addRecords(nameStr, idStr, departmentStr, batchStr, sectionStr);
                System.out.println(nameStr);
                CreateTextFile.closeFile();
            }
        });

        // Read student informations
        // showInfoButton.addActionListener(new ActionListener(){

        //     public void actionPerformed(ActionEvent e){
        //         ReadTextFile.openFile();
        //         ReadTextFile.readRecords();
        //         ReadTextFile.closeFile();
        //     }
        // });
        // JOptionPane.showMessageDialog(null, "done");
    }

    public static void main(String[] args) {
        StudentInfo frame = new StudentInfo();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setBackground(Color.GREEN);
    }
}
