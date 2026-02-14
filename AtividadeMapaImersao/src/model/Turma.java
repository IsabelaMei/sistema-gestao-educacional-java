package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codigoTurma;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma (int codigoTurma, Professor professor, Curso curso) {
        this.codigoTurma = codigoTurma;
        this.professor =  professor;
        this.curso = curso;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void adicionarAluno(Aluno aluno) {
        for (Aluno a : listaAlunos) {
            if(a.getMatricula().equals(aluno.getMatricula())) {
                System.out.println("model.Aluno já está matriculado na turma.");
                return;
            }
        }
        listaAlunos.add(aluno);
        System.out.println("model.Aluno " + aluno.getNome() + " adicionado à turma.");
    }

    public void removerAluno(Aluno aluno) {
        listaAlunos.remove(aluno);
        System.out.println("model.Aluno " + aluno.getNome() + " removido da turma.");
    }

    //criando o metodo para listar os alunos da turma
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void resumoTurma() {
        System.out.println("Resumo da turma " + codigoTurma);
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Lista dos alunos:");
        for(Aluno aluno : listaAlunos) {
            System.out.println(aluno.getNome());
        }
    }
}
