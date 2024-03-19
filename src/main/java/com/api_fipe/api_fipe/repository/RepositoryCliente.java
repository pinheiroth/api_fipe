package com.api_fipe.api_fipe.repository;

import com.api_fipe.api_fipe.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface RepositoryCliente extends CrudRepository<Cliente, Long> {
}
