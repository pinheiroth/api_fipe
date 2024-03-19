package com.api_fipe.api_fipe.service.implementacao;

import com.api_fipe.api_fipe.domain.Carro;
import com.api_fipe.api_fipe.domain.Cliente;
import com.api_fipe.api_fipe.repository.FipeRepository;
import com.api_fipe.api_fipe.repository.RepositoryCliente;
import com.api_fipe.api_fipe.service.ClienteService;
import com.api_fipe.api_fipe.service.FipeCarService;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private RepositoryCliente repository;
    @Autowired
    private FipeRepository fipeRepository;
    @Autowired
    private FipeCarService fipeService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteMaisCarro(cliente);
    }

    @Override
    public void atualizarPorId(Long id, Cliente cliente) {
        Optional<Cliente> newCliente = repository.findById(id);
        if(newCliente.isPresent()){
            salvarClienteMaisCarro(cliente);
        }
    }

    @Override
    public void deletarPorId(Long id) {

        repository.deleteById(id);
    }

    public void salvarClienteMaisCarro(Cliente cliente){
        String car = cliente.getCarro().getId();
        Carro carro = fipeRepository.findById(car).orElseGet(()->{
            Carro newCar = fipeService.consultarFipe(car);
            fipeRepository.save(newCar);
            return newCar;
        });
        cliente.setCarro(carro);
        repository.save(cliente);

    }
}
