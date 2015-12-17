package Dao;

import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import Entites.User;


public class UserDao extends SqlMapClientDaoSupport implements IUserDao{

	@Override
	public List<User> selectAllUsers() {
		return (List<User>) getSqlMapClientTemplate().queryForList("User.selectAll", null);
	}

	@Override
	public User selectOneUser(int idUser) 
	{
		// recuperer dans la BDD
		User user = (User) getSqlMapClientTemplate().queryForObject("User.selectOneUser", idUser);
		if (user == null)
			throw new ExceptionDao("le user d'id ["+idUser+"]sn'existe pas");	
		return user;
	}

	@Override
	public void saveUser(User user) {
		if (user != null){
			if (user.getId() == -1){
				insertOneUser(user);
			}else
				updateOneUser(user);
		}
	}

	@Override
	public void insertOneUser(User user)
	{
		if (user != null)		
				getSqlMapClientTemplate().insert("User.insertOneUser", user);		
	}

	@Override
	public void updateOneUser(User user)
	{
		int nbUser = getSqlMapClientTemplate().update("User.updateOneUser", user);
		
		if (nbUser != 1 ){
			throw new ExceptionDao("echec update user");
		}
	}

	@Override
	public void deleteOneUser(int idUser) 
	{
		int nbUserDelete = getSqlMapClientTemplate()
				.delete("User.deleteOne", idUser);
		if (nbUserDelete == 0 )
			throw new ExceptionDao("le user d'id ["+idUser+"] inconnu");
	}
}
