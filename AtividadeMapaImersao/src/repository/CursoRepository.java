package repository;
import model.Curso;
import java.util.ArrayList;
import java.util.List;

//Criando um repositorio para curso, reponsavel por gerenciar o armazenamento dos objetos curso
public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    //criando o metodo para criar/salvar cursos
    public void salvar(Curso curso) {
        cursos.add(curso);
    }

    //criando o metodo para listar todos os cursos
    public List<Curso> listar() {
        return cursos;
    }

    //criando o metodo para procurar cursos pelo codigo
    public Curso procurarPorCodigo(int codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null; //retorna nulo caso o curso nao seja encontrado
    }
}
