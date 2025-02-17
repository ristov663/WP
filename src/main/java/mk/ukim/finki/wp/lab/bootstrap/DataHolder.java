package mk.ukim.finki.wp.lab.bootstrap;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

//    public static List<Artist> artistList = new ArrayList<>();
//    public static List<Album> albumList = new ArrayList<>();
//    public static List<Song> songList = new ArrayList<>();
//
//    @PostConstruct
//    public void init() {
//
//        // Add artists
//        artistList.add(new Artist("Taylor", "Swift", "Taylor Swift Bio"));
//        artistList.add(new Artist("Bruno", "Mars", "Bruno Mars Bio"));
//        artistList.add(new Artist("Billie", "Eilish", "Billie Eilish Bio"));
//        artistList.add(new Artist("Ed", "Sheeran", "Ed Sheeran Bio"));
//        artistList.add(new Artist("Dua", "Lipa", "Dua Lipa Bio"));
//
//        // Add songs
//        songList.add(new Song("Espresso", "Pop", 2024, List.of(artistList.get(3)), null)); // Album set later
//        songList.add(new Song("A Bar Song (Tipsy)", "Country", 2024, List.of(artistList.get(0)), null));
//        songList.add(new Song("Lose Control", "Pop", 2023, List.of(artistList.get(2)), null));
//        songList.add(new Song("Please Please Please", "Please Please Please", 2024, List.of(artistList.get(4)), null));
//        songList.add(new Song("Beautiful Things", "Pop rock", 2023, List.of(artistList.get(1)), null));
//
//        // Add albums
//        albumList.add(new Album("A Peace of Us", "Pop", "2023"));
//        albumList.add(new Album("Negative Spaces", "Rock", "2024"));
//        albumList.add(new Album("Bouquet", "Pop", "2024"));
//        albumList.add(new Album("Mahashmashana", "Pop", "2022"));
//        albumList.add(new Album("Night Palace", "Pop", "2024"));
//
//        // Assign albums to songs
//        songList.get(0).setAlbum(albumList.get(0));
//        songList.get(1).setAlbum(albumList.get(1));
//        songList.get(2).setAlbum(albumList.get(2));
//        songList.get(3).setAlbum(albumList.get(3));
//        songList.get(4).setAlbum(albumList.get(4));
//    }
}
