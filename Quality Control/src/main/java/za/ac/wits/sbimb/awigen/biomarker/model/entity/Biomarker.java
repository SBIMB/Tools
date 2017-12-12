/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.ac.wits.sbimb.awigen.biomarker.util.Util;

/**
 * @author Freedom Mukomana
 *
 */
@Entity
@Table(name="BIOMARKER")
public class Biomarker {
	
	String studyID;
	String studySiteID;
	String sex;
	String site;
	Integer plasmaBatch;
	String plasmaBox;
	Calendar datePlasmaReceived;
	Boolean isHaemolysed;
	String biomarkerNotes;
	String plasmaTechName;
	Double glucose1;
	Double glucose2;
	Double glucose3;
	Calendar dateGlucose1;
	Calendar dateGlucose2;
	Calendar dateGlucose3;
	String glucoseComments;
	Integer serumBatch;
	String serumBox;
	Calendar dateSerumReceived;
	Boolean isSerumTestable;
	String serumComments;
	String serumTechName;
	Double sCreatinine1;
	Double sCreatinine2;
	Double sCreatinine3;
	Double insulin1;
	Double insulin2;
	Double insulin3;
	Calendar dateInsulinTested1;
	Calendar dateInsulinTested2;
	Calendar dateInsulinTested3;
	String insulinComments;
	Double hdl1;
	Double hdl2;
	Double hdl3;
	Double ldl1;
	Double ldl2;
	Double ldl3;
	Double cholesterol1;
	Double cholesterol2;
	Double cholesterol3;
	Double triglycerides1;
	Double triglycerides2;
	Double triglycerides3;
	Calendar dateLipidsTested1;
	Calendar dateLipidsTested2;
	Calendar dateLipidsTested3;
	String lipidsComments;
	Integer urineBatch;
	String urineBox;
	Calendar dateUrineReceived;
	String urineTechName;
	Double urineCreatinine;
	Double urineAlbumin;
	Double acr;
	Double urineProtein;
	Calendar dateUrineTested;
	String urineComments;
	String noResults;
	Boolean isComplete;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
	
	/**
	 * 
	 */
	public Biomarker() {
		
	}
	
	/**
	 * 
	 */
	public Biomarker(String biomarkerStr) {
		String[] biomarkerStrVar = biomarkerStr.split(","); 
		
		try{
			studyID = biomarkerStrVar[0];
			
			if(!biomarkerStrVar[1].isEmpty()){
				studySiteID = biomarkerStrVar[1];
			}else{
					
			}
			
			
			if(!biomarkerStrVar[2].isEmpty()){
				sex = biomarkerStrVar[2].toString().trim();
			}else{
				sex = "9";
			}
			
			if(!biomarkerStrVar[3].isEmpty()){
				site = biomarkerStrVar[3].toString().trim();
			}else{
				site = "9";
			}
			
			if(!biomarkerStrVar[4].isEmpty()){
				plasmaBatch = Integer.getInteger(biomarkerStrVar[4]);
			}else{
				//plasmaBatch="";
			}
			
			if(!biomarkerStrVar[5].isEmpty()){
				plasmaBox = biomarkerStrVar[5];
			}else{
				plasmaBox = "";
			}
			
			datePlasmaReceived = Util.parseStringToDate(biomarkerStrVar[6]);
			/*if(!biomarkerStrVar[6].isEmpty()){				 
				datePlasmaReceived.setTime(sdf.parse(biomarkerStrVar[6].toString()));
			}else{
				datePlasmaReceived.setTime(sdf.parse("1900-01-01"));
			}*/
			
			if(!biomarkerStrVar[7].isEmpty()){
				isHaemolysed = Boolean.getBoolean(biomarkerStrVar[7]);
			}else{
				isHaemolysed=null;
			}
			
			if(!biomarkerStrVar[8].isEmpty()){
				biomarkerNotes = biomarkerStrVar[8];
			}else{
				biomarkerNotes="";
			}
			
			if(!biomarkerStrVar[9].isEmpty()){
				plasmaTechName = biomarkerStrVar[9];
			}else{
				plasmaTechName = "";
			}
			
			if(!biomarkerStrVar[10].isEmpty()){
				glucose1 = Double.parseDouble(biomarkerStrVar[10]);
			}else{
				glucose1 = 0.00;
			}
			
			if(!biomarkerStrVar[11].isEmpty()){
				glucose2 = Double.parseDouble(biomarkerStrVar[11]);
			}else{
				glucose2=0.00;
			}
			
			if(!biomarkerStrVar[12].isEmpty()){
				glucose3 = Double.parseDouble(biomarkerStrVar[12]);
			}else{
				glucose3=0.00;
			}
			
			dateGlucose1 = Util.parseStringToDate(biomarkerStrVar[13]);
			/*if(!biomarkerStrVar[13].isEmpty()){
				dateGlucose1.setTime(sdf.parse(biomarkerStrVar[13].toString()));
			}else{
				dateGlucose1.setTime(sdf.parse("1900-01-01"));
			}*/
			dateGlucose2 = Util.parseStringToDate(biomarkerStrVar[14]);
			/*if(!biomarkerStrVar[14].isEmpty()){
				dateGlucose2.setTime(sdf.parse(biomarkerStrVar[14].toString()));
			}else{
				dateGlucose2.setTime(sdf.parse("1900-01-01"));
			}*/
			dateGlucose3 = Util.parseStringToDate(biomarkerStrVar[15]);
			/*if(!biomarkerStrVar[15].isEmpty() | !biomarkerStrVar[15].equalsIgnoreCase("") | !biomarkerStrVar[15].equalsIgnoreCase(null)){
				System.out.println("Date Glucose 3 "+ biomarkerStrVar[15].toString());
				dateGlucose3.setTime(sdf.parse(biomarkerStrVar[15].toString()));
			}else{
				dateGlucose3.setTime(sdf.parse("1900-01-01"));
			}*/
			if(!biomarkerStrVar[16].isEmpty()){
				glucoseComments = biomarkerStrVar[16];
			}else{
				glucoseComments="";
			}
			
			if(!biomarkerStrVar[17].isEmpty()){
				serumBatch = Integer.getInteger(biomarkerStrVar[17]);
			}else{
				//serumBatch="";
			}
			
			if(!biomarkerStrVar[18].isEmpty()){
				serumBox = biomarkerStrVar[18];
			}else{
				serumBox="";
			}
			
			dateSerumReceived = Util.parseStringToDate(biomarkerStrVar[19]);
			/*if(biomarkerStrVar[19].length()!=0 & !biomarkerStrVar[19].isEmpty() & biomarkerStrVar[19].trim().toString()!=""){
				dateSerumReceived.setTime(sdf1.parse(biomarkerStrVar[19].toString()));
			}else{
				dateSerumReceived.setTime(sdf.parse("1900-01-01"));
			}*/
			
			if(!biomarkerStrVar[20].isEmpty()){
				isSerumTestable = Boolean.getBoolean(biomarkerStrVar[20]);
			}else{
				
			}
			
			if(!biomarkerStrVar[21].isEmpty()){
				serumComments = biomarkerStrVar[21];
			}else{
				
			}
			
			if(!biomarkerStrVar[22].isEmpty()){
				serumTechName = biomarkerStrVar[22];
			}else{
				serumTechName ="";	
			}			
				
			if(!biomarkerStrVar[23].isEmpty()){
				sCreatinine1 = Double.parseDouble(biomarkerStrVar[23]);
			}else{
				sCreatinine1 = 0.00;
			}
			
			if(!biomarkerStrVar[24].isEmpty()){
				sCreatinine2 = Double.parseDouble(biomarkerStrVar[24]);
			}else{
				sCreatinine2 = 0.00;
			}
			
			if(!biomarkerStrVar[25].isEmpty()){
				sCreatinine3 = Double.parseDouble(biomarkerStrVar[25]);
			}else{
				sCreatinine3 = 0.00;
			}
			
			if(!biomarkerStrVar[26].isEmpty()){
				insulin1 = Double.parseDouble(biomarkerStrVar[26]);
			}else{
				insulin1=0.00;	
			}
			
			if(!biomarkerStrVar[27].isEmpty()){
				insulin2 = Double.parseDouble(biomarkerStrVar[27]);
			}else{
				insulin2 = 0.00;
			}
			
			if(!biomarkerStrVar[28].isEmpty()){
				insulin3 = Double.parseDouble(biomarkerStrVar[28]);
			}else{
				insulin3 = 0.00;
			}
						
			dateInsulinTested1 = Util.parseStringToDate(biomarkerStrVar[29]);					
			/*if(!biomarkerStrVar[29].isEmpty()){
				dateInsulinTested1.setTime(sdf.parse(biomarkerStrVar[29].toString()));
			}else{
				dateInsulinTested1.setTime(sdf.parse("1900-01-01"));
			}*/
			
			dateInsulinTested2 = Util.parseStringToDate(biomarkerStrVar[30]);						
			/*if(!biomarkerStrVar[30].isEmpty()){
				dateInsulinTested2.setTime(sdf.parse(biomarkerStrVar[30].toString()));
			}else{
				dateInsulinTested2.setTime(sdf.parse("1900-01-01"));
			}*/
			
			dateInsulinTested3 = Util.parseStringToDate(biomarkerStrVar[31]);						
			/*if(!biomarkerStrVar[31].isEmpty()){
				dateInsulinTested3.setTime(sdf.parse(biomarkerStrVar[31].toString()));
			}else{
				dateInsulinTested3.setTime(sdf.parse("1900-01-01"));
			}*/
			
			if(!biomarkerStrVar[32].isEmpty()){
				insulinComments = biomarkerStrVar[32];
			}else{
					
			}
			
			if(!biomarkerStrVar[33].isEmpty()){
				hdl1 = Double.parseDouble(biomarkerStrVar[33]);
			}else{
				hdl1=0.00;
			}
			
			if(!biomarkerStrVar[34].isEmpty()){
				hdl2 = Double.parseDouble(biomarkerStrVar[34]);
			}else{
				hdl2=0.00;	
			}
			
			if(!biomarkerStrVar[35].isEmpty()){
				hdl3 = Double.parseDouble(biomarkerStrVar[35]);
			}else{
				hdl3=0.00;	
			}
			
			if(!biomarkerStrVar[36].isEmpty()){
				ldl1 = Double.parseDouble(biomarkerStrVar[36]);
			}else{
				ldl1 = 0.00;	
			}
			
			if(!biomarkerStrVar[37].isEmpty()){
				ldl2 = Double.parseDouble(biomarkerStrVar[37]);
			}else{
				ldl2 = 0.00;	
			}
			
			if(!biomarkerStrVar[38].isEmpty()){
				ldl3 = Double.parseDouble(biomarkerStrVar[38]);
			}else{
				ldl3 = 0.00;	
			}
			
			if(!biomarkerStrVar[39].isEmpty()){
				cholesterol1 = Double.parseDouble(biomarkerStrVar[39]);
			}else{
				cholesterol1 = 0.00;	
			}
			
			if(!biomarkerStrVar[40].isEmpty()){
				cholesterol2 = Double.parseDouble(biomarkerStrVar[40]);
			}else{
				cholesterol2 = 0.00;
			}
			
			if(!biomarkerStrVar[41].isEmpty()){
				cholesterol3 = Double.parseDouble(biomarkerStrVar[41]);
			}else{
				cholesterol3=0.00;
			}
			
			if(!biomarkerStrVar[42].isEmpty()){
				triglycerides1 = Double.parseDouble(biomarkerStrVar[42]);
			}else{
				triglycerides1=0.00;
			}
			
			if(!biomarkerStrVar[43].isEmpty()){
				triglycerides2 = Double.parseDouble(biomarkerStrVar[43]);
			}else{
				triglycerides2=0.00;
			}
			
			if(!biomarkerStrVar[44].isEmpty()){
				triglycerides3 = Double.parseDouble(biomarkerStrVar[44]);
			}else{
				triglycerides3=0.00;		
			}
			
			dateLipidsTested1 = Util.parseStringToDate(biomarkerStrVar[45]);
			/*if(!biomarkerStrVar[45].isEmpty()){
				dateLipidsTested1.setTime(sdf.parse(biomarkerStrVar[45].toString()));
			}else{
				dateLipidsTested1.setTime(sdf.parse("1900-01-01"));
			}*/
			
			dateLipidsTested2 = Util.parseStringToDate(biomarkerStrVar[46]);
			/*if(!biomarkerStrVar[46].isEmpty()){
				dateLipidsTested2.setTime(sdf.parse(biomarkerStrVar[46].toString()));
			}else{
				dateLipidsTested2.setTime(sdf.parse("1900-01-01"));
			}*/
			
			dateLipidsTested3 = Util.parseStringToDate(biomarkerStrVar[47]);
			/*if(!biomarkerStrVar[47].isEmpty()){
				dateLipidsTested3.setTime(sdf.parse(biomarkerStrVar[47].toString()));
			}else{
				dateLipidsTested3.setTime(sdf.parse("1900-01-01"));
			}*/
			
			if(!biomarkerStrVar[48].isEmpty()){
				lipidsComments = biomarkerStrVar[48];
			}else{
					
			}
			
			if(!biomarkerStrVar[49].isEmpty()){
				urineBatch = Integer.getInteger(biomarkerStrVar[49]);
			}else{
					
			}
			
			//System.out.println(biomarkerStrVar[42]);
			if(!biomarkerStrVar[50].isEmpty()){
				urineBox = biomarkerStrVar[50];
			}else{
					
			}
			
			dateUrineReceived = Util.parseStringToDate(biomarkerStrVar[51]);
			/*if(!biomarkerStrVar[51].isEmpty()){
				dateUrineReceived.setTime(sdf.parse(biomarkerStrVar[51].toString()));
			}else{
				dateUrineReceived.setTime(sdf.parse("1900-01-01"));	
			}*/
			
			if(!biomarkerStrVar[52].isEmpty()){
				urineTechName = biomarkerStrVar[52];
			}else{
					
			}
			
			if(!biomarkerStrVar[53].isEmpty()){
				urineCreatinine = Double.parseDouble(biomarkerStrVar[53]);
			}else{
				urineCreatinine = 0.00;
			}
			
			if(!biomarkerStrVar[54].isEmpty()){
				urineAlbumin = Double.parseDouble(biomarkerStrVar[54]);
			}else{
				urineAlbumin = 0.00;
			}
			
			if(!biomarkerStrVar[55].isEmpty()){
				acr = Double.valueOf(biomarkerStrVar[55]);
			}else{
				//acr = "";
			}
			
			if(!biomarkerStrVar[56].isEmpty()){
				urineProtein = Double.parseDouble(biomarkerStrVar[56]);
			}else{
				urineProtein = 0.00;
			}
			
			dateUrineTested = Util.parseStringToDate(biomarkerStrVar[57]);			
			/*if(!biomarkerStrVar[57].isEmpty()){
				dateUrineTested.setTime(sdf.parse(biomarkerStrVar[57].toString()));
			}else{
				dateUrineTested.setTime(sdf.parse("1900-01-01"));	
			}*/
			
			if(!biomarkerStrVar[58].isEmpty()){
				urineComments = biomarkerStrVar[58];
			}else{
					
			}
			
			if(!biomarkerStrVar[59].isEmpty()){
				noResults = biomarkerStrVar[59];
			}else{
					
			}
			
			if(!biomarkerStrVar[60].isEmpty()){
				isComplete = Boolean.parseBoolean(biomarkerStrVar[60]);
			}else{
					
			}
		}catch(Exception ex){
			System.out.println(urineCreatinine + " " + urineAlbumin + " " + biomarkerStr);
			ex.printStackTrace();
		}
	}

	/**
	 * @param studyID
	 * @param studySiteID
	 * @param sex
	 * @param plasmaBatch
	 * @param plasmaBox
	 * @param datePlasmaReceived
	 * @param isHaemolysis
	 * @param biomarkerNotes
	 * @param plasmaTechName
	 * @param glucose1
	 * @param glucose2
	 * @param dateGlucose
	 * @param glucoseComments
	 * @param serumBatch
	 * @param serumBox
	 * @param dateSerumReceived
	 * @param isSerumTestable
	 * @param serumComments
	 * @param serumTechName
	 * @param sCreatinine
	 * @param insulin1
	 * @param insulin2
	 * @param dateInsulinTested
	 * @param insulinComments
	 * @param hdl1
	 * @param hdl2
	 * @param ldl1
	 * @param ldl2
	 * @param cholesterol1
	 * @param cholesterol2
	 * @param triglycerides1
	 * @param triglycerides2
	 * @param dateLipidsTested
	 * @param lipidsComments
	 * @param urineBatch
	 * @param urineBox
	 * @param dateUrineReceived
	 * @param urineTechName
	 * @param urineCreatinine
	 * @param urineAlbumin
	 * @param acr
	 * @param urineProtein
	 * @param dateUrineTested
	 * @param urineComments
	 * @param isComplete
	 */
	
	public Biomarker(String studyID, 
			String studySiteID, 
			String sex,
			String site,
			Integer plasmaBatch, 
			String plasmaBox, 
			Calendar datePlasmaReceived,
			Boolean isHaemolysis, 
			String biomarkerNotes, 
			String plasmaTechName,
			Double glucose1, 
			Double glucose2, 
			Double glucose3,
			Calendar dateGlucose1,
			Calendar dateGlucose2,
			Calendar dateGlucose3,
			String glucoseComments, 
			Integer serumBatch, 
			String serumBox,
			Calendar dateSerumReceived, 
			Boolean isSerumTestable,
			String serumComments, 
			String serumTechName, 
			Double sCreatinine1,
			Double sCreatinine2,
			Double sCreatinine3,
			Double insulin1, 
			Double insulin2, 
			Double insulin3,
			Calendar dateInsulinTested1,
			Calendar dateInsulinTested2,
			Calendar dateInsulinTested3,
			String insulinComments, 
			Double hdl1, 
			Double hdl2, 
			Double hdl3,
			Double ldl1,
			Double ldl2,
			Double ldl3,
			Double cholesterol1, 
			Double cholesterol2,
			Double cholesterol3,
			Double triglycerides1, 
			Double triglycerides2,
			Double triglycerides3,
			Calendar dateLipidsTested1, 
			Calendar dateLipidsTested2, 
			Calendar dateLipidsTested3, 
			String lipidsComments,
			Integer urineBatch, 
			String urineBox, 
			Calendar dateUrineReceived,
			String urineTechName, 
			Double urineCreatinine, 
			Double urineAlbumin,
			Double acr, 
			Double urineProtein, 
			Calendar dateUrineTested,
			String urineComments, 
			Boolean isComplete) {
		this.studyID = studyID;
		this.studySiteID = studySiteID;
		this.sex = sex;
		this.site = site;
		this.plasmaBatch = plasmaBatch;
		this.plasmaBox = plasmaBox;
		this.datePlasmaReceived = datePlasmaReceived;
		this.isHaemolysed = isHaemolysis;
		this.biomarkerNotes = biomarkerNotes;
		this.plasmaTechName = plasmaTechName;
		this.glucose1 = glucose1;
		this.glucose2 = glucose2;
		this.glucose3 = glucose3;
		this.dateGlucose1 = dateGlucose1;
		this.glucoseComments = glucoseComments;
		this.serumBatch = serumBatch;
		this.serumBox = serumBox;
		this.dateSerumReceived = dateSerumReceived;
		this.isSerumTestable = isSerumTestable;
		this.serumComments = serumComments;
		this.serumTechName = serumTechName;
		this.sCreatinine1 = sCreatinine1;
		this.sCreatinine2 = sCreatinine2;
		this.sCreatinine3 = sCreatinine3;
		this.insulin1 = insulin1;
		this.insulin2 = insulin2;
		this.insulin2 = insulin3;
		this.dateInsulinTested1 = dateInsulinTested1;
		this.insulinComments = insulinComments;
		this.hdl1 = hdl1;
		this.hdl2 = hdl2;
		this.hdl2 = hdl3;
		this.ldl1 = ldl1;
		this.ldl2 = ldl2;
		this.ldl2 = ldl3;
		this.cholesterol1 = cholesterol1;
		this.cholesterol2 = cholesterol2;
		this.cholesterol2 = cholesterol3;
		this.triglycerides1 = triglycerides1;
		this.triglycerides2 = triglycerides2;
		this.triglycerides2 = triglycerides3;
		this.dateLipidsTested1 = dateLipidsTested1;
		this.dateLipidsTested2 = dateLipidsTested2;
		this.dateLipidsTested3 = dateLipidsTested3;
		this.lipidsComments = lipidsComments;
		this.urineBatch = urineBatch;
		this.urineBox = urineBox;
		this.dateUrineReceived = dateUrineReceived;
		this.urineTechName = urineTechName;
		this.urineCreatinine = urineCreatinine;
		this.urineAlbumin = urineAlbumin;
		this.acr = acr;
		this.urineProtein = urineProtein;
		this.dateUrineTested = dateUrineTested;
		this.urineComments = urineComments;
		this.isComplete = isComplete;
	}
	
	/**
	 * @return the studyID
	 */
	@Id
	@Column(name="STUDY_ID")
	public String getStudyID() {
		return studyID;
	}
	/**
	 * @param studyID the studyID to set
	 */
	public void setStudyID(String studyID) {
		this.studyID = studyID;
	}
	/**
	 * @return the studySiteID
	 */
	@Column(name="STUDY_SITE_ID")
	public String getStudySiteID() {
		return studySiteID;
	}
	/**
	 * @param studySiteID the studySiteID to set
	 */
	public void setStudySiteID(String studySiteID) {
		this.studySiteID = studySiteID;
	}
	/**
	 * @return the sex
	 */
	@Column(name="SEX")
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	/**
	 * @return the site
	 */
	@Column(name="SITE")
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the sCreatinine1
	 */
	@Column(name="S_CREATININE_1")
	public Double getsCreatinine1() {
		return sCreatinine1;
	}

	/**
	 * @param sCreatinine the sCreatinine to set
	 */
	public void setsCreatinine1(Double sCreatinine1) {
		this.sCreatinine1 = sCreatinine1;
	}
	
	/**
	 * @return the sCreatinine
	 */
	@Column(name="S_CREATININE_2")
	public Double getsCreatinine2() {
		return sCreatinine2;
	}

	/**
	 * @param sCreatinine the sCreatinine to set
	 */
	public void setsCreatinine2(Double sCreatinine2) {
		this.sCreatinine2 = sCreatinine2;
	}

	/**
	 * @return the sCreatinine
	 */
	@Column(name="S_CREATININE_3")
	public Double getsCreatinine3() {
		return sCreatinine3;
	}

	/**
	 * @param sCreatinine the sCreatinine to set
	 */
	public void setsCreatinine3(Double sCreatinine3) {
		this.sCreatinine3 = sCreatinine3;
	}
	
	/**
	 * @return the plasmaBatch
	 */
	@Column(name="PLASMA_BATCH")
	public Integer getPlasmaBatch() {
		return plasmaBatch;
	}
	/**
	 * @param plasmaBatch the plasmaBatch to set
	 */
	public void setPlasmaBatch(Integer plasmaBatch) {
		this.plasmaBatch = plasmaBatch;
	}
	/**
	 * @return the plasmaBox
	 */
	@Column(name="PLASMA_BOX")
	public String getPlasmaBox() {
		return plasmaBox;
	}
	/**
	 * @param plasmaBox the plasmaBox to set
	 */
	public void setPlasmaBox(String plasmaBox) {
		this.plasmaBox = plasmaBox;
	}
	/**
	 * @return the datePlasmaReceived
	 */
	@Column(name="DATE_PLASMA_RECEIVED")
	public Calendar getDatePlasmaReceived() {
		return datePlasmaReceived;
	}
	/**
	 * @param datePlasmaReceived the datePlasmaReceived to set
	 */
	public void setDatePlasmaReceived(Calendar datePlasmaReceived) {
		this.datePlasmaReceived = datePlasmaReceived;
	}
	/**
	 * @return the isHaemolysis
	 */
	@Column(name="IS_HAEMOLYSED")
	public Boolean getIsHaemolysis() {
		return isHaemolysed;
	}
	/**
	 * @param isHaemolysis the isHaemolysis to set
	 */
	public void setIsHaemolysis(Boolean isHaemolysis) {
		this.isHaemolysed = isHaemolysis;
	}
	/**
	 * @return the biomarkerNotes
	 */
	@Column(name="BIOMARKER_NOTES")
	public String getBiomarkerNotes() {
		return biomarkerNotes;
	}
	/**
	 * @param biomarkerNotes the biomarkerNotes to set
	 */
	public void setBiomarkerNotes(String biomarkerNotes) {
		this.biomarkerNotes = biomarkerNotes;
	}
	/**
	 * @return the plasmaTechName
	 */
	@Column(name="PLASMA_TECH_NAME")
	public String getPlasmaTechName() {
		return plasmaTechName;
	}
	/**
	 * @param plasmaTechName the plasmaTechName to set
	 */
	public void setPlasmaTechName(String plasmaTechName) {
		this.plasmaTechName = plasmaTechName;
	}
	/**
	 * @return the glucose1
	 */
	@Column(name="GLUCOSE_1")
	public Double getGlucose1() {
		return glucose1;
	}
	/**
	 * @param glucose1 the glucose1 to set
	 */
	public void setGlucose1(Double glucose1) {
		this.glucose1 = glucose1;
	}
	/**
	 * @return the glucose2
	 */
	@Column(name="GLUCOSE_2")
	public Double getGlucose2() {
		return glucose2;
	}
	/**
	 * @param glucose2 the glucose2 to set
	 */
	public void setGlucose2(Double glucose2) {
		this.glucose2 = glucose2;
	}
	/**
	 * @return the glucose3
	 */
	@Column(name="GLUCOSE_3")
	public Double getGlucose3() {
		return glucose3;
	}
	/**
	 * @param glucose3 the glucose3 to set
	 */
	public void setGlucose3(Double glucose3) {
		this.glucose3 = glucose3;
	}
	/**
	 * @return the dateGlucose
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_GLUCOSE_1")
	public Calendar getDateGlucose1() {
		return dateGlucose1;
	}
	/**
	 * @param dateGlucose the dateGlucose to set
	 */
	public void setDateGlucose1(Calendar dateGlucose1) {
		this.dateGlucose1 = dateGlucose1;
	}
	/**
	 * @return the dateGlucose
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_GLUCOSE_2")
	public Calendar getDateGlucose2() {
		return dateGlucose2;
	}
	/**
	 * @param dateGlucose the dateGlucose to set
	 */
	public void setDateGlucose2(Calendar dateGlucose2) {
		this.dateGlucose2 = dateGlucose2;
	}
	/**
	 * @return the dateGlucose
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_GLUCOSE_3")
	public Calendar getDateGlucose3() {
		return dateGlucose3;
	}
	/**
	 * @param dateGlucose the dateGlucose to set
	 */
	public void setDateGlucose3(Calendar dateGlucose3) {
		this.dateGlucose3 = dateGlucose3;
	}
	/**
	 * @return the glucoseComments
	 */
	@Column(name="GLUCOSE_COMMENTS")
	public String getGlucoseComments() {
		return glucoseComments;
	}
	/**
	 * @param glucoseComments the glucoseComments to set
	 */
	public void setGlucoseComments(String glucoseComments) {
		this.glucoseComments = glucoseComments;
	}
	/**
	 * @return the serumBatch
	 */
	@Column(name="SERUM_BATCH")
	public Integer getSerumBatch() {
		return serumBatch;
	}
	/**
	 * @param serumBatch the serumBatch to set
	 */
	public void setSerumBatch(Integer serumBatch) {
		this.serumBatch = serumBatch;
	}
	/**
	 * @return the serumBox
	 */
	@Column(name="SERUM_BOX")
	public String getSerumBox() {
		return serumBox;
	}
	/**
	 * @param serumBox the serumBox to set
	 */
	public void setSerumBox(String serumBox) {
		this.serumBox = serumBox;
	}
	/**
	 * @return the dateSerumReceived
	 */
	@Column(name="DATE_SERUM_RECEIVED")
	public Calendar getDateSerumReceived() {
		return dateSerumReceived;
	}
	/**
	 * @param dateSerumReceived the dateSerumReceived to set
	 */
	public void setDateSerumReceived(Calendar dateSerumReceived) {
		this.dateSerumReceived = dateSerumReceived;
	}
	/**
	 * @return the isSerumTestable
	 */
	@Column(name="IS_SERUM_TESTABLE")
	public Boolean getIsSerumTestable() {
		return isSerumTestable;
	}
	/**
	 * @param isSerumTestable the isSerumTestable to set
	 */
	public void setIsSerumTestable(Boolean isSerumTestable) {
		this.isSerumTestable = isSerumTestable;
	}
	/**
	 * @return the serumComments
	 */
	@Column(name="SERUM_COMMENTS")
	public String getSerumComments() {
		return serumComments;
	}
	/**
	 * @param serumComments the serumComments to set
	 */
	public void setSerumComments(String serumComments) {
		this.serumComments = serumComments;
	}
	/**
	 * @return the serumTechName
	 */
	@Column(name="SERUM_TECH_NAME")
	public String getSerumTechName() {
		return serumTechName;
	}
	/**
	 * @param serumTechName the serumTechName to set
	 */
	public void setSerumTechName(String serumTechName) {
		this.serumTechName = serumTechName;
	}
	
	/**
	 * @return the insulin1
	 */
	@Column(name="INSULIN_1")
	public Double getInsulin1() {
		return insulin1;
	}
	/**
	 * @param insulin1 the insulin1 to set
	 */
	public void setInsulin1(Double insulin1) {
		this.insulin1 = insulin1;
	}
	/**
	 * @return the insulin2
	 */
	@Column(name="INSULIN_2")
	public Double getInsulin2() {
		return insulin2;
	}
	/**
	 * @param insulin2 the insulin2 to set
	 */
	public void setInsulin2(Double insulin2) {
		this.insulin2 = insulin2;
	}
	/**
	 * @return the insulin3
	 */
	@Column(name="INSULIN_3")
	public Double getInsulin3() {
		return insulin3;
	}
	/**
	 * @param insulin3 the insulin3 to set
	 */
	public void setInsulin3(Double insulin3) {
		this.insulin3 = insulin3;
	}
	/**
	 * @return the dateInsulinTested1
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_INSULIN_TESTED_1")
	public Calendar getDateInsulinTested1() {
		return dateInsulinTested1;
	}
	/**
	 * @param dateInsulinTested1 the dateInsulinTested1 to set
	 */
	public void setDateInsulinTested1(Calendar dateInsulinTested1) {
		this.dateInsulinTested1 = dateInsulinTested1;
	}
	/**
	 * @return the dateInsulinTested2
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_INSULIN_TESTED_2")
	public Calendar getDateInsulinTested2() {
		return dateInsulinTested2;
	}
	/**
	 * @param dateInsulinTested2 the dateInsulinTested2 to set
	 */
	public void setDateInsulinTested2(Calendar dateInsulinTested2) {
		this.dateInsulinTested2 = dateInsulinTested2;
	}
	/**
	 * @return the dateInsulinTested
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_INSULIN_TESTED_3")
	public Calendar getDateInsulinTested3() {
		return dateInsulinTested3;
	}
	/**
	 * @param dateInsulinTested3 the dateInsulinTested3 to set
	 */
	public void setDateInsulinTested3(Calendar dateInsulinTested3) {
		this.dateInsulinTested3 = dateInsulinTested3;
	}
	/**
	 * @return the insulinComments
	 */
	@Column(name="INSULIN_COMMENTS")
	public String getInsulinComments() {
		return insulinComments;
	}
	/**
	 * @param insulinComments the insulinComments to set
	 */
	public void setInsulinComments(String insulinComments) {
		this.insulinComments = insulinComments;
	}
	/**
	 * @return the hdl1
	 */
	@Column(name="HDL_1")
	public Double getHdl1() {
		return hdl1;
	}
	/**
	 * @param hdl1 the hdl1 to set
	 */
	public void setHdl1(Double hdl1) {
		this.hdl1 = hdl1;
	}
	/**
	 * @return the hdl2
	 */
	@Column(name="HDL_2")
	public Double getHdl2() {
		return hdl2;
	}
	/**
	 * @param hdl2 the hdl2 to set
	 */
	public void setHdl2(Double hdl2) {
		this.hdl2 = hdl2;
	}
	/**
	 * @return the hdl3
	 */
	@Column(name="HDL_3")
	public Double getHdl3() {
		return hdl3;
	}
	/**
	 * @param hdl3 the hdl3 to set
	 */
	public void setHdl3(Double hdl3) {
		this.hdl3 = hdl3;
	}
	/**
	 * @return the ldl1
	 */
	@Column(name="LDL_1")
	public Double getLdl1() {
		return ldl1;
	}
	/**
	 * @param ldl1 the ldl1 to set
	 */
	public void setLdl1(Double ldl1) {
		this.ldl1 = ldl1;
	}
	/**
	 * @return the ldl2
	 */
	@Column(name="LDL_2")
	public Double getLdl2() {
		return ldl2;
	}
	/**
	 * @param ldl2 the ldl2 to set
	 */
	public void setLdl2(Double ldl2) {
		this.ldl2 = ldl2;
	}
	/**
	 * @return the ldl3
	 */
	@Column(name="LDL_3")
	public Double getLdl3() {
		return ldl3;
	}
	/**
	 * @param ldl3 the ldl3 to set
	 */
	public void setLdl3(Double ldl3) {
		this.ldl3 = ldl3;
	}
	/**
	 * @return the cholesterol1
	 */
	@Column(name="CHOLESTEROL_1")
	public Double getCholesterol1() {
		return cholesterol1;
	}
	/**
	 * @param cholesterol1 the cholesterol1 to set
	 */
	public void setCholesterol1(Double cholesterol1) {
		this.cholesterol1 = cholesterol1;
	}
	/**
	 * @return the cholesterol2
	 */
	@Column(name="CHOLESTEROL_2")
	public Double getCholesterol2() {
		return cholesterol2;
	}
	/**
	 * @param cholesterol2 the cholesterol2 to set
	 */
	public void setCholesterol2(Double cholesterol2) {
		this.cholesterol2 = cholesterol2;
	}
	/**
	 * @return the cholesterol3
	 */
	@Column(name="CHOLESTEROL_3")
	public Double getCholesterol3() {
		return cholesterol3;
	}
	/**
	 * @param cholesterol3 the cholesterol3 to set
	 */
	public void setCholesterol3(Double cholesterol3) {
		this.cholesterol3 = cholesterol3;
	}
	/**
	 * @return the triglycerides1
	 */
	@Column(name="TRIGLYCERIDES_1")
	public Double getTriglycerides1() {
		return triglycerides1;
	}
	/**
	 * @param triglycerides1 the triglycerides1 to set
	 */
	public void setTriglycerides1(Double triglycerides1) {
		this.triglycerides1 = triglycerides1;
	}
	/**
	 * @return the triglycerides2
	 */
	@Column(name="TRIGLYCERIDES_2")
	public Double getTriglycerides2() {
		return triglycerides2;
	}
	/**
	 * @param triglycerides2 the triglycerides2 to set
	 */
	public void setTriglycerides2(Double triglycerides2) {
		this.triglycerides2 = triglycerides2;
	}
	/**
	 * @return the triglycerides3
	 */
	@Column(name="TRIGLYCERIDES_3")
	public Double getTriglycerides3() {
		return triglycerides3;
	}
	/**
	 * @param triglycerides3 the triglycerides3 to set
	 */
	public void setTriglycerides3(Double triglycerides3) {
		this.triglycerides3 = triglycerides3;
	}
	/**
	 * @return the dateLipidsTested
	 */
	@Column(name="DATE_LIPIDS_TESTED_1")
	public Calendar getDateLipidsTested1() {
		return dateLipidsTested1;
	}
	/**
	 * @param dateLipidsTested the dateLipidsTested1 to set
	 */
	public void setDateLipidsTested1(Calendar dateLipidsTested1) {
		this.dateLipidsTested1 = dateLipidsTested1;
	}
	/**
	 * @return the dateLipidsTested
	 */
	@Column(name="DATE_LIPIDS_TESTED_2")
	public Calendar getDateLipidsTested2() {
		return dateLipidsTested2;
	}
	/**
	 * @param dateLipidsTested the dateLipidsTested1 to set
	 */
	public void setDateLipidsTested2(Calendar dateLipidsTested2) {
		this.dateLipidsTested2 = dateLipidsTested2;
	}
	/**
	 * @return the dateLipidsTested
	 */
	@Column(name="DATE_LIPIDS_TESTED_3")
	public Calendar getDateLipidsTested3() {
		return dateLipidsTested3;
	}
	/**
	 * @param dateLipidsTested3 the dateLipidsTested3 to set
	 */
	public void setDateLipidsTested3(Calendar dateLipidsTested3) {
		this.dateLipidsTested3 = dateLipidsTested3;
	}
	/**
	 * @return the lipidsComments
	 */
	@Column(name="LIPIDS_COMMENTS")
	public String getLipidsComments() {
		return lipidsComments;
	}
	/**
	 * @param lipidsComments the lipidsComments to set
	 */
	public void setLipidsComments(String lipidsComments) {
		this.lipidsComments = lipidsComments;
	}
	/**
	 * @return the urineBatch
	 */
	@Column(name="URINE_BATCH")
	public Integer getUrineBatch() {
		return urineBatch;
	}
	/**
	 * @param urineBatch the urineBatch to set
	 */
	public void setUrineBatch(Integer urineBatch) {
		this.urineBatch = urineBatch;
	}
	/**
	 * @return the urineBox
	 */
	@Column(name="URINE_BOX")
	public String getUrineBox() {
		return urineBox;
	}
	/**
	 * @param urineBox the urineBox to set
	 */
	public void setUrineBox(String urineBox) {
		this.urineBox = urineBox;
	}
	/**
	 * @return the dateUrineReceived
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_URINE_RECEIVED")
	public Calendar getDateUrineReceived() {
		return dateUrineReceived;
	}
	/**
	 * @param dateUrineReceived the dateUrineReceived to set
	 */
	public void setDateUrineReceived(Calendar dateUrineReceived) {
		this.dateUrineReceived = dateUrineReceived;
	}
	/**
	 * @return the urineTechName
	 */
	@Column(name="URINE_TECH_NAME")
	public String getUrineTechName() {
		return urineTechName;
	}
	/**
	 * @param urineTechName the urineTechName to set
	 */
	public void setUrineTechName(String urineTechName) {
		this.urineTechName = urineTechName;
	}
	/**
	 * @return the urineCreatinine
	 */
	@Column(name="URINE_CREATININE")
	public Double getUrineCreatinine() {
		return urineCreatinine;
	}
	/**
	 * @param urineCreatinine the urineCreatinine to set
	 */
	public void setUrineCreatinine(Double urineCreatinine) {
		this.urineCreatinine = urineCreatinine;
	}
	/**
	 * @return the urineAlbumin
	 */
	@Column(name="URINE_ALBUMIN")
	public Double getUrineAlbumin() {
		return urineAlbumin;
	}
	/**
	 * @param urineAlbumin the urineAlbumin to set
	 */
	public void setUrineAlbumin(Double urineAlbumin) {
		this.urineAlbumin = urineAlbumin;
	}
	/**
	 * @return the acr
	 */
	@Column(name="ACR")
	public Double getAcr() {
		return acr;
	}
	/**
	 * @param acr the acr to set
	 */
	public void setAcr(Double acr) {
		this.acr = acr;
	}
	/**
	 * @return the urineProtein
	 */
	@Column(name="URINE_PROTEIN")
	public Double getUrineProtein() {
		return urineProtein;
	}
	/**
	 * @param urineProtein the urineProtein to set
	 */
	public void setUrineProtein(Double urineProtein) {
		this.urineProtein = urineProtein;
	}
	/**
	 * @return the dateUrineTested
	 */
	@Column(name="DATE_URINE_TESTED")
	public Calendar getDateUrineTested() {
		return dateUrineTested;
	}
	/**
	 * @param dateUrineTested the dateUrineTested to set
	 */
	public void setDateUrineTested(Calendar dateUrineTested) {
		this.dateUrineTested = dateUrineTested;
	}
	/**
	 * @return the urineComments
	 */
	@Column(name="URINE_COMMENTS")
	public String getUrineComments() {
		return urineComments;
	}
	/**
	 * @param urineComments the urineComments to set
	 */
	public void setUrineComments(String urineComments) {
		this.urineComments = urineComments;
	}
		
	/**
	 * @return the noResults
	 */
	@Column(name="NO_RESULTS")
	public String getNoResults() {
		return noResults;
	}

	/**
	 * @param noResults the noResults to set
	 */
	public void setNoResults(String noResults) {
		this.noResults = noResults;
	}

	/**
	 * @return the isComplete
	 */
	@Column(name="IS_COMPLETE")
	public Boolean getIsComplete() {
		return isComplete;
	}
	/**
	 * @param isComplete the isComplete to set
	 */
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	
}
