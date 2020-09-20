import edu.princeton.cs.algs4.StdOut;

// An immutable type representing a location on Earth.
public class Location {
    private final String loc; // location name
    private final double lat; // latitude
    private final double lon; // longitude

    // Construct a new location given its name, latitude, and longitude values.
    public Location(String loc, double lat, double lon) {
        this.loc = loc;
        this.lat = lat;
        this.lon = lon;
    }

    // The great-circle distance between this location and that.
    public double distanceTo(Location that) {
        double x1 = Math.toRadians(this.lat);
        double y1 = Math.toRadians(this.lon);
        double x2 = Math.toRadians(that.lat);
        double y2 = Math.toRadians(that.lon);

        double d = 111 * Math.toDegrees(Math.acos(Math.sin(x1)
                * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) 
                * Math.cos(y1 - y2)));

        return d;
    }

    // Is this location the same as that?
    public boolean equals(Location that) {
         if ((this.lat == that.lat) 
            && (this.lon == that.lon)) {
            return true;
        }
        return false;
    }

    // A string representation of the location, in "loc (lat, lon)" format.
    public String toString() {
        return loc + " (" + lat + ", " + lon + ")";
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int rank = Integer.parseInt(args[0]);
        double lat = Double.parseDouble(args[1]);
        double lon = Double.parseDouble(args[2]);        
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 
                                  40.6769, 117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)", 
                                  22.9519, -43.2106);
        for (Location wonder : wonders) {
            StdOut.println(wonder);
        }
        StdOut.println(wonders[rank].distanceTo(new Location("", lat, lon)));
        StdOut.println(wonders[rank].equals(new Location("", lat, lon)));
    }
}