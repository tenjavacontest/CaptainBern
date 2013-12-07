package com.captainbern.doge.logger;

import com.captainbern.doge.utils.LogicUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ModuleLogger extends Logger {

    private final String[] modulePath;
    private final String prefix;

    public ModuleLogger(String... modulePath) {
        this(Bukkit.getLogger(), modulePath);
    }

    public ModuleLogger(Logger parent, String... modulePath) {
        super(StringUtils.join(modulePath, "."), null);
        this.setParent(parent);
        this.setLevel(Level.ALL);
        this.modulePath = modulePath;
        StringBuilder builder = new StringBuilder();
        for (String module : modulePath) {
            builder.append("[").append(module).append("] ");
        }
        this.prefix = builder.toString();
    }

    public ModuleLogger getModule(String... path) {
        return new ModuleLogger(this.getParent(), LogicUtils.appendArray(this.modulePath, path));
    }

    @Override
    public void log(LogRecord logRecord) {
        logRecord.setMessage(this.prefix + logRecord.getMessage());
        super.log(logRecord);
    }

}
