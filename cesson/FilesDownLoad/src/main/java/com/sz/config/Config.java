package com.sz.config;

/**
 * 把所有的配置，全部写成一个配置类。
 */
public class Config {

    private String downloadRootPath;

    public String getDownloadRootPath() {
        return downloadRootPath;
    }

    public void setDownloadRootPath(String downloadRootPath) {
        this.downloadRootPath = downloadRootPath;
    }
}
