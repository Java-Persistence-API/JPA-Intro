package hellojpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / http://minkuk-jo.com
 * @since 2021. 01. 26.
 */
@Entity
public class Member {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
