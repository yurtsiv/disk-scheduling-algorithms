package scheduler;

import request.Request;
import util.Requests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CSCAN implements ScheduleAlgorithm {
    private Request getSmallestDiskLocationReq(ArrayList<Request> requests) {
        return requests
            .stream()
            .min(Comparator.comparing(Request::getDiskLocation))
            .orElseThrow(NoSuchElementException::new);
    }

    private Request findNearestToTheRight(ArrayList<Request> activeRequests, int headPosition) {
        ArrayList<Request> nearestCandidates =
            activeRequests
                .stream()
                .filter(request -> request.getDiskLocation() >= headPosition)
                .collect(Collectors.toCollection(ArrayList::new));

        if (nearestCandidates.size() == 0) {
            return getSmallestDiskLocationReq(activeRequests);
        }

        return Requests.findNearestToHead(nearestCandidates, headPosition);
    }

    public Request getNextRequest(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
        return findNearestToTheRight(activeRequests, currentHeadPosition);
    }
}
