package model;

public abstract class Usuario implements Autenticacao {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public abstract String getPerfil();

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //criando o metodo polimorfico para gerar relatorio
    public String gerarRelatorio(){
        return "Relatório do usuário: " + getNome();
    }
}
