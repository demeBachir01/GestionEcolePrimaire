package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.ClasseDto;
import backen.gestionbulletinprimaire.Service.ClasseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Classe")
@AllArgsConstructor
@NoArgsConstructor
public class ClasseController {

    @Autowired
    private ClasseService classeService;
    @GetMapping("All")
    public List<ClasseDto> getAll(){
        return classeService.lisAllClasse();
    }

    // Méthode pour ajouter une Classe
    @PostMapping("Add")
    public ClasseDto addClasse(@RequestBody ClasseDto classeDto){
        return classeService.addClasse(classeDto);
    }
    // Méthode pour récupérer une Classe par son ID
    @GetMapping("getById")
    public ClasseDto getClasseById(@RequestParam("id") Long id){
       return classeService.getClasseById(id);

    }
}
