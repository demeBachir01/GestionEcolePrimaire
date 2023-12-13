package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.CompositionDto;
import backen.gestionbulletinprimaire.Entites.Composition;
import backen.gestionbulletinprimaire.Entites.Eleve;
import backen.gestionbulletinprimaire.Repository.CompositionRepository;
import backen.gestionbulletinprimaire.Repository.EleveRepository;
import backen.gestionbulletinprimaire.Repository.PersonneRepository;
import backen.gestionbulletinprimaire.mapper.Compositionmapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CompositionService {
    @Autowired
    private CompositionRepository compositionRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private EleveRepository eleveRepository;
    private Compositionmapper compositionmapper=new Compositionmapper();

    // Méthode pour récupérer toutes les Composition
    public List<CompositionDto> listAllComposition() {
        List<Composition> compositions=compositionRepository.findAll();
        List<CompositionDto> compositionDtos=new ArrayList<>();
        for(Composition cm:compositions) {
            CompositionDto compositionDto = new CompositionDto();
            compositionDto = compositionmapper.fromCompositionToCompositionDto(cm);
            compositionDtos.add(compositionDto);
        }
        return compositionDtos;
    }

    // Méthode pour récupérer une composition par son ID
    public CompositionDto getCompositionById(Long id) {
        Composition composition = compositionRepository.findById(id).get();
        return compositionmapper.fromCompositionToCompositionDto(composition);
    }

    // Méthode pour ajouter une composition
    public CompositionDto addComposition(CompositionDto compositionDto) {
        //personnemapper =new Personnemapper();
        Composition composition=compositionmapper.fromCompositionDToComposition(compositionDto);
        return compositionmapper.fromCompositionToCompositionDto(compositionRepository.save(composition));
    }

    // Méthode pour mettre à jour une Composition
    public void updateComposition( CompositionDto compositionDto) {
        Composition composition = compositionRepository.findById(compositionDto.getId()).get();
        if (compositionDto != null) {
            composition.setId(compositionDto.getId());
            composition.setNomCompo(compositionDto.getNomCompo());
            composition.setEleve(new Eleve());
            compositionRepository.save(composition);
        }

    }

    // Méthode pour supprimer une Composition par son ID
    public void deleteComposition(Long id) {
        Composition composition = compositionRepository.findById(id).orElse(null);
        if (composition != null) {
            compositionRepository.delete(composition);
        }
    }
}
