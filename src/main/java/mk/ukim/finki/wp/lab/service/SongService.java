package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(Long trackId);
    Optional<Song> save(String title, String genre, int releaseYear, Album album);
    Optional<Song> update(Long id, String title, String genre, int releaseYear, Album album);
    void deleteSongById(Long id);
    List<Song> findAllByAlbum_Id(Long albumId);
}
