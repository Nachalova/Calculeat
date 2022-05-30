package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Класс выбора операции
public class Click_Operation implements ActionListener {// Наследуем интерфейс слушателя
// Создаем поля
    JComboBox operation, getform1, getform2;
    JTextField re1, im1, re2, im2, stepen;
    JLabel step, j1, j2, pl1, pl2, z1, z2, cos1, sin1, exs1, skob1, cos2, sin2, exs2, skob2;
    JButton clear1, clear2;
    calculeat.Click_Clear clear;
//Создаем конструктор
    Click_Operation (JComboBox operation, JComboBox  getform1, JComboBox getform2, JTextField re1, JTextField im1, JTextField re2, JTextField im2, JTextField stepen, JButton clear1, JButton clear2, JLabel z1, JLabel z2, JLabel j1, JLabel j2, JLabel pl1, JLabel pl2, JLabel step, JLabel cos1, JLabel sin1, JLabel exs1, JLabel skob1, JLabel cos2, JLabel sin2, JLabel exs2, JLabel skob2, Click_Clear clear){
        this.operation = operation;
        this.getform1 = getform1;
        this.getform2 = getform2;
        this.re1 = re1;
        this.im1 = im1;
        this.re2 = re2;
        this.im2 = im2;
        this.stepen = stepen;
        this.clear1 = clear1;
        this.clear2 = clear2;
        this.step = step;
        this.z1 = z1;
        this.z2 = z2;
        this.j1 = j1;
        this.j2 = j2;
        this.pl1 = pl1;
        this.pl2 = pl2;
        this.cos1 = cos1;
        this.sin1 = sin1;
        this.exs1 = exs1;
        this.skob1 = skob1;
        this.cos2 = cos2;
        this.sin2 = sin2;
        this.exs2 = exs2;
        this.skob2 = skob2;
        this.clear = clear;
    }
    //Переопределяем метод унаследованого класса
    @Override
    public void actionPerformed(ActionEvent e) {
        if (operation.getSelectedIndex()<4){// В зависимости от выбранной операции скрываем виджеты
            step.setVisible(false);
            stepen.setVisible(false);
            re1.setVisible(true);
            im1.setVisible(true);
            z1.setVisible(true);
            getform1.setVisible(true);
            if (getform1.getSelectedIndex()==0) {
                pl1.setVisible(true);
                j1.setVisible(true);
            }
            else if (getform1.getSelectedIndex()==1) {
                sin1.setVisible(true);
                cos1.setVisible(true);
            }
            else {
                exs1.setVisible(true);
                skob1.setVisible(true);
            }
            clear1.setVisible(true);
            re2.setVisible(true);
            im2.setVisible(true);
            z2.setVisible(true);
            getform2.setVisible(true);
            if (getform2.getSelectedIndex()==0) {
                pl2.setVisible(true);
                j2.setVisible(true);
            }
            else if (getform2.getSelectedIndex()==1) {
                sin2.setVisible(true);
                cos2.setVisible(true);
            }
            else {
                exs2.setVisible(true);
                skob2.setVisible(true);
            }
            clear2.setVisible(true);
            clear.clear();
        }
        else if (operation.getSelectedIndex()==4){
            step.setVisible(true);
            stepen.setVisible(true);
            re1.setVisible(true);
            im1.setVisible(true);
            z1.setVisible(true);
            getform1.setVisible(true);
            if (getform1.getSelectedIndex()==0) {
                pl1.setVisible(true);
                j1.setVisible(true);
            }
            else if (getform1.getSelectedIndex()==1) {
                sin1.setVisible(true);
                cos1.setVisible(true);
            }
            else {
                exs1.setVisible(true);
                skob1.setVisible(true);
            }
            clear1.setVisible(true);
            re2.setVisible(false);
            im2.setVisible(false);
            pl2.setVisible(false);
            j2.setVisible(false);
            z2.setVisible(false);
            cos2.setVisible(false);
            sin2.setVisible(false);
            exs2.setVisible(false);
            skob2.setVisible(false);
            getform2.setVisible(false);
            clear2.setVisible(false);
            stepen.setText("");
            re2.setText("");
            im2.setText("");
            clear.clear();
        }
        else if (operation.getSelectedIndex()==5){
            step.setVisible(true);
            stepen.setVisible(true);
            re2.setVisible(true);
            im2.setVisible(true);
            if (getform2.getSelectedIndex()==0) {
                pl2.setVisible(true);
                j2.setVisible(true);
            }
            else if (getform2.getSelectedIndex()==1) {
                sin2.setVisible(true);
                cos2.setVisible(true);
            }
            else {
                exs2.setVisible(true);
                skob2.setVisible(true);
            }
            z2.setVisible(true);
            getform2.setVisible(true);
            clear2.setVisible(true);
            re1.setVisible(false);
            im1.setVisible(false);
            pl1.setVisible(false);
            j1.setVisible(false);
            z1.setVisible(false);
            getform1.setVisible(false);
            cos1.setVisible(false);
            sin1.setVisible(false);
            exs1.setVisible(false);
            skob1.setVisible(false);
            clear1.setVisible(false);
            stepen.setText("");
            re1.setText("");
            im1.setText("");
            clear.clear();
        }
    }
}
