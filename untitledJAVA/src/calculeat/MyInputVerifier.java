package calculeat;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
// ����� ��������� ��� ����� ����� ������
public class MyInputVerifier extends PlainDocument { // ���������� ����� PlainDocument
    boolean bool = true;// ������� ����
    String chars = "0123456789.-";
    //������� �����������
    MyInputVerifier (boolean bool){
        this.bool = bool;
    }
    //�������������� ����� �������������� ������
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(bool) {// ����� ������ ����� ������������ �����
        }
        else {// ���� ������ ����� �������
            chars = "0123456789";
        }
        for (int i = 0; i < str.length(); i++) {// ��������� ���������� �� �������� ������ ������������
                if (!chars.contains(str.substring(i, i + 1))) return;
        }
            if (bool&&getLength() < 25) {
                super.insertString(offs, str, a);
            }
            if (!bool&&getLength() < 1) {
                super.insertString(offs, str, a);
            }
        }
    }

