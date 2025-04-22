package dao;

import java.util.List;

import model.Item;

public interface ItemDAO {
	 void guardar(Item item);
	 List<Item> listarTodos();
}
