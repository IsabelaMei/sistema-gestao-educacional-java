package model;

public class CursoPresencial extends Curso {
    private String salaDeAula;

    public CursoPresencial(String nome, int codigo, double cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    @Override
    public String detalharCurso() {
        return "model.Curso presencial: " + getNome() + " | Código: " + getCodigo() + " | Sala de aula: " + salaDeAula + " | Carga horária: " + getCargaHoraria();
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório do curso presencial: " + getNome() + " | Código: " + getCodigo() + " | Sala de aula : " + getSalaDeAula() + " | Carga Horária: " + getCargaHoraria();
    }
}
