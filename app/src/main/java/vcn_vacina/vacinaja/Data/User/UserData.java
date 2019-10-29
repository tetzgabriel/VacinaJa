package vcn_vacina.vacinaja.Data.User;

public class UserData {
    private String nome;
    private String idade;
    private String bloodType;
    private int image;


    public UserData(String nome, String idade, String bloodType, int image) {
        this.nome = nome;
        this.idade = idade;
        this.bloodType = bloodType;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getImage() {
        return image;
    }

}
