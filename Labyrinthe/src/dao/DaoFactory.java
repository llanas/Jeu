package dao;

import dao.labyrinthe.LabyrintheDao;

public abstract class DaoFactory {
	
	LabyrintheDao labyrintheDao;
	
	public DaoFactory(LabyrintheDao labyrintheDao) {
		super();
		this.labyrintheDao = labyrintheDao;
	}

	public LabyrintheDao getLabyrintheDao() {
		return this.labyrintheDao;
	}
}
