package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Класс выбора формы числа
public class Click_Form implements ActionListener {// Наследуем интерфейс слушателя
    JTextField re, im;// Создаем поля
    JLabel j, pl, cos, sin, exs, skob;
    JComboBox getform;
    //Создаем конструктор
    Click_Form (JComboBox getform, JTextField re, JTextField im, JLabel j, JLabel pl, JLabel cos, JLabel sin, JLabel exs, JLabel skob){
        this.getform = getform;
        this.re = re;
        this.im = im;
        this.j = j;
        this.pl = pl;
        this.cos = cos;
        this.sin = sin;
        this.exs = exs;
        this.skob = skob;
    }
    //Переопределяем метод унаследованого класса
    @Override
    public void actionPerformed(ActionEvent e) {
        if(getform.getSelectedIndex()==0){//В зависимости от выбранной формы скрываем виджеты
            pl.setVisible(true);
            j.setVisible(true);
            cos.setVisible(false);
            sin.setVisible(false);
            exs.setVisible(false);
            skob.setVisible(false);
        }
        else if(getform.getSelectedIndex()==1){
            pl.setVisible(false);
            j.setVisible(false);
            cos.setVisible(true);
            sin.setVisible(true);
            exs.setVisible(false);
            skob.setVisible(false);
        }
        else{
            pl.setVisible(false);
            j.setVisible(false);
            cos.setVisible(false);
            sin.setVisible(false);
            exs.setVisible(true);
            skob.setVisible(true);
        }
    }
}
