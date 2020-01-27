package com.ex9.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {

    @RequestMapping("/images/{imagename}")
    public void imageViewer(HttpServletRequest req,
            HttpServletResponse res,
            @PathVariable("imagename") String imageName) {
        String path = "C:\\Users\\Edgla\\Documents\\";
        Path image = Paths.get(path, imageName);

        if (Files.exists(image)) {
            res.setHeader("Content-Disposition", "inline");
            res.setContentType(MediaType.IMAGE_PNG_VALUE);
            try {
                Files.copy(image, res.getOutputStream());
                res.getOutputStream().flush();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    
    @RequestMapping("/files/{filename}")
    public void fileDownloader(HttpServletRequest req,
            HttpServletResponse res,
            @PathVariable("filename") String filename) {
        String path = "C:\\Users\\Edgla\\Documents\\";
        Path file = Paths.get(path, filename);

        if (Files.exists(file)) {
            res.setHeader("Content-Disposition", "inline");
            res.setContentType(MediaType.APPLICATION_PDF_VALUE);
            try {
                Files.copy(file, res.getOutputStream());
                res.getOutputStream().flush();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }

}