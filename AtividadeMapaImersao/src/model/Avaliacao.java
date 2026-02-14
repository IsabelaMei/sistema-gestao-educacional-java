package model;

public class Avaliacao {
    private int nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.nota = 0; //nota inicia com zero aguardando atribuicao
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void atribuirNota(int nota, String nomeAluno, int codigoTurma) {
        if(nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Nota: " + nota + " da atividade " + this.descricao + " registrada ao aluno " + nomeAluno + " da turma " + codigoTurma);
        }
    }
}
