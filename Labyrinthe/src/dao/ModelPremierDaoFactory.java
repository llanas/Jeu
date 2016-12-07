package dao;

import dao.labyrinthe.LabyrintheDaoModelPremier;

public class ModelPremierDaoFactory extends DaoFactory {

	public ModelPremierDaoFactory() {
		super(new LabyrintheDaoModelPremier());
	}

}
