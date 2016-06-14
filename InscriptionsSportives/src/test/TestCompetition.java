package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCompetition {
	
	/*Inscriptions i = Inscriptions.getInscriptions();
	LocalDate dateclôture1 = LocalDate.of(2016, Month.DECEMBER, 31);
	LocalDate dateclôture2 = LocalDate.of(2016, Month.JANUARY, 31);
	LocalDate newdateclôture = LocalDate.of(2016, Month.JANUARY, 31);
	Competition comp_personnes = i.createCompetition("MLS", dateclôture1 , false);
	Competition comp_equipe = i.createCompetition("MLS", dateclôture2 , true);
	Personne p = i.createPersonne("Chatin","Cyril","chatincyril@yahoo.fr");
	Equipe e = i.createEquipe("CGY");
	
	@Test
	public void testGetNom()
	{
		assertEquals("MLS", comp_personnes.getNom());
	}
	
	@Test
	public void testInscriptionsOuvertes()
	{
		assertEquals(comp_personnes.inscriptionsOuvertes(), true);
		assertEquals(comp_equipe.inscriptionsOuvertes(), false);
	}

	
	@Test(expected = RuntimeException.class)
	public void testSetDateClôture() throws Exception 
	{
		comp_personnes.setDateCloture(newdateclôture);
	}
	
	@Test
	public void testGetDateCloture()
	{
		assertEquals(LocalDate.of(2016, Month.DECEMBER, 31), comp_personnes.getDateCloture());
		assertEquals(LocalDate.of(2016, Month.JANUARY, 31), comp_equipe.getDateCloture());
	}
	
	@Test
	public void testEstEnEquipe()
	{
		assertEquals(comp_equipe.estEnEquipe(), true);
		assertEquals(comp_personnes.estEnEquipe(), false);
	}
	
	@Test
	public void testAddPersonne()
	{
		assertTrue(comp_personnes.add(p));
		assertTrue(comp_personnes.getCandidats().contains(p));
	}
	
	@Test
	public void testAddEquipe()
	{
		assertTrue(comp_equipe.add(e));
		assertTrue(comp_equipe.getCandidats().contains(e));
	}
	
	@Test
	public void testRemovePersonne()
	{
		assertTrue(comp_personnes.add(p));
		assertTrue(comp_personnes.remove(p));
		assertFalse(comp_personnes.getCandidats().contains(p));
	}
	
	@Test
	public void testRemoveEquipe()
	{
		assertTrue(comp_equipe.add(e));
		assertTrue(comp_equipe.remove(e));
		assertFalse(comp_equipe.getCandidats().contains(e));
	}*/
}
