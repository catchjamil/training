package com.sd.bts.security.licence;


import java.io.File;

import javax.swing.filechooser.FileFilter;

public class LicenseFileFilter extends FileFilter {
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith("zip");
    }
    
    public String getDescription() {
        return "License files";
    }
}