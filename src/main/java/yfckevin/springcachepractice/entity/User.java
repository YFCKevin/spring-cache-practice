package yfckevin.springcachepractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Schema(description = "會員編號")
    @Id
    private UUID id;

    @Schema(description = "信箱")
    private String email;

    @Schema(description = "密碼")
    private String password;

    @Schema(description = "姓名")
    private String name;
}