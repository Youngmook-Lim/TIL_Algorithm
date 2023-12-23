import java.util.*;

class Solution {
    
    int basicTime;
    int basicFee;
    int unitTime;
    int unitFee;
    Map<Integer, Car> map;
    
    class Car {
        int id;
        String curTime;
        int totalTime = 0;
        
        Car(int id, String curTime) {
            this.id = id;
            this.curTime = curTime;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
        map = new TreeMap<>();
        
        for (String x : records) {
            String[] tmp = x.split(" ");
            String time = tmp[0];
            int id = Integer.parseInt(tmp[1]);
            String type = tmp[2];
            
            if (!map.containsKey(id)) {
                map.put(id, new Car(id, time));
            } else {
                Car car = map.get(id);
                if (car.curTime == null) {
                    car.curTime = time;
                } else {
                    addTime(car, time);
                }
            }
        }
        
        for (int id : map.keySet()) {
            Car car = map.get(id);
            if (car.curTime != null) {
                addTime(car, "23:59");
            }
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        for (int id: map.keySet()) {
            answer[idx++] = calcFee(map.get(id));
        }
        
        return answer;
    }
    
    int calcFee(Car car) {
        int totalTime = car.totalTime;
        
        if (totalTime < basicTime) {
            return basicFee;
        }
        
        int additionalTime = (totalTime - basicTime) / unitTime;
        if ((totalTime - basicTime) % unitTime != 0) {
            additionalTime++;
        }
        
        return basicFee + additionalTime * unitFee;
    }
    
    void addTime(Car car, String time) {
        int enterHour = Integer.parseInt(car.curTime.split(":")[0]);
        int enterMin = Integer.parseInt(car.curTime.split(":")[1]);
        int leaveHour = Integer.parseInt(time.split(":")[0]);
        int leaveMin = Integer.parseInt(time.split(":")[1]);
        
        int diffMin = (leaveHour * 60 + leaveMin) - (enterHour * 60 + enterMin);
        
        car.totalTime += diffMin;
        car.curTime = null;
    }
}