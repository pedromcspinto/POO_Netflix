package ComparatorsPackage;

import java.util.Comparator;

import UploadsPackage.*;

public class CompareByTitle implements Comparator<InterfaceUploads>{

	@Override
	public int compare(InterfaceUploads a1, InterfaceUploads a2) {
		int compare = a1.getTitle().compareTo(a2.getTitle());
		return compare;
	}

	
	
}
