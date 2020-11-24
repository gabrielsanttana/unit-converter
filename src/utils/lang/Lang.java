package utils.lang;

public abstract class Lang {

  public static ELang lang = ELang.EN_US;

  public static final String[] example = new String[] { "Example", "Exemplo" };
  public static final String[] scientificNotation = new String[] {
    "Scientific Notation",
    "Notação Científica",
  };
  public static final String[] convertFrom = new String[] {
  	"Convert from",
  	"Converter de",
  };
  public static final String[] to = new String[] {
    "to",
    "para",
  };
  public static final String[] close = new String[] {
    "Close",
    "Fechar",
  };
  public static final String[] help = new String[] {
    "Help",
    "Ajuda",
  };
  public static final String[] about = new String[] {
    "About",
    "Sobre",
  };
  public static final String[] file = new String[] {
    "File",
    "Arquivo",
  };
  public static final String[] unit_converter = new String[] {
    "Unit Converter",
    "Conversor de Unidades",
  };
  public static final String[] helper_text = new String[] {
  	"Unit Converter\n\n-------------------------------\n\nThis program was written to be a simple educational project that shows how to use some resources of Graphical User Interface (Swing) from Java language and some software engineering techniques. The aim of the program is performing the conversion between two measure units.\n\nAll the action is placed in the background panel of the main screen. The user interacts woth this screen most of time.\n\nThe menu options are very straight:\n* From the 'File' menu, one can choose to finish the program;\n* From the 'Help' menu, one can choose see standard texts: 'Help', 'Disclaimer' and 'About'\n\n",
  	"Conversor de Unidades\n\n-------------------------------\n\nEste programa foi escrito para ser um projeto educacional simples que mostra como usar alguns recursos da Interface Gráfica do Usuário (Swing) da linguagem Java e algumas técnicas de engenharia de software. O objetivo do programa ao realizar a conversão entre duas unidades de medida.\n\nToda a ação é colocada no painel de fundo da tela principal. O usuário interage com esta tela na maioria das vezes.\n\nAs opções do menu são muito simples:\n* No menu 'Arquivo', pode-se optar por finalizar o programa;\n* No menu 'Ajuda', pode-se escolher ver os textos padrão: 'Ajuda', 'Aviso Legal' e 'Sobre'"
  };
  
  public static final String[] unit_distance = new String[] {
  	"Distance",
  	"Distância"
  };
  public static final String[] unit_area = new String[] {
  	"Area",
  	"Área"
  };
  public static final String[] unit_volume = new String[] {
    	"Volume",
    	"Volume"
    };
  public static final String[] unit_mass = new String[] {
    	"Mass",
    	"Massa"
    };
  public static final String[] unit_time = new String[] {
    	"Time",
    	"Tempo"
    };
  public static final String[] unit_speed = new String[] {
    	"Speed",
    	"Velocidade"
    };
  public static final String[] unit_acceleration = new String[] {
    	"Acceleration",
    	"Aceleração"
    };
  public static final String[] unit_force = new String[] {
    	"Force",
    	"Força"
    };
  public static final String[] unit_pressure = new String[] {
    	"Pressure",
    	"Pressão"
    };
  public static final String[] unit_energy = new String[] {
    	"Energy",
    	"Energia"
    };
  public static final String[] unit_power = new String[] {
    	"Power",
    	"Potência"
    };
  public static final String[] unit_viscosity = new String[] {
    	"Viscosity",
    	"Viscosidade"
    };
  public static final String[] unit_temperature = new String[] {
    	"Temperature",
    	"Temperatura"
    };
  public static final String[] unit_luminous_intensity = new String[] {
    	"Luminous intensity",
    	"Intensidade luminosa"
    };
  public static final String[] unit_amount_of_substance = new String[] {
    	"Amount of substance",
    	"Quantidade de substância"
    };
  public static final String[] unit_electric_current = new String[] {
    	"Electric current",
    	"Corrente elétrica"
    };
  public static final String[] unit_currency = new String[] {
    	"Currency",
    	"Moeda"
    };
  
  public static String get(String[] words) {
    if (words.length != ELang.values().length) return null;

    return words[lang.getIndex()];
  }
}
