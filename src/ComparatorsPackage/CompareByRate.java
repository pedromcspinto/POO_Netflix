package ComparatorsPackage;

import java.util.Comparator;

import UploadsPackage.InterfaceUploads;

public class CompareByRate  implements Comparator<InterfaceUploads>{
	
	@Override
	public int compare(InterfaceUploads o1, InterfaceUploads o2) {
		
		int compare = Float.compare(o1.getRate(), o2.getRate());
		if(compare==0) {
			compare=o1.getTitle().compareTo(o2.getTitle());		
		}
		return compare;
	}
}
