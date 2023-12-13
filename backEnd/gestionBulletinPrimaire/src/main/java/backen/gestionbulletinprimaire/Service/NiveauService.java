package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.NiveauDto;
import backen.gestionbulletinprimaire.Entites.Niveau;
import backen.gestionbulletinprimaire.Repository.NiveauRepository;
import backen.gestionbulletinprimaire.mapper.Niveaumapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class NiveauService {
    private NiveauRepository niveauRepository;
    private Niveaumapper niveaumapper;

    // Méthode pour récupérer toutes les Niveau
    public List<NiveauDto> listAllNiveau(){
        List<Niveau> niveaus=niveauRepository.findAll();
        List<NiveauDto> niveauDtos=new ArrayList<>();
        for(Niveau nv:niveaus) {
            NiveauDto niveauDto = new NiveauDto();
            niveauDto = niveaumapper.fromNiveauToNiveauDto(nv);
            niveauDtos.add(niveauDto);
        }
        return niveauDtos;
    }


    // Méthode pour récupérer une Niveau par son ID
    public NiveauDto getNiveauById(Long id) {
        Niveau niveau = niveauRepository.findById(id).get();
        return niveaumapper.fromNiveauToNiveauDto(niveau);
    }

    // Méthode pour ajouter une Niveau
    public NiveauDto addNiveau(NiveauDto niveauDto) {
        Niveau niveau=niveaumapper.fromNiveauDToNiveau(niveauDto);
        return niveaumapper.fromNiveauToNiveauDto(niveauRepository.save(niveau));
    }

    // Méthode pour mettre à jour une Niveau
    public void updateNiveau( NiveauDto niveauDto) {
        Niveau niveau = niveauRepository.findById(niveauDto.getId()).get();
        if (niveau != null) {
            niveau.setId(niveauDto.getId());
            niveau.setNom(niveauDto.getNom());
            niveauRepository.save(niveau);
        }
    }

    // Méthode pour supprimer une Niveau par son ID
    public void deleteNiveau(Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        if (niveau != null) {
            niveauRepository.delete(niveau);
        }
    }


}
