package netcracker.study.monopoly.db.model;

import lombok.Getter;
import lombok.Setter;
import netcracker.study.monopoly.util.JSONBUserType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@TypeDef(name = "jsonb", typeClass = JSONBUserType.class,
        parameters = @Parameter(name = JSONBUserType.CLASS,
                value = "netcracker.study.monopoly.db.model.json.GameState"))
@Entity
@Getter
public class Game extends AbstractIdentifiableObject implements Serializable {

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "currentGame")
    private Set<Player> players;

    @Type(type = "jsonb")
    @Setter
    private netcracker.study.monopoly.db.model.json.GameState state;
}
