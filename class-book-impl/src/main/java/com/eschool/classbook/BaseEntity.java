package com.eschool.classbook;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {
    @Column(nullable = false)
    private boolean deleted;

    @Column(nullable = false)
    @CreationTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @UpdateTimestamp
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime modifyingDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return deleted == that.deleted
                && Objects.equals(creationDate, that.creationDate)
                && Objects.equals(modifyingDate, that.modifyingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deleted, creationDate, modifyingDate);
    }
}
