public class main {
    public static void main(String[] args) {
        Client physical = new PhysicalPerson();
        physical.setMoney(1000);
        Client legal = new LegalPerson();
        legal.setMoney(1982892);
        Client businessman = new IndividualBusinessman();
        businessman.setMoney(546778);

        physical.accountInformation();
        System.out.println();
        legal.accountInformation();
        System.out.println();
        businessman.accountInformation();
        System.out.println();

        physical.take(100);
        System.out.println(physical.getAmount());
        businessman.put(100);
        System.out.println(businessman.getAmount());
        legal.put(100);
        System.out.println(legal.getAmount());
        System.out.println();
        physical.put(200);
        System.out.println(physical.getAmount());
        businessman.take(100000);
        System.out.println(businessman.getAmount());
        legal.take(1000000);
        System.out.println(legal.getAmount());

    }
}
