package calculeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// ����� �������� ��������
public class Click_Delete implements ActionListener { // ��������� ��������� ���������
    JList list_save;// ��������� ����
    String [] elements;
    JLabel inf;
    JPanel mainPanel;
//������� �����������
    Click_Delete(JList list_save, String [] elements, JLabel inf, JPanel mainPanel) {
        this.list_save = list_save;
        this.elements = elements;
        this.inf = inf;
        this.mainPanel = mainPanel;
    }
// �������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            delete();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
//����� �������� ��������
    public void delete () throws IOException {
        if (list_save.getSelectedIndex() != -1) {// ���� �������� �������
            try (FileReader n = new FileReader("save.txt")) {// ��������� ���� ����������
                String y = (String) list_save.getSelectedValue();
                BufferedReader f = new BufferedReader(n);
                FileWriter c = new FileWriter("save2.txt");//������� ��������� ����
                String str = new String();
                while ((str = f.readLine()) != null) {// ��������� ��� ��������, ����� ����������, � ��������� ����
                    if(!str.equals(y)){
                        c.write(str+"\n");
                    }
                }
                f.close();//��������� ������
                c.close();
                FileReader n2 = new FileReader("save2.txt");// ��������� ��������� ����
                f = new BufferedReader(n2);
                c = new FileWriter("save.txt");// ��������� ���� ����������
                int i =0;
                String elements2 [] = new String[elements.length];// ������� ������ ��������
                while ((str = f.readLine()) != null){//��������� �������� � ���������� ����� � ������
                        c.write(str + "\n");
                        elements2[i] = str;
                        i++;
                }
                mainPanel.remove(0);//������� ������ ����
                list_save = new JList(elements2);//������� ����� ����
                JScrollPane scroll = new JScrollPane(list_save);//��������� �����
                scroll.setPreferredSize(new Dimension(100, 100));
                mainPanel.add(scroll, 0);//��������� ����� ���� �� ������
                mainPanel.revalidate();// ��������� ������
                f.close();//��������� ������
                c.close();
                n2.close();
                new File ("save2.txt").delete();//������� �������� ����
                inf.setText("����:�������� �������");
            }
                    catch(FileNotFoundException e){// ���������� �� ������ ��������� ����� ����������
                    JOptionPane.showMessageDialog(new JFrame(), "���� �� ������", "��������������", JOptionPane.ERROR_MESSAGE);
                }
            }
        else{
                JOptionPane.showMessageDialog(new JFrame(), "�������� ������� ��� ��������", "��������������", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
