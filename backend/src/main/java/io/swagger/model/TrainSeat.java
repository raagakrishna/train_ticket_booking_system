package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "Seat")
public class TrainSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @Column(name = "seat_id")
    @JsonProperty("seat_id")
    private Integer seatId;

    @ToString.Include
    @Column(name = "train_id", nullable = false)
    @JsonIgnore
    private Integer trainId;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @JsonProperty("class_type")
    private TrainClass classType;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "seat_type_id", nullable = false)
    @JsonProperty("seat_type")
    private SeatType seatType;

    @ToString.Include
    @Column(name = "seat_number", nullable = false)
    @JsonProperty("seat_number")
    @ApiModelProperty(value = "")
    private String seatNumber;

    @ToString.Include
    @Column(name = "is_booked", nullable = false)
    @JsonProperty("is_booked")
    @ApiModelProperty(value = "")
    private boolean isBooked;

    @Column(name = "date_created", nullable = false)
    @JsonIgnore
    private LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false)
    @JsonIgnore
    private LocalDateTime dateUpdated;
}
