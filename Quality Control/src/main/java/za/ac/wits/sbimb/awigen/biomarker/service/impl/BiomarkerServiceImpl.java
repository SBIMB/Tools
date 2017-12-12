/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.ac.wits.sbimb.awigen.biomarker.dao.BiomarkerDAO;
import za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker;
import za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService;

/**
 * @author Freedom Mukomana
 *
 */
@Transactional
@Service("BiomarkerService")
public class BiomarkerServiceImpl implements IBiomarkerService {
	
	
	
	@Override
	public void createTable(String tableName, String columnHeaders) {
		biomarkerDAO.createTable(tableName, columnHeaders);	
	}

	@Autowired
	BiomarkerDAO biomarkerDAO = new BiomarkerDAO();

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#create(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	@Override
	public void save(Biomarker biomarker) {
		biomarkerDAO.save(biomarker);
	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#update(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	@Override
	public void update(Biomarker biomarker) {
		biomarkerDAO.update(biomarker);
	}
	

	@Override
	public void updateTables() {
		biomarkerDAO.updateThidPartyTable();
		
	}


	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#delete(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	@Override
	public void delete(Biomarker biomarker) {
		biomarkerDAO.delete(biomarker);
	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#deleteByID(java.lang.String)
	 */
	@Override
	public void deleteByID(String studyID) {
		biomarkerDAO.deleteByID(studyID);
	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#getBiomarker(java.lang.String)
	 */
	@Override
	public Biomarker getBiomarker(String studyID) {
		return biomarkerDAO.getBiomarker(studyID);
	}
}
