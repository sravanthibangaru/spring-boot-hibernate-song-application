package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.repository.SongRepository;
import com.example.song.repository.SongJpaRepository;
import com.example.song.model.Song;


// Write your code here

@Service 
public class SongJpaService implements SongRepository{

    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song> getAllSongs(){
        List<Song> songsList = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(songsList);
        return songs;
    }

    @Override
    public Song getSongById(int songId)throws ResponseStatusException{
        try{
            Song song = songJpaRepository.findById(songId).get();
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song)throws ResponseStatusException{
        try{
            songJpaRepository.save(song);
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override

    public Song updateSong(int songId, Song song)throws ResponseStatusException{

        try{
            Song existingSong = songJpaRepository.findById(songId).get();
            if(song.getSongName() != null){
                existingSong.setSongName(song.getSongName());
            }
            if(song.getLyricist() != null){
                existingSong.setLyricist(song.getLyricist());
            }
            if(song.getSinger() != null){
                existingSong.setSinger(song.getSinger());
            }
            if(song.getMusicDirector() != null){
                existingSong.setMusicDirector(song.getMusicDirector());
            }
            songJpaRepository.save(existingSong);
            return existingSong;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteSong(int songId)throws ResponseStatusException{
        try{
            songJpaRepository.deleteById(songId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}