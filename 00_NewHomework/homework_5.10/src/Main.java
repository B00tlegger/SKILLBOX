public class Main {
    public static void main(String[] args) {
        Computer lenovo = new Computer("Lenovo" , "IdeaPad");
        lenovo.setProcessor(new Processor(2700, 4, ProcessorVendor.AMD, 50));
        lenovo.setRam(new Ram(RamType.DDR_3, 4000 , 150));
        lenovo.setHardDrive(new HardDrive(HardType.SSD, 512, 250));
        lenovo.setScreen(new Screen(15.6, ScreenType.IPS, 2000 ));
        lenovo.setKeyboard(new Keyboard(KeyboardType.MEMBRANE, false, 1000));
        System.out.println(lenovo.toString());

        System.out.println();

        Computer asus = new Computer("ASUS" , "Zenbook UX431FA-AM196T");
        asus.setProcessor(new Processor(2100, 2, ProcessorVendor.INTEL, 50));
        asus.setRam(new Ram(RamType.DDR_3, 8000 , 150));
        asus.setHardDrive(new HardDrive(HardType.SSD, 2562, 250));
        asus.setScreen(new Screen(14, ScreenType.IPS, 2000 ));
        asus.setKeyboard(new Keyboard(KeyboardType.MEMBRANE, false, 1000));
        System.out.println(asus.toString());

        System.out.println();

        Computer hp = new Computer("HP" , "15s-eq0077ur");
        hp.setProcessor(new Processor(2100, 4, ProcessorVendor.AMD, 50));
        hp.setRam(new Ram(RamType.DDR_3, 8000 , 150));
        hp.setHardDrive(new HardDrive(HardType.SSD, 2562, 250));
        hp.setScreen(new Screen(15.6, ScreenType.IPS, 2000 ));
        hp.setKeyboard(new Keyboard(KeyboardType.MEMBRANE, false, 1000));
        System.out.println(hp.toString());

    }
}
