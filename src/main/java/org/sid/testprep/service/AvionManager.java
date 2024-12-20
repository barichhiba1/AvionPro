package org.sid.testprep.service;

import lombok.AllArgsConstructor;
import org.sid.testprep.dao.entities.Avion;
import org.sid.testprep.dao.repositories.AvionRepository;
import org.sid.testprep.dto.AvionDto;
import org.sid.testprep.mapper.AvionMapper;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
@AllArgsConstructor
public class AvionManager implements  AvionService{

   private AvionRepository avionRepository;
   private AvionMapper avionMapper;
    @Override
    public AvionDto saveAvion(AvionDto avionDto) {
        Avion avion= avionMapper.fromAvionDtoToAvion(avionDto);
        avion=avionRepository.save(avion);
        avionDto=avionMapper.fromAvionToAvionDto(avion);
        return avionDto;
    }

    @Override
    public Boolean deleteAvion (Long id) {
        try {
            avionRepository.findById(id);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<AvionDto> getAvionByModel(String model) {
        List<Avion>avions=avionRepository.findByModel(model);
        List<AvionDto>avionDtos=new ArrayList<>();
        for(Avion avion:avions){
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;

    }

    @Override
    public List<AvionDto> getAvionByModelAndPrice(String model, double price) {
       List<Avion>avions=avionRepository.findByModelAndPrice(model,price);
       List<AvionDto>avionDtos=new ArrayList<>();
       for(Avion avion: avions){
           avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
       }
       return avionDtos;
    }

    @Override
    public List<AvionDto> saveAvions(List<AvionDto> avionDtos) {
      List<Avion> avions=new ArrayList<>();
      for(AvionDto avionDto:avionDtos){
          avions.add(avionMapper.fromAvionDtoToAvion(avionDto));

      }
      avions=avionRepository.saveAll(avions);
      avionDtos=new ArrayList<>();
      for (Avion avion: avions){
        avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
      }
      return avionDtos;
    }
}
