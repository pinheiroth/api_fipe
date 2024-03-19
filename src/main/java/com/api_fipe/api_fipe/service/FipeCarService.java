package com.api_fipe.api_fipe.service;

import com.api_fipe.api_fipe.domain.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fipeapi", url = "http://api.fipeapi.com.br/v1")
public interface FipeCarService {

    @GetMapping("/{car}/json/")
    Carro consultarFipe(
            @PathVariable("car") String car
    );
}
