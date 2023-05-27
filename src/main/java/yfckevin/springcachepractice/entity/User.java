package yfckevin.springcachepractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long id;

    @Schema(description = "信箱")
    private String email;

    /*
    * 不可序列化(轉換成JSON)，可以反序列化(轉換成user物件)
    * 僅能讓此物件值被設定進去，無法讀取。
    * */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(description = "密碼")
    private String password;

    @Schema(description = "姓名")
    private String name;
}