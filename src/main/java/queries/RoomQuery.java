package queries;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class RoomQuery {
	
	public static final int MIN_AGE_FOR_SEPARATE_BED = 4;
	
	public int adl = 1;
	public String chl;

	public RoomQuery() {}
	
	public RoomQuery(int adults, String childrenAges) {
		this.adl = adults;
		this.chl = childrenAges;
	}
	
	public void setAdl(int adl) {
		this.adl = adl;
	}
	public void setChl(String chl) {
		this.chl = chl;
	}

    public int adults() {
        return adl;
    }
	
	public List<Integer> children() {
        return new ArrayList<Integer>(StringUtils.commaSeparatedToInts(chl));
	}
	
	public int countChildrenAgedGte( int age ) {
		int count = 0;
		for ( Integer i : children() ) {
			if ( i >= age ) {
				count++;
			}
		}
		return count;
	}
	
	public int sleepingPlacesNeeded() {
		return adl + countChildrenAgedGte(MIN_AGE_FOR_SEPARATE_BED);
	}

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(adl);
        List<Integer> children = children();
        if ( !children.isEmpty() ) {
            s.append(" + ");
            s.append(children.size());
        }
        return s.toString();
    }

}
