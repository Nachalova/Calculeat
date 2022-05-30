package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Класс помощи
public class Click_Help implements ActionListener {// Унаследую интерфейс слушателя
    // Переопределяем метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(new JFrame(), "Для выполнении операции введите комплексные числа  в специально отведенные ячейки,\nвыберите тип операции и нажмите кнопку 'рассчитать'. Для очистки  ячеек нажмите кнопку\n'очистить'. Для дальнейшей работы с полученным числом нажмите кнопку 'перенести\nрезультат'. Для сохранения результата нажмитие кнопку 'сохранить', а для загрузки 'загрузить'.\nДля построения графика нажмите 'построить график' ","Помощь",JOptionPane.PLAIN_MESSAGE, new ImageIcon("help.png"));
    }
}
