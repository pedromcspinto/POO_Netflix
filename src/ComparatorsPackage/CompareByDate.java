package ComparatorsPackage;

import java.util.*;
import UploadsPackage.*;
public class CompareByDate implements Comparator<InterfaceUploads>{

	@Override
	public int compare(InterfaceUploads o1, InterfaceUploads o2) {
		
		int compare =Integer.compare(o1.getRelease(), o2.getRelease());
		if(compare==0) {
			compare=o1.getTitle().compareTo(o2.getTitle());		
		}
		return compare;
	}

}
