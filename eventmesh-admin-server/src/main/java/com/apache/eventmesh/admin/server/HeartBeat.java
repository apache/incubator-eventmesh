package com.apache.eventmesh.admin.server;

import com.apache.eventmesh.admin.server.task.JobState;
import com.apache.eventmesh.admin.server.task.Position;

public class HeartBeat {
    private String address;
    private String reportedTimeStamp;
    private String jobID;
    private Position position;
    private JobState state;
}
