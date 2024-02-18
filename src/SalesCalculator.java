import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculator extends JFrame implements ActionListener {
    private JTextField phonePriceField, phoneQuantityField, repairPriceField, repairHoursField;
    private JLabel phoneTotalLabel, repairTotalLabel;

    public SalesCalculator() {
        setTitle("Sales Calculator");
        setSize(650, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating components
        JLabel phoneLabel = new JLabel("Enter details of the phones sold:");
        JLabel phonePriceLabel = new JLabel("Price:");
        phonePriceField = new JTextField(10);
        JLabel phoneQuantityLabel = new JLabel("Quantity sold:");
        phoneQuantityField = new JTextField(10);
        phoneTotalLabel = new JLabel();

        JLabel repairLabel = new JLabel("Enter details of the repair services:");
        JLabel repairPriceLabel = new JLabel("Price per hour:");
        repairPriceField = new JTextField(10);
        JLabel repairHoursLabel = new JLabel("Number of hours:");
        repairHoursField = new JTextField(10);
        repairTotalLabel = new JLabel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Creating layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));
        mainPanel.setPreferredSize(new Dimension(350, 120));

        mainPanel.add(phoneLabel);
        mainPanel.add(new JLabel());
        mainPanel.add(phonePriceLabel);
        mainPanel.add(phonePriceField);
        mainPanel.add(phoneQuantityLabel);
        mainPanel.add(phoneQuantityField);
        mainPanel.add(phoneTotalLabel);

        JPanel repairPanel = new JPanel();
        repairPanel.setLayout(new GridLayout(4, 2));
        repairPanel.setPreferredSize(new Dimension(350, 120));

        repairPanel.add(repairLabel);
        repairPanel.add(new JLabel());
        repairPanel.add(repairPriceLabel);
        repairPanel.add(repairPriceField);
        repairPanel.add(repairHoursLabel);
        repairPanel.add(repairHoursField);
        repairPanel.add(repairTotalLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(mainPanel, BorderLayout.NORTH);
        container.add(repairPanel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate")) {
            // Calculate total sales for phones
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
            double phoneTotal = phonePrice * phoneQuantity;
            phoneTotalLabel.setText("Total sales for phones: ₱" + phoneTotal);

            // Calculate total sales for repair services
            double repairPrice = Double.parseDouble(repairPriceField.getText());
            int repairHours = Integer.parseInt(repairHoursField.getText());
            double repairTotal = repairPrice * repairHours;
            repairTotalLabel.setText("Total sales for repair services: ₱" + repairTotal);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SalesCalculator calculator = new SalesCalculator();
                calculator.setVisible(true);
            }
        });
    }
}
