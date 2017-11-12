package ru.info.tech.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * Created by Sulaymon on 04.11.2017.
 */

public class MySitemeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/basic_decorator.jsp")
                .addDecoratorPath("/admin/*", "/admin/basic_decorator.jsp");
    }
}
