package model;

public class Administrador extends Usuario {
    private String disciplina;

    public Administrador(String nome, String login, String senha, String disciplina) {
        super(nome, login, senha);
        this.disciplina = disciplina;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        if(this.login.equals(login) && this.senha.equals(senha)) {
            System.out.println("model.Administrador(a): " + nome + " autenticado.");
            return true;
        }
        System.out.println("model.Administrador(a): " + nome + " não autenticado. Ocorreu uma falha.");
        return false;
    }

    @Override
    public String getPerfil() {
        return "model.Administrador(a) " + nome + " | Disciplina: " + disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
