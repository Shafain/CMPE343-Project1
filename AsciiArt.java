public class AsciiArt {
    public static void main(String[] args) {

        
        final String RESET   = "\u001B[0m";
        final String RED     = "\u001B[31m";
        final String GREEN   = "\u001B[32m";
        final String YELLOW  = "\u001B[33m";
        final String BLUE    = "\u001B[34m";
        final String MAGENTA = "\u001B[35m";
        final String CYAN    = "\u001B[36m";
        final String WHITE   = "\u001B[37m";

        System.out.println(RED     + "   _      _      _      _      _      _      _      _      _      _   " + RESET);
        System.out.println(GREEN   + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ " + RESET);
        System.out.println(YELLOW  + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)" + RESET);
        System.out.println(BLUE    + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) " + RESET);
        System.out.println(MAGENTA + "   _      | | _  |  _  _ __  _                                    _   " + RESET);
        System.out.println(CYAN    + " _( )_    |^|(/_ | (_ (_)|||(/_                                 _( )_ " + RESET);
        System.out.println(WHITE   + "(_ o _)                                                        (_ o _)" + RESET);
        System.out.println(RED     + " (_,_)    _|_ _    _|_|_  _                                     (_,_) " + RESET);
        System.out.println(GREEN   + "   _       |_(_)    |_| |(/_                                      _   " + RESET);
        System.out.println(YELLOW  + " _( )_     _        o                                           _( )_ " + RESET);
        System.out.println(BLUE    + "(_ o _)   |_) __ _  |  _  _ _|_   /|                           (_ o _)" + RESET);
        System.out.println(MAGENTA + " (_,_)    |   | (_)_| (/_(_  |_    |                            (_,_) " + RESET);
        System.out.println(CYAN    + "   _       _           _                             o            _   " + RESET);
        System.out.println(WHITE   + " _( )_    (_| __ _    |_)   __  _ __ |_  _  __ _                _( )_ " + RESET);
        System.out.println(RED     + "(_ o _)   __| | (_)|_||     |||(/_||||_)(/_ | _>     o         (_ o _)" + RESET);
        System.out.println(GREEN   + " (_,_)                                                          (_,_) " + RESET);
        System.out.println(YELLOW  + "   _      _      _      _      _      _      _      _      _      _   " + RESET);
        System.out.println(BLUE    + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ " + RESET);
        System.out.println(MAGENTA + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)" + RESET);
        System.out.println(CYAN    + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) " + RESET);
        
        System.out.println(WHITE + " _____                                                                               _____ ");
        System.out.println("( ___ )-----------------------------------------------------------------------------( ___ )");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |  " + RED + " AA  K  K H  H M   M EEEE DDD      N   N  AA  ZZZZZ  AA  RRRR   OOO  V     V" + WHITE + " |   | ");
        System.out.println(" |   |  " + YELLOW + "A  A K K  H  H MM MM E    D  D     NN  N A  A    Z  A  A R   R O   O V     V" + WHITE + " |   | ");
        System.out.println(" |   |  " + GREEN + "AAAA KK   HHHH M M M EEE  D  D     N N N AAAA   Z   AAAA RRRR  O   O  V   V" + WHITE + "  |   | ");
        System.out.println(" |   |  " + CYAN + "A  A K K  H  H M   M E    D  D     N  NN A  A  Z    A  A R R   O   O   V V" + WHITE + "   |   | ");
        System.out.println(" |   |  " + BLUE + "A  A K  K H  H M   M EEEE DDD      N   N A  A ZZZZZ A  A R  RR  OOO     V" + WHITE + "    |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |  " + MAGENTA + "K  K U   U  AA  N   N DDD  Y   Y K  K" + WHITE + "                                        |   | ");
        System.out.println(" |   |  " + CYAN + "K K  U   U A  A NN  N D  D  Y Y  K K" + WHITE + "                                         |   | ");
        System.out.println(" |   |  " + YELLOW + "KK   U   U AAAA N N N D  D   Y   KK" + WHITE + "                                          |   | ");
        System.out.println(" |   |  " + GREEN + "K K  U   U A  A N  NN D  D   Y   K K" + WHITE + "                                         |   | ");
        System.out.println(" |   |  " + BLUE + "K  K  UUU  A  A N   N DDD    Y   K  K" + WHITE + "                                        |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |  " + RED + "K  K Y   Y RRRR  Y   Y K  K BBBB   AA  Y   Y EEEE V     V" + WHITE + "                    |   | ");
        System.out.println(" |   |  " + YELLOW + "K K   Y Y  R   R  Y Y  K K  B   B A  A  Y Y  E    V     V" + WHITE + "                    |   | ");
        System.out.println(" |   |  " + GREEN + "KK     Y   RRRR    Y   KK   BBBB  AAAA   Y   EEE   V   V" + WHITE + "                     |   | ");
        System.out.println(" |   |  " + CYAN + "K K    Y   R R     Y   K K  B   B A  A   Y   E      V V" + WHITE + "                      |   | ");
        System.out.println(" |   |  " + BLUE + "K  K   Y   R  RR   Y   K  K BBBB  A  A   Y   EEEE    V" + WHITE + "                       |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |  " + MAGENTA + " OOO  M   M III RRRR  BBBB  EEEE K  K" + WHITE + "                                        |   | ");
        System.out.println(" |   |  " + CYAN + "O   O MM MM  I  R   R B   B E    K K" + WHITE + "                                         |   | ");
        System.out.println(" |   |  " + YELLOW + "O   O M M M  I  RRRR  BBBB  EEE  KK" + WHITE + "                                          |   | ");
        System.out.println(" |   |  " + GREEN + "O   O M   M  I  R R   B   B E    K K" + WHITE + "                                         |   | ");
        System.out.println(" |   |  " + BLUE + " OOO  M   M III R  RR BBBB  EEEE K  K" + WHITE + "                                        |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |  " + RED + "U   U BBBB   AA  III DDD   AA  Y   Y EEEE V     V" + WHITE + "                            |   | ");
        System.out.println(" |   |  " + YELLOW + "U   U B   B A  A  I  D  D A  A  Y Y  E    V     V" + WHITE + "                            |   | ");
        System.out.println(" |   |  " + GREEN + "U   U BBBB  AAAA  I  D  D AAAA   Y   EEE   V   V" + WHITE + "                             |   | ");
        System.out.println(" |   |  " + CYAN + "U   U B   B A  A  I  D  D A  A   Y   E      V V" + WHITE + "                              |   | ");
        System.out.println(" |   |  " + BLUE + " UUU  BBBB  A  A III DDD  A  A   Y   EEEE    V" + WHITE + "                               |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |                                                                               |   | ");
        System.out.println(" |   |  " + MAGENTA + "RRRR   AA  U   U L        III BBBB  RRRR   AA  H  H III M   M  OOO  V     V" + WHITE + "  |   | ");
        System.out.println(" |   |  " + CYAN + "R   R A  A U   U L         I  B   B R   R A  A H  H  I  MM MM O   O V     V" + WHITE + "  |   | ");
        System.out.println(" |   |  " + YELLOW + "RRRR  AAAA U   U L         I  BBBB  RRRR  AAAA HHHH  I  M M M O   O  V   V" + WHITE + "   |   | ");
        System.out.println(" |   |  " + GREEN + "R R   A  A U   U L         I  B   B R R   A  A H  H  I  M   M O   O   V V" + WHITE + "    |   | ");
        System.out.println(" |   |  " + BLUE + "R  RR A  A  UUU  LLLL     III BBBB  R  RR A  A H  H III M   M  OOO     V" + WHITE + "     |   | ");
        System.out.println(" |___|                                                                               |___| ");
        System.out.println("(_____)-----------------------------------------------------------------------------(_____)");

        System.out.println(RESET);
    }
}

