package calculeat;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
// Класс валидатор для ячеек ввода данных
public class MyInputVerifier extends PlainDocument { // Унаследуем класс PlainDocument
    boolean bool = true;// Создаем поля
    String chars = "0123456789.-";
    //Создаем конструктор
    MyInputVerifier (boolean bool){
        this.bool = bool;
    }
    //Переопределяем метод унаследованого класса
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(bool) {// Еслия ячейка ввода комплексного числа
        }
        else {// Если ячейка ввода степени
            chars = "0123456789";
        }
        for (int i = 0; i < str.length(); i++) {// Проверяем допустимые ли значения вводит пользователь
                if (!chars.contains(str.substring(i, i + 1))) return;
        }
            if (bool&&getLength() < 25) {
                super.insertString(offs, str, a);
            }
            if (!bool&&getLength() < 1) {
                super.insertString(offs, str, a);
            }
        }
    }

