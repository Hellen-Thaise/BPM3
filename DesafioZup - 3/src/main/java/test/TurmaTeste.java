package test;

import org.example.Pessoa;
import org.example.Turma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurmaTeste {
    Turma turma;

    public TurmaTeste() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        Pessoa pessoa1 = new Pessoa(1, "Hellen");
        Pessoa pessoa2 = new Pessoa(2, "Baddy");
        Pessoa pessoa3 = new Pessoa(3, "Paulo");
        this.turma = new Turma();
        this.turma.adicionarPessoa(pessoa1);
        this.turma.adicionarPessoa(pessoa2);
        this.turma.adicionarPessoa(pessoa3);
    }

    @AfterEach
    public void tearDown() {
        this.turma.removerTodasPessoas();
    }

    @Test
    public void deveRetornarExcecaoPessoaInvalida() {
        try {
            this.turma.adicionarPessoa(new Pessoa(-1, "teste"));
        } catch (Exception var2) {
            assert var2.getMessage().equals("Objeto pessoa inválido");
        }

    }

    @Test
    public void deveRetornarExcecaoPessoaExistente() {
        try {
            this.turma.adicionarPessoa(new Pessoa(1, "teste"));
        } catch (Exception var2) {
            assert var2.getMessage().equals("Objeto pessoa já está atribuido a turma");
        }

    }

    @Test
    public void deveRetornarSucessoAdicionarPessoa() throws Exception {
        this.turma.adicionarPessoa(new Pessoa(4, "teste"));

        assert this.turma.getPessoas().size() == 4;

    }

    @Test
    public void deveRetornarSucessoRemoverTodasPessoa() throws Exception {
        this.turma.removerTodasPessoas();

        assert this.turma.getPessoas().isEmpty();

    }
}
