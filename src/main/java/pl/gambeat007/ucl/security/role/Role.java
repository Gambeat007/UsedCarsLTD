package pl.gambeat007.ucl.security.role;

import lombok.*;
import pl.gambeat007.ucl.model.UCLBase;
import pl.gambeat007.ucl.model.UCLRole;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "roles")
public class Role extends UCLBase {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private UCLRole name;

    public Role() {
    }

    public Role(UCLRole name) {
        this.name = name;
    }
}
