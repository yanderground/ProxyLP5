package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente(1, "Carlos", "Rua A", 1000.0f));
        BD.addCliente(new Cliente(2, "Ana", "Rua B", 2000.0f));
    }

    @Test
    void deveRetornarDadosPessoaisCliente() {
        ClienteProxy cliente = new ClienteProxy(1);

        assertEquals(Arrays.asList("Carlos", "Rua A"), cliente.obterDadosPessoais());
    }

    @Test
    void deveRetornarSaldoCliente() {
        Funcionario funcionario = new Funcionario("Paulo", true);
        ClienteProxy cliente = new ClienteProxy(2);

        assertEquals(2000.0f, cliente.obterSaldo(funcionario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarSaldoCliente() {
        try {
            Funcionario funcionario = new Funcionario("Maria Joana", false);
            ClienteProxy cliente = new ClienteProxy(2);

            cliente.obterSaldo(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}
