package org.example;

import java.util.List;

public interface ICliente {
    List<String> obterDadosPessoais();
    Float obterSaldo(Funcionario funcionario);
}

