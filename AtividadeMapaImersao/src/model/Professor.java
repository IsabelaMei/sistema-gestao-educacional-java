package model;

public class Professor extends Usuario {
    private String especialidade;
    private int registro;
    private String disciplina;

    public Professor(String nome, String login, String senha, String especialidade, String disciplina, int registro) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
        this.disciplina = disciplina;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        if(this.login.equals(login) && this.senha.equals(senha)) {
            System.out.println("model.Professor: " + nome + " autenticado.");
            return true;
        }
        System.out.println("model.Professor: " + nome + " não autenticado. Ocorreu uma falha");
        return false;
    }

    @Override
    public String getPerfil() {
        return "model.Professor de " + disciplina + " | Registro: " + registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    //implementando o metodo de gerar relatorio
    @Override
    public String gerarRelatorio(){
        return "Relatório do professor: " + nome + " | Registro:" + getRegistro() + " | Especialidade: " + getEspecialidade() + " | Disciplina: " + getDisciplina();
    }
}


