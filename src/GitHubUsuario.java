public class GitHubUsuario {
    private String nome;
    private String bio;
    private int repositorios;
    private int seguidores;

    public GitHubUsuario(String nome, String bio, int repositorios, int seguidores) {
        this.nome = nome;
        this.bio = bio;
        this.repositorios = repositorios;
        this.seguidores = seguidores;
    }
    public String getNome()        { return nome; }
    public String getBio()         { return bio; }
    public int getRepositorios()   { return repositorios; }
    public int getSeguidores()     { return seguidores; }

    @Override
    public String toString() {
        return """
                === Perfil GitHub ===
                Nome:         %s
                Bio:          %s
                Repositórios: %d
                Seguidores:   %d
                """.formatted(nome, bio, repositorios, seguidores);
    }
}
