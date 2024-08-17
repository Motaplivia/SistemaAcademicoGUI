import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disciplina {
    public int idDisciplina;
    public String nomeDisciplina;
    public int cargaHoraria;
    public Professor professor;
    public List<Turma> turmas; // Lista de turmas associadas à disciplina

    // Construtor com professor
    public Disciplina(int idDisciplina, String nomeDisciplina, int cargaHoraria, Professor professor) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.turmas = new ArrayList<>(); // Inicializa a lista de turmas
    }

    // Construtor sem professor
    public Disciplina(int idDisciplina, String nomeDisciplina, int cargaHoraria) {
        this(idDisciplina, nomeDisciplina, cargaHoraria, null);
    }

    // Método para cadastrar uma nova disciplina
    public static Disciplina cadastrarDisciplina() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nInforme o código da disciplina:");
        int idDisciplina = input.nextInt();
        input.nextLine();

        System.out.println("\nInforme o nome da disciplina:");
        String nomeDisciplina = input.nextLine();

        System.out.println("\nInforme a carga horária da disciplina:");
        int cargaHoraria = input.nextInt();
        input.nextLine();

        // Pergunta se deseja cadastrar uma turma
        System.out.println("\nDeseja cadastrar uma turma para esta disciplina? (s/n)");
        String resposta = input.nextLine();
        List<Turma> turmas = new ArrayList<>();

        if (resposta.equalsIgnoreCase("s")) {
            Turma novaTurma = Turma.cadastraTurma();
            turmas.add(novaTurma); // Adiciona a turma à disciplina
        }

        // Cadastra o professor antes de associá-lo à disciplina
        System.out.println("\nDeseja associar um professor à disciplina? (s/n)");
        resposta = input.nextLine();
        Professor professor = null;

        if (resposta.equalsIgnoreCase("s")) {
            professor = Professor.cadastrarProfessor();
        }

        // Retorna nova disciplina com professor
        Disciplina novaDisciplina = new Disciplina(idDisciplina, nomeDisciplina, cargaHoraria, professor);
        novaDisciplina.turmas.addAll(turmas);
        return novaDisciplina;
    }

    // Método para adicionar uma turma à disciplina
    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    // Método para definir o professor da disciplina
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // Getters
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
}
