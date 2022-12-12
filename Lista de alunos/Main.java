
// Lista de alunos sem usar arraylist
public class Main {
    public static void main (String args[]) {

        ListaAlunos lista = new ListaAlunos();

        lista.adicionarAluno(new Aluno("Eduardo", 10));
        lista.adicionarAluno(new Aluno("Carlos", 10));
        lista.adicionarAluno(new Aluno("Bruna", 10));
        lista.adicionarAluno(new Aluno("Ana", 10));


        lista.ordenarPorOrdem().mostrarAlunos();


        






       
    }
}