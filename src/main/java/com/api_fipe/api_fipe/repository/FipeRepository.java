package com.api_fipe.api_fipe.repository;

import com.api_fipe.api_fipe.domain.Carro;
import org.springframework.data.repository.CrudRepository;


public interface FipeRepository extends CrudRepository<Carro, String> {
}
