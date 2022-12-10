package pl.gambeat007.ucl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller test class for users access levels check & maintain.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ucl/test")
public class TestController {

    // Each one of method below checks different level of users access and returns a simple String to confirm.
    @GetMapping("/public")
    @PreAuthorize("hasRole('PUBLIC')")
    public String shouldAccessPublicContent() {
        return "Public content.";
    }

    @GetMapping("/customer")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String shouldAccessCustomerContent() {
        return "Customer content.";
    }

    @GetMapping("/owner")
    @PreAuthorize("hasRole('OWNER')")
    public String shouldAccessOwnerContent() {
        return "Owner content.";
    }
}
