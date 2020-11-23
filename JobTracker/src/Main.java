import java.time.LocalDateTime;

/**
 * Simple demo program to show the JobProgressTracker in action
 * @author K. Welsh
 *
 */

public class Main {
	public static void main(String[] args) {
		JobProgressTracker tracker = new JobProgressTracker("cakes.db");
		
		//uncomment this to empty the file if its getting clumsy
		//you could just delete cakes.db, if you prefer
		tracker.clear();
		
		JobProgressInfo progress = new JobProgressInfo(1234,"Baking",JobProgressInfo.PROGRESS_STARTED,LocalDateTime.now().minusMinutes(30));
		JobProgressInfo progress2 = new JobProgressInfo(1234,"Baking",JobProgressInfo.PROGRESS_FINISHED,LocalDateTime.now().minusMinutes(5));
		JobProgressInfo progress3 = new JobProgressInfo(2345,"Baking",JobProgressInfo.PROGRESS_STARTED,LocalDateTime.now());
		JobProgressInfo progress4 = new JobProgressInfo(1234,"Icing",JobProgressInfo.PROGRESS_STARTED,LocalDateTime.now());
		JobProgressInfo progress5 = new JobProgressInfo(1234,"Icing",JobProgressInfo.PROGRESS_FINISHED,LocalDateTime.now());
		
		tracker.processProgressUpdate(progress);
		tracker.processProgressUpdate(progress2);
		tracker.processProgressUpdate(progress3);
		tracker.processProgressUpdate(progress4);
		tracker.processProgressUpdate(progress5);
		
		
		JobProgressInfo[] info = tracker.getJobProgress(1234);
		
		for(int i=0;i<info.length;i++) {
			String status = " finished ";
			if ( info[i].getProgressType() == JobProgressInfo.PROGRESS_STARTED ) {
				status = " started ";
			}
			System.out.println("Job "+ info[i].getJobID() + status + info[i].getProcessTitle() + " at "  + info[i].getTimestamp());			
		}
		
		
		JobProgressInfo[] infoProcess = tracker.getProgressByProcess("Icing");
			for(int i=0;i<infoProcess.length;i++) {
				String status = " finished ";
					if(infoProcess[i].getProgressType() == JobProgressInfo.PROGRESS_STARTED) {
						status = " started ";
					}
				System.out.println("Job "+ infoProcess[i].getJobID() + status + infoProcess[i].getProcessTitle() + " at "  + infoProcess[i].getTimestamp());			
		}
			
			
		JobProgressInfo[] infoProgressFinished = tracker.getDespatchedJobsInfo();
			for(int i=0;i<infoProgressFinished.length;i++) {
				String status = " finished ";
					if(infoProgressFinished[i].getProgressType() == JobProgressInfo.PROGRESS_FINISHED) {
						System.out.println("Job "+ infoProgressFinished[i].getJobID() + status + infoProgressFinished[i].getProcessTitle() + " at "  + infoProgressFinished[i].getTimestamp());
					}
							
		}
		tracker.close();
	}	
	}
