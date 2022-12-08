package com.ab.greedy;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * There is one meeting room in a firm.
 * There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of meeting i and F[i] is finish time of meeting i.
 * The task is to find the maximum number of meetings that can be accommodated in the meeting room.
 *
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 */
public class ActivityOrMeetingSelection {
    public static void main(String[] args) {
        int[] startingTime = { 1, 3, 0, 5, 8, 5 };
        int[] finishingTime = { 2, 4, 6, 7, 9, 9 };
        List<Meeting> meetings = meetingSelection(startingTime,finishingTime);
        System.out.println("Max list of meetings accommodate in single room in a day");
        for (Meeting m: meetings) {
            System.out.println(m);
        }
    }

    private static List<Meeting> meetingSelection(int[] startingTime, int[] finishingTime) {
        List<Meeting> result = new ArrayList<>();
        List<Meeting> meetings = new ArrayList<>();
        int totalMeetings = startingTime.length;
        for (int i = 0; i < totalMeetings; i++) {
            Meeting meeting = new Meeting("M" + i, startingTime[i],finishingTime[i]);
            meetings.add(meeting);
        }
        meetings.sort(Comparator.comparing(m -> m.finishTime));
        result.add(meetings.get(0));
        Meeting prevMeeting = meetings.get(0);
        for (int i = 0; i < meetings.size(); i++) {
            Meeting currMeeting = meetings.get(i);
            if(currMeeting.startTime > prevMeeting.finishTime){
                result.add(currMeeting);
                prevMeeting = currMeeting;
            };
        }
        return result;
    }

    private static class Meeting {
        String name;
        int startTime;
        int finishTime;

        public Meeting(String name, int startTime, int finishTime) {
            this.name = name;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return "Meeting{" + name + ", startTime=" + startTime + ", finishTime=" + finishTime + '}';
        }
    }
}
