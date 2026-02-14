package repository;
import model.Professor;
import java.util.ArrayList;
import java.util.List;

//Criando um repositorio para professor, reponsavel por gerenciar o armazenamento dos objetos professor
public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();

    //criando o metodo para criar/salvar professores
    public void salvar(Professor professor) {
        professores.add(professor);
    }

    //criando o metodo para listar todos os professores
    public List<Professor> listar() {
        return professores;
    }

    //criando o metodo para procurar professores pelo registro
    public Professor procurarPorRegistro(int registro) {
        for (Professor p : professores) {
            if (p.getRegistro() == registro) {
                return p;
            }
        }
        return null; //retorna nulo caso o professor nao seja encontrado
    }
}
