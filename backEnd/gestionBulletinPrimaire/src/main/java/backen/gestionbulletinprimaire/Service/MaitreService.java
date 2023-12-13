package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.MaitreDto;
import backen.gestionbulletinprimaire.Entites.Etablissement;
import backen.gestionbulletinprimaire.Entites.Maitre;
import backen.gestionbulletinprimaire.Repository.ClasseRepository;
import backen.gestionbulletinprimaire.Repository.EtablissementRepository;
import backen.gestionbulletinprimaire.Repository.MaitreRepository;
import backen.gestionbulletinprimaire.mapper.Maitremapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class MaitreService {
    @Autowired
    private MaitreRepository maitreRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private ClasseRepository classeRepository;

    private Maitremapper maitremapper=new Maitremapper();

    // Méthode pour récupérer toutes les Maitre
    public List<MaitreDto> listAllMaitre(){
        List<Maitre> maitres=maitreRepository.findAll();
        List<MaitreDto> maitreDtos=new ArrayList<>();
        for(Maitre m:maitres) {
            MaitreDto maitreDto = new MaitreDto();
            maitreDto = maitremapper.fromMaitreToMaitreDto(m);
            maitreDtos.add(maitreDto);
        }
        return maitreDtos;
    }


    // Méthode pour récupérer une Maitre par son ID
    public MaitreDto getMaitreById(Long id) {
        Maitre maitre = maitreRepository.findById(id).get();
        return maitremapper.fromMaitreToMaitreDto(maitre);
    }

    // Méthode pour ajouter une Maitre
    public MaitreDto addMaitre(MaitreDto maitreDto) {
        //personnemapper =new Personnemapper();
        Maitre maitre=maitremapper.fromMaitreDToMaitre(maitreDto);
        return maitremapper.fromMaitreToMaitreDto(maitreRepository.save(maitre));
    }

    // Méthode pour mettre à jour une Maitre
    public void updateMaitre( MaitreDto maitreDto) {
        Maitre maitre = maitreRepository.findById(maitreDto.getId()).get();
        if (maitre != null) {
            maitre.setId(maitreDto.getId());
            maitre.setEtablissements(new Etablissement());
            maitre.setClasses(new ArrayList<>());

            maitreRepository.save(maitre);
        }
    }

    // Méthode pour supprimer une Maitre par son ID
    public void deleteMaitre(Long id) {
        Maitre maitre = maitreRepository.findById(id).orElse(null);
        if (maitre != null) {
            maitreRepository.delete(maitre);
        }
    }
}
