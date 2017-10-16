package smartFuRS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalculationUtility {
	
	public static int daysBetween(Calendar day1, Calendar day2){
	    Calendar dayOne = (Calendar) day1.clone(),
	            dayTwo = (Calendar) day2.clone();

	    if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
	        return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
	    } else {
	        if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
	            //swap them
	            Calendar temp = dayOne;
	            dayOne = dayTwo;
	            dayTwo = temp;
	        }
	        int extraDays = 0;
	        int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);

	        while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
	            dayOne.add(Calendar.YEAR, -1);
	            // getActualMaximum() important for leap years
	            extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
	        }

	        return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays ;
	    }
	}
	
	public static boolean isDateFormattedCorrect(String datetext) {	
		try {
			Calendar day = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
			day.setTime(sdf.parse(datetext));	
			if(day.get(1)>2017) {
				return false;
			}
			if(day.get(1)<1980) {
				return false;
			}
			
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public static boolean isReceivedDateValidForCamp(String recDateTxt, String campDateTxt) {
		try {
			Calendar revday = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
			revday.setTime(sdf.parse(recDateTxt));	
			
			Calendar cmpday = Calendar.getInstance();
			cmpday.setTime(sdf.parse(campDateTxt));	
			
			int day = cmpday.get(5);
			int month = cmpday.get(12);
			
			int r_day = revday.get(5);
			int r_month = revday.get(12);
			
			if(r_month<month-3 ||r_month>month-1) {
				return false;
			}
			if(r_month==month-3 && r_day<day) {
				return false;
			}
			if(r_month==month-1 && r_day>day) {
				return false;
			}
			//otherwist return true
			return true;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public static ArrayList<Camper> getCampersByGender(String gender, ArrayList<Camper> campers){
		ArrayList<Camper> outputList = new ArrayList<Camper>();
		for(Camper c: campers) {
			if(c.getGender().equals(gender)) {
				outputList.add(c);
			}
		}
		return outputList;
		
	}
	
	public static ArrayList<Camper> getCampersByCategory(String cat, ArrayList<Camper> campers){
		ArrayList<Camper> outputList = new ArrayList<Camper>();
		for(Camper c: campers) {
			if(c.getCategory().equals(cat)) {
				outputList.add(c);
			}
		}
		return outputList;
		
	}
	
	public static int getDormFewestGroup(ArrayList<Camper> campers) {
		
		int g1=0;
		int g2=0;
		int g3=0;
		
		for(Camper c: campers) {
			if(c.getDormNum()==1) {
				g1++;
			} else if(c.getDormNum()==2) {
				g2++;
			} else if(c.getDormNum()==3) {
				g3++;
			}
		}
		
		if(g2<g1) {
			return 2;
		}
		if(g3<g2) {
			return 3;
		}		
		return 1;

	}
		
	
	
}
