package user;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(exclude = {"id"})
public class User {

    private String username;
    private String password;
    private String rePassword;
    private String name;
    private String socialSecurityNumber;
    private String phoneNumber;
    private String address;
    private String job;
    private double weight;
    private double height;


    @Builder(builderMethodName = "bulder")
    public User(String username, String password, String rePassword, String name, String socialSecurityNumber, String phoneNumber, String address, String job, double weight, double height) {
        this.username = username;
        this.password = password;
        this.rePassword = rePassword;
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.weight = weight;
        this.height = height;
    }
}
