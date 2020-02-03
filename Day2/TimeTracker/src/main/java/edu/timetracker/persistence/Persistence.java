package edu.timetracker.persistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import edu.timetracker.model.TimeInfo;
import edu.timetracker.model.User;

public class Persistence {
	
	public static Map<UUID, TimeInfo> timeRecord = new HashMap<>();
	
	public static Set<User> users = new HashSet<>();
}
