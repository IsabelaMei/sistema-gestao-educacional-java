package ui;
import java.util.Scanner;
import model.Aluno;
import model.Curso;
import model.Professor;
import model.Turma;
import service.AlunoService;
import service.CursoService;
import service.ProfessorService;
import service.TurmaService;

//criando a classe menu que sera iterativa ao usuario
public class Menu {
    private Scanner sc = new Scanner(System.in);
    //conectando a classe Menu às classes services para acessar os dados
    private AlunoService alunoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private TurmaService turmaService;

    //criando o construtor que recebe uma instancia dos services para acessar os dados
    public Menu(AlunoService alunoService, ProfessorService professorService, CursoService cursoService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
    }

    //criando o metodo que inicia o loop no menu
    public void exibir() {
        int opcao;

        do {
            mostrarMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            //utilizando o switch para executar qual opcao o usuario escolher
            switch (opcao){
                case 1: submenuCadastro();
                break;
                case 2: submenuTurmas();
                break;
                case 3: submenuAvaliacoes();
                break;
                case 4: submenuRelatorios();
                break;
                case 5: System.out.println("Opção sair selecionada. Saindo do sistema.");
                break;
                default: System.out.println("Opção inválida.Tente novamente com um dos números listados.");
                break;
            }
        } while (opcao != 5);
    }

    //criando o metodo para mostrar o menu
    public void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("Escolha uma das opções:");
        System.out.println("Opção 1: Cadastros");
        System.out.println("Opção 2: Turmas");
        System.out.println("Opção 3: Avaliações");
        System.out.println("Opção 4: Relatórios");
        System.out.println("Opção 5: Sair");
    }

    //criando o submenu que gerencia as opcoes de cadastro
    private void submenuCadastro() {
        System.out.println("Escolha uma das opções de cadastro:");
        System.out.println("1- Cadastro de aluno");
        System.out.println("2- Cadastro de professor");
        System.out.println("3- Cadastro de curso");
        System.out.println("4- Voltar ao menu");

        int opcao = sc.nextInt();
        sc.nextLine();

        //utilizando o switch para executar qual opcao o usuario escolher
        switch (opcao) {
            case 1: {
                //solicitando ao usuario os dados necessarios para fazer o cadastro do aluno
                System.out.println("Digite o nome do aluno a ser cadastrado:");
                String nome = sc.nextLine();
                System.out.println("Digite a matrícula do aluno a ser cadastrado:");
                String matricula = sc.nextLine();
                System.out.println("Digite o curso do aluno a ser cadastrado:");
                String curso = sc.nextLine();
                System.out.println("Digite o login do aluno a ser cadastrado:");
                String login = sc.nextLine();
                System.out.println("Digite uma senha provisória do aluno a ser cadastrado:");
                String senha = sc.nextLine();

                //chama o metodo cadastrar aluno de alunoService
                alunoService.cadastrarAluno(nome, login, senha, matricula, curso);
                break;
            }
            case 2: {
                //solicitando ao usuario os dados necessarios para fazer o cadastro do professor
                System.out.println("Digite o nome do professor a ser cadastrado:");
                String nome = sc.nextLine();
                System.out.println("Digite a especialidade do professor a ser cadastrado:");
                String especialidade = sc.nextLine();
                System.out.println("Digite a disciplina do professor a ser cadastrado:");
                String disciplina = sc.nextLine();
                System.out.println("Digite o registro do professor a ser cadastrado:");
                int registro = sc.nextInt();
                sc.nextLine();
                System.out.println("Digite o login do professor a ser cadastrado:");
                String login = sc.nextLine();
                System.out.println("Digite uma senha provisória do professor a ser cadastrado:");
                String senha = sc.nextLine();
                //chama o metodo cadastrar professor de professorService
                professorService.cadastrarProfessor(nome, login, senha, especialidade, disciplina, registro);
                break;
            }

            case 3: {
                //solicitando ao usuario os dados necessarios para fazer o cadastro do curso
                System.out.println("Digite o nome do curso a ser cadastrado:");
                String nome = sc.nextLine();
                System.out.println("Digite o código do curso a ser cadastrado:");
                int codigo = sc.nextInt();
                System.out.println("Digite a carga horária do curso a ser cadastrado:");
                double cargaHoraria = sc.nextDouble();
                //chama o metodo cadastrar curso de CursoService
                cursoService.cadastrarCurso(nome, codigo, cargaHoraria);
                break;
            }
            case 4: return;
            default: System.out.println("Opção inválida. Tente novamente com um dos números listados.");
        }
    }

    //criando o submenu que gerencia as opcoes de turma
    private void submenuTurmas() {
        System.out.println("Escolha uma das opções para Turma:");
        System.out.println("1- Criar uma nova turma");
        System.out.println("2- Adicionar aluno à turma");
        System.out.println("3- Voltar");
        int opcao = Integer.parseInt(sc.nextLine());

        //utilizando o switch para executar qual opcao o usuario escolher
        switch (opcao){
            case 1: {
                //solicitando ao usuario os dados necessarios para fazer o cadastro da turma
                System.out.println("Digite o código da turma a ser cadastrada:");
                int codigoTurma = Integer.parseInt(sc.nextLine());
                System.out.println("Digite o registro do professor responsável pela turma a ser cadastrada:");
                int registroProfessor = Integer.parseInt(sc.nextLine());
                //verificando se o registro do professor e valido
                Professor professor = professorService.procurar(registroProfessor);
                if (professor == null) {
                    System.out.println("Erro. Professor não encontrado, confirme o número do registro e tente novamente.");
                    return;
                }
                System.out.println("Digite o código do curso da turma a ser cadastrada:");
                int codigoCurso = Integer.parseInt(sc.nextLine());
                //verificando se o codigo do curso e valido
                Curso curso = cursoService.procurar(codigoCurso);
                if (curso == null) {
                    System.out.println("Erro. Curso não encontrado, confirme o código do curso e tente novamente.");
                    return;
                }
                //chama o metodo cadastrar turma de TurmaService
                turmaService.cadastrarTurma(codigoTurma, professor, curso);
                break;
            }

            case 2: {
                //solicitando ao usuario os dados necessarios para fazer o cadastro do aluno na turma
                System.out.println("Digite o código da turma:");
                int codigoTurma = Integer.parseInt(sc.nextLine());
                //verificando se o codigo da turma e valido
                Turma turma = turmaService.procurarPorCodigo(codigoTurma);
                if (turma == null) {
                    System.out.println("Erro. Turma não encontrada, tente novamente.");
                    return;
                }
                System.out.println("Digite a matrícula do aluno:");
                String matricula = sc.nextLine().trim(); //utilizando .trim() para remover espacos em branco no inicio ou fim
                //verificando se a matricula do aluno e valida
                Aluno aluno = alunoService.procurarPorMatricula(matricula);
                if (aluno == null) {
                    System.out.println("Erro. Aluno não encontrado, tente novamente.");
                    return;
                }
                //chama o metodo adicionar aluno da classe turma
                turma.adicionarAluno(aluno);
                break;
            }
            case 3: return;
            default: System.out.println("Erro. Opção inválida, tente novamente.");
        }
    }

    //criando o submenu que gerencia as opcoes de avaliacao
    private void submenuAvaliacoes() {
        System.out.println("Escolha uma das opções para avaliações");
        System.out.println("1- Registrar nota");
        System.out.println("2- Voltar");
        int opcao = Integer.parseInt(sc.nextLine());

        //utilizando o switch para executar qual opcao o usuario escolher
        switch (opcao) {
            case 1: {
                //solicitando ao usuario os dados necessarios para fazer o registro da nota
                System.out.println("Digite o código da turma:");
                int codigoTurma = Integer.parseInt(sc.nextLine());
                System.out.println("Digite a matrícula do aluno:");
                String matricula = sc.nextLine();
                System.out.println("Digite a nota do aluno:");
                int nota = Integer.parseInt(sc.nextLine());
                //chama o metodo registrar avaliacao de TurmaService
                turmaService.registrarAvaliacao(codigoTurma, matricula, nota);
                break;
            }
            case 2: return;
            default: System.out.println("Erro. Opção inválida, tente novamente.");
        }
    }

    //criando o submenu que gerencia as opcoes de relatorios
    private void submenuRelatorios() {
        System.out.println("Escolha uma das opções para relatórios:");
        System.out.println("1- Relatórios de alunos");
        System.out.println("2- Relatórios de professores");
        System.out.println("3- Relatórios de cursos");
        System.out.println("4- Relatórios de turmas");
        System.out.println("5- Voltar");
        int opcao = sc.nextInt();

        //utilizando o switch para executar qual opcao o usuario escolher
        switch (opcao) {
            case 1:
                for (Aluno a : alunoService.listar()) {
                    System.out.println(a.gerarRelatorio());
                };
                break;
            case 2:
                for (Professor p : professorService.listar()) {
                    System.out.println(p.gerarRelatorio());
                }
                break;
            case 3:
                for (Curso c : cursoService.listar()) {
                    System.out.println(c.gerarRelatorio());
                }
                break;
            case 4:
                for (Turma t : turmaService.listar()) {
                    t.resumoTurma();
                }
                break;
            case 5: return;
            default: System.out.println("Erro. Opção inválida, tente novamente.");
        }
    }
}

