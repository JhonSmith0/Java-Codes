// Lista de alunos sem usar arraylist
public class Main {
    public static void main (String args[]) {
        ListaAlunos lista = new ListaAlunos();
        Questionario qst = new Questionario();
        while (true) {
            lista.mostrarMenu();
            lista.HandleMenuAnswer(qst.ask(">> ", true));
        }
    }
}