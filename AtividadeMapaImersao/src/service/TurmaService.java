package service;
import model.Turma;
import model.Professor;
import model.Aluno;
import model.Curso;
import repository.AlunoRepository;
import repository.TurmaRepository;
import java.util.List;

//criando a classe service para turma, responsavel pelas regras de negocio que envolvem as turmas
public class TurmaService {
    //conectando a classe TurmaService à classe TurmaRepository para acessar os dados
    private TurmaRepository repository;
    private AlunoRepository alunoRepository; //conectando à classe AlunoRepository para buscar dados dos alunos

    //criando o construtor da classe que recebe uma instancia de TurmaRepository e AlunoRepository para acessar os dados
    public TurmaService(TurmaRepository repository, AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    //criando o metodo para cadastrar turma
    public void cadastrarTurma(int codigoTurma, Professor professor, Curso curso) {
        //verificando se a turma ja esta cadastrada
        Turma existente = repository.procurarPorCodigoTurma(codigoTurma);
        if (existente != null) {
            System.out.println("Erro. Turma com o código " + codigoTurma + " já está cadastrada.");
            return;
        }
        Turma turma = new Turma(codigoTurma, professor, curso);
        repository.salvar(turma);
        System.out.println("Turma cadastrada!");
    }

    //criando o metodo para procurar por uma turma em especifico
    public Turma procurarPorCodigo(int codigoTurma) {
        return repository.procurarPorCodigoTurma(codigoTurma);
    }

    //criando o metodo para listar todas as turmas
    public List<Turma> listar() {
        return repository.listar();
    }

    //criando o metodo para registrar nota da avaliacao
    public void registrarAvaliacao (int codigoTurma, String matricula, int nota) {
        Turma turma = repository.procurarPorCodigoTurma(codigoTurma);
        if (turma == null) {
            System.out.println("Erro. Código de turma não encontrado, tente novamente.");
            return;
        }
        //procurando o aluno no repositorio para registrar a nota da avaliacao
        Aluno alunoEncontrado = alunoRepository.procurarPorMatricula(matricula);
            if (alunoEncontrado == null) {
                System.out.println("Erro. Aluno não encontrado no sistema.");
                return;
            }
        if (nota < 0 || nota > 10) {
            System.out.println("Erro. Nota " + nota + " inválida. A nota deve ser um valor entre 0 e 10");
            return;
        }
        alunoEncontrado.registrarNota("Avaliação da turma", nota, codigoTurma);
        System.out.println("Avaliação registrada para o aluno " + alunoEncontrado.getNome());
    }
}
