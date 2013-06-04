package is.bokun.dtos;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class HasBookableExtras implements WithExtras {

	public List<BookableExtraDto> extras = new ArrayList<>();

    @JsonIgnore
	public BookableExtraDto findExtra(Long id) {
		for (BookableExtraDto e : extras) {
			if ( e.id.equals(id) ) {
				return e;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public List<BookableExtraDto> getIncludedExtras() {
		List<BookableExtraDto> list = new ArrayList<>();
		for ( BookableExtraDto e : extras ) {
			if ( e.included ) {
				list.add(e);
			}
		}
		return list;
	}
	
	@JsonIgnore
	public List<BookableExtraDto> getOptionalExtras() {
		List<BookableExtraDto> list = new ArrayList<>();
		for ( BookableExtraDto e : extras ) {
			if ( !e.included ) {
				list.add(e);
			}
		}
		return list;
	}
}
