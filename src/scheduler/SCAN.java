package scheduler;

import request.Request;
import util.Requests;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SCAN implements ScheduleAlgorithm {
    private int headMoveDirection = 1;

    private Request findNearestInMoveDirection(ArrayList<Request> activeRequests, int headPosition) {
       ArrayList<Request> nearestCandidates =
            activeRequests
               .stream()
               .filter(request -> {
                   if (headMoveDirection == 1) {
                       return request.getDiskLocation() >= headPosition;
                   } else {
                       return request.getDiskLocation() <= headPosition;
                   }
               })
               .collect(Collectors.toCollection(ArrayList::new));

       if (nearestCandidates.size() == 0) {
          headMoveDirection = -headMoveDirection;
          return findNearestInMoveDirection(activeRequests, headPosition);
       }

       return Requests.findNearestToHead(nearestCandidates, headPosition);
    }

    public Request getNextRequest(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
        return findNearestInMoveDirection(activeRequests, currentHeadPosition);
    }
}
