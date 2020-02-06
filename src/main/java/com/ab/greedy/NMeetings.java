package com.ab.greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arpit Bhardwaj
 */
public class NMeetings {
    public static void main(String[] args) {
        int[] startingTime = { 1, 3, 0, 5, 8, 5 };
        int[] finishingTime = { 2, 4, 6, 7, 9, 9 };
        /*int[] startingTime = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] finishingTime = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};*/
        List<Integer> meetingsList = getMeetingNumbers(startingTime,finishingTime);
        System.out.println("Max list of meetings accommodate in single room : " + meetingsList);
    }

    private static List<Integer> getMeetingNumbers(int[] startingTime, int[] finishingTime) {

        List<Integer> resultList = new ArrayList<>();
        List<Meeting> meetingsList = new ArrayList<>();
        int totalMeetings = startingTime.length;
        //sort pairs based on finishing time
        for (int i = 0; i < totalMeetings; i++) {
            Meeting meeting = new Meeting(startingTime[i],finishingTime[i],i+1);
            meetingsList.add(meeting);
        }
        /*Collections.sort(meetingsList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.finishingTime > m2.finishingTime){
                    return 1;
                };
                if (m1.finishingTime < m2.finishingTime){
                    return -1;
                };
                return 0;
            }
        });*/
        //using java 8 syntax
        Collections.sort(meetingsList, Comparator.comparing((Meeting meeting) -> meeting.finishingTime));

        /*List<Meeting> sortedList = meetingsList.stream()
                .sorted(Comparator.comparing((Meeting meeting) -> meeting.finishingTime))
                .collect(Collectors.toList());*/

        //add first meeting position in results
        resultList.add(meetingsList.get(0).position);

        for (int i = 0; i < meetingsList.size(); i++) {
            int size = resultList.size();
            Meeting currentMeeting = meetingsList.get(i);
            //get the previously selected meeting finishing time and compare with current meeting starting time
            if(currentMeeting.startingTime > meetingsList.get(resultList.get(size - 1) - 1).finishingTime){
                resultList.add(currentMeeting.position);
            };
        }


        return resultList;
    }

    private static class Meeting {
        int startingTime;
        int finishingTime;
        int position;

        public Meeting(int startingTime, int finishingTime, int position) {
            this.startingTime = startingTime;
            this.finishingTime = finishingTime;
            this.position = position;
        }
    }
}
