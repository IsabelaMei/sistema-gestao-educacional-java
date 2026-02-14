package service;
import model.Curso;
import repository.CursoRepository;
import java.util.List;

//criando a classe service para curso, responsavel pelas regras de negocio que envolvem os cursos
public class CursoService {
    //conectando a classe CursoService à classe CursoRepository para acessar os dados
    private CursoRepository repository;

    //criando o construtor da classe que recebe uma instancia de CursoRepository para acessar os dados
    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    //criando o metodo para cadastrar curso
    public void cadastrarCurso(String nome, int codigo, double cargaHoraria) {
        //verificando se o curso ja esta cadastrado
        Curso existente = repository.procurarPorCodigo(codigo);
        if (existente != null) {
            System.out.println("Erro. Curso com o código " + codigo + " já está cadastrado.");
        }
        Curso curso = new Curso(nome, codigo, cargaHoraria);
        repository.salvar(curso);
        System.out.println("Curso cadastrado!");
    }

    //criando o metodo para listar todos os cursos
    public List<Curso> listar() {
        return repository.listar();
    }

    //criando o metodo para procurar por um curso em especifico
    public Curso procurar(int codigo) {
        return  repository.procurarPorCodigo(codigo);
    }
}
