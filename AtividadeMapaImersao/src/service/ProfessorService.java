package service;
import model.Professor;
import repository.ProfessorRepository;
import java.util.List;

//criando a classe service para professor, responsavel pelas regras de negocio que envolvem os professores
public class ProfessorService {
    //conectando a classe ProfessorService à classe ProfessorRepository para acessar os dados
    private ProfessorRepository repository;

    //criando o construtor da classe que recebe uma instancia de ProfessorRepository para acessar os dados
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    //criando o metodo para cadastrar professor
    public void cadastrarProfessor(String nome, String login, String senha, String especialidade, String disciplina, int registro) {
        //verificando se o professor ja esta cadastrado
        Professor existente = repository.procurarPorRegistro(registro);
        if (existente != null) {
            System.out.println("Erro. Professor com o registro " + registro + " já está cadastrado.");
        }
        Professor professor = new Professor(nome, login, senha, especialidade, disciplina, registro);
        repository.salvar(professor);
        System.out.println("Professor cadastrado!");
    }

    //criando o metodo para listar todos os professores
    public List<Professor> listar() {
        return repository.listar();
    }
    //criando o metodo para procurar por um professor em especifico
    public Professor procurar(int registro) {
        return repository.procurarPorRegistro(registro);
    }
}
