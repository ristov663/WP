package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.impl.ArtistServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artist")
    public String getArtists(Model model) {
        List<Artist> artistList = artistService.listArtists();
        model.addAttribute("artistList", artistList);
        return "artistsList";
    }

    @PostMapping("/artist")
    public String selectTrack(@RequestParam(required = false) Long songRadio,
                              Model model) {
        List<Artist> artistList = artistService.listArtists();
        model.addAttribute("trackId", songRadio);
        model.addAttribute("artistList", artistList);
        return "artistsList";
    }
}