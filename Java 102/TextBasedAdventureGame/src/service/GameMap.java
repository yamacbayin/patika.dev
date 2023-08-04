package service;

import model.zone.Zone;
import model.zone.battlezone.BattleZone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameMap {
    private Map<String, Zone> zones;
    private Map<String, Set<Zone>> connections;

    public GameMap() {
        zones = new HashMap<>();
        connections = new HashMap<>();
    }

    public void addZone(Zone zone) {
        zones.put(zone.getName(), zone);
        connections.put(zone.getName(), new HashSet<>());
    }

    public Zone getZone(String zoneName) {
        return zones.get(zoneName);
    }

    public void addConnection(String zoneName1, String zoneName2) {
        Zone zone1 = zones.get(zoneName1);
        Zone zone2 = zones.get(zoneName2);
        if (zone1 != null && zone2 != null) {
            connections.get(zoneName1).add(zone2);
            connections.get(zoneName2).add(zone1);
        }
    }

    public void removeConnection(String zoneName1, String zoneName2) {
        Zone zone1 = zones.get(zoneName1);
        Zone zone2 = zones.get(zoneName2);
        if (zone1 != null && zone2 != null) {
            connections.get(zoneName1).remove(zone2);
            connections.get(zoneName2).remove(zone1);
        }
    }

    public boolean areConnected(Zone zoneName1, Zone zoneName2) {
        return connections.getOrDefault(zoneName1.getName(), new HashSet<>()).contains(zoneName2);
    }

    public Set<Zone> getConnections(String zoneName) {
        return connections.getOrDefault(zoneName, new HashSet<>());
    }

    public void test() {
        for (Zone zone : zones.values()) {
            if (zone instanceof BattleZone) {
                System.out.println(((BattleZone) zone));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Zone zone : zones.values()) {
            sb.append(zone.getName()).append(": ").append(zone.getDescription()).append("\n");
            sb.append("Connected Zones: ");
            Set<Zone> connectedZones = connections.get(zone.getName());
            if (connectedZones != null) {
                for (Zone connectedZone : connectedZones) {
                    sb.append(connectedZone.getName()).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length()); // Remove the last comma and space
            }
            sb.append("\n\n");
        }
        return sb.toString();
    }
}