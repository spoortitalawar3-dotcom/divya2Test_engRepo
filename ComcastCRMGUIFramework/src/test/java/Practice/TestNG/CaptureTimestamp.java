package Practice.TestNG;

import java.util.Date;

public class CaptureTimestamp {

	public static void main(String[] args) {
		//String Date=new Date().toString();//Mon Jan 05 11:24:22 IST 2026
		String time=new Date().toString().replace(" ","_").replace(":","_");//USING JAVA REPLACE METHOD replace space and : with _ 
		System.out.println(time);//Mon_Jan_05_11_30_23_IST_2026
		//TO TREMOVE SPACE AND COLON BCZ I WNT TO GIVE THIS AS FILE NAME ALONG TESTNAME,SO FILE SHOLUD NOT HAVE SPACES.
		

	}

}
//