package test;

import static org.junit.Assert.*;

import org.junit.Test;

import inscriptions.Personne;
import inscriptions.Equipe;
import inscriptions.Inscriptions;

public class TestPersonne {
	
	Inscriptions i = Inscriptions.getInscriptions();
	Personne p = i.createPersonne("Chatin","Cyril","chatincyril@yahoo.fr");
	Equipe e = i.createEquipe("CGY");
	
	@Test
	public void testGetPrenom()
	{
		assertEquals("Cyril", p.getPrenom());
	}
	
	@Test
	public void testSetPrenom()
	{
		p.setPrenom("cycy");
		assertEquals("cycy", p.getPrenom());
	}
	
	@Test
	public void testGetMail()
	{
		assertEquals("chatincyril@yahoo.fr", p.getMail());
	}
	
	@Test
	public void testSetEmail()
	{
		p.setMail("chatincyril@gmail.com");
		assertEquals("chatincyril@gmail.com", p.getMail());
	}
	
	@Test
	public void testaddEquipe()
	{
		assertTrue(e.add(p));
	}
	
	@Test
	public void testRemoveEquipe()
	{
		assertTrue(e.add(p));
		assertTrue(e.remove(p));
		assertFalse(p.getEquipes().contains(e));
	}
	
	


}
