package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.DirecteurDto;
import backen.gestionbulletinprimaire.Entites.Directeur;
import backen.gestionbulletinprimaire.Entites.Etablissement;
import backen.gestionbulletinprimaire.Repository.DirecteurRepository;
import backen.gestionbulletinprimaire.Repository.EtablissementRepository;
import backen.gestionbulletinprimaire.Repository.PersonneRepository;
import backen.gestionbulletinprimaire.mapper.Directeurmapper;
import backen.gestionbulletinprimaire.mapper.Etablissementmapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class DirecteurService {
    @Autowired
    private DirecteurRepository directeurRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    private Etablissementmapper etablissementmapper;
    private Directeurmapper directeurmapper =new Directeurmapper();

    public List<DirecteurDto> listAllDirecteur(){

        List<Directeur> directeurs=directeurRepository.findAll();
        List<DirecteurDto> directeurDtos=new ArrayList<>();
        for (Directeur d:directeurs){
            DirecteurDto directeurDto=new DirecteurDto();
            directeurDto =directeurmapper.fromDirecteurToDirecteurDto(d);
            directeurDtos.add(directeurDto);
        }
     return directeurDtos;
    }

    // Méthode pour récupérer une Directeur par son ID
    public DirecteurDto getDirecteurById(Long id){
        Directeur directeur=directeurRepository.findById(id).get();
        return directeurmapper.fromDirecteurToDirecteurDto(directeur);
    }

    // Méthode pour ajouter un Directeur
    public DirecteurDto addDirecteur(DirecteurDto directeurDto) {
       // Directeur directeur=new Directeur();
        Directeur directeur=directeurmapper.fromDirecteurDToDirecteur(directeurDto);
        Etablissement etablissement=etablissementRepository.findById(directeur.getEtablissement().getId()).get();
        directeur.setEtablissement(etablissement);
        return directeurmapper.fromDirecteurToDirecteurDto(directeurRepository.save(directeur));
    }

    // Méthode pour mettre à jour une directeur
    public void updateDirecteur( DirecteurDto directeurDto) {
        Directeur directeur = directeurRepository.findById(directeurDto.getId()).get();
        if (directeur != null) {
            directeur.setId(directeurDto.getId());
            directeur.setNom(directeurDto.getNom());
            directeur.setPrenom(directeurDto.getPrenom());
            directeur.setAdresse(directeurDto.getAdresse());
            directeur.setEmail(directeurDto.getEmail());
            directeur.setTelephone(directeurDto.getTelephone());
            directeur.setEtablissement(etablissementmapper.fromEtablissementDToEtablissement(directeurDto.getEtablissementDto()));
            directeurRepository.save(directeur);
        }
    }

    // Méthode pour supprimer une Directeur par son ID
    public void deleteComposition(Long id) {
        Directeur directeur = directeurRepository.findById(id).orElse(null);
        if (directeur != null) {
            directeurRepository.delete(directeur);
        }
    }
}
