package calculeat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// Класс сохранения
public class Click_Save implements ActionListener {//Унаследую интерфейс слушателя
    JTextField re3, im3;// Создаю поля
    JLabel inf;
    String file;
    //Создаю конструктор
    Click_Save (JTextField re3, JTextField im3, String file, JLabel inf){
        this.re3 = re3;
        this.im3 = im3;
        this.inf = inf;
        this.file = file;
    }
// Переопределяю метод унаследованого интерфейса
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            save(file);// Вызываю метод сохранения
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
//Создаю метод сохранения
    public void save (String file) throws IOException{
        try(FileWriter c = new FileWriter(file,true)) {//Открываю поток
            if (re3.getText().length()>0) {//Если результат не пуст
                c.append(re3.getText() + " ");//Беру значение в алгебраической форме и записываю в файл сохранения
                c.append(im3.getText() + "\n");
                inf.setText("Инфо:Результат сохранён");
            }
            else{
                inf.setText("Инфо:Результат не сохранён. Значение результата пустое");
            }
        }
        catch (FileNotFoundException u){// Исключение на случай отсутствия файла
            inf.setText("Инфо:Результат не сохранён");
        }
    }
}
