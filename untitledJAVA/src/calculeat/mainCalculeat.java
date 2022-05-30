package calculeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class mainCalculeat {
    public static void main(String[] args) {
        JFrame okno = new JFrame("����������� ����������� �����"); //������� �������� ���� ����������
        JMenuItem help = new JMenuItem("������");// ������� ������� ������� ����� ��������� �� ����� ����
        JMenuItem save = new JMenuItem("���������");
        JMenuItem download = new JMenuItem("���������");
        JMenuItem sp = new JMenuItem("��������� ������");
        JMenuItem exit = new JMenuItem("�����");
        JButton rafn = new JButton("����������");
        JButton clear1 = new JButton("��������");
        JButton clear2 = new JButton("��������");
        JButton perenos = new JButton("��������� ���������");
        JButton graf = new JButton("��������� ������");
        String courses1[] = {"+", "-", "*", ":", "�������� � ������� ������ �����", "�������� � ������� ������ �����"};
        JComboBox operation = new JComboBox(courses1);
        String courses2[] = {"�������������� �����", "������������������ �����", "���������������� �����"};
        JComboBox getform1 = new JComboBox(courses2);
        String courses3[] = {"�������������� �����", "������������������ �����", "���������������� �����"};
        JComboBox getform2 = new JComboBox(courses3);
        JLabel z1 = new JLabel("������ �����:");
        JLabel z2 = new JLabel("������ �����:");
        JLabel step = new JLabel("������� �����(����� ����� �� 0 �� 9):");
        JLabel dei = new JLabel("�������� ��������:");
        JLabel rez1 = new JLabel("(�������������� �����)");
        JLabel rez2 = new JLabel("(������������������ �����)");
        JLabel rez3 = new JLabel("(�������������� �����)");
        JLabel j1 = new JLabel("*j");
        JLabel j2 = new JLabel("*j");
        JLabel j3 = new JLabel("*j");
        JLabel pl1 = new JLabel("+");
        JLabel pl2 = new JLabel("+");
        JLabel pl3 = new JLabel("+");
        JLabel inf = new JLabel("����:");
        JLabel cos1 = new JLabel("*(cos");
        JLabel cos2 = new JLabel("*(cos");
        JLabel sin1 = new JLabel("�+j*sinx�)");
        JLabel sin2 = new JLabel("�+j*sinx�)");
        JLabel skob1 = new JLabel("�)");
        JLabel skob2 = new JLabel("�)");
        JLabel exs1 = new JLabel("*e^(j*");
        JLabel exs2 = new JLabel("*e^(j*");
        JTextField re1 = new JTextField("");
        JTextField im1 = new JTextField("");
        JTextField re2 = new JTextField("");
        JTextField im2 = new JTextField("");
        JTextField stepen = new JTextField("");
        JTextField re3 = new JTextField("");
        JTextField im3 = new JTextField("");
        JTextField trig = new JTextField("");
        JTextField pokaz = new JTextField("");
        JMenuBar box = new JMenuBar();
        JMenu d = new JMenu("�����");
        Click_Clear doclear1 = new Click_Clear(re1, im1, re3, im3, trig, pokaz, inf);// ������� ������� ������ ������� �����
        Click_Clear doclear2 = new Click_Clear(re2, im2, re3, im3, trig, pokaz, inf);
        Click_Clear doclear3 = new Click_Clear(re3, im3, trig, pokaz);
        Click_Rachet dorachet = new Click_Rachet(operation, getform1, getform2, re1, im1, re2, im2, re3, im3, trig, pokaz, stepen, inf);// ������� ������ ������ ������� ��������
        Click_Exit goexit = new Click_Exit(okno);//������� ������ ������ ������
        Click_Help gohelp = new Click_Help();// ������� ������ ������ ������
        Click_Download godownload = new Click_Download(re1, im1, re2, im2, inf, doclear3, getform1, getform2);// ������� ������ ������ ��������
        Click_Save gosave = new Click_Save(re3, im3, "save.txt", inf);// ������� ������ ������ ����������
        Click_Copy gocopy = new Click_Copy(getform1, re1, im1, re3, im3, doclear2, inf);// ������� ������ ������ �������� ��������
        Click_Operation gooperation = new Click_Operation(operation, getform1, getform2, re1, im1, re2, im2, stepen, clear1, clear2, z1, z2, j1, j2, pl1, pl2, step, cos1, sin1, exs1, skob1, cos2, sin2, exs2, skob2, doclear3);// ������� ������ ������ ������ ��������
        Click_Form doform1 = new Click_Form(getform1, re1, im1, j1, pl1, cos1, sin1, exs1, skob1);// ������� ������� ������� ������ ����
        Click_Form doform2 = new Click_Form(getform2, re2, im2, j2, pl2, cos2, sin2, exs2, skob2);
        JPanel mainPanel = new JPanel();// �������� ������ �� ������� ����� ��������� �������
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(100, 250, 150));// ������ ���� ������
        im1.setToolTipText("Im, �");// ������� ��������� ��� ����� ������ � ������
        im2.setToolTipText("Im, �");
        re1.setToolTipText("Re, ������ �����");
        re2.setToolTipText("Re, ������ �����");
        d.add(help);// ��������� �����
        d.add(save);
        d.add(download);
        d.add(sp);
        d.add(exit);
        box.add(d);
        mainPanel.add(z1);//��������� ������� �� ������
        mainPanel.add(getform1);
        mainPanel.add(re1);
        mainPanel.add(cos1);
        mainPanel.add(exs1);
        mainPanel.add(pl1);
        mainPanel.add(im1);
        mainPanel.add(j1);
        mainPanel.add(sin1);
        mainPanel.add(skob1);
        mainPanel.add(clear1);
        mainPanel.add(z2);
        mainPanel.add(getform2);
        mainPanel.add(re2);
        mainPanel.add(cos2);
        mainPanel.add(exs2);
        mainPanel.add(pl2);
        mainPanel.add(im2);
        mainPanel.add(j2);
        mainPanel.add(sin2);
        mainPanel.add(skob2);
        mainPanel.add(clear2);
        mainPanel.add(step);
        mainPanel.add(stepen);
        mainPanel.add(dei);
        mainPanel.add(operation);
        mainPanel.add(rafn);
        mainPanel.add(rez1);
        mainPanel.add(re3);
        mainPanel.add(pl3);
        mainPanel.add(im3);
        mainPanel.add(j3);
        mainPanel.add(rez2);
        mainPanel.add(trig);
        mainPanel.add(rez3);
        mainPanel.add(pokaz);
        mainPanel.add(perenos);
        mainPanel.add(graf);
        mainPanel.add(inf);
        okno.getContentPane().add(mainPanel);// ��������� ������ �� ����
        okno.setJMenuBar(box);
        okno.setPreferredSize(new Dimension(600, 700));// ������ ������������� ������ ����
        okno.pack();
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
        clear1.addActionListener(doclear1);// ��������� ���������� � �������
        clear2.addActionListener(doclear2);
        rafn.addActionListener(dorachet);
        exit.addActionListener(goexit);
        help.addActionListener(gohelp);
        save.addActionListener(gosave);
        operation.addActionListener(gooperation);
        download.addActionListener(godownload);
        perenos.addActionListener(gocopy);
        getform1.addActionListener(doform1);
        getform2.addActionListener(doform2);
        graf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        re1.setDocument(new MyInputVerifier(true));// ������������� ���������
        re2.setDocument(new MyInputVerifier(true));
        im1.setDocument(new MyInputVerifier(true));
        im2.setDocument(new MyInputVerifier(true));
        stepen.setDocument(new MyInputVerifier(false));
        re3.setEditable(false);// �� ���� ������ ���-���� � ������ � �����������
        im3.setEditable(false);
        trig.setEditable(false);
        pokaz.setEditable(false);
        step.setVisible(false);// �������� ������ ��� ������� �������
        stepen.setVisible(false);
        cos1.setVisible(false);
        sin1.setVisible(false);
        exs1.setVisible(false);
        skob1.setVisible(false);
        cos2.setVisible(false);
        sin2.setVisible(false);
        exs2.setVisible(false);
        skob2.setVisible(false);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        operation.addKeyListener(new KeyAdapter() { //��������� ����������� ���������� �������� �� ������� ������ "Enter"
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "Enter") {
                    dorachet.rachet();
                }
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        im1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "Enter") {
                    dorachet.rachet();
                }
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        re1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "Enter") {
                    dorachet.rachet();
                }
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        im2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "Enter") {
                    dorachet.rachet();
                }
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        re2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "Enter") {
                    dorachet.rachet();
                }
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        stepen.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "Enter") {
                    dorachet.rachet();
                }
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        rafn.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String str = (e.getKeyText(e.getKeyCode()));
                if (str == "F5") {
                    try {
                        gosave.save("save.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        graf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame graf = new JFrame("����������� ����� �� �������");
                graf.add(new Grafik(re3, im3), BorderLayout.CENTER);//��������� ������
                graf.setPreferredSize(new Dimension(500, 500));
                graf.setLocationRelativeTo(null);
                graf.pack();
                graf.setVisible(true);
            }
        });
        new Music(5,sp,inf).run();
    }
}


