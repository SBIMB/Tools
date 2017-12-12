/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.wits.sbimb.awigen.biomarker.model.entity.Biomarker;
import za.ac.wits.sbimb.awigen.biomarker.service.IBiomarkerService;
import za.ac.wits.sbimb.awigen.biomarker.service.impl.BiomarkerServiceImpl;

/**
 * @author Freedom Mukomana
 *
 */
public final class Util {
	
	@Autowired
	IBiomarkerService biomarkerService = new BiomarkerServiceImpl();
	List<Biomarker> biomarkers = new ArrayList<Biomarker>();
	
	String results = null;
	final static String DATE_FORMAT_1 = "yyyy-mm-dd";	
	final static String DATE_FORMAT_2 = "dd/mm/yyyy";	
	
	static SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT_1);
	static SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_FORMAT_2);
	
	public void getData(){
		REDCapImport redCapImport = new REDCapImport();
		
		results = redCapImport.doPost();
	}
	
	public void createBiomarkerObjects(){
		
		List<String> biomarkerStrs = Arrays.asList(results.split(";"));		
		for(String biomarkerStr : biomarkerStrs){	
			if(biomarkerStr.contains("awigen_id")){
				
			}else{
				Biomarker biomarker = new Biomarker(biomarkerStr);
				biomarkers.add(biomarker);				
			}				
		}
	}
	
	public void saveBiomarkers(){
		/*biomarkerService.createTable(null, null);
		for(Biomarker biomarker : biomarkers){
			biomarkerService.save(biomarker);
		}*/
		biomarkerService.updateTables();
	}
	
	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT_1);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	
	public void statistics(){
		//Rengine re = new Rengine();
		
		//re.eval("library(Amelia)");
		//re.eval(String.format("greeting <- data.frame(x1=%s,x2=%s)", x1, x2));
		//REXP result = re.eval("predict(model, newData)");
		//REXP mydf = REXP.createDataFrame(new RList(new REXP[]{
				
		//}))
		String[] rows = results.split(";");
		String[] row;
		String[][] matrix = new String[rows[0].length()][rows.length];
		for(int i=0;i<rows.length-1;i++){
			row = rows[i].split(",");
			System.out.println(rows[i].toString());
			for(int j=0;j<row.length-1;j++){
				System.out.println(i+" "+j+" "+row[j]);
				if(i!=636)
				matrix[i][j]="ttt";//row[j].toString();
				System.out.println(matrix);
			}
			
		}
		
		
		/*REXP mydf = REXP
                .createDataFrame(new RList(
                        new REXP[] {
                                new REXPString(rows[0]),
                                new REXPString(),
                                new REXPInteger(col3)},
                        colNames));

    eng.assign("myDataFrame", mydf);*/
	}
	public static Calendar parseStringToDate(String dateStr){
		Calendar dateTmp = Calendar.getInstance();
		try {
			if(dateStr.contains("-"))
				dateTmp.setTime(sdf1.parse(dateStr));
			
			if(dateStr.contains("/"))
				dateTmp.setTime(sdf2.parse(dateStr));
				
		} catch (ParseException e) {
			try {
				dateTmp.setTime(sdf1.parse("1900-01-01"));
			} catch (ParseException e1) {
				
			}
		}
		
		return dateTmp;		
	}
}
