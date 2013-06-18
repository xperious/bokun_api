package is.bokun.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class Paginator {

	public static final int ADJACENTS = 3;

	public int currentPage;
	public int pageSize;
	public int startIndex;
	public int totalPages;
	public long totalSize;

	public List<Item> items = new ArrayList<Item>();

	public Paginator(int currentPage, int pageSize, long totalSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.startIndex = calculateStartIndex(currentPage, pageSize);
		this.totalPages = calculateTotalPages(pageSize, totalSize);
		prepareItems();
	}

	private void prepareItems() {
		if ( totalPages < (7 + ADJACENTS*2) ) { // not enough pages to bother breaking it up
			for ( int i = 1; i <= totalPages; i++ ) {
				items.add(new Item(i));
			}
		} else if ( totalPages > (5 + ADJACENTS*2) ) { // enough pages to hide some
			if ( currentPage < (1 + ADJACENTS*2) ) {
				// close to beginning, only hide later pages
				for ( int i = 1; i < (4 + ADJACENTS*2); i++ ) {
					items.add(new Item(i));
				}
				items.add(new Item());
				items.add(new Item(totalPages-1));
				items.add(new Item(totalPages));
			} else if ( (totalPages - ADJACENTS*2) > currentPage && currentPage > ADJACENTS*2 ) {
				// in middle, hide some at front and some at back
				items.add(new Item(1));
				items.add(new Item(2));
				items.add(new Item());
				for ( int i = (currentPage-ADJACENTS); i <= (currentPage+ADJACENTS); i++ ) {
					items.add(new Item(i));
				}
				items.add(new Item());
				items.add(new Item(totalPages-1));
				items.add(new Item(totalPages));
			} else {
				// close to end, only hide early pages
				items.add(new Item(1));
				items.add(new Item(2));
				items.add(new Item());
				for ( int i = (totalPages-(2 + ADJACENTS*2)); i <= totalPages; i++ ) {
					items.add(new Item(i));
				}
			}
		}
	}
	
	public int rangeStart() {
		return startIndex+1;
	}
	
	public int rangeEnd() {
		int endIndex = (startIndex+pageSize);
		if ( endIndex > totalSize ) {
			endIndex = (int)totalSize;
		}
		return endIndex;
	}

	public String range() {
		int endIndex = (startIndex+pageSize);
		if ( endIndex > totalSize ) {
			endIndex = (int)totalSize;
		}
		return "" + (startIndex+1) + " - " + endIndex;
	}

	public boolean hasPreviousPage() {
		return currentPage > 1;
	}

	public boolean hasNextPage() {
		return currentPage < totalPages;
	}

	public static int calculateTotalPages(int pageSize, long totalSize) {
		if ( totalSize <= 0 ) {
			return 1;
		}

		if ( (totalSize % pageSize) == 0 ) {
			return (int)totalSize / pageSize;
		} else {
			return ((int)totalSize / pageSize) + 1;
		}
	}

	public static int calculateStartIndex(int page, int pageSize) {
        if ( page < 1 ) { page = 1; }
		return (page-1) * pageSize;
	}

	public class Item {
		public int p;
		public boolean separator = false;

		public Item(int p) {
			this.p = p;
			this.separator = false;
		}

		public Item() {
			this.separator = true;
		}
	}
}