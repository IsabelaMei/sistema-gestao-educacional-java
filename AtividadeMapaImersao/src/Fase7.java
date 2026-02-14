import model.*;

import java.util.ArrayList;
import java.util.List;

public class Fase7 {

    public static void main (String[] args) {
        Professor professor1 = new Professor("João da Silva","Joao.Silva","joao123","POO", "POO", 1101234);
        Aluno aluno1 = new Aluno("Isabela Mei","Isabela_Mei","senha9263","24077548-5", "Análise e Desenvolvimento de Sistemas");
        Administrador administrador1 = new Administrador("Amanda Melo", "amanda.melo", "melo8543", "POO");
        Curso curso1 = new Curso("Análise e Desenvolvimento de Sistemas", 54, 120.00);
        Turma turma1 = new Turma(202501, professor1, curso1);
        CursoPresencial cursoPresencial = new CursoPresencial("Engenharia de Software", 202601, 80.00, "Laboratório 15");
        CursoEAD cursoEAD = new CursoEAD("Ciências da Computação", 202603, 120.00, "Studeo");

        //Implementando um menu para gerar relatorios multiplos em sequencia
        //criando uma lista polimorfica
        List<Object> elementosDoRelatorio = new ArrayList<>();
        elementosDoRelatorio.add(aluno1);
        elementosDoRelatorio.add(professor1);
        elementosDoRelatorio.add(cursoEAD);
        elementosDoRelatorio.add(cursoPresencial);

        System.out.println("Geração dos Relatórios");
        //criando um laco de repeticao for utilizando o 'for' para que gere relatorios multiplos em sequencia
        for (Object elemento : elementosDoRelatorio) {
            //utilizando do condicional if/else para verificar qual o tipo de elemento para chamar o relatorio correto
            if(elemento instanceof Aluno) {
                System.out.println(((Aluno) elemento).gerarRelatorio());
            } else if (elemento instanceof Professor) {
                System.out.println(((Professor) elemento).gerarRelatorio());
            } else if (elemento instanceof CursoEAD) {
                System.out.println(((CursoEAD) elemento).gerarRelatorio());
            } else if (elemento instanceof CursoPresencial) {
                System.out.println(((CursoPresencial)elemento).gerarRelatorio());
            }
        }
    }
}