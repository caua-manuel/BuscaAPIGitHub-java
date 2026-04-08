import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConsultaGitHub {
    public GitHubUsuario buscar(String nomeUsuario) throws ErroConsultaGitHubException, IOException, InterruptedException {

        String endereco = "https://api.github.com/users/" + nomeUsuario;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .header("Accept", "application/vnd.github.v3+json")
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            throw new ErroConsultaGitHubException("Usuário " + nomeUsuario + " não encontrado no GitHub");
        }
        return parsearUsuario(response.body());
    }
        private GitHubUsuario parsearUsuario (String json){
            String nome = extrairCampo(json, "name");
            String bio = extrairCampo(json, "bio");
            int repositorios = Integer.parseInt(extrairCampo(json, "public_repos"));
            int seguidores = Integer.parseInt(extrairCampo(json, "followers"));
            return new GitHubUsuario(nome, bio, repositorios, seguidores);
        }
        private String extrairCampo (String json, String campo){
            String chave = "\"" + campo + "\"";
            int inicio = json.indexOf(chave);
            if (inicio == -1) return "N/A";

            inicio = json.indexOf(":", inicio) + 1;
            String resto = json.substring(inicio).strip();

            if (resto.startsWith("\"")) {
                int fim = resto.indexOf("\"", 1);
                return resto.substring(1, fim);
            } else {
                int fim = resto.indexOf(",");
                if (fim == -1) fim = resto.indexOf("}");
                return resto.substring(0, fim).strip();
            }
        }
    }
