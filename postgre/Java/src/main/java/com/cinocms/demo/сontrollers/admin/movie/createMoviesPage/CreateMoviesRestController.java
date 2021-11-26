package com.cinocms.demo.сontrollers.admin.movie.createMoviesPage;

import com.cinocms.demo.filesManipulation.FileToDisk;
import com.cinocms.demo.filesManipulation.TypesFile;
import com.cinocms.demo.filesManipulation.TypesGallery;
import com.cinocms.demo.model.HiddenMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.model.MoviesGalleriesEntity;
import com.cinocms.demo.model.MoviesTypesEntity;
import com.cinocms.demo.services.HiddenMoviesService;
import com.cinocms.demo.services.MoviesGalleriesService;
import com.cinocms.demo.services.MoviesService;
import com.cinocms.demo.services.MoviesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;


@RestController
@RequestMapping("/admin")
public class CreateMoviesRestController {
    @Autowired
    private MoviesService moviesService;
    @Autowired
    private MoviesGalleriesService moviesGalleriesService;
    @Autowired
    private MoviesTypeService moviesTypeService;
    @Autowired
    private HiddenMoviesService hiddenMoviesService;

    public final static String NAME_MAIN_IMAGE = "Main";

    @PostMapping("/create-movie")
    public void createMoviesInformation(@RequestParam("moviesName") String moviesName,
                                        @RequestParam("moviesType") ArrayList<String> moviesType,
                                        @RequestParam("moviesDescription") String moviesDescription,
                                        @RequestParam("uploadMainImg") MultipartFile mainImage,
                                        @RequestParam("trailerLink") String trailerLink,
                                        @RequestParam("addToGalleryPicture") MultipartFile[] galleryPictures) {

        LinkedList<String> pathToImages = new LinkedList<>();
        FileToDisk fileToDisk = new FileToDisk();

        MoviesEntity savedNewMoviesEntity = moviesService.save(new MoviesEntity(moviesName, moviesDescription,
                fileToDisk.uploadFile(TypesFile.IMAGE, TypesGallery.MOVIES, moviesName, NAME_MAIN_IMAGE, mainImage), trailerLink));

        for (var picture : galleryPictures) {
            pathToImages.addLast(fileToDisk.uploadFile(TypesFile.IMAGE, TypesGallery.MOVIES, moviesName, UUID.randomUUID().toString(),
                    picture));
        }

        for (var pathToImage : pathToImages) {
            moviesGalleriesService.save(new MoviesGalleriesEntity(pathToImage, savedNewMoviesEntity));
        }

        for (var type : moviesType) {
            moviesTypeService.save(new MoviesTypesEntity(type, savedNewMoviesEntity));
        }

        hiddenMoviesService.save(new HiddenMoviesEntity(savedNewMoviesEntity));
    }
}
