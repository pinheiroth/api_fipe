package com.api_fipe.api_fipe.service;

import com.api_fipe.api_fipe.domain.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizarPorId(Long id, Cliente cliente);
    void deletarPorId(Long id);
}
