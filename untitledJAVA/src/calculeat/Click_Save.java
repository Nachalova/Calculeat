package calculeat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// ����� ����������
public class Click_Save implements ActionListener {//��������� ��������� ���������
    JTextField re3, im3;// ������ ����
    JLabel inf;
    String file;
    //������ �����������
    Click_Save (JTextField re3, JTextField im3, String file, JLabel inf){
        this.re3 = re3;
        this.im3 = im3;
        this.inf = inf;
        this.file = file;
    }
// ������������� ����� �������������� ����������
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            save(file);// ������� ����� ����������
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
//������ ����� ����������
    public void save (String file) throws IOException{
        try(FileWriter c = new FileWriter(file,true)) {//�������� �����
            if (re3.getText().length()>0) {//���� ��������� �� ����
                c.append(re3.getText() + " ");//���� �������� � �������������� ����� � ��������� � ���� ����������
                c.append(im3.getText() + "\n");
                inf.setText("����:��������� �������");
            }
            else{
                inf.setText("����:��������� �� �������. �������� ���������� ������");
            }
        }
        catch (FileNotFoundException u){// ���������� �� ������ ���������� �����
            inf.setText("����:��������� �� �������");
        }
    }
}
