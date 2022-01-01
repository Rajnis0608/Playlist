package com.javalearning;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    public boolean addSong(String songTitle, double songDuration) {
        if(findSong(songTitle) == null) {
            songs.add(new Song(songTitle, songDuration));
            return true;
        }
        else {
            return false;
        }
    }

    private Song findSong(String songTitle) {
        Song song = null;
        for(int i = 0; i < songs.size() ; i++) {
            Song checkedSong = songs.get(i);
            if(checkedSong.getTitle().equals(songTitle)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber , LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if(index > songs.size() || index < 0) {
            System.out.println("This album does not have track " + trackNumber);
            return false;
        }
        playList.add(songs.get(index));
        return true;
    }

    public boolean addToPlayList(String songTitle , LinkedList<Song> playList) {
        if(findSong(songTitle) != null) {
            playList.add(findSong(songTitle));
            return true;
        }
        else {
            System.out.println("This album does not have song " + songTitle);
            return false;
        }
    }
}