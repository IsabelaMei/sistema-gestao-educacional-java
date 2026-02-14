package model;

//criando a interface autenticacao que sera o contrato que as outras classes irao implementar
public interface Autenticacao {
    boolean autenticar(String login, String senha);
}
