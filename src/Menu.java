import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Tela  {
    private JPanel panelMenu;
    private JButton cadastraDisciplina;
    private JList listaDisciplina;
    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelh;
    private JLabel labelProf;
    private JButton addTurmaButton;
    private JList turmas;
    List<Disciplina> data;

    Menu(){
        // Lista de disciplinas
        data = new ArrayList<Disciplina>();

        // evento para selecionar elemento da lista
        listaDisciplina.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = listaDisciplina.getSelectedIndex();
                Disciplina d = data.get(index);
                labelId.setText(String.valueOf(d.idDisciplina));
                labelName.setText(d.nomeDisciplina);
                labelh.setText(String.valueOf(d.cargaHoraria));
                labelProf.setText(d.professor.getNome());

                updateTurma(d);
            }
        });

        // evento de add disciplina
        addTurmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Teste");
                Disciplina d = data.get(listaDisciplina.getSelectedIndex());
                d.addTurma(new Turma(name));
                updateTurma(d);
            }
        });
    }
    @Override
    public JPanel getPanel() {
        return panelMenu;
    }

    public JButton getButton1(){
        return cadastraDisciplina;
    }

    public void SetLista(List<Disciplina> data){
        this.data = data;
        String[] names = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            names[i] = data.get(i).nomeDisciplina;
        }
        listaDisciplina.setListData(names);
        try {
            listaDisciplina.setSelectedIndex(0);
        } catch (Exception e) {}
    }

    private void updateTurma(Disciplina d){
        String[] names = new String[d.turmas.size()];
        for (int i = 0; i < d.turmas.size(); i++) {
            names[i] = d.turmas.get(i).getNomeTurma();
        }
        turmas.setListData(names);
    }
}
