package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//����� ������
public class Click_Exit implements ActionListener {// �������� ��������� ���������
    JFrame okno;// ������ ����
//������ �����������
    Click_Exit(JFrame okno) {
        this.okno = okno;
    }
// ������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e) {
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.dispose();// �������� ����
        System.exit(0);
    }
}
