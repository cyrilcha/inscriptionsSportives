package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCompetition {
	
	Inscriptions i = Inscriptions.getInscriptions();
	LocalDate dateclôture = LocalDate.of(2016, Month.DECEMBER, 31);
	LocalDate newdateclôture = LocalDate.of(2016, Month.JANUARY, 31);
	Competition comp_personnes = i.createCompetition("MLS", dateclôture , false);
	Personne p = i.createPersonne("Chatin","Cyril","chatincyril@yahoo.fr");

	
	@Test(expected = RuntimeException.class)
	public void testSetDateClôture() throws Exception 
	{
		comp_personnes.setDateCloture(newdateclôture);
	}
	
	@Test
	public void testAddPersonne()
	{
		assertTrue(comp_personnes.add(p));
		assertTrue(comp_personnes.getCandidats().contains(p));
	}
	
	@Test
	public void testRemovePersonne()
	{
		assertTrue(comp_personnes.add(p));
		assertTrue(comp_personnes.remove(p));
		assertFalse(comp_personnes.getCandidats().contains(p));
		
	}
	
}
