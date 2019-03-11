package FrontEnd;

import BackEnd.Operatie;

public class MVCCalculator {
    public static void main(String[] args) {

        Operatie theModel = new Operatie();
        CalculatorView theView = new CalculatorView();
        CalculatorController theController = new CalculatorController(theView, theModel);
        theView.setVisible(true);
    }
}