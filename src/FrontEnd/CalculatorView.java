package FrontEnd;

import BackEnd.*;

import java.awt.event.ActionListener;
import javax.swing.*;


public class
CalculatorView extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel polinomUnuText = new JLabel("Polinom 1");
    private JLabel polinomDoiText = new JLabel("Polinom 2");
    private JLabel rezultat = new JLabel("Rezultat");
    private JLabel rest = new JLabel("Rest");


    private JTextField polinomUnuTextBox = new JTextField();
    private JTextField polinomDoiTextBox = new JTextField();


    private JButton calculezaRezultatButon = new JButton("Calculeza");

    private String[] operatiiSritng = {"+", "-", "*", "/", "Deriveaza", "Integreaza"};
    public JComboBox opertatiiList = new JComboBox(operatiiSritng);

    private JTextField calcSolution = new JTextField();
    private JTextField restSolution = new JTextField();


    CalculatorView() {

        //text Label
        polinomUnuText.setBounds(120, 20, 80, 20);
        polinomDoiText.setBounds(120, 170, 80, 20);
        rezultat.setBounds(560, 20, 200, 20);
        rest.setBounds(570, 165, 50, 30);

        polinomUnuTextBox.setBounds(20, 40, 350, 20);
        polinomDoiTextBox.setBounds(20, 190, 350, 20);
        calcSolution.setBounds(400, 40, 350, 20);
        restSolution.setBounds(400, 190, 350, 20);

        //jButton
        calculezaRezultatButon.setBounds(330, 100, 100, 20);

        //combo box
        opertatiiList.setSelectedIndex(5);
        opertatiiList.setBounds(90, 100, 120, 20);

        //panel
        panel.add(polinomUnuTextBox);
        panel.add(polinomDoiTextBox);
        panel.add(calcSolution);
        panel.add(polinomUnuText);
        panel.add(polinomDoiText);
        panel.add(rezultat);
        panel.add(rest);
        panel.add(restSolution);

        panel.add(calculezaRezultatButon);

        panel.add(opertatiiList);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 300);
        panel.setLayout(null);
        this.setTitle("Calculator Polinomial");
        setVisible(true);
    }


    public Polinom getPolinomUnuTextBox() {

        Polinom pol = new Polinom(polinomUnuTextBox.getText());
        return pol;
    }

    public Polinom getPolinomDoiTextBox() {

        Polinom pol = new Polinom(polinomDoiTextBox.getText());
        return pol;
    }


    public void setRezultat(Polinom polinom) {
        calcSolution.setText(polinom.toString());

    }

    public void setRestSolution(Polinom polinom) {
        restSolution.setText(polinom.toString());

    }

    void solutieCalculateListener(ActionListener listenForCalcButton) {
        calculezaRezultatButon.addActionListener(listenForCalcButton);
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}

