package model;

public class Curso {
    private String nome;
    private int codigo;
    private double cargaHoraria;

    public Curso(String nome, int codigo, double cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public String detalharCurso() {
        return "model.Curso: " + nome + " | Código:" + codigo;
    }

    //criando o metodo polimorfico para gerar relatorio
    public String gerarRelatorio() {
        return "Relatório do curso: " + getNome() + " | Código: " + getCodigo() + " | Carga Horária: " + getCargaHoraria();
    }
}

