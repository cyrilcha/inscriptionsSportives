package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestEquipe
{
	Inscriptions i = Inscriptions.getInscriptions();
	Equipe e = i.createEquipe("CGY");
	Personne p = i.createPersonne("Chatin","Cyril","chatincyril@yahoo.fr");
	
	@Test
	public void testAddPersonne()
	{
		assertTrue(e.add(p));
		assertTrue(e.getMembres().contains(p));
	}
	
	@Test
	public void testRemovePersonne()
	{
		assertTrue(e.add(p));
		assertTrue(e.remove(p));
		assertFalse(e.getMembres().contains(p));
	}
	
}
