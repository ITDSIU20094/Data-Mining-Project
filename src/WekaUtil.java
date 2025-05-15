public class WekaUtil {
    public static void setWekaProperties() {
        // Suppress BLAS/LAPACK warnings
        System.setProperty("com.github.fommil.netlib.BLAS", "com.github.fommil.netlib.F2jBLAS");
        System.setProperty("com.github.fommil.netlib.LAPACK", "com.github.fommil.netlib.F2jLAPACK");
        System.setProperty("com.github.fommil.netlib.ARPACK", "com.github.fommil.netlib.F2jARPACK");

        // Set Weka properties
        System.setProperty("java.vm.vendor", "Sun Microsystems Inc.");
        System.setProperty("java.vendor", "Sun Microsystems Inc.");
        System.setProperty("java.vm.name", "Java HotSpot(TM) 64-Bit Server VM");
        System.setProperty("weka.core.logging.Logger", "weka.core.logging.ConsoleLogger");
        System.setProperty("weka.core.WekaPackageManager.VERBOSE", "false");
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
    }
}
