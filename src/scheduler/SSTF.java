package scheduler;

import request.Request;
import util.Requests;

import java.util.ArrayList;

public class SSTF implements ScheduleAlgorithm {
   public void serve(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
      Request currentRequest = Requests.findNearestToHead(activeRequests, currentHeadPosition);
      headPath.add(currentRequest.getDiskLocation());
      activeRequests.remove(currentRequest);
   }
}
