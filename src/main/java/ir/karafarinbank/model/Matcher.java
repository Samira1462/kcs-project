package ir.karafarinbank.model;

import javax.persistence.*;

@Entity
@Table(name = "MATCHERS")
public class Matcher {
    @Id
    private Long id;
    @Column
    public String pageName;

    private String role;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
