// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAccess {
  
  public static Workouts loadWorkouts() {
    // What is a try/catch block and why do we need one?
    // What is an exception?
	  Workouts workouts = new Workouts();
	  try {
		  File file = new File(Config.WORKOUTFILE);
		  Scanner scanner = new Scanner(file);
		  scanner.useDelimiter(",");
		  while(scanner.hasNext()) {
			  workouts.addWorkout(
					  scanner.next(),									// Name
					  Workouts.Equipment.valueOf(scanner.next()),		// Equipment
					  Workouts.Muscle.valueOf(scanner.next()),			// Primary Muscles
					  Workouts.Muscle.valueOf(scanner.next()),			// Secondary Muscles
					  scanner.next(),									// Description
					  scanner.next()									// Reminder
					  );
		  }
		  scanner.close();
	  }
	  catch(FileNotFoundException e) {
		  System.out.println("ERROR: " + e);
	  }
	  return workouts;
  }

}
