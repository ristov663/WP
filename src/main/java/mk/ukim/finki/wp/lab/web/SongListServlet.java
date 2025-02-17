//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//import static java.lang.String.valueOf;
//
//@WebServlet(name = "SongListServlet", urlPatterns = {"/servlet/listSongs"})
//public class SongListServlet extends HttpServlet {
//
//    public final SpringTemplateEngine templateEngine;
//    public final SongService songService;
//
//    public SongListServlet(SpringTemplateEngine templateEngine, SongService songService) {
//        this.templateEngine = templateEngine;
//        this.songService = songService;
//    }
//
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Song> songList;
//        songList = songService.listSongs();
//
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(iWebExchange);
//        context.setVariable("songList", songList);
//        templateEngine.process("listSongs.html", context, resp.getWriter());
//    }
//
//
//    //NEW CODE
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        String searchString = req.getParameter("searchString");
//        List<Song> filteredSongs = songService.findByTitle(searchString);
//
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(iWebExchange);
//        context.setVariable("filteredSongs", filteredSongs);
//        templateEngine.process("listSongs.html", context, resp.getWriter());
//    }
//
//
//}