package backen.gestionbulletinprimaire.Controller;


import backen.gestionbulletinprimaire.DTO.DirecteurDto;
import backen.gestionbulletinprimaire.Service.DirecteurService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Directeur")
@AllArgsConstructor
@NoArgsConstructor
public class DirecteurController {


    @Autowired
    private DirecteurService directeurService;
    @GetMapping("All")
    public List<DirecteurDto> getAll(){
        return directeurService.ListAllDirecteur();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public DirecteurDto addDirecteur(@RequestBody DirecteurDto directeurDto){
//        System.out.println(directeurDto.getNom());
//        System.out.println(directeurDto.getPrenom());
//        System.out.println(directeurDto.getAdresse());
//        System.out.println(directeurDto.getEmail());
//        System.out.println(directeurDto.getTelephone());
        return directeurService.addDirecteur(directeurDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public DirecteurDto getDirecteurById(@RequestParam("id") Long id){
        return directeurService.getDirecteurById(id);

    }
}
