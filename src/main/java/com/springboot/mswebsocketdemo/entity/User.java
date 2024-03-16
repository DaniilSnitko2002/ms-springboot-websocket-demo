package com.springboot.mswebsocketdemo.entity;
import com.springboot.mswebsocketdemo.constant.UserStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /**
     * The id
     */
    @Id
    @GeneratedValue(generator = "USERS_ID_SEQ")
    @GenericGenerator(name = "USERS_ID_SEQ", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    /**
     * The name
     */
    @NotBlank(message = "nickName is mandatory")
    @Column(name = "nick_name")
    private String nickName;

    /**
     * The fullName
     */
    @NotBlank(message = "fullName is mandatory")
    @Column(name = "full_name")
    private String fullName;

    /**
     * The devicesInUse
     */
    @Column(name = "devices_in_use")
    private int devicesInUse = 1;

    /**
     * The status
     */
    @Enumerated(EnumType.STRING)
    private UserStatusEnum status;
}
