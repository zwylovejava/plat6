package net.northking.cloudplatform.utils;

/**
 * Created by HUANGCS3 on 2016/8/31.
 */

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntUrlPathMatcher implements UrlMatcher {
    private boolean requiresLowerCaseUrl;
    private PathMatcher pathMatcher;

    public AntUrlPathMatcher() {
        this(true);
    }

    public AntUrlPathMatcher(boolean requiresLowerCaseUrl) {
        this.requiresLowerCaseUrl = true;
        this.pathMatcher = new AntPathMatcher();
        this.requiresLowerCaseUrl = requiresLowerCaseUrl;
    }

    public Object compile(String path) {
        return this.requiresLowerCaseUrl?path.toLowerCase():path;
    }

    public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
        this.requiresLowerCaseUrl = requiresLowerCaseUrl;
    }

    public boolean pathMatchesUrl(Object path, String url) {
        return !"/**".equals(path) && !"**".equals(path)?this.pathMatcher.match((String)path, url):true;
    }

    public String getUniversalMatchPattern() {
        return "/**";
    }

    public boolean requiresLowerCaseUrl() {
        return this.requiresLowerCaseUrl;
    }

    public String toString() {
        return super.getClass().getName() + "[requiresLowerCase=\'" + this.requiresLowerCaseUrl + "\']";
    }

    public static void main(String[] argvs){
        AntPathMatcher matcher = new AntPathMatcher();
        boolean result = matcher.match("/console/**", "/console/list/**");
        System.out.println(result);
    }
}