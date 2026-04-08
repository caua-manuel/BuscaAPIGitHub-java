import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do usuario: ");
        String nomeUsuario = sc.nextLine();

        ConsultaGitHub consulta = new ConsultaGitHub();

        try {
            GitHubUsuario usuario = consulta.buscar(nomeUsuario);
            System.out.println(usuario);
        } catch (ErroConsultaGitHubException e){
            System.out.println(" X: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println(" X Erro de conexão: " + e.getMessage());
        }



    }
}


// TODO dar commit no github !!!!!!!!