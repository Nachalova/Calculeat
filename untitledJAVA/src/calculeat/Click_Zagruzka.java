package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//Класс загрузки значения
public class Click_Zagruzka implements ActionListener {// Унаследую интерфейс слушателя 
    JTextField re1, im1, re2, im2;// Создаю поля
    calculeat.Click_Clear clear;
    JList list_save;
    JLabel inf;
    JFrame download;
    JComboBox icheika, getform1,getform2;
    Click_Delete del;
//Создаю конструктор
    Click_Zagruzka (JTextField re1, JTextField im1, JTextField re2, JTextField im2, JList list_save, JLabel inf, JFrame download, Click_Clear clear, JComboBox icheika, Click_Delete del, JComboBox getform1, JComboBox getform2){
        this.re1 = re1;
        this.im1 = im1;
        this.re2 = re2;
        this.im2 = im2;
        this.list_save = list_save;
        this.inf = inf;
        this.download = download;
        this.clear = clear;
        this.icheika = icheika;
        this.del = del;
        this.getform1 = getform1;
        this.getform2 = getform2;
    }
//Переопределяю метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e){
        {
            try {
                zagruz();// Вызваю метод загрузки значения
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    //Создаю метод загрузки значения
    public void zagruz() throws IOException {
        list_save = del.list_save;// Беру значения листа с класса удаления
        if (list_save.getSelectedIndex()!= -1){//Если выбран элемент
            try {
                String y = list_save.getSelectedValue().toString();//Беру значение
                char[] i = y.toCharArray();// Преобразую String в Char
                int f=0;
                int[] n = new int[y.length()];
                for (int t =0;t<y.length()-1;t++) {//Запоминаю где находятся лишние пробелы
                    if (i[t] == ' ') {
                        n[t] = 1;
                    } else {
                        n[t] = 0;
                        f++;
                    }
                    if (f > 0) {
                        if (i[t] == ' ' && i[t + 1] == ' ') {
                            n[t] = 1;
                        } else {
                            n[t] = 0;
                        }
                    }
                }
                StringBuffer x = new StringBuffer(y);
                for (int t =y.length()-1;t>=0;t--) {//Удаляю лишние пробелы
                    if (n[t]==1) {
                        x.deleteCharAt(t);
                    }
                }
                y = x.toString();
                String s [] = y.split(" ");// Разделяю строку с значением на две части
                if (icheika.getSelectedIndex()==0) {//Записываю значения в выбранные ячейки
                    re1.setText(s[0].replace(',', '.'));
                    im1.setText(s[1].replace(',', '.'));
                    getform1.setSelectedIndex(0);
                    if (re1.getText().length()>0&&im1.getText().length()>0) {
                        inf.setText("Инфо:Значение загружено");
                    }
                    else {
                        inf.setText("Инфо:Значение не загружено или загружено частично");
                    }
                }
                else{
                    re2.setText(s[0].replace(',', '.'));
                    im2.setText(s[1].replace(',', '.'));
                    getform2.setSelectedIndex(0);
                    if (re2.getText().length()>0&&im2.getText().length()>0) {
                        inf.setText("Инфо:Значение загружено");
                    }
                    else {
                        inf.setText("Инфо:Значение не загружено или загружено частично");
                    }
                }
                download.dispose();
                clear.clear();
            }
            catch (IndexOutOfBoundsException e){// Исключение на случай если данные не допустимого значения
                JOptionPane.showMessageDialog(new JFrame(), "Выбранное значение не может быть загружено","предупреждение",JOptionPane.WARNING_MESSAGE);
                inf.setText("Инфо:Значение не загружено");
            }
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Выберите значение для загрузки","предупреждение",JOptionPane.ERROR_MESSAGE);
        }
    }
}
