import java.util.ArrayList;
import java.util.List;

public class RainfallStats {
	private final List<Double> mList = new ArrayList<>();

	public void addMeasurement(double measurement) throws InvalidRainfallException {
		if(measurement < 0) {
			throw new InvalidRainfallException();
		}
		mList.add(measurement);
		
	}

	public int getCount() {
		return mList.size();
	}

	public double getMean() throws IllegalStateException {
		if(mList.size() == 0) {
			throw new IllegalStateException();
		}
		double total = 0;
		for(double x: mList) {
			total+=x;
		}
		
		return total/mList.size();
	}

	public double getMax() throws IllegalStateException{
		if(mList.size() == 0) {
			throw new IllegalStateException();
		}
		double max = 0;
		for(double x: mList) {
			if(x > max) {
				max = x;
			}
		}
		return max;
	}
	


}
