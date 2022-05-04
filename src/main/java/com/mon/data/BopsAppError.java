package com.mon.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "BOPS_APP_ERRORS")
public class BopsAppError {
//    @Id
//    private int id;
    @Column
    private String ERR_CLASS;
    @Column
    private String ERR_CATEGORY;
    @Column
    private String ERR_DESCRIPTION;
    @Id
    @Column
    private LocalDateTime DATE_STARTED;
    @Column
    private LocalDateTime DATE_UPDATED;

    public BopsAppError() { }

    public String getERR_CLASS() {
        return ERR_CLASS;
    }

    public String getERR_CATEGORY() {
        return ERR_CATEGORY;
    }

    public String getERR_DESCRIPTION() {
        return ERR_DESCRIPTION;
    }

    public LocalDateTime getDATE_STARTED() {
        return DATE_STARTED;
    }

    public LocalDateTime getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BopsAppError)) return false;
        BopsAppError that = (BopsAppError) o;
        return Objects.equals(ERR_CLASS, that.ERR_CLASS) && Objects.equals(ERR_CATEGORY, that.ERR_CATEGORY) && Objects.equals(ERR_DESCRIPTION, that.ERR_DESCRIPTION) && Objects.equals(DATE_STARTED, that.DATE_STARTED) && Objects.equals(DATE_UPDATED, that.DATE_UPDATED);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ERR_CLASS, ERR_CATEGORY, ERR_DESCRIPTION, DATE_STARTED, DATE_UPDATED);
    }

    @Override
    public String toString() {
        return "BopsAppError{" +
                "ERR_CLASS='" + ERR_CLASS + '\'' +
                ", ERR_CATEGORY='" + ERR_CATEGORY + '\'' +
                ", ERR_DESCRIPTION='" + ERR_DESCRIPTION + '\'' +
                ", DATE_STARTED=" + DATE_STARTED +
                ", DATE_UPDATED=" + DATE_UPDATED +
                '}';
    }
}
