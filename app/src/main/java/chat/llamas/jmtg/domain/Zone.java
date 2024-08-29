package chat.llamas.jmtg.domain;

public enum Zone {
	LIBRARY(false, false, true, ZoneType.REGULAR),
	HAND(false, false, false, ZoneType.REGULAR),
	BATTLEFIELD(true, true, false, ZoneType.REGULAR),
	GRAVEYARD(true, false, true, ZoneType.REGULAR),
	STACK(true, true, true, ZoneType.REGULAR),
	EXILE(true, true, false, ZoneType.REGULAR),
	COMMAND(true, true, false, ZoneType.REGULAR),
	;
	private boolean shared;
	private boolean publicZone;
	private boolean sorted;
	private ZoneType zoneType;
	Zone(boolean publicZone, boolean shared, boolean sorted, ZoneType zoneType) {
		this.publicZone = publicZone;
		this.shared = shared;
		this.sorted = sorted;
		this.zoneType = zoneType;
	}
	public boolean isShared() {
		return shared;
	}
	public boolean isPublicZone() {
		return publicZone;
	}
	public boolean isSorted() {
		return sorted;
	}
	public ZoneType getZoneType() {
		return zoneType;
	}
}
enum ZoneType {
	REGULAR,
	EXTRA,
	DEPRECATED
}