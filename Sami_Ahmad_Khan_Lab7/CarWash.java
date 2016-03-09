package Lab7;

import java.util.LinkedList;
import java.util.Queue;

public class CarWash {
	
	public final static String OVERFLOW = " (Overflow)\n";
	protected final String HEADING ="\n\nTime\tEvent\t\tWaiting Time\n";
	protected static final int INFINITY = 10000; // indicates no car being washed
	protected static final int MAX_SIZE = 5; // maximum cars allowed in carQueue
	protected int WASH_TIME; // minutes to wash one car
	protected Queue<Car> carQueue;
	protected LinkedList<String> results; // the sequence of events in the simulation
	protected int currentTime,nextDepartureTime, // when car being washed will finish
	numberOfCars,
	waitingTime,overFlowCount;
	protected float sumOfWaitingTimes;
	
	//added constructor
	
	public CarWash()
	{
	carQueue = new LinkedList<Car>(); 
	results = new LinkedList<String>(); 
	results.add (HEADING);
	currentTime = 0;
	numberOfCars = 0;
	waitingTime = 0; 
	sumOfWaitingTimes = 0; 
	nextDepartureTime = INFINITY; // no car being washed
	} // constructor
	
	/**
	 * Finish Up Method
	 * @return
	 */
	public LinkedList<String> finishUp()
	{
	while (nextDepartureTime < INFINITY) // while there are unwashed cars
	processDeparture();
	return results;
	} // finishUp
	
	/**
	 * 
	 * @param nextArrivalTimew
	 * @return
	 */
	public LinkedList<String> process (int nextArrivalTime) {
		
		final String BAD_TIME = "The time of the next arrival cannot be less than the current time.";
		
		if (nextArrivalTime < currentTime)
			throw new IllegalArgumentException (BAD_TIME);
		
		while (nextArrivalTime >= nextDepartureTime) 
			processDeparture();
		
		return processArrival (nextArrivalTime); } // process
	
	
	/**
	* Updates the simulation to reflect the fact that a car has finished getting washed. *
	*/
	protected LinkedList<String> processDeparture() {
		final String DEPARTURE = "\tDeparture\t\t";
		int arrivalTime;
		currentTime = nextDepartureTime;
		if(nextDepartureTime != 0)
			results.add (Integer.toString (currentTime) + DEPARTURE +
				Integer.toString (waitingTime) + "\n");
		if (!carQueue.isEmpty())
		{
			Car car = carQueue.remove();
			arrivalTime = car.getArrivalTime();
			waitingTime = currentTime - arrivalTime;
			sumOfWaitingTimes += waitingTime;
			nextDepartureTime = currentTime + WASH_TIME;
		} // carQueue was not empty
		else
		{
			waitingTime = 0;
			nextDepartureTime = INFINITY; // no car is being washed
		} // carQueue was empty
		return results;
	} // method processDeparture
	
	
	/**
	* Moves the just arrived car into the car wash (if there is room on the car queue),
	* 
	* or turns the car away (if there is no room on the car queue). *
	* 
	* @param nextArrivalTime – the arrival time of the just-arrived car. *
	*/
	protected LinkedList<String> processArrival (int nextArrivalTime) {
		
		final String ARRIVAL = "\tArrival"; 
		currentTime = nextArrivalTime;
		results.add (Integer.toString (currentTime) + ARRIVAL); 
		if (carQueue.size() == MAX_SIZE)
		results.add (OVERFLOW);
		
		else {
			numberOfCars++;
			if (nextDepartureTime == INFINITY) // if no car is being washed
				nextDepartureTime = currentTime + WASH_TIME;
			else
				carQueue.add (new Car (nextArrivalTime)); 
			results.add ("\n");
		} // not an overflow
		return results;
	} // method processArrivalocessArrival
	
	/**
	* Returns the history of this CarWash objectís arrivals and departures, and the
	* average waiting time.
	*
	* @return the history of the simulation, including the average waiting time.
	*
	*/
	public LinkedList<String> getResults(){
	final String NO_CARS_MESSAGE = "There were no cars in the car wash.\n";
	
			if (numberOfCars == 0)
			results.add (NO_CARS_MESSAGE);
			else {
			results.add ("\n\nThe average waiting time was " + Math.round((sumOfWaitingTimes / numberOfCars) * 10)/10.0 + " minutes per car.\n");
			
			results.add ("\nThe average queue length was " + Math.round((sumOfWaitingTimes / currentTime) * 10)/10.0 + " cars per minute.\n");
			
			results.add ("\nThe number of overflow was " + overFlowCount);
			}
			
			return results;
	} // method getResults	
}
