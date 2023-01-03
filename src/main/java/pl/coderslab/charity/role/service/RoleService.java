package pl.coderslab.charity.role.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.role.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

}
