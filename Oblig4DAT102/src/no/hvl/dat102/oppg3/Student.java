package no.hvl.dat102.oppg3;

import java.util.Objects;

public class Student {

   private int snr; 
   private String namn; 
 
   public Student(int snr, String namn) { 
      this.snr = snr; 
      this.namn = namn; 
    }

	@Override
	public int hashCode() {
		return Objects.hash(namn, snr);
	}   
   
}
