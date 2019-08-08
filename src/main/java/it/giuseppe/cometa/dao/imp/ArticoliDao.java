package it.giuseppe.cometa.dao.imp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.giuseppe.cometa.dao.IArticoliDao;

@Service
public class ArticoliDao extends NamedParameterJdbcDaoSupport implements IArticoliDao{
	
	@Autowired
	public ArticoliDao(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}
	
	
	@Override
	public List<String> getAllArticoli() {

		List<String> articoli = null;
		String sql = "SELECT descrizione , COUNT(codice_lotto) FROM cometa.articoli AS A JOIN lotti AS L on A.id = L.id_articolo GROUP BY descrizione";
		BeanPropertyRowMapper<String> rm = new BeanPropertyRowMapper<String>(String.class);
		articoli = getNamedParameterJdbcTemplate().query(sql, rm);

		return articoli;

	}
	
}
