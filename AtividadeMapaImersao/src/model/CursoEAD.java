package model;

public class CursoEAD extends Curso {
    private String plataformaVirtual;

    public CursoEAD (String nome, int codigo, double cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    @Override
    public String detalharCurso() {
        return "model.Curso EAD: " + getNome() + " | Código: " + getCodigo() + " | Plataforma virtual: " + plataformaVirtual + " | Carga horária: " + getCargaHoraria();
    }

    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório do curso EAD: " + getNome() + " | Código: " + getCodigo() + " | Plataforma: " + getPlataformaVirtual() + " | Carga Horária: " + getCargaHoraria();
    }
}
