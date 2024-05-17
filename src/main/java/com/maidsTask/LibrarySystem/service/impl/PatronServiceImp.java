package com.maidsTask.LibrarySystem.service.impl;

import com.maidsTask.LibrarySystem.dto.PatronDTO;
import com.maidsTask.LibrarySystem.exception.NotFoundException;
import com.maidsTask.LibrarySystem.mapper.PatronMapper;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.model.Patron;
import com.maidsTask.LibrarySystem.repository.PatronRepository;
import com.maidsTask.LibrarySystem.service.PatronService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatronServiceImp implements PatronService {
    private PatronRepository patronRepository;

    @Override
    public Patron addPatron(PatronDTO patronDTO) {
        Patron patron= PatronMapper.mapToPatron(patronDTO);
        return patronRepository.save(patron);
    }

    @Override
    public Patron getPatron(Integer id) {
        Patron patron=patronRepository.findById(id).
                orElseThrow(()->new NotFoundException("not found patron with this id :"+ id));
        return patron;
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public void updatePatron(Integer id, PatronDTO patronDTO) {
        Patron patron=patronRepository.findById(id).
                orElseThrow(()->new NotFoundException("not found patron with this id :"+ id));
        //check the existing fields before update
        patron.setName(patronDTO.getName()!=null?patronDTO.getName():patron.getName());
        patron.setPassword(patronDTO.getPassword()!=null?patronDTO.getPassword():patron.getPassword());
        patron.setContactInformation(patronDTO.getContactInformation()!=null?patronDTO.getContactInformation():patron.getContactInformation());
        patron.setEmail(patronDTO.getEmail()!=null?patronDTO.getEmail():patron.getEmail());
        patronRepository.save(patron);
    }

    @Override
    public void deletePatron(Integer id) {
        Patron patron=patronRepository.findById(id).
                orElseThrow(()->new NotFoundException("not found patron with this id :"+ id));
        patronRepository.deleteById(id);
    }
}
