import java.util.Scanner;

public class Professor {
    private int idProfessor;
    private String nome;

    public Professor(int idProfessor, String nome) {
        this.idProfessor = idProfessor;
        this.nome = nome;
    }

    // Método para cadastrar um novo professor
    public static Professor cadastrarProfessor() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nInforme o código do professor:");
        int idProfessor = input.nextInt();
        input.nextLine();

        System.out.println("\nInforme o nome do professor:");
        String nome = input.nextLine();

        return new Professor(idProfessor, nome);
    }

    // Getters
    public int getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }
}
