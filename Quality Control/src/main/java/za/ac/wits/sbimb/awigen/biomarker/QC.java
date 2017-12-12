/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker;

import za.ac.wits.sbimb.awigen.biomarker.util.Util;

/**
 * @author Freedom Mukomana
 *
 */
public class QC {
	
	//public final static SessionFactory;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		QC qc = new QC();
		qc.startQC();

	}
	
	void startQC(){
		Util util = new Util();
		util.getData();
		util.createBiomarkerObjects();
		util.saveBiomarkers();
		
		//util.statistics();
	}

}
