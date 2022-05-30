package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Класс выхода
public class Click_Exit implements ActionListener {// Наследую интерфейс слушателя
    JFrame okno;// Создаю поле
//Создаю конструктор
    Click_Exit(JFrame okno) {
        this.okno = okno;
    }
// Переопределяю метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e) {
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.dispose();// Закрываю окно
        System.exit(0);
    }
}
