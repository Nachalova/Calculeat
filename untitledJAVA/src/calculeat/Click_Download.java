package calculeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// ����� ��������
public class Click_Download implements ActionListener {// ��������� ��������� ���������
    JTextField re1, im1, re2, im2;// ��������� ����
    JLabel inf;
    calculeat.Click_Clear clear;
    JComboBox getform1,getform2;
// ������� �����������
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
// �������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            download();// �������� ����� ��������
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
// ����� ��������
    public void download() throws IOException {
        try(FileReader n = new FileReader("save.txt")){ // ��������� ���� ���������� � ������ ������
            BufferedReader f = new BufferedReader(n);
            JLabel fibor = new JLabel("� ����� ������ ���������:");// ������� �������
            String courses[] = {"1", "2"};
            JComboBox icheika = new JComboBox(courses);
            JPanel mainPanel = new JPanel(); // ������� ������ �� ������� ����� ��������� �������
            JButton zagruz = new JButton("��������� �����");
            JButton delete = new JButton("�������");
            JFrame c = new JFrame("���������� ����������"); // ������� ���� �� ������� ����� ��������� ���� ������
            String k;
            int i=0;
            while ((k=f.readLine())!=null) {// ������ ���������� ����� � ����� ����������
                i++;
            }
            f.close();// ��������� �����
            String elements[] =new String[i];
            JList list_save = new JList(elements);// ������� ����
            calculeat.Click_Delete del = new Click_Delete(list_save, elements, inf, mainPanel);// // ������� ������ ������ �������� ��������
            JScrollPane scroll = new JScrollPane(list_save);// ��������� ����� � �����
            scroll.setPreferredSize(new Dimension(100, 100));
            i = 0;
            FileReader u = new FileReader("save.txt");// ����� ��������� ��� ���� � ������ ������
            BufferedReader o = new BufferedReader(u);
            while ((k=o.readLine())!=null) {// ��������� ����
                elements[i]=k;
                i++;
            }
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(scroll);// ��������� ���� � ������� �� ������
            JPanel panel = new JPanel();// ������� ������ ��� ������
            panel.setLayout(new GridLayout());
            panel.add(fibor);// ��������� ������ �� ������
            panel.add(icheika);
            panel.add(zagruz);
            panel.add(delete);
            panel.setMaximumSize(new Dimension(700,100));//  ������ ������������ ������ ��� ������
            mainPanel.add(panel, BorderLayout.SOUTH);// ��������� ������ � �������� �� ������
            c.getContentPane().add(mainPanel);// ��������� ������ �� ����
            c.setMinimumSize(new Dimension(700, 250));// ������ ����������� � ������������� ������ ����
            c.setPreferredSize(new Dimension(700, 250));
            c.pack();
            c.setLocationRelativeTo(null);
            c.setVisible(true);
            u.close();// ��������� ������
            o.close();
            mainPanel.getComponent(0);
            inf.setText("����:���� ���������� ������");
            delete.addActionListener(del);// ��������� ��������� � ������ �������� ��������
            calculeat.Click_Zagruzka zagr = new Click_Zagruzka(re1, im1, re2, im2, list_save, inf, c, clear, icheika, del, getform1, getform2);// ������� ������ ������ �������� ��������
            zagruz.addActionListener(zagr);// �������� ��������� � ������ �������� ��������
        }
        catch (FileNotFoundException u){// ��������� ���������� �� ������ ���������� ����� ����������
            inf.setText("����:��� ����������� �����������");
        }
    }
}
