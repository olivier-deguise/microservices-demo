package com.org.myapp.demo.notification;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Notification {

    @Id
    @SequenceGenerator(
            name="notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer notificationId;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
    private String toCustomerEmail;
    private Integer toCustomerId;

}
