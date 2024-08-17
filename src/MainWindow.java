import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {
    private JFrame window;
    private int current_selected = 0;
    private List<Tela> telas;

    MainWindow(){
        telas = new ArrayList<Tela>();

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        // config tela 1
        Inicial n = new Inicial();
        JButton b = n.getButton1();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePanel(1);
            }
        });
        telas.add(n);

        // config tela 2
        Menu tela2 = new Menu();
        JButton b2 = tela2.getButton1();
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePanel(2);
            }
        });
        telas.add(tela2);

        // config tela 3
        CadastraDisciplina tela3 = new CadastraDisciplina();
        JButton b3 = tela3.getButton1();
        // evento back
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela2.SetLista(tela3.getData());
                ChangePanel(1);
            }
        });
        telas.add(tela3);
        ChangePanel(0);

        window.setVisible(true);
    }

    private void ChangePanel(int index){
        JPanel tela_last = telas.get(current_selected).getPanel();
        JPanel tela_new = telas.get(index).getPanel();

        current_selected = index;

        tela_last.setVisible(false);
        window.remove(tela_last);

        tela_new.setVisible(true);
        window.add(tela_new);
    }
}
