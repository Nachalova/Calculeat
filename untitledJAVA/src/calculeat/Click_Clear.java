package calculeat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// ����� �������
public class Click_Clear implements ActionListener {// ��������� ��������� ���������
    public JTextField re, im, re3, im3, tang, pokaz;//������ ����
    JLabel inf = new JLabel("");
    boolean s;
//������ ����������� ��� ������� ���������� � ������ �� ����������� �����
    Click_Clear(JTextField re, JTextField im, JTextField re3, JTextField im3, JTextField tang, JTextField pokaz, JLabel inf) {
        this.re = re;
        this.im = im;
        this.re3 = re3;
        this.im3 = im3;
        this.tang = tang;
        this.pokaz = pokaz;
        this.inf = inf;
        s = true;
    }
// ������ ����������� ��� ������� ����������
    Click_Clear( JTextField re3, JTextField im3, JTextField tang, JTextField pokaz) {
        this.re3 = re3;
        this.im3 = im3;
        this.tang = tang;
        this.pokaz = pokaz;
        s = false;
    }
    // �������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e) {
        clear();// ������� ����� �������
    }
// ������ ����� �������
    public void clear () {
        if(s) {// ������ ��������� � ����������� �����
            re.setText("");
            im.setText("");
            inf.setText("����:������ �������");
        }
        else{// ������ ���������
            inf.setText("����:��������� ������");
        }
        re3.setText("");
        im3.setText("");
        tang.setText("");
        pokaz.setText("");
    }
}