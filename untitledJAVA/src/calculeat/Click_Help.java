package calculeat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// ����� ������
public class Click_Help implements ActionListener {// ��������� ��������� ���������
    // �������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(new JFrame(), "��� ���������� �������� ������� ����������� �����  � ���������� ���������� ������,\n�������� ��� �������� � ������� ������ '����������'. ��� �������  ����� ������� ������\n'��������'. ��� ���������� ������ � ���������� ������ ������� ������ '���������\n���������'. ��� ���������� ���������� �������� ������ '���������', � ��� �������� '���������'.\n��� ���������� ������� ������� '��������� ������' ","������",JOptionPane.PLAIN_MESSAGE, new ImageIcon("help.png"));
    }
}
