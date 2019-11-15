package dates_times_locales_and_resource_bundles.settingLocales;

import java.util.Locale;

class LocaleGen {
    private Locale local;

    public LocaleGen(String region) {
        this.local = new Locale.Builder().setLanguage("en").setRegion(region).build();
    }

    public Locale getLocal(){
        return local;
    }
}

public class SetLocale {
    public static void main(String[] args) {
      LocaleGen usa = new LocaleGen("US");
      LocaleGen fr = new LocaleGen("FR");
        System.out.println(usa.getLocal() + " " + usa.getLocal().getDisplayLanguage());
        System.out.println(fr.getLocal());
        System.out.println();
        System.out.println(Locale.getDefault());
        Locale.setDefault(new Locale("en", "FR"));
        System.out.println(Locale.getDefault().getDisplayCountry());
        Locale.setDefault(Locale.CHINA);
        System.out.println(Locale.getDefault().getDisplayCountry());
    }
}
