/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May  6 21:58:27 CEST 2018
 */

package uebung11.as.aufgabe02;

public class LandingOrder {

  private PriorityQueue<Long, Airplane> pq;

  public LandingOrder() {
    pq = new PriorityQueue<Long, Airplane>();
  }

  public void addAirplane(Airplane airplane) {
    pq.insert(airplane.getQuantityOfPetrol(), airplane);
  }

  public Airplane nextAirplane() {
	if(pq.isEmpty()) {
		return null;
	}
    Entry<Long, Airplane> entry = pq.removeMin();
    return entry.getValue();
  }

  public boolean isEmpty() {
    return pq.isEmpty();
  }

  public static void main(String[] args) {
    LandingOrder landingOrder = new LandingOrder();

    landingOrder.addAirplane(new Airplane("Basel", 20));
    landingOrder.addAirplane(new Airplane("Geneva", 100));
    landingOrder.addAirplane(new Airplane("New-York", 10));
    landingOrder.addAirplane(new Airplane("London", 5));
    landingOrder.addAirplane(new Airplane("Tel Aviv", 300));

    Airplane nextLanding;
    while ((nextLanding = landingOrder.nextAirplane()) != null) {
      System.out.println("Airplane from " + nextLanding.getDepartureAirport()
          + " has landed");
    }

    System.out.println("All airplanes have landed.");
  }
}

/* Session-Log (SOLL):

Airplane from London has landed
Airplane from New-York has landed
Airplane from Basel has landed
Airplane from Geneva has landed
Airplane from Tel Aviv has landed
All airplanes have landed.

*/

 
 
 
 
