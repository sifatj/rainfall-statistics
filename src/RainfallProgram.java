import java.io.*;

public class RainfallProgram {
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		RainfallStats stats = new RainfallStats();
		System.out.println("Enter rainfall measurements (in mm), or \"end\" to stop.");
		
		while(true) {
			System.out.print("> ");
			String line = keyboard.readLine();
			if("end".equals(line)) {
				break;
			}  
			
			// parse the measurement and add it to stats
			try {
				double measurement = Double.parseDouble(line);
				stats.addMeasurement(measurement);
			} catch(InvalidRainfallException ex) {
				// print a message if the measurement is negative
				System.out.println("Measurement is negative");
			} catch(NumberFormatException ex) {
				// print a message if the measurement cannot be parsed	
				System.out.println("Measurement cannot be parsed");
			}
			
		}

		System.out.println(stats.getCount() + " measurement(s) entered.");
		
		// prevent the exception when no measurements have been entered.
		if(stats.getCount() > 0) {
			System.out.println("Mean rainfall: " + stats.getMean() + " mm");
			System.out.println("Maximum rainfall: " + stats.getMax() + " mm");
		}
	}
}
