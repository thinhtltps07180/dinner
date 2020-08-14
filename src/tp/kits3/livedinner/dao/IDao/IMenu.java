package tp.kits3.livedinner.dao.IDao;

import java.util.List;

import tp.kits3.livedinner.vo.Menu;

public interface IMenu {
	List<Menu> findAll();
	void save(Menu menu);
	Menu findOne(int muid);
	void update(Menu menu);
}
