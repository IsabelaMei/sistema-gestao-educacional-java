package repository;
import model.Turma;
import java.util.ArrayList;
import java.util.List;

//Criando um repositorio para turma, reponsavel por gerenciar o armazenamento dos objetos turmas
public class TurmaRepository {
    private List<Turma> turmas = new ArrayList<>();

    //criando o metodo para criar/salvar turmas
    public void salvar(Turma turma){
        turmas.add(turma);
    }

    //criando o metodo para listar todas as turmas
    public List<Turma> listar() {
        return turmas;
    }

    //criando o metodo para procurar turmas pelo codigo
    public Turma procurarPorCodigoTurma(int codigoTurma) {
        for (Turma t : turmas) {
            if (t.getCodigoTurma() == codigoTurma) {
                return t;
            }
        }
        return null; //retorna nulo caso a turma nao seja encontrada
    }
}
