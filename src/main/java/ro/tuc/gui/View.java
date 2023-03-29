package ro.tuc.gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel contentPane;
    private JTextField firstNumberTextField;
    private JTextField secondNumberTextField;
    private JComboBox operationsComboBox;
    private JLabel resultValueLabel;

    Controller controller = new Controller(this);

    public View(String name) {
        super(name);
        this.prepareGui();
    }

    public void prepareGui(){
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2, 2));
        this.prepareNumbersPanel();
        this.prepareResultPanel();
        this.setContentPane(this.contentPane);
    }

    private void prepareResultPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1,1));
        JLabel resultLabel = new JLabel("Result", JLabel.CENTER);
        this.resultValueLabel = new JLabel("", JLabel.CENTER);
        resultPanel.add(resultLabel);
        resultPanel.add(this.resultValueLabel);
        this.contentPane.add(resultPanel);
    }

    private void prepareNumbersPanel() {
        JPanel numbersPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(5, 2));
        JLabel firstNumberLabel = new JLabel("First number", JLabel.CENTER);
        numbersPanel.add(firstNumberLabel);
        this.firstNumberTextField = new JTextField();
        numbersPanel.add(this.firstNumberTextField);
        JLabel secondNumberLabel = new JLabel("Second number", JLabel.CENTER);
        numbersPanel.add(secondNumberLabel);
        this.secondNumberTextField = new JTextField();
        numbersPanel.add(secondNumberTextField);
        JLabel operationsLabel = new JLabel("Select operation", JLabel.CENTER);
        numbersPanel.add(operationsLabel);
        String[] operations = new String[]{"Adunare", "Scadere", "Inmultire", "Derivare", "Integrare"};
        this.operationsComboBox = new JComboBox(operations);
        numbersPanel.add(operationsComboBox);
        JButton computeButton = new JButton("Compute");
        computeButton.setActionCommand("COMPUTE");
        computeButton.addActionListener(this.controller);
        numbersPanel.add(computeButton);
        this.contentPane.add(numbersPanel);
    }

    public JTextField getFirstNumberTextField() {
        return firstNumberTextField;
    }

    public JTextField getSecondNumberTextField() {
        return secondNumberTextField;
    }

    public JComboBox getOperationsComboBox() {
        return operationsComboBox;
    }

    public JLabel getResultValueLabel() {
        return resultValueLabel;
    }
}
