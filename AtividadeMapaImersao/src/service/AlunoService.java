package service;
import model.Aluno;
import repository.AlunoRepository;
import java.util.List;

//criando a classe service para aluno, responsavel pelas regras de negocio que envolvem os alunos
public class AlunoService {
    //conectando a classe AlunoService à classe AlunoRepository para acessar os dados
    private AlunoRepository repository;

    //criando o construtor da classe que recebe uma instancia de AlunoRepository para acessar os dados
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    //criando o metodo para cadastrar aluno
    public void cadastrarAluno(String nome, String login, String senha, String matricula, String curso) {
        //verificando se o aluno ja esta cadastrado
        Aluno existente = repository.procurarPorMatricula(matricula);
        if (existente != null) {
            System.out.println("Erro. Aluno com a matrícula " + matricula + " já está cadastrado.");
            return;
        }
        Aluno aluno = new Aluno(nome, login, senha, matricula, curso);
        repository.salvar(aluno);
        System.out.println("Aluno " + nome + " cadastrado!.");
    }

    //criando o metodo para listar todos os alunos
    public List<Aluno> listar() {
        return repository.listar();
    }

    //criando o metodo para procurar por um aluno em especifico
    public Aluno procurarPorMatricula(String matricula) {
        return repository.procurarPorMatricula(matricula);
    }
}
