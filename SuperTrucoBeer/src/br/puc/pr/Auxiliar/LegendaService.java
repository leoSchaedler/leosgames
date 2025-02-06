package br.puc.pr.Auxiliar;

public class LegendaService {

    /*
    BLACK("\033[0;30m"),    // BLACK
    RED("\033[0;31m"),      // RED
    GREEN("\033[0;32m"),    // GREEN
    YELLOW("\033[0;33m"),   // YELLOW
    BLUE("\033[0;34m"),     // BLUE
    MAGENTA("\033[0;35m"),  // MAGENTA
    CYAN("\033[0;36m"),     // CYAN
    WHITE("\033[0;37m"),    // WHITE
     */

    public static String getLegendCode(int index){
        int correct = index;
        while (correct > 7)
            correct = correct -7;
        String legendaCode = "\033[";
        switch (correct){
            case 1:
                legendaCode += "0;33m";
                break;
            case 2:
                legendaCode += "0;32m";
                break;
            case 3:
                legendaCode += "0;31m";
                break;
            case 4:
                legendaCode += "0;30m";
                break;
            case 5:
                legendaCode += "0;34m";
                break;
            case 6:
                legendaCode += "0;35m";
                break;
            case 7:
                legendaCode += "0;36m";
                break;
            default:
                legendaCode += "1;37m";
                break;
        }
        return legendaCode;
    }
}
