//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet (name = "ArtistServlet", urlPatterns = {"/servlet/artist"})
//public class ArtistServlet extends HttpServlet {
//
//    private final ArtistService artistService;
//    private final SpringTemplateEngine templateEngine;
//    private final SongService songService;
//
//    public ArtistServlet(ArtistService artistService, SpringTemplateEngine templateEngine, SongService songService) {
//        this.artistService = artistService;
//        this.templateEngine = templateEngine;
//        this.songService = songService;
//    }
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Artist> artistList;
//        artistList = artistService.listArtists();
//
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(iWebExchange);
//        context.setVariable("artistList", artistList);
//        templateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//
//    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long trackId;
//        List<Artist> artistList;
//        artistList = artistService.listArtists();
//
//        if (req.getParameter("trackId") != null) {
//            trackId = Long.valueOf(req.getParameter("trackId"));
//        } else {
//            trackId = Long.valueOf("-");
//        }
//
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(iWebExchange);
//        context.setVariable("trackId", trackId);
//        context.setVariable("artistList", artistList);
//        templateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//}