package calculeat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Класс очистки
public class Click_Clear implements ActionListener {// Унаследую интерфейс слушателя
    public JTextField re, im, re3, im3, tang, pokaz;//Создаю поля
    JLabel inf = new JLabel("");
    boolean s;
//Создаю конструктор для очистки результата и одного из комплексных чисел
    Click_Clear(JTextField re, JTextField im, JTextField re3, JTextField im3, JTextField tang, JTextField pokaz, JLabel inf) {
        this.re = re;
        this.im = im;
        this.re3 = re3;
        this.im3 = im3;
        this.tang = tang;
        this.pokaz = pokaz;
        this.inf = inf;
        s = true;
    }
// Создаю конструктор для очистки результата
    Click_Clear( JTextField re3, JTextField im3, JTextField tang, JTextField pokaz) {
        this.re3 = re3;
        this.im3 = im3;
        this.tang = tang;
        this.pokaz = pokaz;
        s = false;
    }
    // Переопределяем метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e) {
        clear();// Вызываю метод очистки
    }
// Создаю метод очистки
    public void clear () {
        if(s) {// Очищаю результат и комплексное число
            re.setText("");
            im.setText("");
            inf.setText("Инфо:Ячейки очищены");
        }
        else{// Очищаю результат
            inf.setText("Инфо:Результат очищен");
        }
        re3.setText("");
        im3.setText("");
        tang.setText("");
        pokaz.setText("");
    }
}