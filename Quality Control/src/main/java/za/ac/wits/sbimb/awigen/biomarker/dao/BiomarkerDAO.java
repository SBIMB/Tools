/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.dao;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker;

/**
 * @author Freedom Mukomana
 *
 */
@Transactional
@Repository("BiomarkerDAO")
public class BiomarkerDAO extends HibernateSessionDAO{
	
	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#create(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	public void createTable(String tableName, String columnHeaders) {
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Dropping biomarker table");
		String queryString = "DROP TABLE public.biomarker;";
		session.createSQLQuery(queryString).executeUpdate();
		
		System.out.println("Dropped biomarker table");
		
		System.out.println("Creating biomarker table");
		
		queryString = "CREATE TABLE public.biomarker ("
				+" study_id character varying(255) NOT NULL, "
				+" study_site_id character varying(255),"
				+" sex character varying(255),"
				+" site character varying(255),"
				+" plasma_batch integer,"
				+" plasma_box character varying(255),"
				+" date_plasma_received timestamp without time zone,"
				+" is_haemolysed boolean,"
				+" biomarker_notes character varying(255),"
				+" plasma_tech_name character varying(255),"
				+" glucose_1 double precision,"
				+" glucose_2 double precision,"
				+" glucose_3 double precision,"
				+" date_glucose_1 timestamp without time zone,"
				+" date_glucose_2 timestamp without time zone,"
				+" date_glucose_3 timestamp without time zone,"
				+" glucose_comments character varying(255),"
				+" serum_batch integer,"
				+" serum_box character varying(255),"
				+" date_serum_received timestamp without time zone,"
				+" is_serum_testable boolean,"
				+" serum_comments character varying(255),"
				+" serum_tech_name character varying(255),"
				+" s_creatinine_1 double precision,"
				+" s_creatinine_2 double precision,"
				+" s_creatinine_3 double precision,"
				+" insulin_1 double precision,"
				+" insulin_2 double precision,"
				+" insulin_3 double precision,"
				+" date_insulin_tested_1 timestamp without time zone,"
				+" date_insulin_tested_2 timestamp without time zone,"
				+" date_insulin_tested_3 timestamp without time zone,"
				+" insulin_comments character varying(255),"
				+" hdl_1 double precision,"
				+" hdl_2 double precision,"
				+" hdl_3 double precision,"
				+" ldl_1 double precision,"
				+" ldl_2 double precision,"
				+" ldl_3 double precision,"
				+" cholesterol_1 double precision,"
				+" cholesterol_2 double precision,"
				+" cholesterol_3 double precision,"
				+" triglycerides_1 double precision,"
				+" triglycerides_2 double precision,"
				+" triglycerides_3 double precision,"
				+" date_lipids_tested_1 timestamp without time zone,"
				+" date_lipids_tested_2 timestamp without time zone,"
				+" date_lipids_tested_3 timestamp without time zone,"
				+" lipids_comments character varying(255),"
				+" urine_batch integer,"
				+" urine_box character varying(255),"
				+" date_urine_received timestamp without time zone,"
				+" urine_tech_name character varying(255),"
				+" urine_creatinine double precision,"
				+" urine_albumin double precision,"
				+" acr double precision,"
				+" urine_protein double precision,"
				+" date_urine_tested timestamp without time zone,"
				+" urine_comments character varying(255),"
				+" no_results character varying(255),"
				+" is_complete boolean,"
				+" CONSTRAINT biomarker_pkey PRIMARY KEY (study_id)"
				+" )"
				+" 	  	  WITH ("
				+"  	  OIDS=FALSE"
				+" 		  );"
				+" ALTER TABLE public.biomarker"
				+"  OWNER TO awigen;";

		session.createSQLQuery(queryString).executeUpdate();
		transaction.commit();
	
		System.out.println("Table created");
		
	}
	
	public void updateThidPartyTable() {
		Transaction transaction = session.beginTransaction();
				
		System.out.println("Updating all_sites table with data from biomarker table");
			
		String queryString = "UPDATE public.biomarker SET serum_comments='No Blood Taken' WHERE serum_comments LIKE '%no blood taken%' OR serum_comments LIKE '%No serum taken%';"
				+ " UPDATE public.biomarker SET serum_comments='No Serum in Tube' WHERE serum_comments LIKE '%No serum in%' OR serum_comments LIKE '%no serum%';"
				+ " UPDATE public.biomarker SET serum_comments='No Sample in Tube' WHERE serum_comments LIKE '%No sample%';"
				+ " UPDATE public.biomarker SET serum_comments='Query Yusuf' WHERE serum_comments LIKE '%query Yusuf%';"
				+ " UPDATE"
					+ "	all_sites"
				+ " SET"
				+ " plasma_batch=tmp.plasma_batch,"
				+ " plasma_box=tmp.plasma_box,"
				+ " date_plasma_received=tmp.date_plasma_received,"
				+ " is_haemolysed=tmp.is_haemolysed,"
				+ " biomarker_notes=tmp.biomarker_notes,"
				+ " serum_tech_name=tmp.serum_tech_name,"
				+ " glucose=tmp.glucose_1,"
				+ " glucose_2=tmp.glucose_2,"
				+ " glucose_3=tmp.glucose_3,"
				+ " date_glucose=tmp.date_glucose_1,"
				+ " glucose_comments=tmp.glucose_comments,"
				+ " serum_batch=tmp.serum_batch,"
				+ " serum_box=tmp.serum_box,"
				+ " date_serum_received=tmp.date_serum_received,"
				+ " is_serum_testable=tmp.is_serum_testable,"
				+ " serum_comments=tmp.serum_comments,"
				+ " s_creatinine=tmp.s_creatinine_1,"
				+ " plasma_tech_name=tmp.plasma_tech_name,"
				+ " insulin=tmp.insulin_1,"
				+ " insulin_2=tmp.insulin_2,"
				+ " insulin_3=tmp.insulin_3,"
			+ " date_insulin_tested=tmp.date_insulin_tested_1,"
			+ " insulin_comments=tmp.insulin_comments,"
			+ " hdl=tmp.hdl_1,"
			+ " hdl_2=tmp.hdl_2,"
			+ " hdl_3=tmp.hdl_3,"
			+ " ldl=tmp.ldl_1,"
			+ " ldl_2=tmp.ldl_2,"
			+ " ldl_3=tmp.ldl_3,"
			+ " cholesterol_1=tmp.cholesterol_1,"
			+ " cholesterol_2=tmp.cholesterol_2,"
			+ " cholesterol_3=tmp.cholesterol_3,"
			+ " triglycerides=tmp.triglycerides_1,"
			+ " triglycerides_2=tmp.triglycerides_2,"
			+ " triglycerides_3=tmp.triglycerides_3,"
			+ " date_lipids_tested=tmp.date_lipids_tested_1,"
			+ " lipid_comments=tmp.lipids_comments,"
			+ " urine_batch=tmp.urine_batch,"
			+ " urine_box=tmp.urine_box,"
			+ " date_urine_received=tmp.date_urine_received,"
			+ " urine_tech_name=tmp.urine_tech_name,"
			+ " ur_creatinine=tmp.urine_creatinine,"
			+ " ur_albumin=tmp.urine_albumin,"
			+ " acr=tmp.acr,"
			+ " ur_protein=tmp.urine_protein,"
			+ " date_urine_tested=tmp.date_urine_tested,"
			+ " urine_comments=tmp.urine_comments,"
			+ " date_glucose_2=tmp.date_glucose_2,"
			+ " s_creatinine_2=tmp.s_creatinine_2,"
			+ " date_insulin_tested_2=tmp.date_insulin_tested_2,"
			+ " date_lipids_tested_2=tmp.date_lipids_tested_2"
		+ " FROM"
			+ " (SELECT study_id, plasma_batch, plasma_box, date_plasma_received, is_haemolysed, biomarker_notes, serum_tech_name, glucose_1, glucose_2, glucose_3, date_glucose_1, glucose_comments, serum_batch, serum_box, date_serum_received, is_serum_testable, serum_comments, s_creatinine_1, plasma_tech_name, insulin_1, insulin_2, insulin_3, date_insulin_tested_1, insulin_comments, hdl_1, hdl_2, hdl_3, ldl_1, ldl_2, ldl_3, cholesterol_1, cholesterol_2, cholesterol_3, triglycerides_1, triglycerides_2, triglycerides_3, date_lipids_tested_1, lipids_comments, urine_batch, urine_box, date_urine_received, urine_tech_name, urine_creatinine, urine_albumin, acr, urine_protein, date_urine_tested, urine_comments, date_glucose_2, s_creatinine_2, date_insulin_tested_2, date_lipids_tested_2, no_results, is_complete FROM biomarker) AS tmp"
		+ " WHERE"
			+ " all_sites.study_id=tmp.study_id;";

		session.createSQLQuery(queryString).executeUpdate();
		transaction.commit();
		
		System.out.println("Table updated");
		
	}
	
	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#create(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	public void save(Biomarker biomarker) {		
		Transaction t = session.beginTransaction();
			
		session.saveOrUpdate(biomarker);
		t.commit();
	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#update(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	public void update(Biomarker biomarker) {
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(biomarker);
		t.commit();
	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#delete(za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker)
	 */
	public void delete(Biomarker biomarker) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#deleteByID(java.lang.String)
	 */
	public void deleteByID(String studyID) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService#getBiomarker(java.lang.String)
	 */
	public Biomarker getBiomarker(String studyID) {
		// TODO Auto-generated method stub
		return null;
	}
}
