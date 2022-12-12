public class Aluno {
    public String nome;
    public int idade;
    
    Aluno(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentar() {
        System.out.printf("Nome: %s\n", this.nome);
        System.out.printf("Idade: %d\n", this.idade);
    }
}
