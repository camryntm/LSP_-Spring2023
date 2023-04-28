package org.howard.edu.lsp.finals.problem;

import java.util.*;

/**
 * This class represents a custom song database. 
 * The database stores songs and their genres in a HashMap. 
 * Each genre maps to a HashSet of song titles.
 * 
 * @author Camryn Turner-Markes
 */
public class SongsDatabase {
    private HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    /**
     * Adds a song title to a genre or creates a new genre starting with that song.
     * 
     * @param genre the genre of the song
     * @param title the title of the song
     */
    public void addSong(String genre, String title) {
        HashSet<String> songTitles = map.get(genre);
        if (songTitles == null) {
            songTitles = new HashSet<String>();
            map.put(genre, songTitles);
        }
        songTitles.add(title);
    }

    /**
     * Returns the set of all song titles for a given genre.
     * If the genre does not exist in the database, an empty set is returned.
     * 
     * @param genre the genre of the songs to retrieve
     * @return the set of song titles for the given genre
     */
    public Set<String> getSongs(String genre) {
        HashSet<String> songTitles = map.get(genre);
        if (songTitles == null) {
            songTitles = new HashSet<String>();
        }
        return songTitles;
    }

    /**
     * Returns the genre associated with a given song title.
     * If the song title is not found in the database, 
     * a message is returned indicating that the song is not in the database.
     * 
     * @param title the title of the song
     * @return the genre of the song or an error message if the song is not in the database
     */
    public String getGenreOfSong(String title) {
        for (String genre : map.keySet()) {
            HashSet<String> songTitles = map.get(genre);
            if (songTitles.contains(title)) {
                return genre;
            }
        }
        return "That song is not in the database.";
    }
}
