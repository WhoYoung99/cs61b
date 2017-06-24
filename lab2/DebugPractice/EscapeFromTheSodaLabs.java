public class EscapeFromTheSodaLabs extends Trial {

    /**
     * General Ackbar has discovered treasures in the second floor labs. However, a nefarious entity, Leorge Gucas
     * has "deployed the algorithm" which is set to destroy the labs. To save Soda, collect all the treasures in as few
     * hops as possible. You may set only one breakpoint.
     */


    /** Bonus for Bosses #1: Do you see why the program registers 8 hops with the bare minimum constraints?
     *  Do this while only registering 5 hops with all of the same constraints!
     *  Ans: put the breakpoint at line 20: the first of treasureChest.
     *       the key question is: how this program determine isStop()? It's based on last timestamp and current time.
     *       and, every treasureChest should get a Goal and try to avoid entering for-loop in both traps
     *       as a result, use shift + F8 to get Goals from trap without entering for-loop,
     *       and use F8 for plain treasureChest
    */
    public static void main(String[] args) {
        Traveler cal = new Traveler("General Ackbar", 5, 8);
        treasureChest(cal);
        trap(cal);
        treasureChest(cal);
        superTrap(cal);
        cal.endJourney();
    }

    public static void trap(Traveler t) {
        treasureChest(t);
        for (int i = 0; i < 10; i++) {
            nothingHere(t);
        }
    }

    public static void superTrap(Traveler t) {
        treasureChest(t);
        trap(t);
        for (int i = 0; i < 10; i++) {
            nothingHere(t);
        }
    }
}
