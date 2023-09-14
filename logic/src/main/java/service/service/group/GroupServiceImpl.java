package service.service.group;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import service.convertor.GroupConvertor;
import service.dto.Group;
import service.repository.GroupRepository;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService{

    private GroupConvertor convertor;
    private GroupRepository repository;
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Group saveGroup(by.model.Group group) {
        try {
            printTransaction();
            return repository.save(convertor.convert(group));
        } catch (Exception c) {
            c.printStackTrace();
        }
        return null;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void printTransaction() {
        System.out.println("Current Transaction: " + TransactionSynchronizationManager.getCurrentTransactionName());
    }
}
