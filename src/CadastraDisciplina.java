import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastraDisciplina implements Tela {
    private JPanel panel1;
    private JTable table1;
    private JTextField idDisciplina;
    private JTextField nomeDisciplina;
    private JTextField cargaHoraria;
    private JButton cadastrar;
    private JComboBox professor;
    private JLabel professorLabel;
    private JButton voltaMenu;
    private List<Disciplina> data;

    CadastraDisciplina(){
        // Gerenciar Tabela
        String[] colunas = {
                "Código","Nome", "Carga Horária", "Professor"
        };

        data = new ArrayList<>();

        UpdateDataTable(data, colunas);

        // criar lista de professor
        Professor[] professor_list = {
                new Professor(1, "Magno Machado"),
                new Professor(2, "Robson França"),
                new Professor(3, "Caio Espanha"),
                new Professor(4, "Jéssica Facundo")
        };

        // Gerenciar Form

        // add prof
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Professor p: professor_list){
            model.addElement(p.getNome());
        }
        professor.setModel(model);
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                d[0] = idDisciplina.getText();
                d[1] = nomeDisciplina.getText();
                d[2] = cargaHoraria.getText();
                d[3] = professor.getSelectedItem().toString();
                */
                int id = Integer.valueOf(idDisciplina.getText());
                String nome = nomeDisciplina.getText();
                int h = Integer.valueOf(cargaHoraria.getText());
                int index_prof = professor.getSelectedIndex();
                Disciplina d = new Disciplina(id, nome, h, professor_list[index_prof]);

                data.add(d);
                UpdateDataTable(data, colunas);
            }
        });
    }

    private void UpdateDataTable(List<Disciplina> data, String[] colunas){
        String[][] data_aux = new String[data.size()][4];
        for(int i = 0; i < data.size(); i++){
            Disciplina disciplina = data.get(i);
            data_aux[i][0] = String.valueOf(disciplina.idDisciplina);
            data_aux[i][1] = disciplina.nomeDisciplina;
            data_aux[i][2] = String.valueOf(disciplina.cargaHoraria);
            data_aux[i][3] = disciplina.professor.getNome();
        }

        TableModel model = new DefaultTableModel(data_aux, colunas);
        table1.setModel(model);
    }

    @Override
    public JPanel getPanel() {
        return panel1;
    }

    public JButton getButton1(){
        return voltaMenu;
    }

    public List<Disciplina> getData(){
        return data;
    }
}
