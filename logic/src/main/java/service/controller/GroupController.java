package service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.dto.Group;
import service.service.group.GroupService;

@RestController("group/")
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;

    @PostMapping("create")
    public Group saveGroup(@RequestBody by.model.Group group) {
        return groupService.saveGroup(group);
    }
}
