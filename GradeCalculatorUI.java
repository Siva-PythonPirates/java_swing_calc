import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorUI extends JFrame {
    private JTextField mathField, scienceField, historyField, hciField, tocField, ipField, poaiField, cnField;
    private JButton calculateButton, closeButton;
    private JLabel resultLabel;

    public GradeCalculatorUI() {
        setTitle("Grade Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel hciLabel = new JLabel("HCI Marks:");
        hciField = new JTextField();

        JLabel tocLabel = new JLabel("TOC Marks:");
        tocField = new JTextField();

        JLabel ipLabel = new JLabel("IP Marks:");
        ipField = new JTextField();

        JLabel poaiLabel = new JLabel("POAI Marks:");
        poaiField = new JTextField();

        JLabel cnLabel = new JLabel("CN Marks:");
        cnField = new JTextField();

        inputPanel.add(hciLabel);
        inputPanel.add(hciField);
        inputPanel.add(tocLabel);
        inputPanel.add(tocField);
        inputPanel.add(ipLabel);
        inputPanel.add(ipField);
        inputPanel.add(poaiLabel);
        inputPanel.add(poaiField);
        inputPanel.add(cnLabel);
        inputPanel.add(cnField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        calculateButton = new JButton("Calculate Grades");
        resultLabel = new JLabel();
        closeButton = new JButton("Close");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hciMarks = Integer.parseInt(hciField.getText());
                int tocMarks = Integer.parseInt(tocField.getText());
                int ipMarks = Integer.parseInt(ipField.getText());
                int poaiMarks = Integer.parseInt(poaiField.getText());
                int cnMarks = Integer.parseInt(cnField.getText());

                double average = (hciMarks + tocMarks + ipMarks + poaiMarks + cnMarks) / 5.0;
                String grade = calculateGrade(average);

                resultLabel.setText("Average Grade: " + grade);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        buttonPanel.add(calculateButton);
        buttonPanel.add(closeButton);

        add(inputPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String calculateGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GradeCalculatorUI().setVisible(true);
            }
        });
    }
}
