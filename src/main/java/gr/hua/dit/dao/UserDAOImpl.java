package gr.hua.dit.dao;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import gr.hua.dit.models.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	//add new user into DB
	@Override
	public void register(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into Users (UserID, Name, Password) values (?, ?, ?)", user.getUserID(),
				user.getName(), user.getPassword());

	}

	//compare user's input to all IDs to check if ID exists
	@Override
	public int compare(String userid) {
		String query = "select UserID from Users";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int comp = 0;
		List<Map<String, Object>> idRows = jdbcTemplate.queryForList(query);
		for (Map<String, Object> idRow : idRows) {

			String ids = String.valueOf(idRow.get("UserID"));
			if (userid.equals(ids))
				comp = comp + 1;
		}
		return comp;
	}

	//search for certain user id and password in DB for user's login
	@Override
	public User login(String userid, String password) {
		String query = "select * from Users where UserID = ? and Password = ?";

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Object queryForObject = jdbcTemplate.queryForObject(query, new Object[] { userid, password },
					new BeanPropertyRowMapper<User>(User.class));
			User user = (User) queryForObject;

			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	//return a user by searching for his ID in DB
	@Override
	public User getById(String userid) {
		String query = "select * from Users where UserID = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object queryForObject = jdbcTemplate.queryForObject(query, new Object[] { userid },
				new BeanPropertyRowMapper<User>(User.class));
		User user = (User) queryForObject;

		return user;
	}
}
