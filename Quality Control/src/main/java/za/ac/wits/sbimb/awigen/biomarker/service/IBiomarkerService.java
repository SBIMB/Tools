/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.service;

import za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker;

/**
 * @author Freedom Mukomana
 *
 */
public interface IBiomarkerService {
	public void createTable(String tableName, String columnHeaders);
	public void save(Biomarker biomarker);
	public void update(Biomarker biomarker);
	public void updateTables();
	public void delete(Biomarker biomarker);
	public void deleteByID(String studyID);
	public Biomarker getBiomarker(String studyID);
}
