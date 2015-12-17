package Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import Entites.FeuilleDevoir;


public class FeuilleDevoirImpl extends SqlMapClientDaoSupport 
			implements IFeuilleDevoirDao
{	
	@Override
	public  List<FeuilleDevoir> selectAllDevoirs()
	{
		return  (List<FeuilleDevoir>) getSqlMapClientTemplate().queryForList(
				"FeuilleDevoir.selectAllDevoirs", null);
	}

	@Override
	public List<FeuilleDevoir> selectDevoirsProf(int idProf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeuilleDevoir selectOneDevoir(int idFeuille) {
		//recuperer la personne dans BDD
		FeuilleDevoir feuille = (FeuilleDevoir) getSqlMapClientTemplate()
				.queryForObject("FeuilleDevoir.selectOneDevoir", new Integer(idFeuille));
		if (feuille == null)
			throw new ExceptionDao("la feuille devoir de id ["+idFeuille+"] existe pas!");
		return feuille;
	}

	@Override
	public void saveDevoir(FeuilleDevoir feuille)
	{
		if (feuille != null){
			//insert ou update ?
			if (feuille.getId() == -1){
				// insert alors
				insertOneDevoir(feuille);
			}else{ //update sinon
				updateOneDevoir(feuille);
			}
		}
	}

	@Override
	public void insertOneDevoir(FeuilleDevoir feuille) {
		if (feuille != null)
			getSqlMapClientTemplate().insert("FeuilleDevoir.insertOneDevoir", feuille);	
	}

	@Override
	public void updateOneDevoir(FeuilleDevoir feuille) {
		int nb = getSqlMapClientTemplate().update("FeuilleDevoir.updateOneDevoir", feuille);
		if (nb == 0)
			throw new ExceptionDao("la feuille devoir de id ["+feuille.getId()+"] " +
					"existe pas ou a ete modifiee!");
		
		
	}

	@Override
	public void deleteOneDevoir(int idFeuilleDevoir) 
	{
		int nb = getSqlMapClientTemplate().delete("FeuilleDevoir.deleteOneDevoir",
											new Integer(idFeuilleDevoir));
		if (nb == 0)
			throw new ExceptionDao("feuilledevoir d' id ["+idFeuilleDevoir+"] inconnu");
		
	}

}
