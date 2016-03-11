package test;

import static org.junit.Assert.*;

import org.junit.Test;

import inscriptions.Personne;
import inscriptions.Inscriptions;

public class TestPersonne {
	
	Inscriptions i = Inscriptions.getInscriptions();
	Personne p = i.createPersonne("Chatin","Cyril","chatincyril@yahoo.fr");
	
	@Test
	public void testGetNom()
	{
		assertEquals("Chatin", p.getNom());
	}
	


}
