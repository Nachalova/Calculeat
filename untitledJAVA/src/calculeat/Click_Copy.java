package calculeat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Класс переноса значения
public class Click_Copy implements ActionListener {// Наследуем интерфейс слушателя
    JTextField re1 ,im1 ,re3 ,im3;//Добавляем поля
    calculeat.Click_Clear clear;
    JLabel inf;
    JComboBox getform1;
//Создаем конструктор
    Click_Copy(JComboBox getform1, JTextField re1, JTextField im1, JTextField re3, JTextField im3, Click_Clear clear, JLabel inf) {
        this.getform1 = getform1;
        this.re1 = re1;
        this.im1 = im1;
        this.re3 = re3;
        this.im3 = im3;
        this.clear = clear;
        this.inf = inf;
    }
    // Переопределяем метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e) {
        if (re3.getText().length()>0) {// Если результат не пуст
            getform1.setSelectedIndex(0);// Устанавливаем алгебраическую форму для первого числа
            re1.setText(re3.getText().replace(',', '.'));// переносим результат
            im1.setText(im3.getText().replace(',', '.'));
            clear.clear();// Очищаем ячейки
            inf.setText("Инфо:Результат перенесён");
        }
        else {
            inf.setText("Инфо:Результат пуст");
        }
    }
}
