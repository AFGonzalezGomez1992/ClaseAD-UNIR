package service;
import model.Editorial;
import repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class EditorialServiceImpl implements EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public Editorial agregarEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }
}