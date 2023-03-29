package ro.tuc.gui;

import ro.tuc.logic.Operatii;
import ro.tuc.model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private final View view;

    private final Operatii operatie = new Operatii();

    public Controller(View v){
        this.view = v;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("COMPUTE")){
            Polinom firstNumber = Operatii.toPolinom(view.getFirstNumberTextField().getText());
            Polinom secondNumber = Operatii.toPolinom(view.getSecondNumberTextField().getText());
            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
            new Polinom();
            Polinom result = switch (operation) {
                case "Adunare" -> operatie.adunare(firstNumber, secondNumber);
                case "Scadere" -> operatie.scadere(firstNumber, secondNumber);
                case "Inmultire" -> operatie.inmultire(firstNumber, secondNumber);
                case "Derivare" -> operatie.derivare(firstNumber);
                case "Integrare" -> operatie.integrare(firstNumber);
                default -> new Polinom();
            };
            view.getResultValueLabel().setText(result.afisarePolinom());
        }
    }

}
