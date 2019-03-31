package scheduler;

import request.Request;
import util.Requests;

import java.util.ArrayList;

public class SSTF implements ScheduleAlgorithm {
   public Request getNextRequest(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
      return Requests.findNearestToHead(activeRequests, currentHeadPosition);
   }
}
