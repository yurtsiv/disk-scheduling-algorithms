import request.Request;
import request.RequestsGenerator;
import scheduler.*;
import util.RandomNums;
import util.ResultsAnalyzer;

import java.util.ArrayList;

public class Main {
    private static final int
        seriesLength = 10,
        maxDiskLocation = 100,
        maxArrivalTime = 0;


    private static void printRequests(ArrayList<Request> requests) {
        requests.sort((req1, req2) -> req1.getArrivalTime() - req2.getArrivalTime());
        for (Request request : requests) {
            System.out.print(request.getDiskLocation() + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Request> generatedSeries = RequestsGenerator.getSeries(seriesLength, maxDiskLocation, maxArrivalTime);
        printRequests(generatedSeries);

        Scheduler scheduler = new Scheduler();

        int initialHeadPosition = RandomNums.randomInt(0, maxDiskLocation);
        System.out.println("Initial head position: " + initialHeadPosition);

        ArrayList<Integer> fcfsResult = scheduler.run(generatedSeries, initialHeadPosition, new FCFS());
        ArrayList<Integer> sstfResult = scheduler.run(generatedSeries, initialHeadPosition, new SSTF());
        ArrayList<Integer> scanResult = scheduler.run(generatedSeries, initialHeadPosition, new SCAN());
        ArrayList<Integer> cscanResult = scheduler.run(generatedSeries, initialHeadPosition, new CSCAN());

        System.out.println("FCFS result:");
        ResultsAnalyzer.analyzeAndPrint(fcfsResult);

        System.out.println("SSTF result:");
        ResultsAnalyzer.analyzeAndPrint(sstfResult);

        System.out.println("SCAN result:");
        ResultsAnalyzer.analyzeAndPrint(scanResult);

        System.out.println("C-SCAN result:");
        ResultsAnalyzer.analyzeAndPrint(cscanResult);
    }
}
