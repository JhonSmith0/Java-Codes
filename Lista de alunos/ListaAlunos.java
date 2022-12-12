import java.util.Arrays;



public class ListaAlunos {

    private Aluno alunos[] = new Aluno[inicial];
    static int inicial = 1;
    private int qtd = 0;
    static Questionario questionario = new Questionario();

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

    public void buscarAlunos(String query) {
        for (int i = 0; i < this.qtd; i++) {
            Aluno aluno = this.alunos[i];
            if (aluno.nome.toLowerCase().contains(query.toLowerCase())) {
                System.out.printf("Nome: %s\n", aluno.nome);
                System.out.printf("Id: %s\n", aluno.id);
            };
        }
    }

    public int findIndexById (String id) {
        for (int i = 0; i < this.qtd; i++) {
            if (this.alunos[i].id.equals(id)) return i;
        }
        return -1;
    }

    private void removerAluno (int index) {
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


    public void questionarioAdicionarAluno () {
        String continuar = "y";
        while (continuar.equals("y")) {
            System.out.println("-----------------");

            String nome = questionario.ask("Qual seu nome ? >> ");
            int idade = questionario.ask("Qual sua idade ? >> ", true);
            continuar = questionario.ask("Continuar ? >> ").trim();

            this.adicionarAluno(new Aluno(nome, idade));

        }
    }


    public void questionarioRemoverAluno () {
        String continuar = "y";
        while (continuar.equals("y")) {
            System.out.println("-----------------");

            String id = questionario.ask("Qual o id do aluno ? >> ");
            int index = this.findIndexById(id);

            if (index < 0) {
                System.out.println("ID INVÁLIDO!!!");
                continue;
            }

            this.removerAluno(index);
            System.out.println("Usuario removido com sucesso!");

            continuar = questionario.ask("Continuar ? [y/n] >> ");
        }
    }
    public void questionarioBuscarAlunos () {
        String continuar = "y";
        Questionario questionario = new Questionario();
        while (continuar.equals("y")) {
            System.out.println("-----------------");
            
            String query = questionario.ask("Qual o nome do aluno ? >> ");
            this.buscarAlunos(query);
            
            System.out.println("-----------------");
            continuar = questionario.ask("Continuar ? [y/n] >> ");
        }
    }

    public void mostrarMenu () {
        System.out.println("-".repeat(10));
        System.out.println("[ 1 ] Adicionar aluno");
        System.out.println("[ 2 ] Remover aluno");
        System.out.println("[ 3 ] Mostrar alunos");
        System.out.println("[ 4 ] Buscar alunos");
        System.out.println("-".repeat(10));
    }

    public void HandleMenuAnswer (int alternativa) {
        switch (alternativa) {
            case 1: 
                this.questionarioAdicionarAluno();
                break;

            case 2:
                this.questionarioRemoverAluno();
                break;

            case 3:
                this.mostrarAlunos();
                break;

            case 4:
                this.questionarioBuscarAlunos();
                break;

            default: 
                System.out.println("Alternativa inválida!");
                break;

        }
    }
}