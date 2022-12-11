package pl.gambeat007.ucl.role;

import lombok.*;
import pl.gambeat007.ucl.model.UCLBase;

import javax.persistence.*;

/**
 * This is a model class for users roles
 */

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
