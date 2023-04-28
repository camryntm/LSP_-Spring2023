package org.howard.edu.lsp.finals.problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class SongsDatabaseTest {
	
	@Test
    public void testaddSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Hate It Or Love It");
        db.addSong("Rap", "Private Landing");
        db.addSong("Soul", "I Say a Little Prayer");
        db.addSong("Soul" , "Just Friends");
        
        Set<String> rap_songs = db.getSongs("Rap");
        Set<String> soul_songs = db.getSongs("Soul");
        
        assertTrue(rap_songs.contains("Hate It Or Love It"));
        assertTrue(rap_songs.contains("Private Landing"));
        assertTrue(soul_songs.contains("I Say a Little Prayer"));
        assertTrue(soul_songs.contains("Just Friends"));
        assertFalse(rap_songs.contains("Hello"));
        assertFalse(soul_songs.contains("Nothing Even Matters"));
    }
	
	@Test
	public void testGetSongs() {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Country", "Before He Cheats");
		db.addSong("Country", "Jolene");
		db.addSong("Pop", "You Rock My World");
		
		Set<String> country_songs = db.getSongs("Country");
		Set<String> pop_songs = db.getSongs("Pop");
		
		assertTrue(country_songs.contains("Jolene"));
		assertTrue(pop_songs.contains("You Rock My World"));
		assertEquals(1, db.getSongs("Pop").size());
		
	}
	
	@Test
	public void testGetGenreOfSongs() {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Rap", "B.I.G. (Interlude)");
		db.addSong("Rap", "Crew Love");
		db.addSong("Rap", "pick up the phone");
		db.addSong("Rap", "REEL IT IN");
		db.addSong("Rap", "Mood Swings");
				
		assertEquals("Rap", db.getGenreOfSong("B.I.G. (Interlude)"));
		assertEquals("Rap", db.getGenreOfSong("Mood Swings"));
		assertEquals("Rap", db.getGenreOfSong("REEL IT IN"));
		assertEquals("That song is not in the database.", db.getGenreOfSong("Candy Shop"));
		System.out.println(db.getGenreOfSong("Jolene"));
		System.out.println(db.getSongs("Rap"));
		
	}

}