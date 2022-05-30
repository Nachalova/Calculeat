package calculeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Класс удаления значения
public class Click_Delete implements ActionListener { // Наследуем интерфейс слушателя
    JList list_save;// Добавляем поля
    String [] elements;
    JLabel inf;
    JPanel mainPanel;
//Создаем конструктор
    Click_Delete(JList list_save, String [] elements, JLabel inf, JPanel mainPanel) {
        this.list_save = list_save;
        this.elements = elements;
        this.inf = inf;
        this.mainPanel = mainPanel;
    }
// Переопределяем метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            delete();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
//Метод удаления значения
    public void delete () throws IOException {
        if (list_save.getSelectedIndex() != -1) {// Если значение выбрано
            try (FileReader n = new FileReader("save.txt")) {// Открываем файл сохранения
                String y = (String) list_save.getSelectedValue();
                BufferedReader f = new BufferedReader(n);
                FileWriter c = new FileWriter("save2.txt");//Создаем временный файл
                String str = new String();
                while ((str = f.readLine()) != null) {// Переносим все значения, кроме удаляемого, в временный файл
                    if(!str.equals(y)){
                        c.write(str+"\n");
                    }
                }
                f.close();//Закрываем потоки
                c.close();
                FileReader n2 = new FileReader("save2.txt");// Открываем временный файл
                f = new BufferedReader(n2);
                c = new FileWriter("save.txt");// Открываем файл сохранения
                int i =0;
                String elements2 [] = new String[elements.length];// Создаем массив значений
                while ((str = f.readLine()) != null){//Сохраняем значения с временного файла в массив
                        c.write(str + "\n");
                        elements2[i] = str;
                        i++;
                }
                mainPanel.remove(0);//Удаляем старый лсит
                list_save = new JList(elements2);//Создаем новый лист
                JScrollPane scroll = new JScrollPane(list_save);//Добавляем скрол
                scroll.setPreferredSize(new Dimension(100, 100));
                mainPanel.add(scroll, 0);//Добавляем новый лист на панель
                mainPanel.revalidate();// Обновляем панель
                f.close();//Закрываем потоки
                c.close();
                n2.close();
                new File ("save2.txt").delete();//Удаляем врменный файл
                inf.setText("Инфо:Значение удалено");
            }
                    catch(FileNotFoundException e){// Исключение на случай отсутсвия файла сохранения
                    JOptionPane.showMessageDialog(new JFrame(), "Файл не найден", "предупреждение", JOptionPane.ERROR_MESSAGE);
                }
            }
        else{
                JOptionPane.showMessageDialog(new JFrame(), "Выберите значние для удаления", "предупреждение", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
