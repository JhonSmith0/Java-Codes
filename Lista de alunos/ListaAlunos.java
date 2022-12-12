import java.util.Arrays;


public class ListaAlunos {

    private Aluno alunos[] = new Aluno[inicial];
    private static int inicial = 1;
    private int qtd = 0;

    public int getQtd () {
        return this.qtd;
    }

    public void adicionarAluno (Aluno aluno) {
        if (this.alunos.length == this.qtd) {
            this.alunos = Arrays.copyOf(this.alunos, this.qtd + inicial);
        };     
        this.alunos[this.qtd] = aluno;
        this.qtd++;
    }


    public void mostrarAlunos () {
        for (int i = 0; i < this.qtd; i++) {
            this.alunos[i].apresentar();
        }
    }

    public void removerAluno (int index) {
        for (int i = index; i < this.qtd; i++) {
            if (i + 1 >= this.qtd) continue;
            this.alunos[i] = this.alunos[i + 1];
        }
        this.alunos[--this.qtd] = null;
    }

    public ListaAlunos ordenarPorOrdem () {
        ListaAlunos lista = new ListaAlunos();
        Aluno alunos[] = Arrays.copyOf(this.alunos, this.alunos.length);
        
        while (true) {

            boolean contou = false;

            for (int i = 0; i < alunos.length; i++) {
                if (i + 1 >= alunos.length) continue;

                Aluno current = alunos[i];
                Aluno next = alunos[i + 1];

                int calc = next.nome.compareTo(current.nome);

                if (calc < 0) {
                    alunos[i] = alunos[i + 1];
                    alunos[i + 1] = current;
                    contou = true;
                }

            }
            if (!contou) break;
        }

        for (Aluno aluno : alunos) lista.adicionarAluno(aluno);

        return lista;
    }






}