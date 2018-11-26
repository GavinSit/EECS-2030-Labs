
/**
 * A weather forecast app determines if the pressure readings from its
 * subscribed weather station, if any, indicate it is likely to rain due to a
 * reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {
	WeatherStation ws;
	private double currentPressure = 0;
	private double previousPressure = 0;

	/**
	 * Update the reading of this weather observer. Update the current and last
	 * readings of pressure.
	 */
	public void update() {
		/* Your Task */
		this.currentPressure = ws.pressure.get(ws.pressure.size() - 1);
		if (ws.pressure.size() > 1) {
			this.previousPressure = ws.pressure.get(ws.pressure.size() - 2);
		} else {
			this.previousPressure = this.currentPressure;
		}
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
	 * Get the pressure level read from the last update.
	 * 
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		/* Your Task */
		return this.currentPressure;
	}

	/**
	 * Get the pressure level read from the second last update.
	 * 
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		/* Your Task */
		return this.previousPressure;
	}

	/**
	 * Based on the last and second last readings of the pressure level, it is
	 * determined as likely to rain if there is a reduction on the pressure level;
	 * otherwise it is unlikely to rain.
	 * 
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		/* Your Task */
		if (currentPressure < previousPressure) {
			return true;
		}
		return false;
	}
}