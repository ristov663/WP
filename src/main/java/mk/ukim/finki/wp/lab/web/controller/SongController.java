package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidAlbumIdException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;
    private final ArtistService artistService;

    public SongController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping
    public String getSongsPage(Model model) {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("albums", albumService.findAll());

        return "listSongs";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveSong(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Long trackId,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) Integer releaseYear,
                           @RequestParam(required = false) Long albumId,
                           Model model) {
        if (title == null || title.isEmpty() || genre == null || genre.isEmpty() || releaseYear == null) {
            model.addAttribute("error", "All fields are required.");
            return "add-song";
        }

        Album album = albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId));

        if (trackId == null) {
            this.songService.save(title, genre, releaseYear, album);
        } else {
            songService.update(trackId, title, genre, releaseYear, album);
        }
        return "redirect:/songs";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddSongForm(Model model) {

        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditSongPage(@PathVariable Long id, Model model) {
        Song song = songService.findByTrackId(id);
        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSongById(id);
        return "redirect:/songs";
    }

    @PostMapping("/details")
    public String getSongDetails(@RequestParam(required = false) Long trackId,
                                 @RequestParam(required = false) Long artistId,
                                 Model model) {

        if (trackId != null || artistId != null) {
            Song song = songService.findByTrackId(trackId);
            Artist artist = artistService.findById(artistId);
            song.addArtist(artist);
            model.addAttribute("song", song);
        }
        return "songDetails";
    }

    @GetMapping("/album/{id}")
    public String showAlbums(@PathVariable Long id, Model model) {

        List<Song> songList = songService.findAllByAlbum_Id(id);

        model.addAttribute("songs", songList);

        return "songsInAlbum";
    }
}
