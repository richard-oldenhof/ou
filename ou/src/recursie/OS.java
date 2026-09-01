package recursie;

import java.io.File;

public final class OS {
	public static long mapsize(File root) {
		
		long total =  root.length();
		
		if (root.isDirectory() && (!(root.list() == null))) {
			for (String childname : root.list()) {
				File child = new File(root, childname);
				total = total + mapsize(child);
			}		
		}
		System.out.println(total + "\t" + root);
		return total;
		
	}
}
