/**
 *	@author Sergio Romero Barra
 *
 *	http://bikeportland.org/2011/12/12/new-study-compares-bicyclings-co2-emissions-to-other-modes-63536
 */

package com.sergiorb.java_beca_coritel.ud10.ecological;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<EcologicalImpact> objects = new ArrayList<EcologicalImpact>();
		
		objects.add(new Bike(2, 10.3));
		objects.add(new Car(5, 10.3));
		objects.add(new Building(3000.0, 1500.5, 200.3, 12000.0, 15000.0, 15000.0));
		
		for (EcologicalImpact ecologicalImpact : objects) {
		
			ecologicalImpact.calculateEcologicalImpact();
		}
		
	}
}
