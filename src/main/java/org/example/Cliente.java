package org.example;

import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente {

    private Integer id;
    private String nome;
    private String endereco;
    private Float saldo;

    public Cliente(int id) {
        this.id = id;
        Cliente objeto = BD.getCliente(id);
        this.nome = objeto.nome;
        this.endereco = objeto.endereco;
        this.saldo = objeto.saldo;
    }

    public Cliente(Integer id, String nome, String endereco, Float saldo) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.endereco);
    }

    @Override
    public Float obterSaldo(Funcionario funcionario) {
        return this.saldo;
    }
}
