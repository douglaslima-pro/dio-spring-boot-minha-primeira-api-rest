package edu.douglaslima.spring.apirest.repository;

import org.springframework.stereotype.Repository;

import edu.douglaslima.spring.apirest.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
	
	private Map<Long, User> usuarios = new HashMap<>();

	public void save(User usuario){
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
        this.usuarios.put(usuario.getId(), usuario);
    }
	
    public void update(User usuario){
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
        this.usuarios.put(usuario.getId(), usuario);
    }
    
    public void deleteById(Long id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
        this.usuarios.remove(id);
    }
    
    public List<User> findAll(){
        List<User> listaUsuarios = this.usuarios.values()
        		.stream()
        		.toList();
        return listaUsuarios;
    }
    
    public User findById(Long id){
        System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
        return this.usuarios.get(id);
    }
    
}
