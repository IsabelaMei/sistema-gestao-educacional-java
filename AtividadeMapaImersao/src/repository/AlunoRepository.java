package repository;
import model.Aluno;
import java.util.ArrayList;
import java.util.List;

//Criando um repositorio para aluno, reponsavel por gerenciar o armazenamento dos objetos aluno
public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    //criando o metodo para criar/salvar alunos
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    //criando o metodo para listar todos os alunos
    public List<Aluno> listar() {
        return alunos;
    }

    //criando o metodo para procurar alunos pela matricula
    public Aluno procurarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) return a;
        }
        return null; //retorna nulo caso o aluno nao seja encontrado
    }
}
