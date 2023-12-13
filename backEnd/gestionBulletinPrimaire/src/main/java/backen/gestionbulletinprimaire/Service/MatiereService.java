package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.MatiereDto;
import backen.gestionbulletinprimaire.Entites.Composition;
import backen.gestionbulletinprimaire.Entites.Matiere;
import backen.gestionbulletinprimaire.Repository.CompositionRepository;
import backen.gestionbulletinprimaire.Repository.MatiereRepository;
import backen.gestionbulletinprimaire.mapper.Matieremapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;
    private CompositionRepository compositionRepository;
    private Matieremapper matieremapper=new Matieremapper();


    // Méthode pour récupérer toutes les Matiere
    public List<MatiereDto> listAllMatiere(){
        List<Matiere> matieres=matiereRepository.findAll();
        List<MatiereDto> matiereDtos=new ArrayList<>();
        for(Matiere mt:matieres) {
            MatiereDto matiereDto = new MatiereDto();
            matiereDto = matieremapper.fromMatiereToMatiereDto(mt);
            matiereDtos.add(matiereDto);
        }
        return matiereDtos;
    }


    // Méthode pour récupérer une Matiere par son ID
    public MatiereDto getMatiereById(Long id) {
        Matiere matiere = matiereRepository.findById(id).get();
        return matieremapper.fromMatiereToMatiereDto(matiere);
    }

    // Méthode pour ajouter une Matiere
    public MatiereDto addMatiere(MatiereDto matiereDto) {
        Matiere matiere=matieremapper.fromMatiereDToMatiere(matiereDto);
        return matieremapper.fromMatiereToMatiereDto(matiereRepository.save(matiere));
    }

    // Méthode pour mettre à jour une Matiere
    public void updateMatiere( MatiereDto matiereDto) {
        Matiere matiere = matiereRepository.findById(matiereDto.getId()).get();
        if (matiere != null) {
            matiere.setId(matiereDto.getId());
            matiere.setComposition(new Composition());

            matiereRepository.save(matiere);
        }
    }

    // Méthode pour supprimer une Matiere par son ID
    public void deleteMatiere(Long id) {
        Matiere matiere = matiereRepository.findById(id).orElse(null);
        if (matiere != null) {
            matiereRepository.delete(matiere);
        }
    }
}
