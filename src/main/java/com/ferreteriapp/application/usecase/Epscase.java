package com.ferreteriapp.application.usecase;

import java.util.List;

import com.ferreteriapp.domain.Repositoy.EpsRepository;
import com.ferreteriapp.domain.entities.eps;

public class Epscase {
    private final EpsRepository repository;

    public Epscase(EpsRepository repository) {
        this.repository = repository;
    }
    public void save (String name){
        eps eps = new eps(name);
        repository.save(eps);
    }
    public eps obtenerEps(int id){
        return repository.findById(id);
    }
    public List<eps> ListarEps(){
        return repository.fiadAll();
    }
    public void actualizarEps(String name){
        eps eps = new eps(name);
        repository.update(eps);
    }
    public void eliminarEps(int id) {
        repository.delete(id);
    }
}
