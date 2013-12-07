package com.captainbern.inkhearth;

import com.captainbern.inkhearth.utils.LogicUtil;
import com.captainbern.inkhearth.utils.StringUtil;
import org.bukkit.Bukkit;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ModuleLogger extends Logger{

    private final String[] modulePath;
    private final String prefix;

    /**
     * Creates a new ModuleLogger.
     * @param modulePath How the logger should be displayed.
     */
    public ModuleLogger(String... modulePath) {
        this(Bukkit.getLogger(), modulePath);
    }

    /**
     * Creates a new module logger which takes an already existing logger as root logger.
     * @param parent The root logger.
     * @param modulePath The module name.
     */
    public ModuleLogger(Logger parent, String... modulePath) {
        super(StringUtil.join(modulePath, "."), null);
        this.setParent(parent);
        this.setLevel(Level.ALL);
        this.modulePath = modulePath;
        StringBuilder builder = new StringBuilder();
        for (String module : modulePath) {
            builder.append("[").append(module).append("] ");
        }
        this.prefix = builder.toString();
    }

    /**
     * Returns a new ModuleLogger for the given path.
     * @param path The logger name.
     * @return A new ModuleLogger.
     */
    public ModuleLogger getModule(String... path) {
        return new ModuleLogger(this.getParent(), LogicUtil.appendArray(this.modulePath, path));
    }

    /**
     * Logs a message.
     * @param logRecord The logrecord.
     */
    @Override
    public void log(LogRecord logRecord) {
        logRecord.setMessage(this.prefix + logRecord.getMessage());
        super.log(logRecord);
    }
}
