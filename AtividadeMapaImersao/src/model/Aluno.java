package model;

import java.util.ArrayList;
public class Aluno extends Usuario {
    private String matricula;
    private String curso;
    private ArrayList<Avaliacao> notasAluno = new ArrayList<>();

    public Aluno(String nome, String login, String senha, String matricula, String curso) {
       super(nome, login, senha);
       this.matricula = matricula;
       this.curso = curso;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        if(this.login.equals(login) && this.senha.equals(senha)) {
            System.out.println("model.Aluno: " + nome + " autenticado.");
            return true;
        }
        System.out.println("model.Aluno: " + nome + " não autenticado. Ocorreu uma falha.");
        return false;
    }

    @Override
    public String getPerfil() {
        return "model.Aluno: " + matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void registrarNota(String descricaoAvaliacao, int nota, int codigoTurma) {
        Avaliacao notaIndividual = new Avaliacao(descricaoAvaliacao);
        notaIndividual.atribuirNota(nota, this.nome, codigoTurma);
        if (notaIndividual.getNota() >= 0) {
            this.notasAluno.add(notaIndividual);
        }
    }

    public void exibirNota() {
        System.out.println("Notas do aluno " + getNome() + ":");
        for (Avaliacao avaliacao : notasAluno) {
            System.out.println(avaliacao.getDescricao() + ": nota " + avaliacao.getNota());
        }
    }

    @Override
    public String gerarRelatorio(){
        return "Relatório do aluno: " + nome + " | Matrícula: " + getMatricula() + " | model.Curso: " + getCurso();
    }
}
