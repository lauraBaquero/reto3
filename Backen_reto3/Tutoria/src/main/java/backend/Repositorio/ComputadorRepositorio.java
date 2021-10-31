/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import backend.Modelo.Computador;
import backend.Interface.InterfaceComputador;

/**
 *
 * @author USUARIO
 */
@Repository
public class ComputadorRepositorio {
      @Autowired
    private InterfaceComputador crud;
    

    public List<Computador> getAll(){
        return (List<Computador>) crud.findAll();       
    }
    
    public Optional <Computador> getComputador(int id){
        return crud.findById(id);
    }
    
    public Computador save(Computador computador){
        return crud.save(computador);
    }
     public void delete(Computador computador){
        crud.delete(computador);
    }
    
}
