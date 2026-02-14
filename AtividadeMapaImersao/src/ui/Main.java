package ui;
import repository.*;
import service.*;

//criando a classe main para fazer a integracao com as camadas
public class Main {
    public static void main(String[] args) {
        //instanciando os repositorios
        //cria as listas de armazenamento temporario
        AlunoRepository alunoRepository = new AlunoRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        CursoRepository cursoRepository = new CursoRepository();
        TurmaRepository turmaRepository = new TurmaRepository();

        //instanciando os services
        //cria as regras de negocio e relaciona aos repositorios correspondentes
        AlunoService alunoService = new AlunoService(alunoRepository);
        ProfessorService professorService = new ProfessorService(professorRepository);
        CursoService cursoService = new CursoService(cursoRepository);
        TurmaService turmaService = new TurmaService(turmaRepository, alunoRepository);

        Menu menu = new Menu(alunoService, professorService, cursoService, turmaService);
        menu.exibir(); //iniciando o loop que exibe o menu interativo para o usuario
    }
}
