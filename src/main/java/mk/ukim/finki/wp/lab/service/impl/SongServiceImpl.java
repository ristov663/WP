package mk.ukim.finki.wp.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Transactional
    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        Song existingSong = songRepository.findById(song.getId())
                .orElseThrow(() -> new RuntimeException("Song not found"));

        existingSong.getPerformers().add(artist);


        Optional.of(songRepository.save(new Song(existingSong.getTitle(), existingSong.getGenre(), existingSong.getReleaseYear(), existingSong.getAlbum())));

        return artist;
    }

    @Override
    public Song findByTrackId(Long id) {
        return songRepository.findSongById(id);
    }


    @Override
    public Optional<Song> save(String title, String genre, int releaseYear, Album album) {
        return Optional.of(songRepository.save(new Song(title, genre, releaseYear, album)));
    }

    @Override
    public Optional<Song> update(Long id, String title, String genre, int releaseYear, Album album) {
        Song song = songRepository.findById(id).orElse(null);

        if (song != null) {
            song.setTitle(title);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            song.setAlbum(album);

            return Optional.of(songRepository.save(song));
        }

        return Optional.empty();
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }
}