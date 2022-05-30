package calculeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// Класс загрузки
public class Click_Download implements ActionListener {// Наследуем интерфейс слушателя
    JTextField re1, im1, re2, im2;// Добавляем поля
    JLabel inf;
    calculeat.Click_Clear clear;
    JComboBox getform1,getform2;
// Создаем конструктор
    Click_Download (JTextField re1, JTextField im1, JTextField re2, JTextField im2, JLabel inf, Click_Clear clear, JComboBox getform1, JComboBox getform2){
        this.re1 = re1;
        this.im1 = im1;
        this.re2 = re2;
        this.im2 = im2;
        this.inf = inf;
        this.clear = clear;
        this.getform1 = getform1;
        this.getform2 = getform2;

    }
// Переопределяем метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            download();// Вызываем метод загрузки
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
// метод загрузки
    public void download() throws IOException {
        try(FileReader n = new FileReader("save.txt")){ // открываем файл сохранения в режиме чтения
            BufferedReader f = new BufferedReader(n);
            JLabel fibor = new JLabel("В какую ячейку загрузить:");// Создаем виджеты
            String courses[] = {"1", "2"};
            JComboBox icheika = new JComboBox(courses);
            JPanel mainPanel = new JPanel(); // Создаем панель на которой будут размещены виджеты
            JButton zagruz = new JButton("Загрузить число");
            JButton delete = new JButton("Удалить");
            JFrame c = new JFrame("Сохранённые результаты"); // Создаем окно на котором будет размещена наша панель
            String k;
            int i=0;
            while ((k=f.readLine())!=null) {// Узнаем количество строк в файле сохранения
                i++;
            }
            f.close();// Закрываем поток
            String elements[] =new String[i];
            JList list_save = new JList(elements);// Создаем лист
            calculeat.Click_Delete del = new Click_Delete(list_save, elements, inf, mainPanel);// // Создаем объект класса удаления значения
            JScrollPane scroll = new JScrollPane(list_save);// Добавляем скрол к листу
            scroll.setPreferredSize(new Dimension(100, 100));
            i = 0;
            FileReader u = new FileReader("save.txt");// Снова открываем наш файл в режиме чтения
            BufferedReader o = new BufferedReader(u);
            while ((k=o.readLine())!=null) {// Заполняем лист
                elements[i]=k;
                i++;
            }
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(scroll);// Добавялем лсит с скролом на панель
            JPanel panel = new JPanel();// Создаем панель для кнопок
            panel.setLayout(new GridLayout());
            panel.add(fibor);// Добавляем кнопки на панель
            panel.add(icheika);
            panel.add(zagruz);
            panel.add(delete);
            panel.setMaximumSize(new Dimension(700,100));//  Задаем максимальный размер для панели
            mainPanel.add(panel, BorderLayout.SOUTH);// Размещаем панель с кнопками на панель
            c.getContentPane().add(mainPanel);// Размещаем панель на окне
            c.setMinimumSize(new Dimension(700, 250));// Задаем минимальный и рекомендуемый размер окна
            c.setPreferredSize(new Dimension(700, 250));
            c.pack();
            c.setLocationRelativeTo(null);
            c.setVisible(true);
            u.close();// Закрываем потоки
            o.close();
            mainPanel.getComponent(0);
            inf.setText("Инфо:Файл сохранения открыт");
            delete.addActionListener(del);// Добавляем слушателя к кнопке удаления значения
            calculeat.Click_Zagruzka zagr = new Click_Zagruzka(re1, im1, re2, im2, list_save, inf, c, clear, icheika, del, getform1, getform2);// Создаем объект класса загрузки значения
            zagruz.addActionListener(zagr);// Добавлем слушателя к кнопке загрузки значения
        }
        catch (FileNotFoundException u){// обработка исключения на случай отсутствия файла сохранения
            inf.setText("Инфо:Нет сохраненных результатов");
        }
    }
}
