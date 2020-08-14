package tp.kits3.livedinner.service;

import java.util.List;

import tp.kits3.livedinner.dao.IDao.IMenu;
import tp.kits3.livedinner.dao.IDaoImpl.MenuImpl;
import tp.kits3.livedinner.vo.Menu;

public class MenuService {
	private IMenu menu;
	
	public MenuService() {
		menu = new MenuImpl();
	}
	
	public List<Menu> findAll(){
		return menu.findAll();
	}
	
	public void save (Menu menu) {
		this.menu.save(menu);
	}
	
}
