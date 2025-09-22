// 代码生成时间: 2025-09-22 21:31:35
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.List;

/**
 * SystemPerformanceMonitor is a ManagedBean for monitoring system performance.
 */
@ManagedBean
@ViewScoped
public class SystemPerformanceMonitor {

    private long memoryFree;
    private long memoryTotal;
    private long memoryMax;
    private long memoryUsed;
    private long systemCpuLoad;
    private long processCpuLoad;
    private long uptime;
    private String javaVersion;
    private String systemName;
    private String userName;
    private long totalThreads;
    private long peakThreads;
    private long daemonThreads;

    /**
     * Initializes the system performance monitor.
     */
    public void init() {
        this.memoryFree = getMemoryFree();
        this.memoryTotal = getMemoryTotal();
        this.memoryMax = getMemoryMax();
        this.memoryUsed = getMemoryUsed();
        this.systemCpuLoad = getSystemCpuLoad();
        this.processCpuLoad = getProcessCpuLoad();
        this.uptime = getUptime();
        this.javaVersion = getJavaVersion();
        this.systemName = getSystemName();
        this.userName = getUserName();
        this.totalThreads = getTotalThreads();
        this.peakThreads = getPeakThreads();
        this.daemonThreads = getDaemonThreads();
    }

    // Getters and Setters
    public long getMemoryFree() {
        return memoryFree;
    }
    public void setMemoryFree(long memoryFree) {
        this.memoryFree = memoryFree;
    }
    public long getMemoryTotal() {
        return memoryTotal;
    }
    public void setMemoryTotal(long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }
    public long getMemoryMax() {
        return memoryMax;
    }
    public void setMemoryMax(long memoryMax) {
        this.memoryMax = memoryMax;
    }
    public long getMemoryUsed() {
        return memoryUsed;
    }
    public void setMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }
    public long getSystemCpuLoad() {
        return systemCpuLoad;
    }
    public void setSystemCpuLoad(long systemCpuLoad) {
        this.systemCpuLoad = systemCpuLoad;
    }
    public long getProcessCpuLoad() {
        return processCpuLoad;
    }
    public void setProcessCpuLoad(long processCpuLoad) {
        this.processCpuLoad = processCpuLoad;
    }
    public long getUptime() {
        return uptime;
    }
    public void setUptime(long uptime) {
        this.uptime = uptime;
    }
    public String getJavaVersion() {
        return javaVersion;
    }
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }
    public String getSystemName() {
        return systemName;
    }
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public long getTotalThreads() {
        return totalThreads;
    }
    public void setTotalThreads(long totalThreads) {
        this.totalThreads = totalThreads;
    }
    public long getPeakThreads() {
        return peakThreads;
    }
    public void setPeakThreads(long peakThreads) {
        this.peakThreads = peakThreads;
    }
    public long getDaemonThreads() {
        return daemonThreads;
    }
    public void setDaemonThreads(long daemonThreads) {
        this.daemonThreads = daemonThreads;
    }

    // Helper methods
    private long getMemoryFree() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        return heapMemoryUsage.getUsed();
    }

    private long getMemoryTotal() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        return heapMemoryUsage.getMax();
    }

    private long getMemoryMax() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        return heapMemoryUsage.getMax();
    }

    private long getMemoryUsed() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        return heapMemoryUsage.getUsed();
    }

    private long getSystemCpuLoad() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        return osBean.getSystemCpuLoad();
    }

    private long getProcessCpuLoad() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        return osBean.getProcessCpuLoad();
    }

    private long getUptime() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeBean.getUptime();
        return uptime / 1000; // Convert milliseconds to seconds
    }

    private String getJavaVersion() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        return runtimeBean.getSystemProperties().get("java.version");
    }

    private String getSystemName() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        return runtimeBean.getSystemProperties().get("os.name");
    }

    private String getUserName() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        return runtimeBean.getSystemProperties().get("user.name");
    }

    private long getTotalThreads() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        return runtimeBean.getThreadInfo().length;
    }

    private long getPeakThreads() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        return runtimeBean.getPeakThreadCount();
    }

    private long getDaemonThreads() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        List<ThreadInfo> threadInfos = runtimeBean.getThreadInfo();
        long count = 0;
        for (ThreadInfo threadInfo : threadInfos) {
            if (threadInfo.isDaemon()) {
                count++;
            }
        }
        return count;
    }
}
