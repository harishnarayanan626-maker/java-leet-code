import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // id -> {stationName, checkInTime}
    private Map<Integer, CheckIn> checkInMap;

    // "start->end" -> {totalTime, tripCount}
    private Map<String, Trip> tripMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        tripMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String route = checkIn.station + "->" + stationName;

        Trip trip = tripMap.getOrDefault(route, new Trip());

        trip.totalTime += (t - checkIn.time);
        trip.count++;

        tripMap.put(route, trip);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        Trip trip = tripMap.get(route);

        return (double) trip.totalTime / trip.count;
    }

    // Helper class for check-in information
    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route statistics
    static class Trip {
        int totalTime;
        int count;

        Trip() {
            totalTime = 0;
            count = 0;
        }
    }
}
