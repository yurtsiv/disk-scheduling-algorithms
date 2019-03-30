package scheduler;

import request.Request;

import java.util.ArrayList;

public class FCFS implements ScheduleAlgorithm {
    public void serve(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
        Request currentRequest = activeRequests.get(0);
        headPath.add(currentRequest.getDiskLocation());
        activeRequests.remove(0);
    }
}
