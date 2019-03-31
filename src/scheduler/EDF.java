package scheduler;

import request.Request;

import java.util.ArrayList;
import java.util.Comparator;

public class EDF implements ScheduleAlgorithm {
    private Request findReqWithHighestPriority(ArrayList<Request> requests) {
        return requests
            .stream()
            .max(Comparator.comparing(Request::getPriority))
            .orElse(null);
    }

    @Override
    public Request getNextRequest(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
        return findReqWithHighestPriority(activeRequests);
    }
}
