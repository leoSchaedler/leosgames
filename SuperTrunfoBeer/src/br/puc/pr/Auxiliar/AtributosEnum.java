package br.puc.pr.Auxiliar;

import br.puc.pr.RegraDeJogo.Carta;

public enum AtributosEnum {

    TIPO(0, "Tipo"),
    ABV(1, "ABV"),
    IBU(2, "IBU"),
    ORIGINALGRAVITY(3, "Original Gravity"),
    FINALGRAVITY(4, "Final Gravity"),
    SRM(5, "SRM");


    private final int type;

    private final String name;

    AtributosEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }



    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static AtributosEnum getByType(int type){
        switch (type){
            case 0:
                return TIPO;
            case 1:
                return ABV;
            case 2:
                return IBU;
            case 3:
                return ORIGINALGRAVITY;
            case 4:
                return FINALGRAVITY;
            case 5:
                return SRM;
            default:
                return null;
        }
    }

    public static Double getGetter(int type, Carta carta){
        switch (type){
            case 1:
                return carta.getAtributos().getABV();
            case 2:
                return carta.getAtributos().getIBU();
            case 3:
                return carta.getAtributos().getOriginalGravity();
            case 4:
                return carta.getAtributos().getFinalGravity();
            case 5:
                return carta.getAtributos().getSRM();
            default:
                return null;
        }
    }

    public static Double getGetter(AtributosEnum type, Carta carta){
        switch (type){
            case ABV:
                return carta.getAtributos().getABV();
            case IBU:
                return carta.getAtributos().getIBU();
            case ORIGINALGRAVITY:
                return carta.getAtributos().getOriginalGravity();
            case FINALGRAVITY:
                return carta.getAtributos().getFinalGravity();
            case SRM:
                return carta.getAtributos().getSRM();
            default:
                return null;
        }
    }
}
