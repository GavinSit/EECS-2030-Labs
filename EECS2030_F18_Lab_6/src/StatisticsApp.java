import java.util.List;

/**
 * A weather statistics app calculates the minimum, maximum, and average
 * temperature read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	/**
	 * Update the reading of this weather observer. Update the current temperature
	 * and the maximum, minimum, and average accordingly.
	 */
	List<Double> temperatures;
	// double maxTem, minTemp, avgTemp;
	double maxTemp = 0, minTemp = 0, avgTemp = 0;

	WeatherStation ws;

	public void update() {
		/* Your Task */
		temperatures = ws.temperature;
		maxTemp = this.getMaxTemperature();
		minTemp = this.getMinTemperature();
		avgTemp = this.getAverageTemperature();
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return this.ws;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */
		this.ws = ws;
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * 
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		if (temperatures.size() != 0) {
			double min = temperatures.get(0);
			for (int i = 1; i < temperatures.size(); i++) {
				if (temperatures.get(i) < min) {
					min = temperatures.get(i);
				}
			}
			return min;
		} else {
			return 0;
		}
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * 
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		if (temperatures.size() != 0) {
			double max = temperatures.get(0);
			for (int i = 1; i < temperatures.size(); i++) {
				if (temperatures.get(i) > max) {
					max = temperatures.get(i);
				}
			}
			return max;
		} else {
			return 0;
		}
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * 
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		double avg = temperatures.get(0);
		for (int i = 1; i < temperatures.size(); i++) {
			avg += temperatures.get(i);
		}

		return avg / temperatures.size();
	}
}
