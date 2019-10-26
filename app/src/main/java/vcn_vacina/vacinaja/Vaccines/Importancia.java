package vcn_vacina.vacinaja.Vaccines;

public enum Importancia {
    Alta(1), Media(2), Baixa(3);

    public int valorImportancia;

    Importancia(int valor) {
        valorImportancia = valor;
    }

}
