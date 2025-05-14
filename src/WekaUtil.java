public class WekaUtil {
    public static void setWekaProperties() {
        System.setProperty("java.vm.vendor", "Sun Microsystems Inc.");
        System.setProperty("java.vendor", "Sun Microsystems Inc.");
        System.setProperty("java.vm.name", "Java HotSpot(TM) 64-Bit Server VM");
        System.setProperty("weka.core.logging.Logger", "weka.core.logging.ConsoleLogger");
        System.setProperty("weka.core.WekaPackageManager.VERBOSE", "false");
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
    }
}
