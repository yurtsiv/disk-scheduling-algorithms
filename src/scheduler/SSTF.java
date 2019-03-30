package scheduler;

import request.Request;

import java.util.ArrayList;

public class SSTF implements ScheduleAlgorithm {
   private Request findNearest(ArrayList<Request> activeRequests, int headPosition) {
      Request nearestRequest = activeRequests.get(0);
      int minDistance = Math.abs(headPosition - nearestRequest.getDiskLocation());
      for (Request request : activeRequests) {
         int nextDist = Math.abs(headPosition - request.getDiskLocation());

         if (nextDist < minDistance) {
            nearestRequest = request;
            minDistance = nextDist;
         }
      }

      return nearestRequest;
   }

   public void serve(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
      Request currentRequest = findNearest(activeRequests, currentHeadPosition);
      headPath.add(currentRequest.getDiskLocation());
      activeRequests.remove(currentRequest);
   }
}
