package calculeat;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
// Класс музыки
public class Music{
    int e ;
    JLabel inf;
    Clip clip;
    JMenuItem stop;
    Music(int e, JMenuItem stop, JLabel inf){
       this.stop = stop;
        this.e = e;
        this.inf = inf;
    }
    public void run() {
        String[] music = new String[10];
        music[0] = "Mastera_mecha_onlajjn.wav";
        music[1] = "Minami_-_Kawaki_wo_Ameku.wav";
        music[2] = "No_Game_No_Life.wav";
        music[3] = "Nyanpasu - Yabure Kabure.wav";
        music[4] = "OST_Naruto_shippuden.wav";
        music[5] = "Sati_Akura_-_Kawaki_wo_AmekuDomecano_openin.wav";
        music[6] = "Tetrad_Smerti_Death_Note.wav";
        music[7] = "Tokijjskijj_gul.wav";
        music[8] = "Zero_Two.wav";
        music[9] = "Ataka_Titano.wav";
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent t) {
                if (stop.getText() == "Выключить музыку") {
                    stop.setText("Включить музыку");
                    clip.stop();
                    inf.setText("Инфо:Воспроизведение музыки приостановлено");                }
                else {
                    stop.setText("Выключить музыку");
                    clip.start();
                    inf.setText("Инфо:Воспроизведение музыки продолжено");
                }
            }
        });
        goPlay(e,music);
    }
    public void goPlay(int e, String music[]){
        int i = 0;
        while (i < 100) {
            try {
                File soundFile = new File(music[e % 10]);
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                clip = AudioSystem.getClip();
                clip.open(ais);
                FloatControl vc = (FloatControl)//Получаем контроллер громкости
                clip.getControl(FloatControl.Type.MASTER_GAIN);
                vc.setValue(5); //Устанавливаем уровень громкости
                clip.setFramePosition(0); //устанавливаем указатель на старт
                clip.start();//Запускаем поток
                Thread.sleep(clip.getMicrosecondLength() / 1000);
                clip.stop(); //Останавливаем
                clip.close(); //Закрываем
                e++;
               i++;
            } catch (IOException | UnsupportedAudioFileException
                    | LineUnavailableException exc) {
                exc.printStackTrace();
            } catch (InterruptedException exc) {
                System.out.println("Ошибка " + exc.toString());
            }
    }
    }
}
