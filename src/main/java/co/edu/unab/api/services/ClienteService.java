package co.edu.unab.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase());  
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(String id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
                             
    }      
    public Optional<ClienteModel> obtenerClientePorId(String id){
        
        return clienteRepository.findById(id);
    }  
    
    public ArrayList<ClienteModel> obtenerPorNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    public ArrayList<ClienteModel> obtenerPorNombreYApellido (String nombre, String apellido){
        return clienteRepository.clientePorNombreYApellido(nombre, apellido);
    }

    public ArrayList<ClienteModel> obtenerClientePorCiudadYDepartamento (String ciudad, String departamento){
        return clienteRepository.clientePorCiudad(ciudad, departamento);
    }

    public ArrayList<ClienteModel> obtenerClientesMayorIgualPuntos(Long puntos){
        return clienteRepository.findByPuntosGreaterThanEqual(puntos);
    }

    public ArrayList<ClienteModel> obtenerClienteMenorIgualPuntos(Long puntos){
        return clienteRepository.clienteMenorIgualPuntos(puntos);
    }

    public ArrayList<ClienteModel> obtenerClientePorProductos (String nombre){
        return clienteRepository.clientePorProductos(nombre);
    }
}