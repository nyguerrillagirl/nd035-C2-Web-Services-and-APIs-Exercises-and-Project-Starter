package com.udacity.boogle.maps;

// Reference: https://www.techiedelight.com/implement-map-with-multiple-keys-multikeymap-java/

public class LatLonKey {
	
	public Double lat;
	public Double lon;
	
	public LatLonKey(Double lat, Double lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
	@Override
	public boolean equals(Object o) {
		// Is this the same object instance?
		if (this == o) return true;
		
		// Are they even the same object type?
		if (o == null || getClass() != o.getClass()) return false;
		
		// Make the object o provided - concrete
		LatLonKey latlonKey = (LatLonKey) o;
		
		// Check the lat member 
		if (lat != null ? !lat.equals(latlonKey.lat) : latlonKey.lat != null) {
			return false;
		}
		
		// Check the lon member 
		if (lon != null ? !lon.equals(latlonKey.lon) : latlonKey.lon != null) {
			return false;
		}
		// This must be the same (lat,lon)
		return true;
	}
	
	@Override
	public int hashCode() {
        int result = lat != null ? lat.hashCode() : 0;
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        return result;		
	}
	
	@Override
	public String toString() {
		return "[" + lat + "," + lon + "]";
	}
}
