package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//����� �������� ��������
public class Click_Zagruzka implements ActionListener {// ��������� ��������� ��������� 
    JTextField re1, im1, re2, im2;// ������ ����
    calculeat.Click_Clear clear;
    JList list_save;
    JLabel inf;
    JFrame download;
    JComboBox icheika, getform1,getform2;
    Click_Delete del;
//������ �����������
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
//������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e){
        {
            try {
                zagruz();// ������ ����� �������� ��������
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    //������ ����� �������� ��������
    public void zagruz() throws IOException {
        list_save = del.list_save;// ���� �������� ����� � ������ ��������
        if (list_save.getSelectedIndex()!= -1){//���� ������ �������
            try {
                String y = list_save.getSelectedValue().toString();//���� ��������
                char[] i = y.toCharArray();// ���������� String � Char
                int f=0;
                int[] n = new int[y.length()];
                for (int t =0;t<y.length()-1;t++) {//��������� ��� ��������� ������ �������
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
                for (int t =y.length()-1;t>=0;t--) {//������ ������ �������
                    if (n[t]==1) {
                        x.deleteCharAt(t);
                    }
                }
                y = x.toString();
                String s [] = y.split(" ");// �������� ������ � ��������� �� ��� �����
                if (icheika.getSelectedIndex()==0) {//��������� �������� � ��������� ������
                    re1.setText(s[0].replace(',', '.'));
                    im1.setText(s[1].replace(',', '.'));
                    getform1.setSelectedIndex(0);
                    if (re1.getText().length()>0&&im1.getText().length()>0) {
                        inf.setText("����:�������� ���������");
                    }
                    else {
                        inf.setText("����:�������� �� ��������� ��� ��������� ��������");
                    }
                }
                else{
                    re2.setText(s[0].replace(',', '.'));
                    im2.setText(s[1].replace(',', '.'));
                    getform2.setSelectedIndex(0);
                    if (re2.getText().length()>0&&im2.getText().length()>0) {
                        inf.setText("����:�������� ���������");
                    }
                    else {
                        inf.setText("����:�������� �� ��������� ��� ��������� ��������");
                    }
                }
                download.dispose();
                clear.clear();
            }
            catch (IndexOutOfBoundsException e){// ���������� �� ������ ���� ������ �� ����������� ��������
                JOptionPane.showMessageDialog(new JFrame(), "��������� �������� �� ����� ���� ���������","��������������",JOptionPane.WARNING_MESSAGE);
                inf.setText("����:�������� �� ���������");
            }
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "�������� �������� ��� ��������","��������������",JOptionPane.ERROR_MESSAGE);
        }
    }
}
