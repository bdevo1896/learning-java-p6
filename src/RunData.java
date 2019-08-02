
public class RunData {

	private String title;
	private double distanceInMiles;
	private double time;

	public RunData(String title, double distanceInMiles, double time) {
		super();
		this.title = title;
		this.distanceInMiles = distanceInMiles;
		this.time = time;
	}
	
	public String getTimeAsString(){
		
		int hours = (int)(time)/60;
		String hoursDisplay = ""+hours;
		
		String minutesDisplay = "";
		if(((int)(time)/60)> 0){
			int tempMin = (int)(time - (hours*60));
			
			if(tempMin < 10){
				minutesDisplay = "0"+tempMin;
			}else{
				minutesDisplay = ""+tempMin;
			}
			
		}else{
			if((int)time < 10){
				minutesDisplay = "0"+(int)time;
			}else{
				minutesDisplay = ""+(int)time;
			}
		}
		
		int sec = (int)(60*(time % (int)time));
		
		String secDisplay = "";
		
		if(sec < 10){
			secDisplay = "0"+sec;
		}else{
			secDisplay = ""+sec;
		}
		
		return hoursDisplay+":"+minutesDisplay+":"+secDisplay;
	}
	
	public double getPace(){
		if(distanceInMiles != 0.0){
			return time / distanceInMiles;
		}else{
			return 0.0;
		}
	}
	
	public String getPaceAsString(){
		
		double paceTime = getPace();
		int hours = (int)(paceTime)/60;
		int mins = (int)(paceTime - (hours*60));
		int sec = (int)(60*(paceTime % (int)paceTime));
		
		String minDis ="";
		if(mins < 10){
			minDis = "0"+mins;
		}else{
			minDis = ""+mins;
		}
		
		String secDis ="";
		if(sec < 10){
			secDis = "0"+sec;
		}else{
			secDis = ""+sec;
		}
		
		return hours+":"+minDis+":"+secDis;
	}
	
	public String toString(){
		return title +" Distance: "+distanceInMiles+" Time: "+getTimeAsString()+" Pace: "+getPaceAsString();
	}

	public String getTitle() {
		return title;
	}

	public double getDistanceInMiles() {
		return distanceInMiles;
	}

	public double getTime() {
		return time;
	}

}
