package it.giuseppe.cometa.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.giuseppe.cometa.dao.IArticoliDao;

@RestController
public class ArticoliController {
	
	@Autowired
	IArticoliDao articoliDao;

	@RequestMapping("/articoli/list/")
	public List<String> getIndex() {

		List<String> articoli = new ArrayList<String>();

		try {
			articoli = articoliDao.getAllArticoli();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return articoli;
	}
	
}
