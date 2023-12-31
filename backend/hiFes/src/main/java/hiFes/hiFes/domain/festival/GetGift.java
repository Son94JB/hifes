package hiFes.hiFes.domain.festival;


import com.fasterxml.jackson.annotation.JsonBackReference;
import hiFes.hiFes.domain.user.NormalUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="GetGift")
public class GetGift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="itemId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private ARItem arItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="normal_user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private NormalUser normalUser;


}
