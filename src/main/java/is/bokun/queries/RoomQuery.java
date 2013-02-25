package is.bokun.queries;

import java.util.ArrayList;
import java.util.List;

import is.bokun.utils.StringUtils;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class RoomQuery {
	
	public static final int MIN_AGE_FOR_SEPARATE_BED = 4;
	
	public int adults = 1;
	public List<Integer> children = new ArrayList<>();

	public RoomQuery() {}
	
	public RoomQuery(int adults, String childrenAges) {
		this.adults = adults;
		this.children = new ArrayList<Integer>(StringUtils.commaSeparatedToInts(childrenAges));
	}
	
    public void setAdults(int adults) {
		this.adults = adults;
	}

	public void setChildren(List<Integer> children) {
		this.children = children;
	}
	
	public int countChildrenAgedGte( int age ) {
		int count = 0;
		for ( Integer i : children ) {
			if ( i >= age ) {
				count++;
			}
		}
		return count;
	}
	
	public int sleepingPlacesNeeded() {
		return adults + countChildrenAgedGte(MIN_AGE_FOR_SEPARATE_BED);
	}

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(adults);
        if ( !children.isEmpty() ) {
            s.append(" + ");
            s.append(children.size());
        }
        return s.toString();
    }

}
