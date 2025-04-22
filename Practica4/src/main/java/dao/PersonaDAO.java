package dao;

import java.util.List;

import model.Item;
import model.Persona;

public interface PersonaDAO {
	 void guardar(Persona persona);
	 List<Persona> listarTodos();
	 boolean mailExistente(String email);
}
