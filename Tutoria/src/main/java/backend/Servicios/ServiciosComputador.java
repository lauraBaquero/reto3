/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Servicios;

import backend.Modelo.Computador;
import backend.Repositorio.ComputadorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosComputador {
        @Autowired
    private ComputadorRepositorio metodosCrud;
    
    public List<Computador> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Computador> getComputador(int idComputador){
        return metodosCrud.getComputador(idComputador);
    }
    
    public Computador save(Computador computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<Computador> evt=metodosCrud.getComputador(computer.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }
    public Computador update(Computador computer){
        if(computer.getId()!=null){
            Optional<Computador> e=metodosCrud.getComputador(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    e.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputador(int idComputador) {
        Boolean aBoolean = getComputador(idComputador).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
