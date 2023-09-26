package test;

import org.example.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    Pessoa pessoa;

    public PessoaTest() {
    }


    @BeforeEach
    public void setUp() throws Exception {

        this.pessoa = new Pessoa();
        this.pessoa.getId();
        this.pessoa.getNome();

    }

    @Test
    public void deveRetornarSucessoAdicionarPessoaComIDeNomeValido() throws Exception {
        this.pessoa.setId(1);
        this.pessoa.setNome("Hellen");

        assert this.pessoa.valido();

    }

}