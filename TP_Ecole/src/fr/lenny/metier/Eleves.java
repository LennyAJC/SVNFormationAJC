/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
public abstract class Eleves implements Comparable<IEleves>{

	/**
	 * @return the note
	 */
	public abstract double getNote();

	public int compareTo(IEleves eleves) {
		int result = 0;
		if (this.getNote() < eleves.getNote()) {
			result = -1;
		} else if (this.getNote() > eleves.getNote()) {
			result = 1;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(IEleves eleves) {
		boolean result = false;
		if (this.getNote() == eleves.getNote()) {
			result = true;
		}
		// TODO Auto-generated method stub
		return result;
	}

}
