package com.invenaudio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// In a separate class so we can safely reference it in coremod code without triggering the mod class to load early
public class Constants {
    public static final String MODID = "invenaudio";
    public static final String VERSION = "1.0.0.0";
    public static final String NAME = "Inven Audio";
    public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.7.10]";
    public static final String DEPENDENCIES = "required-before:unimixins@[0.1.22,)";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
}