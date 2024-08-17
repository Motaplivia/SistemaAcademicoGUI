import java.util.Scanner;

public class Turma {
    private String nomeTurma;

    public Turma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    // Método para cadastrar uma nova turma
    public static Turma cadastraTurma() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nInforme o nome da turma:");
        String nomeTurma = input.nextLine();

        return new Turma(nomeTurma);
    }

    // Getter
    public String getNomeTurma() {
        return nomeTurma;
    }
}
