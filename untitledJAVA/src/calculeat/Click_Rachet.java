package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
//Класс расчета результата
public class Click_Rachet implements ActionListener  {// Наследуем интерфейс слушателя
    public JTextField re1, im1, re2, im2, re3, im3, tang, pokaz, stepen;// Создаем поля
    JComboBox operation, getform1, getform2;
    JLabel inf;
//Создаем конструктор
    Click_Rachet(JComboBox operation, JComboBox getform1, JComboBox getform2, JTextField re1, JTextField im1, JTextField re2, JTextField im2, JTextField re3, JTextField im3, JTextField tang, JTextField pokaz, JTextField stepen, JLabel inf) {
        this.operation = operation;
        this.getform1 = getform1;
        this.getform2 = getform2;
        this.re1 = re1;
        this.im1 = im1;
        this.re2 = re2;
        this.im2 = im2;
        this.re3 = re3;
        this.im3 = im3;
        this.tang = tang;
        this.pokaz = pokaz;
        this.stepen = stepen;
        this.inf = inf;
    }
    //Переопределяем метод унаследованого класса
    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {
        rachet();//Вызываем метод расчета
    }
//Создаем метод расчета
    public void rachet () throws NumberFormatException{
        //Проверяем корректность данных для проведения расчета
        boolean a = false, b = false;
        if (re1.getText().length()>0&&im1.getText().length()>0&&re2.getText().length()>0&&im2.getText().length()>0) {
            if (Double.valueOf(re1.getText()) == 0.0 && Double.valueOf(im1.getText()) == 0 || Double.valueOf(re2.getText()) == 0 && Double.valueOf(im2.getText()) == 0) {
                inf.setText("Инфо:Расчёт не произведён");
                JOptionPane.showMessageDialog(new JFrame(), "Не имеет смысла проводить операции с комплексными числами равными нулю", "предупреждение", JOptionPane.WARNING_MESSAGE);
                b = true;
            }
            else {
                a = true;
                b = true;
                }
        }
        if(operation.getSelectedIndex()==4&&re1.getText().length()>0&&im1.getText().length()>0&&stepen.getText().length()>0) {
            if (Double.valueOf(re1.getText()) == 0.0 && Double.valueOf(im1.getText()) == 0) {
                inf.setText("Инфо:Расчёт не произведён");
                JOptionPane.showMessageDialog(new JFrame(), "Не имеет смысла проводить операции с комплексным числом равными нулю", "предупреждение", JOptionPane.WARNING_MESSAGE);
                b = true;
            }
            else {
                a = true;
                b = true;
            }
        }
        if(operation.getSelectedIndex()==5&&re2.getText().length()>0&&im2.getText().length()>0&&stepen.getText().length()>0){
                if(Double.valueOf(re2.getText()) == 0.0 && Double.valueOf(im2.getText()) == 0) {
                    inf.setText("Инфо:Расчёт не произведён");
                    JOptionPane.showMessageDialog(new JFrame(), "Не имеет смысла проводить операции с комплексным числом равными нулю", "предупреждение", JOptionPane.WARNING_MESSAGE);
                    b = true;
                }
                else {
                    a = true;
                    b = true;
                }
        }
        if(!b) {
            inf.setText("Инфо:Расчёт не произведён");
            JOptionPane.showMessageDialog(new JFrame(), "Заполните все ячейки","предупреждение",JOptionPane.WARNING_MESSAGE);
        }
        if(a){//Если данные корректные произвожу расчет
            try {
                double t, p, z, x, l, k, g, m, mod, ygol;
                String result, result2;
                if (operation.getSelectedIndex() == 0) {// Проверяю какая операция была выбрана
                    t = Double.parseDouble(re1.getText());//Беру значения введенных комплексных чисел
                    p = Double.parseDouble(im1.getText());
                    z = Double.parseDouble(re2.getText());
                    x = Double.parseDouble(im2.getText());
                    if(getform1.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        p = t*Math.sin(Math.toRadians(p));
                        t = t*Math.cos(Math.toRadians(Double.parseDouble(im1.getText())));
                    }
                    if(getform2.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        x = z*Math.sin(Math.toRadians(x));
                        z = z*Math.cos(Math.toRadians(Double.parseDouble(im2.getText())));
                    }
                    result = String.format("%.6f", t + z);// Провожу вычисления и записываю результат в алгебраической форме
                    re3.setText(result);
                    result = String.format("%.6f", p + x);
                    im3.setText(result);
                    if ((t+z)==0&&(p+x)==0) {// Если получилось число равное нулю записываю в результат 0
                        pokaz.setText("0.000000");
                        tang.setText("0.000000");
                    }
                    else {
                        mod = Math.sqrt((t + z) * (t + z) + (p + x) * (p + x));
                        result = String.format("%.6f", mod);
                        if ((t + z) < 0 && (p + x) > 0 || (t + z) < 0 && (p + x) < 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                            ygol = 180 + Math.toDegrees(Math.atan((p + x) / (t + z)));
                        }
                        else {
                            ygol = Math.toDegrees(Math.atan((p + x) / (t + z)));
                        }
                        if (ygol<0){// Привожу значение угла к виду 0=<ygol=<2pi
                            ygol+=360;
                        }
                        ygol+=0;//Прибавляю 0, чтобы не было значения угла -0
                        result2 = String.format("%.6f", ygol);
                        pokaz.setText(result + "*" + "e^(j*" + result2 + "°)");// Записываю результат в показательной форме
                        tang.setText(result + "*(cos(" + result2 + "°)" + "+j*sin(" + result2 + "°))");// Записываю результат в тригонометрической форме
                    }
                }
                else if (operation.getSelectedIndex() == 1) {//Проверяю какая операция была выбрана
                    t = Double.parseDouble(re1.getText());//Беру значения введенных комплексных чисел
                    p = Double.parseDouble(im1.getText());
                    z = Double.parseDouble(re2.getText());
                    x = Double.parseDouble(im2.getText());
                    if(getform1.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        p = t*Math.sin(Math.toRadians(p));
                        t = t*Math.cos(Math.toRadians(Double.parseDouble(im1.getText())));
                    }
                    if(getform2.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        x = z*Math.sin(Math.toRadians(x));
                        z = z*Math.cos(Math.toRadians(Double.parseDouble(im2.getText())));
                    }
                    result = String.format("%.6f", t - z);// Провожу вычисления и записываю результат в алгебраической форме
                    re3.setText(result);
                    result = String.format("%.6f", p - x);
                    im3.setText(result);
                    if ((t - z) == 0 && (p - x) == 0) {
                        pokaz.setText("0.000000");
                        tang.setText("0.000000");
                    }
                    else {
                        mod = Math.sqrt((t - z) * (t - z) + (p - x) * (p - x));
                        result = String.format("%.6f", mod);
                        if ((t - z) < 0 && (p - x) > 0 || (t - z) < 0 && (p - x) < 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                            ygol = 180 + Math.toDegrees(Math.atan((p - x) / (t - z)));
                        }
                        else {
                            ygol = Math.toDegrees(Math.atan((p - x) / (t - z)));
                        }
                        if (ygol<0){// Привожу значение угла к виду 0=<ygol=<2pi
                            ygol+=360;
                        }
                        ygol+=0;//Прибавляю 0, чтобы не было значения угла -0
                        result2 = String.format("%.6f", ygol);
                        tang.setText(result + "*(cos(" + result2 + "°)" + "+j*sin(" + result2 + "°))");// Записываю результат в тригонометрической форме
                        pokaz.setText(result + "*" + "e^(j*" + result2 + "°)");// Записываю результат в показательной форме
                    }
                }
                else if (operation.getSelectedIndex() == 2) {// Проверяю какая операция была выбрана
                    t = Double.parseDouble(re1.getText());//Беру значения введенных комплексных чисел
                    p = Double.parseDouble(im1.getText());
                    z = Double.parseDouble(re2.getText());
                    x = Double.parseDouble(im2.getText());
                    if(getform1.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        p = t*Math.sin(Math.toRadians(p));
                        t = t*Math.cos(Math.toRadians(Double.parseDouble(im1.getText())));
                    }
                    if(getform2.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        x = z*Math.sin(Math.toRadians(x));
                        z = z*Math.cos(Math.toRadians(Double.parseDouble(im2.getText())));
                    }
                    l = Math.sqrt(t * t + p * p);
                    k = Math.sqrt(z * z + x * x);
                    g = Math.atan(p / t);
                    m = Math.atan(x / z);
                    mod = l * k;
                    if (t < 0 && p > 0 || t < 0 && p > 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                        g += Math.PI;
                    }
                    if (z < 0 && x > 0 || z < 0 && x > 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                        m += Math.PI;
                    }
                    ygol = g + m;
                    if (ygol<0){// Привожу значение угла к виду 0=<ygol=<2pi
                        ygol+=2*Math.PI;
                    }
                    ygol+=0;//Прибавляю 0, чтобы не было значения угла -0
                    result = String.format("%.6f", mod * Math.cos(ygol));// Провожу вычисления и записываю результат в алгебраической форме
                    re3.setText(result);
                    result = String.format("%.6f", mod * Math.sin(ygol));
                    im3.setText(result);
                    result = String.format("%.6f", mod);
                    result2 = String.format("%.6f", Math.toDegrees(ygol));
                    tang.setText(result + "*(cos(" + result2 + "°)" + "+j*sin(" + result2 + "°))");// Записываю результат в тригонометрической форме
                    pokaz.setText(result + "*" + "e^(j*" + result2 + "°)");// Записываю результат в показательной форме
                }
                else if (operation.getSelectedIndex() == 3) {// Проверяю какая операция была выбрана
                    t = Double.parseDouble(re1.getText());//Беру значения введенных комплексных чисел
                    p = Double.parseDouble(im1.getText());
                    z = Double.parseDouble(re2.getText());
                    x = Double.parseDouble(im2.getText());
                    if(getform1.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        p = t*Math.sin(Math.toRadians(p));
                        t = t*Math.cos(Math.toRadians(Double.parseDouble(im1.getText())));
                    }
                    if(getform2.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        x = z*Math.sin(Math.toRadians(x));
                        z = z*Math.cos(Math.toRadians(Double.parseDouble(im2.getText())));
                    }
                    l = Math.sqrt(t * t + p * p);
                    k = Math.sqrt(z * z + x * x);
                    g = Math.atan(p / t);
                    m = Math.atan(x / z);
                    mod = l / k;
                    if (t < 0 && p > 0 || t < 0 && p > 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                        g += Math.PI;
                    }
                    if (z < 0 && x > 0 || z < 0 && x > 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                        m += Math.PI;
                    }
                    ygol = g - m;
                    if (ygol<0){// Привожу значение угла к виду 0=<ygol=<2pi
                        ygol+=2*Math.PI;
                    }
                    ygol+=0;//Прибавляю 0, чтобы не было значения угла -0
                    result = String.format("%.6f", mod * Math.cos(ygol));// Провожу вычисления и записываю результат в алгебраической форме
                    re3.setText(result);
                    result = String.format("%.6f", mod * Math.sin(ygol));
                    im3.setText(result);
                    result = String.format("%.6f", mod);
                    result2 = String.format("%.6f", Math.toDegrees(ygol));
                    tang.setText(result + "*(cos(" + result2 + "°)" + "+j*sin(" + result2 + "°))");// Записываю результат в тригонометрической форме
                    pokaz.setText(result + "*" + "e^(j*" + result2 + "°)");// Записываю результат в показательной форме
                }
                else if (operation.getSelectedIndex() == 4){// Проверяю какая операция была выбрана
                    t = Double.parseDouble(re1.getText());//Беру значения введенного комплексного числа
                    p = Double.parseDouble(im1.getText());
                    l = Math.sqrt(t * t + p * p);
                    g = Math.atan(p / t);
                    if(getform1.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        p = t*Math.sin(Math.toRadians(p));
                        t = t*Math.cos(Math.toRadians(Double.parseDouble(im1.getText())));
                    }
                    if (t < 0 && p > 0 || t < 0 && p > 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                        g += Math.PI;
                    }
                    double step = Double.valueOf(stepen.getText());//Возвожу число в степень
                    mod = Math.pow(l,step);
                    ygol = g*step;
                    while (ygol>=2*Math.PI){
                        ygol-=2*Math.PI;
                    }
                    while (ygol<=-2*Math.PI){
                        ygol+=2*Math.PI;
                    }
                    if (ygol<0){// Привожу значение угла к виду 0=<ygol=<2pi
                        ygol+=2*Math.PI;
                    }
                    ygol+=0;//Прибавляю 0, чтобы не было значения угла -0
                    result = String.format("%.6f", mod * Math.cos(ygol));// Провожу вычисления и записываю результат в алгебраической форме
                    re3.setText(result);
                    result = String.format("%.6f", mod * Math.sin(ygol));
                    im3.setText(result);
                    result = String.format("%.6f", mod);
                    result2 = String.format("%.6f", Math.toDegrees(ygol));

                    tang.setText(result + "*(cos(" + result2 + "°)" + "+j*sin(" + result2 + "°))");// Записываю результат в тригонометрической форме
                    pokaz.setText(result + "*" + "e^(j*" + result2 + "°)");// Записываю результат в показательной форме
                }
                else {// Проверяю какая операция была выбрана
                    z = Double.parseDouble(re2.getText());//Беру значения введенного комплексного числа
                    x = Double.parseDouble(im2.getText());
                    if(getform2.getSelectedIndex()!=0){// Если форма числа не алгебраическая, то привожу к ней
                        x = z*Math.sin(Math.toRadians(x));
                        z = z*Math.cos(Math.toRadians(Double.parseDouble(im2.getText())));
                    }
                    k = Math.sqrt(z * z + x * x);
                    m = Math.atan(x / z);
                    if (z < 0 && x > 0 || z < 0 && x > 0) {// Прибавляю 180 градусов, если угол лежит в 3 или 4 четверти
                        m += Math.PI;
                    }
                    double step = Double.valueOf(stepen.getText());
                    mod = Math.pow(k,step);
                    ygol = m*step;
                    while (ygol>=2*Math.PI){
                        ygol-=2*Math.PI;
                    }
                    while (ygol<=-2*Math.PI){
                        ygol+=2*Math.PI;
                    }
                    if (ygol<0){// Привожу значение угла к виду 0=<ygol=<2pi
                        ygol+=2*Math.PI;
                    }
                    ygol+=0;//Прибавляю 0, чтобы не было значения угла -0
                    result = String.format("%.6f", mod * Math.cos(ygol));// Провожу вычисления и записываю результат в алгебраической форме
                    re3.setText(result);
                    result = String.format("%.6f", mod * Math.sin(ygol));
                    im3.setText(result);
                    result = String.format("%.6f", mod);
                    result2 = String.format("%.6f", Math.toDegrees(ygol));
                    tang.setText(result + "*(cos(" + result2 + "°)" + "+j*sin(" + result2 + "°))");// Записываю результат в тригонометрической форме
                    pokaz.setText(result + "*" + "e^(j*" + result2 + "°)");// Записываю результат в показательной форме
                }
                inf.setText("Инфо:Расчёт произведён успешно");
            }
            catch (NumberFormatException p) {// Обрабатываю исключение на случай возникновения ошибки
                inf.setText("Инфо:Расчёт не произведён");
                JOptionPane.showMessageDialog(new JFrame(), "Введены некорректные значения", "предупреждение", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

