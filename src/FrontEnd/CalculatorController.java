package FrontEnd;

import BackEnd.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController {

    private CalculatorView theView;
    private Operatie operatieModel;

    public CalculatorController(CalculatorView theView,
                                Operatie operatieModel) {
        this.theView = theView;
        this.operatieModel = operatieModel;

        this.theView.solutieCalculateListener(new CalculateListenerRezultat());

    }

    class CalculateListenerRezultat implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String operatieSelectata = (String) theView.opertatiiList.getSelectedItem();
            System.out.println("Operatie Selectata: " + operatieSelectata);

            Polinom p1 = new Polinom();
            Polinom p2 = new Polinom();
            Polinom rezultat;

            try {

                p1 = theView.getPolinomUnuTextBox();
                p2 = theView.getPolinomDoiTextBox();
                if (p1.getPolinom().isEmpty() || p2.getPolinom().isEmpty())
                    throw new NumberFormatException();

                p1.sortarePolinom();
                p1.eliminaDuplicate();
                p1.eliminaZero();

                p2.sortarePolinom();
                p2.eliminaDuplicate();
                p2.eliminaZero();

            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("Parametrii Invalizi!");
            }

            switch (operatieSelectata) {

                case "+": {

                    rezultat = operatieModel.adunare(p1, p2);
                    rezultat.sortarePolinom();
                    rezultat.eliminaDuplicate();
                    rezultat.eliminaZero();
                    theView.setRezultat(rezultat);

                    System.out.println("+");


                    break;
                }

                case "-": {

                    rezultat = operatieModel.scadere(p1, p2);
                    rezultat.sortarePolinom();
                    rezultat.eliminaDuplicate();
                    rezultat.eliminaZero();
                    theView.setRezultat(rezultat);

                    System.out.println("-");

                    break;
                }

                case "*": {

                    rezultat = operatieModel.inmultire(p1, p2);
                    System.out.println(rezultat);
                    rezultat.sortarePolinom();
                    rezultat.eliminaDuplicate();
                    rezultat.eliminaZero();

                    theView.setRezultat(rezultat);

                    System.out.println("*");

                    break;
                }

                case "/": {


                    if (p1.getGradPol() < p2.getGradPol())
                        theView.displayErrorMessage("Atentie! Grad polinom 1 < Grad polinom 2!");
                    if (!p2.getPolinom().isEmpty()) {

                        rezultat = operatieModel.impartire(p1, p2, true);
                        rezultat.sortarePolinom();
                        rezultat.eliminaDuplicate();
                        rezultat.eliminaZero();
                        theView.setRezultat(rezultat);

                        rezultat = operatieModel.impartire(p1, p2, false);
                        rezultat.sortarePolinom();
                        rezultat.eliminaDuplicate();
                        rezultat.eliminaZero();

                        theView.setRestSolution(rezultat);
                    }
                    else
                        theView.displayErrorMessage("Impartire cu 0");

                    System.out.println("/");

                    break;
                }

                case "Deriveaza": {

                    rezultat = operatieModel.derivare(p1);

                    rezultat.sortarePolinom();
                    rezultat.eliminaDuplicate();
                    rezultat.eliminaZero();

                    theView.setRezultat(rezultat);

                    System.out.println("Deriveaza");

                    break;
                }

                case "Integreaza": {

                    System.out.println(p1);
                    rezultat = operatieModel.integrare(p1);
                    rezultat.sortarePolinom();
                    rezultat.eliminaDuplicate();
                    rezultat.eliminaZero();

                    theView.setRezultat(rezultat);

                    System.out.println("Integreaza");

                    break;
                }

                default:
                    theView.displayErrorMessage("A aparut o eroare in selectarea operatiei!");
            }

        }
    }
}
