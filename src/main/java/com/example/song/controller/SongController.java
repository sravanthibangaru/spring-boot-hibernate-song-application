package com.example.song.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.song.model.Song;
import com.example.song.service.SongJpaService; 

// Write your code here

@RestController 
public class SongController{
    @Autowired 
    public SongJpaService songJpaService;

    @GetMapping("/songs")
    public ArrayList<Song> getAllSongs(){
        return songJpaService.getAllSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId")int songId){
        return songJpaService.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songJpaService.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId")int songId, @RequestBody Song song){
        return songJpaService.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId")int songId){
        songJpaService.deleteSong(songId);
    }


    

}