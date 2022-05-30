package calculeat;


import javax.swing.*;
import java.awt.*;

public class Grafik extends JComponent {
    Color graphicColor = Color.GREEN; // Цвет графика
    int width,height,xz = 0,yz = 0, sx=0,sy=0;;
    Grafik(JTextField re3,JTextField im3) {
        if (re3.getText().length() >0) { // Проверяем не пустой ли результат
            this.xz = (int) (Double.parseDouble(re3.getText().replace(',', '.')));
            this.yz = (int) (Double.parseDouble(im3.getText().replace(',', '.')));
        }
    }

    //Переопределяем метод унаследованого класса
    @Override
    protected void paintComponent(Graphics g) {
        width = getWidth(); // сохраняем текущую ширину панели
        height = getHeight();// сохраняем текущую высоту панели
        drawGrid(g); // рисуем сетку
        drawAxis(g); // рисуем оси
        if (xz != 0 || yz != 0) {
            drawGraphic(g);
        }
    }
    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for(int x=width/2; x<width; x+=30){  // цикл от центра до правого края
            g.drawLine(x, 0, x, height);    // вертикальная линия
        }

        for(int x=width/2; x>0; x-=30){  // цикл от центра до леваого края
            g.drawLine(x, 0, x, height);   // вертикальная линия
        }

        for(int y=height/2; y<height; y+=30){  // цикл от центра до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }

        for(int y=height/2; y>0; y-=30){  // цикл от центра до леваого края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width/2, 0, width/2, height);
        g.drawLine(0, height/2, width, height/2);
    }
    private void drawGraphic(Graphics g) {
        int coeff = 1; // коэффициент для сжатия прямой
        if (Math.abs(xz)> Math.abs(yz)){
            coeff = Math.abs(xz)/(width/2) +1;
        }
        else{
            coeff = Math.abs(yz)/(height/2) +1;;
        }
        g.setColor(graphicColor); // устанавливаем цвет графика
        sx = (width/2 +xz/coeff);
        sy = (height/2 - yz/coeff);
        System.out.println(sx);
        System.out.println(sy);
        System.out.println(width/2);
        System.out.println(height/2);
        System.out.println(coeff);
        g.drawLine(width/2, height/2, sx, sy);   // рисуем прямую
    }
}
